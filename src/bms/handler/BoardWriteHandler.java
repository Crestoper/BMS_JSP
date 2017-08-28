package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BoardDTO;



public class BoardWriteHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		String go = "";
		
		if(cnt == 0){
			
			int num = 0;
			int ref = 1;
			int ref_step = 0;
			int ref_level = 0;
			
			if(req.getParameter("num") != null){
				num = Integer.parseInt(req.getParameter("num"));
				ref = Integer.parseInt(req.getParameter("ref"));
				ref_step = Integer.parseInt(req.getParameter("ref_step"));
				ref_level = Integer.parseInt(req.getParameter("ref_level"));
				System.out.println(num);
				System.out.println(ref);
				System.out.println(ref_step);
				System.out.println(ref_level);
			}
			
			req.setAttribute("num", num);
			req.setAttribute("ref", ref);
			req.setAttribute("ref_step", ref_step);
			req.setAttribute("ref_level", ref_level);
			
			go = "/BMS/board/board_wirte.jsp";
		
		}else if(cnt == 3){
			
			ArrayList<String> list = new ArrayList<String>(); 
			BmsDAO dao = BmsDAOImpl.getInstance();
					
			list.add(req.getParameter("writer"));
			list.add(req.getParameter("passwd"));
			list.add(req.getParameter("subject"));
			list.add(req.getParameter("content"));
			list.add(req.getParameter("ref"));
			list.add(req.getParameter("ref_level"));
			list.add(req.getParameter("ref_step"));
			list.add(req.getParameter("num"));
		
			dao.insert(4, list, null, null);
			
			go = "boardList.do";
		}
		return go;
	}

}
