package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;

public class HostStockAddHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		req.setCharacterEncoding("UTF-8");

		ArrayList<String> list = new ArrayList<String>();
		BmsDAO dao = BmsDAOImpl.getInstance();
			
		list.add(req.getParameter("isbn"));
		list.add(req.getParameter("title"));
		list.add(req.getParameter("author"));
		list.add(req.getParameter("publisher"));
		list.add(req.getParameter("price"));
		list.add(req.getParameter("count"));
		list.add(req.getParameter("subTitle"));
		list.add(req.getParameter("trans"));
		
		System.out.println("입력 isbn : " + req.getParameter("isbn"));
		System.out.println("입력 title : " + req.getParameter("title"));
		System.out.println("입력 author : " + req.getParameter("author"));
		System.out.println("입력 publisher : " + req.getParameter("publisher"));
		System.out.println("입력 price : " + req.getParameter("price"));
		System.out.println("입력 count : " + req.getParameter("count"));
		System.out.println("입력 subTitle : " + req.getParameter("subTitle"));
		System.out.println("입력 trans : " + req.getParameter("trans"));
		
		
		dao.insert(5,list,null,null);
		
		return "";
	}

}
