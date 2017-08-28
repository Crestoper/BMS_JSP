package bms.handler;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.SalesInfoDTO;

public class MypageHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String go = "";
		
		if(req.getSession().getAttribute("memId") != null){
			
			String cnt = null;
			cnt = req.getParameter("cnt");
			System.out.println("cnt : " + cnt);
			
			BmsDAO dao = BmsDAOImpl.getInstance();
			
			ArrayList<SalesInfoDTO> dtolist = new ArrayList<SalesInfoDTO>();

			ArrayList<SalesInfoDTO> searchList = new ArrayList<SalesInfoDTO>();
			ArrayList<SalesInfoDTO> searchList21 = new ArrayList<SalesInfoDTO>();
			ArrayList<SalesInfoDTO> searchList22 = new ArrayList<SalesInfoDTO>();
			
			ArrayList<String> list = new ArrayList<String>();
			
			list.add((String) req.getSession().getAttribute("memId"));
			
			if(cnt == null || cnt.equals("0")){
				dao.search(8, list, null, null,dtolist, null);
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
				
				list.add(name);
				list.add(value);
				
				dao.search(23, list, null, null,dtolist, null);
			}
			dao.search(20, list, null, null, searchList, null);
			//dao.search(21, list, null, null, searchList21, null);
			dao.search(22, list, null, null, searchList22, null);
			
			req.setAttribute("dtolist", dtolist);
			req.setAttribute("searchList", searchList);
			req.setAttribute("searchList21", searchList21);
			req.setAttribute("searchList22", searchList22);
			
		}
		
		return "/BMS/guest/guest_mypage.jsp";
	}

}
