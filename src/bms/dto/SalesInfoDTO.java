package bms.dto;

import java.sql.Date;

public class SalesInfoDTO {

	String salesNum;
	Date salesDay;
	String guestId;
	String isbn;
	String price;
	String salesCount;
	String salesCancel;
	String state;
	String closing;
	String title;
	
	

	
	public Date getSalesDay() {
		return salesDay;
	}
	public void setSalesDay(Date salesDay) {
		this.salesDay = salesDay;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getClosing() {
		return closing;
	}
	public void setClosing(String closing) {
		this.closing = closing;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSalesNum() {
		return salesNum;
	}
	public void setSalesNum(String salesNum) {
		this.salesNum = salesNum;
	}
	public String getGuestId() {
		return guestId;
	}
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSalesCount() {
		return salesCount;
	}
	public void setSalesCount(String salesCount) {
		this.salesCount = salesCount;
	}
	public String getSalesCancel() {
		return salesCancel;
	}
	public void setSalesCancel(String salesCancel) {
		this.salesCancel = salesCancel;
	}
	
	
}
