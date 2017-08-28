package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BookDTO;

public class BuyPageHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		
		String go = "";
		
		String count = null;
		String isbn = null;
		String price = null;
		String title = null;
		
		count = req.getParameter("count");
		isbn = req.getParameter("isbn");
		price = req.getParameter("price");
		title = req.getParameter("title");	
		
		System.out.println("isbn : " + isbn);
		System.out.println("price : " + price);
		System.out.println("count : " + count);
		System.out.println("title : " + title);
			
		
		BmsDAO dao = BmsDAOImpl.getInstance();
		
		ArrayList<BookDTO> dtolist = new ArrayList<BookDTO>();
		ArrayList<String> list = new ArrayList<String>();	
		
		//로그인 상태면 구매페이지 
		if(req.getSession().getAttribute("memId") != null){
			
			System.out.println(req.getParameter("isbn"));
			
			String num = req.getParameter("isbn");
			
			System.out.println("isbn : " +  num);
			
			list.add(num);
			
			dao.search(4, list, dtolist, null, null, null);
			
			req.setAttribute("dtolist", dtolist);
			
			System.out.println("dtolist : " + dtolist);
			
			go = "/BMS/guest/guest_buyPage.jsp";
			
			if(count != null){
				
				list.clear();
				list.add((String) req.getSession().getAttribute("memId"));
				list.add(isbn);
				list.add(title);
				list.add(price);
				list.add(count);
				
				int cnt = dao.insert(2, list, null, null);
				int bcnt = dao.update(2, list, null, null);
				
				if(cnt == 1){
					System.out.println("판매 입력 성공");
				}
				if(bcnt == 1){
					System.out.println("book 테이블 수량 조절 성공");
				}
				req.getSession().setAttribute("msg", 100);
				go = "home.do";
			}
		
		//비로그인 상태면 로그인페이지	
		}else{
		
		go = "login.do";
	}
		return go;
	}
}
