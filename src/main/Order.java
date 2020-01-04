package main;

import java.util.Date;

public class Order {

    private Integer orderId;
    private String username;
    
    private Integer hotelId;
    private Integer startDate;
    private Integer endDate;
    private Integer sNum;
    private Integer dNum;
    private Integer qNum;
	private Integer totalPrice;
    
	public Order(Integer orderId, String username, Integer hotelId, Integer startDate, Integer endDate, Integer sNum,
			Integer dNum, Integer qNum, Integer totalPrice) {
		super();
		this.orderId = orderId;
		this.username = username;
		this.hotelId = hotelId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.sNum = sNum;
		this.dNum = dNum;
		this.qNum = qNum;
		this.totalPrice = totalPrice;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public String getUsername() {
		return username;
	}
	public Integer getHotelId() {
		return hotelId;
	}
	public Integer getStartDate() {
		return startDate;
	}
	public Integer getEndDate() {
		return endDate;
	}
	public Integer getsNum() {
		return sNum;
	}
	public Integer getdNum() {
		return dNum;
	}
	public Integer getqNum() {
		return qNum;
	}
	public Integer getTotalPrice() {
		return totalPrice;
    
}
