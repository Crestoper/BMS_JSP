package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BookDTO;

public class BookpageHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String isbn = req.getParameter("num");
		
		System.out.println("isbn : " + isbn);
		
		ArrayList<BookDTO> dtolist = new ArrayList<BookDTO>();
		ArrayList<String> list = new ArrayList<String>();
		
		list.add(isbn);
		
		BmsDAO dao = BmsDAOImpl.getInstance();
		
		dao.search(4, list, dtolist, null, null, null);
		
		req.setAttribute("dtolist", dtolist);
		
		System.out.println("dtolist : " + dtolist);
		return "/BMS/guest/guest_bookpage.jsp";
	}

}
