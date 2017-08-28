package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BookDTO;

public class HostStockDeleteHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		ArrayList<String> list = new ArrayList<String>();
		BmsDAO dao = BmsDAOImpl.getInstance();
			
		list.add(req.getParameter("isbn"));
		
		System.out.println("수정 isbn : " + req.getParameter("isbn"));
		
		dao.delete(3,list);
			
					
		return null;
	}

}
