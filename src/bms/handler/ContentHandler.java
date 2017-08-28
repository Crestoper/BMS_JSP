package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BoardDTO;

public class ContentHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String num = req.getParameter("num");
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int number = Integer.parseInt(req.getParameter("number"));
		
		BmsDAO dao = BmsDAOImpl.getInstance();
		
		ArrayList<BoardDTO> dtolist = new ArrayList<BoardDTO>();
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(num);
		
		int cnt = dao.search(11,list,null,null,null,dtolist);
		
		if(cnt == 1){
			dao.update(4,list,null,null);
		}
		
		req.setAttribute("dtolist", dtolist);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("number", number);
		
		return "/BMS/board/board_content.jsp";
	}

}
