package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BookDTO;

public class CartBuyHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		
		String go = "";
		
		if(req.getSession().getAttribute("memId") != null){
		
			ArrayList<String> list = new ArrayList<String>();
			BmsDAO dao = BmsDAOImpl.getInstance();
			
			System.out.println("카트 구매페이지 들어옴");
			
			int num = Integer.parseInt(req.getParameter("num"));
			
			System.out.println("for문 전");
			System.out.println("num : " + num);
			
			for(int a = 0; a <= num; a++){
				System.out.println("for문");
				list.add(req.getParameter("isbn"+a));
				list.add(req.getParameter("count"+a));
				list.add((String) req.getSession().getAttribute("memId"));
				list.add(req.getParameter("price"+a));
				list.add(req.getParameter("title"+a));
				
				System.out.println("isbn" + a + "번 : " + req.getParameter("isbn"+a));
				System.out.println("count" + a + "번 : " + req.getParameter("count"+a));
				System.out.println("price" + a + "번 : " + req.getParameter("price"+a));
			}
			
			System.out.println("list size : " + list.size());
			
			System.out.println("for문 후");
			
			int cnt = dao.insert(3, list, null, null);
			int bcnt = dao.update(3, list, null, null);
				
				if(cnt == 1){
					System.out.println("판매 입력 성공");
				}
				if(bcnt == 1){
					System.out.println("book 테이블 수량 조절 성공");
				}
				ArrayList<String> cart = new ArrayList<String>();
				req.getSession().setAttribute("cart", cart);
				req.getSession().setAttribute("msg", "100");
				go = "home.do";
			
		
		//비로그인 상태면 로그인페이지	
		}else{
		
		go = "login.do";
	}
	
		
	
		return "home.do";

	}
}

