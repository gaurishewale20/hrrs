package com.example.hrrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrrs.service.ReservationService;
import com.example.hrrs.controller.bean.Reservation;
import com.example.hrrs.dao.ReservationDao;
@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	ReservationDao resDao;
	
	@Override
	public Reservation getReservationById(Long reservationId){
		Reservation res = resDao.getReservationById(reservationId);
		return res;
	}

	@Override 
	public int createNewReservation(Reservation reservation) {
		return resDao.createNewReservation(reservation);
	}
	
	@Override
	public List<Reservation> getAllReservations(){
		return resDao.getAllReservations();
	}

	@Override
	public List<Reservation> getAllPastReservations(Long id){
		return resDao.getAllPastReservations(id);
	}
	
	@Override
	public void deleteReservation(Long reservationId,Long userId) {
		resDao.deleteReservation(reservationId,userId);
	}
}
