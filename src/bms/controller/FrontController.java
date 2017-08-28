package bms.controller;



import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.handler.CommandHandler;
import bms.handler.NullHandler;

public class FrontController extends HttpServlet {
	
	//<커멘드, 핸들러인스턴스> 매핑 정보 저장
	private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();
	
	public void init() throws ServletException{
		
		String configFile = getInitParameter("configFile");
		
		Properties prop = new Properties();
		
		String configFilePath = getServletContext().getRealPath(configFile);
		
		try(FileReader fis = new FileReader(configFilePath)){
			prop.load(fis);
		}catch(Exception e){
			throw new ServletException(e);
		}
		
		Iterator keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()){
				String command = (String) keyIter.next();
				String handlerClassName = prop.getProperty(command);
				
				try{
					Class<?> handlerClass = Class.forName(handlerClassName);
					CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();
					commandHandlerMap.put(command, handlerInstance);
				}catch(Exception e){
					throw new ServletException(e);
				}
		}
		
		
	}
	
	
	
	private static final long serialVersionUID = 1L;

	public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doPro(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doPro(req,res);
	}
	
	public void doPro(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		String command = req.getRequestURI();
		if(command.indexOf(req.getContextPath()) == 0){
			command = command.substring(req.getContextPath().length());
		}
		CommandHandler handler = commandHandlerMap.get(command);
		
		System.out.println("command : " + command);
		
		if(handler == null){
			handler = new NullHandler();
		}
		
		String viewPage = "";
		
		try{
			
			viewPage = handler.Pro(req, res);
			
			System.out.println("viewPage : " + viewPage);
		
		}catch(Throwable e){
			throw new ServletException(e);
		}
		
		if(viewPage != null){
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, res);
		}
		
	}

}

