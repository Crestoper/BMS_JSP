package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;

public class IdCheckHandler implements CommandHandler{

	public String Pro(HttpServletRequest req, HttpServletResponse res) {
		
		ArrayList<String> list = new ArrayList<String>();
		String result = "";
		String id = req.getParameter("id");
		System.out.println("id : " + id);
		list.add(id);
		
		BmsDAO dao = BmsDAOImpl.getInstance();
		
		int cnt = dao.search(1,list,null,null, null, null);
		System.out.println("cnt : " + cnt);
		if(cnt == 1){
			req.getSession().setAttribute("msg", "900");	
		
		}else{
			req.getSession().setAttribute("msg", "950");
		}
		
		req.setAttribute("cnt", cnt);
		req.setAttribute("id", id);
		
		return "joinus.do";
	}

}
