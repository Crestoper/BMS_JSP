package bms.dao;

import java.util.ArrayList;

import bms.dto.BoardDTO;
import bms.dto.BookDTO;
import bms.dto.GuestDTO;
import bms.dto.SalesInfoDTO;

public interface BmsDAO {
	
	public static BmsDAO getInstance() {
		return null;
	}

	public int search(int i, ArrayList<String> list, ArrayList<BookDTO> bdtos, ArrayList<GuestDTO> gdtos, ArrayList<SalesInfoDTO> sdtos, ArrayList<BoardDTO> bodtos) ;

	int insert(int i, ArrayList<String> list, ArrayList<BookDTO> dtolist, ArrayList<GuestDTO> gdto);

	public int delete(int i, ArrayList<String> list);

	public int update(int i, ArrayList<String> list, ArrayList<BookDTO> dtolist, ArrayList<GuestDTO> gdto);
	
	
	
	

}
