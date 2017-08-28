
package bms.handler;

import java.util.ArrayList;	

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BookDTO;

public class CartHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		
		String go = "";
		//로그인 상태면 구매페이지 
		if(req.getSession().getAttribute("memId") != null){
			String cnt = req.getParameter("cnt");
			String pop = req.getParameter("pop");
			/*String pop =pop = req.getParameter("pop");*/
			String isbn = req.getParameter("isbn");
			
			ArrayList<BookDTO> dtolist = new ArrayList<BookDTO>();
			ArrayList<String> list = (ArrayList<String>)req.getSession().getAttribute("cart");
		
			if(list.isEmpty()){
				req.getSession().setAttribute("msg", "200");
				go = "home.do";
			}else{
				if(cnt != null && cnt.equals("1")){
					for(int x = 0; x < list.size(); x++){
						System.out.println("list에 담긴 isbn : " + list.get(x));
					}
					
					int delpop = Integer.parseInt(pop) * 2;
					System.out.println("delpop : " + delpop);
					System.out.println("list.get(delpop) : " + list.get(delpop));
					list.remove(delpop);
					list.remove((delpop));
					
					cnt = "0";
				}
				BmsDAO dao = BmsDAOImpl.getInstance();
					
				if(list.size() > 0){
					dao.search(5, list, dtolist, null, null, null);
					
					req.setAttribute("dtolist", dtolist);
					
					System.out.println("dtolist : " + dtolist);
				}
				go = "/BMS/guest/guest_cart.jsp";
			}
		//비로그인 상태면 로그인페이지	
			}else{
				go = "login.do";
			}
			
		return go;
	}

}
