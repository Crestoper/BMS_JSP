package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;

public class GuestCancleHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		String salesNum = req.getParameter("salesNum");
		String count = req.getParameter("count");
		String isbn = req.getParameter("isbn");
		
		System.out.println("count : " + count);
		
		ArrayList<String> list = new ArrayList<String>();
		BmsDAO dao = BmsDAOImpl.getInstance();
			
		list.add(salesNum);
		list.add("4");
		list.add(count);
		list.add(isbn);
		System.out.println("수정 salesNum : " + salesNum);
		
		dao.update(7,list,null,null);
		dao.update(8,list,null,null);
		return null;
	}

}
