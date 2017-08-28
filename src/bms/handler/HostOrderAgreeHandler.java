package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;

public class HostOrderAgreeHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		String salesNum = req.getParameter("salesNum");
		String count = req.getParameter("count");
		String isbn = req.getParameter("isbn");
		
		ArrayList<String> list = new ArrayList<String>();
		BmsDAO dao = BmsDAOImpl.getInstance();
			
		
		
		System.out.println("수정 cnt : " + cnt);
		System.out.println("수정 salesNum : " + salesNum);
		
		if(cnt == 1){
			list.add(salesNum);
			list.add("1");
			list.add(count);
			dao.update(7,list,null,null);
			
		}else if(cnt == 2){
			list.add(salesNum);
			list.add("3");
			list.add(count);
			list.add(isbn);
			dao.update(7,list,null,null);
			dao.update(8,list,null,null);
	}
		return "/BMS/host/order_view.jsp";
}
}
