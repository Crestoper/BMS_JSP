package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BookDTO;

public class SearchBookHandler implements CommandHandler{
	
	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		String go = "";
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		
		ArrayList<BookDTO> dtolist = new ArrayList<BookDTO>();
		ArrayList<String> list = new ArrayList<String>();
		String title = req.getParameter("search");
		
		System.out.println(title);
		
		list.add(title);
		
		BmsDAO dao = BmsDAOImpl.getInstance();
		
		dao.search(7, list, dtolist,null, null, null);
		
		req.setAttribute("dtolist", dtolist);
		System.out.println(dtolist);
		
		if(cnt == 1){
			go = "/BMS/guest/searchBook.jsp";
		
		}else if(cnt == 2){
			go = "/BMS/host/host_stock.jsp";
		}
		return go;
	}

}
