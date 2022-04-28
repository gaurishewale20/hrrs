package com.example.hrrs.dao;

import java.util.List;

import com.example.hrrs.controller.bean.Reservation;

public interface ReservationDao {
	Reservation getReservationById(Long reservationId);
	int createNewReservation(Reservation reservation);
	List<Reservation> getAllReservations();
	List<Reservation>getAllPastReservations(Long id);
	void deleteReservation(Long reservationId,Long userId);
}
