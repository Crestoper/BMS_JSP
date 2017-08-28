package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BoardDTO;

public class BoardModifyHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		String go = "";
		String pageNum = req.getParameter("pageNum");;
		String writer = req.getParameter("writer");;
		String num = req.getParameter("num");
		
		ArrayList<BoardDTO> dtolist = new ArrayList<BoardDTO>();
		ArrayList<String> list = new ArrayList<String>();
		
		BmsDAO dao = BmsDAOImpl.getInstance();
		
		//비번입력페이지
		if(cnt == 0){
			req.setAttribute("writer", writer);
			req.setAttribute("num", num);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("cnt", 3);
			
			go = "/BMS/board/board_pw.jsp";
			
		//비번확인
		}else if(cnt == 1){
			
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("num", num);
			
			list.add(writer);
			list.add(req.getParameter("pw"));
			
			
			cnt = dao.search(19,list,null,null, null, null);
			
				if(cnt == 0){
					req.setAttribute("writer", writer);
					req.setAttribute("num", num);
					req.setAttribute("pageNum", pageNum);
					req.setAttribute("cnt", 3);
					
					go = "/BMS/board/board_pw.jsp";
				
				}else if(cnt == 1){
					list.clear();
					System.out.println("게시판 수정 req.getAttribute(num) : " + req.getAttribute("num"));
					list.add(num);
					
					dao.search(11,list,null,null,null,dtolist);
					
					req.setAttribute("dtolist", dtolist);
					System.out.println("게시판 수정 dtolist : " + dtolist);
					go = "/BMS/board/board_modify.jsp";	
				}
		
		}else if(cnt == 3){
			list.add(req.getParameter("subject"));
			list.add(req.getParameter("content"));
			list.add(req.getParameter("passwd"));
			list.add(req.getParameter("num"));
			
			System.out.println("수정할 subject : " + req.getParameter("subject"));
			System.out.println("수정할 content : " + req.getParameter("content"));
			System.out.println("수정할 passwd : " + req.getParameter("passwd"));
			System.out.println("수정할 num : " + req.getParameter("num"));
			
			dao.update(5,list,null,null);
			
			pageNum = req.getParameter("pageNum");
			System.out.println("수정 후 pageNum : " + pageNum);
			
			go = "boardList.do?pageNum="+pageNum;
		}
		return go;
	}

}
