package bms.handler;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.GuestDTO;

public class JoinusProHandler implements CommandHandler{

	public String Pro(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
		
		req.setCharacterEncoding("UTF-8");
		
		ArrayList<String> list = new ArrayList<String>();
		
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String gAddr = addr1+"@"+addr2;
		
		list.add(req.getParameter("id"));
		list.add(req.getParameter("pw"));
		list.add(req.getParameter("gName"));
		list.add(req.getParameter("gBirth"));
		list.add(gAddr);
		list.add(req.getParameter("gEmail"));
		
		BmsDAO dao = BmsDAOImpl.getInstance();
		
		//insert(1) = 회원가입 sql문
		int cnt = dao.insert(1, list, null, null);
		
		req.setAttribute("cnt", cnt);
		req.getSession().setAttribute("msg", "500");
		
		return "home.do";
	}

}
