package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartPutHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String go = "";
		//로그인 상태면 구매페이지 
		if(req.getSession().getAttribute("memId") != null){
			
			System.out.println(req.getParameter("num"));
			
			String num = req.getParameter("num");
			
			System.out.println("num : " +  num);
			
			String count = req.getParameter("count");
			
			System.out.println("count : " +  count);
			
			ArrayList<String> list = (ArrayList<String>)req.getSession().getAttribute("cart");
			
			list.add(num);
			list.add(count);
			req.getSession().setAttribute("msg", "400");
			
			go = "home.do";
			
		//비로그인 상태면 로그인페이지	
		}else{
			go = "login.do";
		}
		
		return go;
	}

}
