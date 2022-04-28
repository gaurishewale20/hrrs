package com.example.hrrs.controller.bean;

import java.sql.Date;
public class Reservation {
	private Long reservationId;
	private Long userId;
	private Date bookingDate;
	private Date checkInDate;
	private Date checkOutDate;
	private String roomType;
	
	public Long getReservationId() {
		return reservationId;
	}
	
	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Date getBookingDate () {
		return bookingDate;
	}
	
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	public Date getCheckInDate() {
		return checkInDate;
	}
	
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getRoomType() {
		return roomType;
	}
	
	public void setRoomType(String roomType ) {
		this.roomType = roomType;
	}
	
	
}
