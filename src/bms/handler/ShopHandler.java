package bms.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShopHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		return "/BMS/shop.jsp";
	}

}
