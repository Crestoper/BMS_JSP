package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BookDTO;

public class HomeHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ArrayList<BookDTO> dtolist = new ArrayList<BookDTO>();
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("10");
		
		
		BmsDAO dao = BmsDAOImpl.getInstance();
		
		dao.search(3, list, dtolist,null,null, null);
		
		req.setAttribute("dtolist", dtolist);
		
		return "/BMS/home.jsp";
	}

}
