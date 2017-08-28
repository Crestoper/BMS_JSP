package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;

public class LoginProHandler implements CommandHandler {

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
			ArrayList<String> list = new ArrayList<String>();
			
			int checkCnt = 0;
			String destination = "";
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			list.add(id);
			list.add(pw);
			
			BmsDAO dao = BmsDAOImpl.getInstance();
			
			int cnt = dao.search(1, list,null,null,null, null);
			
			if(cnt == 1){
				checkCnt = dao.search(2, list,null,null,null, null);
				
				if(checkCnt == 1){
					ArrayList<String> cart = new ArrayList<String>();
					
					req.getSession().setAttribute("memId", id);
					req.getSession().setAttribute("msg", "300");
					
					System.out.println("memId : " + req.getSession().getAttribute("memId"));
					req.getSession().setAttribute("cart", cart);
					
					if(req.getSession().getAttribute("memId").equals("host")){
						destination = "host.do";
					}else{
						destination = "home.do";
					}
				}else if(checkCnt == 0){
					req.getSession().setAttribute("msg", "350");
					System.out.println("350 : " + req.getSession().getAttribute("msg"));
					destination = "login.do";
				}
			}else{
				req.getSession().setAttribute("msg", "320");
				System.out.println("320 : " + req.getSession().getAttribute("msg"));
				destination = "login.do";
			}
			
		return destination;
	}

}
