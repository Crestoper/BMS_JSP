package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BookDTO;

public class InfoExitHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String go = "";
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		
		if(cnt == 0){
			req.setAttribute("cnt", 0);
			go = "rePasswd.do";
		
		}else if(cnt == 1){
			
			cnt = 0;
			
			ArrayList<String> list = new ArrayList<String>();
			
			list.add((String)req.getSession().getAttribute("memId"));
			list.add(req.getParameter("pw"));
			
			System.out.println((String)req.getSession().getAttribute("memId"));
			System.out.println(req.getParameter("pw"));
			
			BmsDAO dao = BmsDAOImpl.getInstance();
			
			cnt = dao.search(2,list,null,null, null, null);
			
			if(cnt == 1){
				int dcnt = dao.delete(1,list);
				
				if(dcnt == 1){
					req.getSession().invalidate();
					req.getSession().setAttribute("msg", "800");
					go = "home.do";
				}
			}else{
					req.getSession().setAttribute("msg", "350");
					go = "rePasswd.do";
			}
		}
		
		return go;
	}

	
}
