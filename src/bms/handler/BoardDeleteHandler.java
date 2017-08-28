package bms.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bms.dao.BmsDAO;
import bms.dao.BmsDAOImpl;
import bms.dto.BoardDTO;

public class BoardDeleteHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {
req.setCharacterEncoding("UTF-8");
		
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		String go = "";
		String pageNum = req.getParameter("pageNum");;
		String writer = req.getParameter("writer");;
		String num = req.getParameter("num");
		
		ArrayList<String> list = new ArrayList<String>();
		
		BmsDAO dao = BmsDAOImpl.getInstance();
		
		//비번입력페이지
		if(cnt == 0){

			req.setAttribute("num", num);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("cnt", 4);
			req.setAttribute("writer", writer);
			
			go = "/BMS/board/board_pw.jsp";
			
		//비번확인
		}else if(cnt == 1){
			//host인 경우 관리자 삭제라고 뜸
			if(req.getSession().getAttribute("memId").equals("host") && !writer.equals("host")){
				
				list.clear();
				System.out.println("게시판 수정 req.getAttribute(num) : " + req.getAttribute("num"));
				list.add(num);
				
					dao.update(12, list, null, null);
				
				go = "boardList.do?pageNum="+pageNum;
			}else{
			
				req.setAttribute("pageNum", pageNum);
				req.setAttribute("num", num);
				list.add(writer);
				list.add(req.getParameter("pw"));
				
				cnt = dao.search(19,list,null,null, null, null);
				
					if(cnt == 0){
						
						req.setAttribute("num", num);
						req.setAttribute("pageNum", pageNum);
						req.setAttribute("cnt", 4);
						req.setAttribute("writer", writer);
						
						go = "/BMS/board/board_pw.jsp";
					
					}else if(cnt == 1){
						list.clear();
						System.out.println("게시판 수정 req.getAttribute(num) : " + req.getAttribute("num"));
						list.add(num);
						
						cnt = dao.delete(2,list);
						System.out.println("삭제 여부 cnt 0 : x 1 : o : " + cnt);
						
						System.out.println("삭제 후 pageNum : " + pageNum);
						
						go = "boardList.do?pageNum="+pageNum;
					}
			}
		
		}
		return go;

}
}
