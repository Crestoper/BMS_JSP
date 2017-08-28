package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BoardDTO;
import bms.dto.BookDTO;

public class HostBookSearchHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");

		//한 페이지 당 출력할 글 개수
		int pageSize = 5;
				
		System.out.println("pageSize : " + req.getParameter("pageSize"));
		
		if(req.getParameter("pageSize") != null){
			pageSize = Integer.parseInt(req.getParameter("pageSize"));
		}
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
		System.out.println("req.getParameter(search) : " + req.getParameter("search"));
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(search);

		//글 개수 구하기
		cnt = dao.search(15,list,null,null,null,null); 
		System.out.println("cnt : " + cnt);
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
		
		ArrayList<BookDTO> dtolist = new ArrayList<BookDTO>();
		
		String startP = Integer.toString(start);
		String endP = Integer.toString(end);
		
		if(cnt > 0){
			dao.search(7,list,dtolist, null,null,null);
			req.setAttribute("dtolist", dtolist);
			System.out.println("dtolist : " + dtolist);
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
		
		return "/BMS/host/host_stock.jsp";
	}

}
