package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BookDTO;
import bms.dto.SalesInfoDTO;

public class HostOrderListHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//한 페이지 당 출력할 글 개수
				int closing = 0;
			
				int pageSize = 5;
				
				System.out.println("pageSize : " + req.getParameter("pageSize"));
				
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
				//글 개수 구하기
				
				cnt = dao.search(17,null,null,null,null,null); 
				
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
				
				ArrayList<SalesInfoDTO> dtolist = new ArrayList<SalesInfoDTO>();
				ArrayList<SalesInfoDTO> closingdtos = new ArrayList<SalesInfoDTO>();
				ArrayList<String> list = new ArrayList<String>(); 
				ArrayList<SalesInfoDTO> guestIdList = new ArrayList<SalesInfoDTO>();
				String startP = Integer.toString(start);
				String endP = Integer.toString(end);
				list.add(startP);
				list.add(endP);
				
				if(cnt > 0){
					
					String searchCnt = null;
					searchCnt = req.getParameter("searchCnt");
					
					if(searchCnt == null || searchCnt.equals("0")){
						dao.search(16,list,null,null,dtolist,null);
					}else{
						String name = req.getParameter("name");
							if(name.equals("title")){
								name = "b." + name;
								System.out.println("b.+name : " + name);
							}else{
								name = "s."+name;
								System.out.println("s.+name : " + name);
							}
						String value = req.getParameter("value");
						System.out.println("name : " + name);
						System.out.println("value : " + value);
						
						list.clear();
						list.add("search");
						list.add(name);
						list.add(value);
						list.add("search");
						
						dao.search(23, list, null, null,dtolist, null);
					}

					closing = dao.search(18,null,null,null,closingdtos,null);
					System.out.println("closing : " + closing);
					
					
					ArrayList<SalesInfoDTO> searchList = new ArrayList<SalesInfoDTO>();
					ArrayList<SalesInfoDTO> searchList22 = new ArrayList<SalesInfoDTO>();
					list.clear();
					
					list.add("search");
					dao.search(20, list, null, null, searchList, null);
					dao.search(22, list, null, null, searchList22, null);
					dao.search(25, null, null, null, guestIdList, null);
					
					req.setAttribute("dtolist", dtolist);
					req.setAttribute("searchList", searchList);
					req.setAttribute("searchList22", searchList22);
					req.setAttribute("guestIdList", guestIdList);
					
					System.out.println("guestIdList : " + guestIdList.get(0).getGuestId());
					System.out.println("guestIdList : " + guestIdList.get(1).getGuestId());
					System.out.println("guestIdList : " + guestIdList.get(2).getGuestId());
					System.out.println("guestIdList : " + guestIdList.get(3).getGuestId());
					
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
					req.setAttribute("closing", closing);
				}
				
				return "/BMS/host/host_order.jsp";
	}

}
