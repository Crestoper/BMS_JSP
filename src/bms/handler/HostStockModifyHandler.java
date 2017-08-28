package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BoardDTO;
import bms.dto.BookDTO;

public class HostStockModifyHandler implements CommandHandler{

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
		list.add(req.getParameter("exIsbn"));
		
		System.out.println("수정 isbn : " + req.getParameter("isbn"));
		System.out.println("수정 title : " + req.getParameter("title"));
		System.out.println("수정 author : " + req.getParameter("author"));
		System.out.println("수정 publisher : " + req.getParameter("publisher"));
		System.out.println("수정 price : " + req.getParameter("price"));
		System.out.println("수정 count : " + req.getParameter("count"));
		System.out.println("수정 subTitle : " + req.getParameter("subTitle"));
		System.out.println("수정 trans : " + req.getParameter("trans"));
		
		
		dao.update(6,list,null,null);
			
					
		return null;
	}
	

}
