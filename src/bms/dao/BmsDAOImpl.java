package bms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.ldap.InitialLdapContext;
import javax.sql.DataSource;

import bms.dto.BoardDTO;
import bms.dto.BookDTO;
import bms.dto.GuestDTO;
import bms.dto.SalesInfoDTO;

public class BmsDAOImpl implements BmsDAO{

	DataSource dataSource;
	
	private static BmsDAOImpl instance = new BmsDAOImpl();
	
	public static BmsDAO getInstance() {
		
		return instance;
	}
	 
	private BmsDAOImpl(){
		try{
			InitialLdapContext context = new InitialLdapContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch(Exception e){
			
		}
	}
	
	//search 모음 i는 유형
	
	@Override
	public int search(int i, ArrayList<String> list, ArrayList<BookDTO> bdtos, ArrayList<GuestDTO> gdtos, ArrayList<SalesInfoDTO> sdtos, ArrayList<BoardDTO> bodtos) {
	
		int cnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		
		try{
			conn = dataSource.getConnection();
			
			//회원가입 sql
			if(i == 1 || i == 6){
				sql = "select * from guest where guestid = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(0));
			
			//id,pw 비교 확인
			}else if(i == 2){
				sql = "select * from guest where guestid = ? And guestpw = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(0));
				pstmt.setString(2, list.get(1));
				
			//게시판 등 뿌려줄 책 정보
			}else if(i == 3){
				sql = "Select * "
						+ "From (Select isbn, title, subtitle, author, trans, publisher, price, percent, point, count,  rownum rNum "
						      + "From book1 "
						      + ") "
						+ "Where rNum >= ? And rNum <= ? ";
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, list.get(0));
					pstmt.setString(2, list.get(1));
				
			//책 한권 정보 
			}else if(i == 4){
				sql = "Select * From book1 Where isbn = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, list.get(0));
				System.out.println("isbn in sql : " + list.get(0));
			//cart 책 담기
			}else if(i == 5){
				for(int a = 0; a < list.size(); a+=2){
					sql = "Select * From book1 Where isbn = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, list.get(a));
					System.out.println("isbn in sql : " + list.get(a));
					
					rs = pstmt.executeQuery();
					
					if(rs.next()){
						cnt = 1;
						
						do{
							BookDTO dto = new BookDTO();
							
							dto.setIsbn(rs.getString("isbn"));
							dto.setTitle(rs.getString("title"));
							dto.setSubTitle(rs.getString("subtitle"));
							dto.setAuthor(rs.getString("author"));
							dto.setTrans(rs.getString("trans"));
							dto.setPublisher(rs.getString("publisher"));
							dto.setPrice(rs.getString("price"));
							dto.setPercent(rs.getString("percent"));
							dto.setPoint(rs.getString("point"));
							dto.setCount(rs.getString("count"));
							dto.setCartCount(list.get(a+1));
							System.out.println("isbn : " + rs.getString("isbn"));
							System.out.println("title : " + rs.getString("title"));
							System.out.println("subtitle : " + rs.getString("subtitle"));
							System.out.println("author : " + rs.getString("author"));
							System.out.println("trans : " + rs.getString("trans"));
							System.out.println("publisher : " + rs.getString("publisher"));
							System.out.println("price : " + rs.getString("price"));
							System.out.println("percent : " + rs.getString("percent"));
							System.out.println("point : " + rs.getString("point"));
							System.out.println("count : " + rs.getString("count"));
							System.out.println("cartCount : " + list.get(a+1));
							
							bdtos.add(dto);
								
						}while(rs.next());
					}
				}
			}else if(i == 7){
				sql = "Select * From book1 Where title like '%'||?||'%'";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, list.get(0));
			
			}else if(i == 8){
				sql = "Select s.salesnum as salesnum, s.guestid as guestid, s.salesday as salesday, s.isbn as isbn, b.price as price, s.salesstock as salesstock, s.state as state, b.title as title From salesinfo s join book1 b on s.isbn = b.isbn Where guestid = ? order by salesNum desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, list.get(0));
			
			}else if(i == 9){
				sql = "Select count(*) From board";
				pstmt = conn.prepareStatement(sql);
				
			}else if(i == 10){
				sql = "Select * "
					+ "From (Select num, writer, passwd, subject, content, readCnt, "
					+ 		"ref, ref_step, ref_level, reg_date, ROWNUM as rNum "
					+ 		"From (Select * "
					+ 			  "From board "
					+ 			  "Order By ref Desc, ref_step Asc" 
					+ 			 ") " 
					+ 		") "
					+ "Where rNum >= ? "
					+ "And rNum <= ? "; 
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, list.get(0));
				pstmt.setString(2, list.get(1));
			
			}else if(i == 11){
				sql = "Select * From board Where num = ? ";
						
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, list.get(0));
		
			}else if(i == 12){
				sql = "Select count(*) From board Where subject like '%'||?||'%'";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, list.get(0));
			
			}else if(i == 13){
				sql = "Select * "
						+ "From (Select num, writer, passwd, subject, content, readCnt, ref, ref_step, ref_level, reg_date, ROWNUM as rNum "
						+ 		"From (Select * "
						+ 			  "From (Select num, writer, passwd, subject, content, readCnt, ref, ref_step, ref_level, reg_date "
						+ 					"From board "
						+ 					"Where subject like '%'||?||'%' "
						+ 					") " 
						+ 			  "Order By ref Desc, ref_step Asc " 
						+ 			 ") "
						+ 		") " 
						+ "Where rNum >= ? "
						+ "And rNum <= ? "; 
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(2, list.get(0));
					pstmt.setString(3, list.get(1));
					pstmt.setString(1, list.get(2));
				
				}else if(i == 14){
					sql = "Select count(*) From book1";
					pstmt = conn.prepareStatement(sql);
					
				}else if(i == 15){
					sql = "Select count(*) From book1 Where title like '%'||?||'%'";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, list.get(0));
				
				}else if(i == 16){
					sql = "Select * "
							+ "From (Select salesnum, guestid, salesday, isbn, title, price, salesstock,state, ROWNUM as rNum  "
							+ 		"From (Select * "
							+ 			  "From salesInfo join book1 "
							+ 			  "using(isbn) "
							+ 			  "Order By salesnum DESC " 
							+ 			 ") " 
							+ 		") "
							+ "Where rNum >= ? "
							+ "And rNum <= ? "; 
						
					System.out.println("여기 들어왔다");
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, list.get(0));
						pstmt.setString(2, list.get(1));
				
				}else if(i == 17){
					
					sql = "Select count(*) From salesInfo";
					
					pstmt = conn.prepareStatement(sql);
					
				}else if(i == 18){
					sql = "select s.salesnum as salesnum, s.isbn as isbn, b.title as title, b.price as price, s.salesday as salesday, sum(s.salesstock) as stock from salesinfo s join book1 b on s.isbn = b.isbn where s.state = 1 group by s.salesnum, s.isbn, b.title, s.salesday, b.price";
					pstmt = conn.prepareStatement(sql);
					
				}else if(i == 19){
					sql = "select * from board where writer = ? And passwd = ?";
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, list.get(0));
					pstmt.setString(2, list.get(1));
				
				}else if(i == 20){
					if(list.get(0).equals("search")){
						sql = "SELECT distinct b.title as title ,s.isbn as isbn from salesinfo s join book1 b on s.isbn = b.isbn";
						pstmt = conn.prepareStatement(sql);
					}else{
					sql = "SELECT distinct b.title as title ,s.isbn as isbn from salesinfo s join book1 b on s.isbn = b.isbn where guestid = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, list.get(0));
					}
				
				}else if(i == 22){
					if(list.get(0).equals("search")){
						sql = "SELECT DISTINCT state from salesinfo";
						pstmt = conn.prepareStatement(sql);
					}else{
						sql = "SELECT DISTINCT state from salesinfo where guestid = ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, list.get(0));
					}
				}else if(i == 23){
						String name = list.get(1);
						System.out.println("list.get(1) " + list.get(1));
						if(list.size() < 4){
							sql = "Select s.salesnum as salesnum, s.isbn as isbn, b.title as title, b.price as price, s.salesday as salesday, s.state as state, s.salesstock as salesstock, s.guestid as guestid From salesinfo s join book1 b on s.isbn = b.isbn Where guestid = ? AND " + name + " = ? order by s.salesNum desc";
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, list.get(0));
							pstmt.setString(2, list.get(2));
						}else{
							sql = "Select salesnum, isbn, title, price, salesday, state, salesstock, guestid "
								+ "From(Select s.salesnum as salesnum, s.isbn as isbn, b.title as title, b.price as price, s.salesday as salesday, s.state as state, s.salesstock as salesstock, s.guestid as guestid, rownum as rnum "
								+ 		"From salesinfo s join book1 b "
								+ 		"on s.isbn = b.isbn "
								+ 		"Where " + name + " = ? "
								+ 		"order by s.salesNum desc "
								+ 		") "
								+ "Where rnum >= ? AND rnum <= ? ";
							
							System.out.println("name : " + name);
							System.out.println("list.get(0) : " + list.get(0));
							System.out.println("list.get(3) : " + list.get(3));
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, list.get(2));
							pstmt.setString(2, list.get(0));
							pstmt.setString(3, list.get(3));
						}
				}else if(i == 24){
					String name = list.get(0);
					sql = "Select count(*) From salesinfo s join book1 b on s.isbn = b.isbn Where " + name + " = ?";	
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, list.get(1));
				
				}else if(i == 25){
					sql = "SELECT DISTINCT guestId from salesinfo";
					pstmt = conn.prepareStatement(sql);
				
				}else if(i == 26){
					sql = "Select * From salesinfo s join book1 b on s.isbn = b.isbn";
				}
			
			rs = pstmt.executeQuery();

			if(rs.next()){
				cnt = 1;
				
				if(i == 3 || i == 4 || i == 7){
					
					do{
						BookDTO dto = new BookDTO();
						
						dto.setIsbn(rs.getString("isbn"));
						dto.setTitle(rs.getString("title"));
						dto.setSubTitle(rs.getString("subtitle"));
						dto.setAuthor(rs.getString("author"));
						dto.setTrans(rs.getString("trans"));
						dto.setPublisher(rs.getString("publisher"));
						dto.setPrice(rs.getString("price"));
						dto.setPercent(rs.getString("percent"));
						dto.setPoint(rs.getString("point"));
						dto.setCount(rs.getString("count"));
						
						System.out.println("isbn : " + rs.getString("isbn"));
						System.out.println("title : " + rs.getString("title"));
						System.out.println("subtitle : " + rs.getString("subtitle"));
						System.out.println("author : " + rs.getString("author"));
						System.out.println("trans : " + rs.getString("trans"));
						System.out.println("publisher : " + rs.getString("publisher"));
						System.out.println("price : " + rs.getString("price"));
						System.out.println("percent : " + rs.getString("percent"));
						System.out.println("point : " + rs.getString("point"));
						System.out.println("count : " + rs.getString("count"));
						
						
						bdtos.add(dto);
						
					}while(rs.next());
				
				}else if(i == 6){
						
						GuestDTO dto = new GuestDTO();
						
						dto.setGuestName(rs.getString("guestname"));
						dto.setGuestPw(rs.getString("guestpw"));
						dto.setGuestBirth(rs.getString("guestbirth"));
						dto.setGuestAddr(rs.getString("guestaddr"));
						dto.setGuestEmail(rs.getString("guestemail"));
						
						System.out.println("guestname : " + rs.getString("guestname"));
						System.out.println("guestpw : " + rs.getString("guestpw"));
						System.out.println("guestbirth : " + rs.getString("guestbirth"));
						System.out.println("guestaddr : " + rs.getString("guestaddr"));
						System.out.println("guestemail : " + rs.getString("guestemail"));
						
						gdtos.add(dto);
				
				}else if(i == 8 || i == 16 || i == 23 || i == 26){
					do{
						SalesInfoDTO dto = new SalesInfoDTO();
						
						dto.setSalesNum(rs.getString("salesnum"));
						dto.setGuestId(rs.getString("guestid"));
						dto.setSalesDay(rs.getDate("salesday"));
						dto.setIsbn(rs.getString("isbn"));
						dto.setPrice(rs.getString("price"));
						dto.setSalesCount(rs.getString("salesstock"));
						dto.setState(rs.getString("state"));
						dto.setTitle(rs.getString("title"));
						
						sdtos.add(dto);
						
					}while(rs.next());
				
				}else if(i == 9 || i == 12 || i == 14 || i == 17 || i == 24){
					cnt = rs.getInt(1);
				
				}else if(i == 10 || i == 11 || i == 13){
					
					do{
						BoardDTO dto = new BoardDTO();
						
						dto.setNum(rs.getInt(1));
						dto.setWriter(rs.getString(2));
						dto.setPasswd(rs.getString(3));
						dto.setSubject(rs.getString(4));
						dto.setContent(rs.getString(5));
						dto.setReadCnt(rs.getInt(6));
						dto.setRef(rs.getInt(7));
						dto.setRef_step(rs.getInt(8));
						dto.setRef_level(rs.getInt(9));
						dto.setReg_date(rs.getTimestamp(10));
						
						System.out.println("setNum : " + rs.getInt(1));
						System.out.println("setWriter : " + rs.getString(2));
						System.out.println("setPasswd : " + rs.getString(3));
						System.out.println("setSubject : " + rs.getString(4));
						System.out.println("setContent : " + rs.getString(5));
						System.out.println("setReadCnt : " + rs.getInt(6));
						System.out.println("setRef : " + rs.getInt(7));
						System.out.println("setRef_step : " + rs.getInt(8));
						System.out.println("setRef_level : " + rs.getInt(9));
						System.out.println("setReg_date : " + rs.getString(10));
						
						bodtos.add(dto);
						
					}while(rs.next());
					
				}else if(i == 18){
					int closing = 0;
					do{
						SalesInfoDTO dto = new SalesInfoDTO();
						int price = rs.getInt("price");
						int stock = rs.getInt("stock");
						int clo = price * stock;
						closing += price * stock;
						
						dto.setSalesNum(rs.getString("salesnum"));
						dto.setIsbn(rs.getString("isbn"));
						dto.setTitle(rs.getString("title"));
						dto.setPrice(Integer.toString(price));
						dto.setSalesDay(rs.getDate("salesday"));
						dto.setSalesCount(Integer.toString(stock));
						dto.setClosing(Integer.toString(clo));
						
						sdtos.add(dto);
						
					}while(rs.next());
					System.out.println("합산 완료 된 closing : " + closing);
					cnt = closing;
				
				}else if(i == 20){
					do{
						SalesInfoDTO dto = new SalesInfoDTO();
						
						dto.setIsbn(rs.getString("isbn"));
						dto.setTitle(rs.getString("title"));
						
						sdtos.add(dto);
					
					}while(rs.next());
				
				}else if(i == 21){
					do{
						SalesInfoDTO dto = new SalesInfoDTO();
						
						dto.setSalesDay(rs.getDate("salesday"));

						sdtos.add(dto);
					
					}while(rs.next());
					
				}else if(i == 22){
					do{
						SalesInfoDTO dto = new SalesInfoDTO();
						
						dto.setState(rs.getString("state"));
						
						sdtos.add(dto);
					
					}while(rs.next());
				}else if(i == 25){
					do{
						SalesInfoDTO dto = new SalesInfoDTO();
						System.out.println("rs.getString(guestid) : " + rs.getString("guestid"));
						dto.setGuestId(rs.getString("guestid"));
						
						sdtos.add(dto);
					
					}while(rs.next());
				}
				
			}else{
				cnt = 0;
			}
			
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				if(rs != null) rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	//insert명령 모음 i = 유형 
	@Override
	public int insert(int i, ArrayList<String> list, ArrayList<BookDTO> dtolist, ArrayList<GuestDTO> gdto) {
		
		int cnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "";
		
		try{
			conn = dataSource.getConnection();
			
			
			//회원가입 sql
			if(i == 1){
				sql = "insert into guest values(g_seq.nextval, ?,?,?,?,?,?)";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(0));
				pstmt.setString(2, list.get(1));
				pstmt.setString(3, list.get(2));
				pstmt.setString(4, list.get(3));
				pstmt.setString(5, list.get(4));
				pstmt.setString(6, list.get(5));
			
				//책 한권 구매
			}else if(i == 2){
				sql = "Insert Into salesinfo(salesnum, guestid, isbn, salesstock,state) Values(sales_seq.nextval, ?, ?, ?, 0)";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(0));
				pstmt.setString(2, list.get(1));
				pstmt.setString(3, list.get(4));
				
			}else if(i == 3){
				
				for(int a = 0;a < list.size();a+=5){
				
				sql = "Insert Into salesinfo(salesnum, isbn,  salesstock, guestid, price) Values(sales_seq.nextval, ?, ?, ?, 0)";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(a));
				pstmt.setString(2, list.get(a+1));
				pstmt.setString(3, list.get(a+2));
				
				cnt = pstmt.executeUpdate();
				}
			}else if(i == 4){
				BoardDTO dto = new BoardDTO();
				
				int num = Integer.parseInt(list.get(7));
				int ref = Integer.parseInt(list.get(4));
				int ref_level = Integer.parseInt(list.get(5));
				int ref_step = Integer.parseInt(list.get(6));
				
				if(num == 0){
					ResultSet rs = null;
					
					sql = "Select Max(num) From board";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					if(rs.next()){
						ref = rs.getInt(1) + 1;
					}else{
						ref = 1;
					}
					ref_level = 0;
					ref_step = 0;
					
					rs.close();
					pstmt.close();
				}else{
					sql = "Update board Set ref_step = ref_step + 1 Where ref = ? And ref_step > ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, ref);
					pstmt.setInt(2, ref_step);
					
					pstmt.executeUpdate();
					
					ref_step++;
					ref_level++;
					
					pstmt.close();
				}
				
				sql = "Insert Into board(num, writer, passwd, subject, content, ref, ref_level, ref_step) values(board_seq.nextval, ?,?,?,?,?,?,?)";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(0));
				pstmt.setString(2, list.get(1));
				pstmt.setString(3, list.get(2));
				pstmt.setString(4, list.get(3));
				pstmt.setInt(5, ref);
				pstmt.setInt(6, ref_level);
				pstmt.setInt(7, ref_step);
				
			}else if(i == 5){
				sql = "insert into book1(isbn,title,author,publisher,price,count,subTitle,trans) values(?,?,?,?,?,?,?,?)";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(0));
				pstmt.setString(2, list.get(1));
				pstmt.setString(3, list.get(2));
				pstmt.setString(4, list.get(3));
				pstmt.setString(5, list.get(4));
				pstmt.setString(6, list.get(5));
				pstmt.setString(7, list.get(6));
				pstmt.setString(8, list.get(7));
			
			}
			
			if(i != 3){
				cnt = pstmt.executeUpdate();
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return cnt;
	}

	@Override
	public int delete(int i, ArrayList<String> list) {
		
		int cnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "";
		
		try{
			conn = dataSource.getConnection();
			
			
			//회원탈퇴 sql
			if(i == 1){
				sql = "delete guest where guestid = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(0));
			
			}else if(i == 2){
				sql = "delete board where num = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(0));
			}else if(i == 3){
				sql = "delete book1 where isbn = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(0));
			
			//주문 취소시 주문 삭제
			}else if(i == 4){
				sql = "delete salesinfo where isbn = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(0));
			}
			
			cnt = pstmt.executeUpdate();
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return cnt;
	}

	@Override
	public int update(int i, ArrayList<String> list, ArrayList<BookDTO> dtolist, ArrayList<GuestDTO> gdto) {
		
		int cnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "";
		
		try{
			conn = dataSource.getConnection();
			
			//회원수정 sql
			if(i == 1){
				sql = "Update guest Set guestpw = ?, guestaddr = ?, guestemail = ? Where guestid = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(1)); 
				pstmt.setString(2, list.get(2));
				pstmt.setString(4, list.get(0));
				pstmt.setString(3, list.get(3));
				
			}else if(i == 2){
				sql = "Update book1 Set count = (count - ?) Where isbn = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(4)); 
				pstmt.setString(2, list.get(1));
				
			}else if(i == 3){
				for(int a = 0; a < list.size() -1; a+=5){
				
				sql = "Update book1 Set count = (count - ?) Where isbn = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(a+1)); 
				pstmt.setString(2, list.get(a));
				
				System.out.println("book1테이블 count - 업데이트");
				System.out.println(list.get(a+1));
				System.out.println(list.get(a));
				
				cnt = pstmt.executeUpdate();
				}
			}else if(i == 4){
				sql = "Update board Set readCnt = (readCnt + 1) Where num = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(0)); 
			
			}else if(i == 5){
				sql = "Update board Set subject = ?, content = ?, passwd = ? Where num = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(0));
				pstmt.setString(2, list.get(1));
				pstmt.setString(3, list.get(2));
				pstmt.setString(4, list.get(3));
				
			}else if(i == 6){
				sql = "Update book1 Set isbn = ?, title = ?, author = ?, publisher = ?, price = ?, count = ?, subTitle = ?, trans = ? Where isbn = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(0));
				pstmt.setString(2, list.get(1));
				pstmt.setString(3, list.get(2));
				pstmt.setString(4, list.get(3));
				pstmt.setString(5, list.get(4));
				pstmt.setString(6, list.get(5));
				pstmt.setString(7, list.get(6));
				pstmt.setString(8, list.get(7));
				pstmt.setString(9, list.get(8));
			
			}else if(i == 7){
				sql = "Update salesinfo Set state = ? Where salesnum = ?";
				 
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, list.get(1));
				pstmt.setString(2, list.get(0));
				
			}else if(i == 8){
				sql = "Update book1 set count = (count + ?) Where isbn = ?";
				
				System.out.println("list.get(2) : " + list.get(2));
				System.out.println("list.get(3) : " + list.get(3));
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, list.get(2));
				pstmt.setString(2, list.get(3));

			}else if(i == 11){
				sql = "Update salesinfo Set closing = 0 Where salesnum = ?";
				 
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(0));
				
				System.out.println("pstmt.setString(1, list.get(1)) : " + list.get(1));
				System.out.println("pstmt.setString(1, list.get(0)) : " + list.get(0));
			
			}else if(i == 12){
				sql = "Update board Set subject = '관리자 삭제', content = '관리자에 의해 삭제된 글입니다.', passwd = 'host' Where num = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, list.get(0));
				
			}
			
			if(i != 3){
				cnt = pstmt.executeUpdate();
				System.out.println("cnt : " + cnt);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return cnt;
	}

	

}
