package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.GuestDTO;

public class InfoModifyHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		
		String go = "";
		
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		
		ArrayList<String> list = new ArrayList<String>();
		BmsDAO dao = BmsDAOImpl.getInstance();
		ArrayList<GuestDTO> dtos = new ArrayList<GuestDTO>();
		System.out.println("가져온 cnt : " + cnt);
		
		if(cnt == 0){
			req.setAttribute("cnt", 3);
			go = "rePasswd.do";
		
		}else if(cnt == 1){
			
			list.add((String)req.getSession().getAttribute("memId"));
			list.add(req.getParameter("pw"));
			
			System.out.println((String)req.getSession().getAttribute("memId"));
			System.out.println(req.getParameter("pw"));
			cnt = dao.search(2,list,null,null, null, null);
			System.out.println("cnt = 1 이면 id = pw : " + cnt);
			if(cnt == 1){
				
				dao.search(6, list, null, dtos, null, null);
				
				req.setAttribute("dtos", dtos);
				System.out.println("dtos 넘김 : " + dtos);
				
				go = "/BMS/guest/guest_infoModify.jsp";
			}else{
				req.getSession().setAttribute("msg", "350");
				go = "rePasswd.do";
			}
			
		}else if(cnt == 2){
			
			System.out.println("회원정보 가져왓으면 cnt = 2 : " + cnt);
			list.clear();
			String addr1 = req.getParameter("addr1");
			String addr2 = req.getParameter("addr2");
			String gAddr = addr1+"@"+addr2;
			
			list.add((String)req.getSession().getAttribute("memId"));
			list.add(req.getParameter("pw"));
			list.add(gAddr);
			list.add(req.getParameter("gEmail"));
			
			
			System.out.println("회원정보 반영 전 cnt = 1 : " + cnt);
				
			int dcnt = dao.update(1,list, null, null);
				
			System.out.println("회원정보 반영 되었음 dcnt = 1 : " + dcnt);
			if(dcnt == 1){
				req.getSession().setAttribute("msg", "600");
				go = "home.do";
				
			}else{
				go = "rePasswd.do";
				}
			}
		
		
		return go;
	}
	
}
