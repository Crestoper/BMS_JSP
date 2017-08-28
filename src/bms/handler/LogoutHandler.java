package bms.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		req.getSession().invalidate();
		req.getSession().setAttribute("msg", "700");
		return "home.do";
	}

}
