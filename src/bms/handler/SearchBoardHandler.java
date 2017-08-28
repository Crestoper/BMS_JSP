package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BoardDTO;

public class SearchBoardHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int pageSize = 15;
		
		if(req.getParameter("pageSize") != null){
			pageSize = Integer.parseInt(req.getParameter("pageSize"));
		}
		
		//출력할 페이지 개수
		int pageBlock = 3;
		
		//글 개수
		int cnt = 0;
		//현제 페이지 시작 번호 : rownum
		int start = 0;
		//현제 페이지 끝 번호 : rownum
		int end = 0;
		
		//출력할 글 번호
		int number = 0;
		//페이지 번호
		String pageNum = null; 	
		//현재 페이지
		int currentPage = 0; 	
		
		//페이지 개수
		int pageCount = 0; 		
		//시작 페이지
		int startPage = 0; 		
		//마지막 페이지
		int endPage = 0; 		
		
		//DAO 싱글톤, 다형성 적용해서 객체생성
		BmsDAO dao = BmsDAOImpl.getInstance();
		
		String search = req.getParameter("search"); 
		ArrayList<String> list = new ArrayList<String>();
		list.add(search);

		//글 개수 구하기
		cnt = dao.search(12,list,null,null,null,null); 
		
		pageNum = req.getParameter("pageNum");
		
		if(pageNum == null){
			//첫페이지를 1페이지로 설정
			pageNum = "1";
		}
		
		//현재 페이지
		currentPage = (Integer.parseInt(pageNum));
		//페이지 개수
		pageCount = (cnt/pageSize) + (cnt%pageSize > 0 ? 1 : 0);
		
		//현재페이지 시작 번호
		start = (currentPage - 1) * pageSize + 1;
		
		//현재페이지 끝 번호
		end = start + pageSize - 1;
		
		if(end > cnt){
			end = cnt;
		}
		
		//출력할 글 번호
		number = cnt - (currentPage - 1) * pageSize; 
		
		ArrayList<BoardDTO> dtolist = new ArrayList<BoardDTO>();
		
		String startP = Integer.toString(start);
		String endP = Integer.toString(end);
		list.clear();
		list.add(startP);
		list.add(endP);
		list.add(search);
		
		if(cnt > 0){
			dao.search(13,list,null,null,null,dtolist);
			req.setAttribute("dtolist", dtolist);
		}
		
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if(currentPage % pageBlock == 0){
			startPage -= pageBlock;
		}
		
		endPage = startPage + pageBlock - 1;
		if(endPage > pageCount){
			endPage = pageCount;
		}
		
		req.setAttribute("cnt", cnt); 			//글 개수
		req.setAttribute("number", number); 	//글 번호
		req.setAttribute("pageNum", pageNum); 	//페이지 번호
		
		if(cnt > 0){
			req.setAttribute("cnt", cnt);
			req.setAttribute("startPage", startPage);	//시작 페이지
			req.setAttribute("endPage", endPage);		//마지막 페이지
			req.setAttribute("pageBlock", pageBlock);	//출력할 페이지 개수 : 3
			req.setAttribute("pageCount", pageCount);	//페이지 개수
			req.setAttribute("currentPage", currentPage);
		}
		

		return "/BMS/board/board_list.jsp";
	}
	

}
