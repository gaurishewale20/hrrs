package com.example.hrrs.service;

import java.util.List;

import com.example.hrrs.controller.bean.Reservation;

public interface ReservationService {
	Reservation getReservationById(Long reservationId);
	int createNewReservation(Reservation reservation);
	List<Reservation> getAllReservations();
	List<Reservation> getAllPastReservations(Long id);
	void deleteReservation(Long reservationId,Long userId);
}
