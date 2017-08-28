package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BookDTO;
import bms.dto.SalesInfoDTO;

public class HostOrderViewHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//한 페이지 당 출력할 글 개수
		String name = req.getParameter("name") == null ? null : req.getParameter("name");
		String value = req.getParameter("value") == null ? null : req.getParameter("value");
		String pageNum = req.getParameter("pageNum") == null ? "1" : req.getParameter("pageNum");	
		int pageSize = req.getParameter("orderSize") == null ? 5 : Integer.parseInt(req.getParameter("orderSize"));
		String searchCnt = req.getParameter("searchCnt") == null ? "0" : req.getParameter("searchCnt");		

		//
		String agreeCnt = req.getParameter("agreeCnt") == null ? null : req.getParameter("agreeCnt");
		String salesNum = req.getParameter("salesNum") == null ? null : req.getParameter("salesNum");
		String count = req.getParameter("count") == null ? null : req.getParameter("count");
		String isbn = req.getParameter("isbn") == null ? null : req.getParameter("isbn");
		
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
		
		ArrayList<String> list = new ArrayList<String>(); 

		if(agreeCnt != null){
			if(agreeCnt.equals("1")){
				System.out.println("salesNum : " + salesNum);
				list.add(salesNum);
				list.add("1");
				dao.update(7,list,null,null);
			}else if(agreeCnt.equals("2")){
				list.add(salesNum);
				list.add("3");
				list.add(count);
				list.add(isbn);
				dao.update(7,list,null,null);
				dao.update(8,list,null,null);
			}
		}
		
		list.clear();
		
		if(searchCnt.equals("0") || searchCnt == null){
			cnt = dao.search(17,null,null,null,null,null);
		}else{
			if(name.equals("title")){
				name = "b." + name;
				System.out.println("b.+name : " + name);
			}else{
				name = "s."+name;
				System.out.println("s.+name : " + name);
			}
			list.clear();
			list.add(name);
			list.add(value);
			cnt = dao.search(24, list, null, null, null, null);
		}
		
		System.out.println("cnt : " + cnt);
		
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
		
		ArrayList<SalesInfoDTO> dtolist = new ArrayList<SalesInfoDTO>();
		ArrayList<SalesInfoDTO> closingdtos = new ArrayList<SalesInfoDTO>();
		
		String startP = Integer.toString(start);
		String endP = Integer.toString(end);
		list.clear();
		
		list.add(startP);
		list.add(endP);
		
		if(cnt > 0){
			
			System.out.println("startP : " + startP);
			System.out.println("name : " + name);
			System.out.println("value : " + value);
			System.out.println("endP : " + endP);
			
			if(searchCnt == null || searchCnt.equals("0")){
				dao.search(16,list,null,null,dtolist,null);
			}else{
				
				list.clear();
				list.add(startP);
				list.add(name);
				list.add(value);
				list.add(endP);
				
				dao.search(23, list, null, null,dtolist, null);
			}
		
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
			
			System.out.println("dtolist : " + dtolist);
			req.setAttribute("dtolist", dtolist);
			
		}
		
		return "/BMS/host/order_view.jsp";
	}

}
