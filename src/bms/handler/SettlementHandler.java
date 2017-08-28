package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.SalesInfoDTO;

public class SettlementHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {

		BmsDAO dao = BmsDAOImpl.getInstance();
		
		
		ArrayList<String> list = new ArrayList<String>(); 
		ArrayList<SalesInfoDTO> searchList = new ArrayList<SalesInfoDTO>();
		ArrayList<SalesInfoDTO> guestIdList = new ArrayList<SalesInfoDTO>();

		list.add("search");
		dao.search(20, list, null, null, searchList, null);
		dao.search(25, null, null, null, guestIdList, null);
		
		req.setAttribute("searchList", searchList);
		req.setAttribute("guestIdList", guestIdList);
		
		return "/BMS/host/host_settlement.jsp";
	}

}
