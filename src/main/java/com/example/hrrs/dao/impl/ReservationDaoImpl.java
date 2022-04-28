package com.example.hrrs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.hrrs.dao.ReservationDao;
import com.example.hrrs.controller.bean.Reservation;

@Repository
public class ReservationDaoImpl extends JdbcDaoSupport implements ReservationDao{
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	@Override
	public Reservation getReservationById(Long reservationId) {
		String sql = "select * from reservation where reservation_id=?" ;
		
		return getJdbcTemplate().queryForObject(sql,new Object[] {reservationId},new RowMapper<Reservation>() {

			@Override
			public Reservation mapRow(ResultSet rs,int rowNum) throws SQLException{
				 Reservation res = new Reservation();
				 res.setReservationId(reservationId);
				 res.setUserId(rs.getLong(2));
				 res.setBookingDate(rs.getDate(3));
				 res.setCheckInDate(rs.getDate(4));
				 res.setCheckOutDate(rs.getDate(5));
				 res.setRoomType(rs.getString(6));
				 return res;
			}
		});
	
	}
	
	@Override
	public int createNewReservation(Reservation res) {
		
		String sql1 = "insert into reservation (user_id,booking_date,check_in_date,check_out_date,room_type) values (?,?,?,?,?);";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		return getJdbcTemplate().update(new PreparedStatementCreator(){
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
				PreparedStatement ps = con.prepareStatement(sql1,new String[] {"reservation_id"});
				ps.setLong(1,res.getUserId());
				ps.setDate(2,res.getBookingDate());
				ps.setDate(3,res.getCheckInDate());
				ps.setDate(4,res.getCheckOutDate());
				ps.setString(5,res.getRoomType());
				
				return ps;
			}
		},keyHolder);
	}
	
	@Override 
	public List<Reservation> getAllReservations(){
		String sql = "select * from reservation";

		return getJdbcTemplate().query(sql,new RowMapper<Reservation>() {
			
			@Override
			public Reservation mapRow(ResultSet rs,int rowNum) throws SQLException{
				 Reservation res = new Reservation();
				 res.setReservationId(rs.getLong(1));
				 res.setUserId(rs.getLong(2));
				 res.setBookingDate(rs.getDate(3));
				 res.setCheckInDate(rs.getDate(4));
				 res.setCheckOutDate(rs.getDate(5));
				 res.setRoomType(rs.getString(6));
				 return res;
			}
		});

	}
	
	@Override
	public void deleteReservation(Long reservationId,Long userId) {
		Reservation res =  getReservationById(reservationId);
		if(res!=null && (res.getUserId()==userId||userId==1)) {
			String sql = "delete from reservation where reservation_id ="+reservationId.toString();
			getJdbcTemplate().update(sql);
		}
	}
	
	@Override 
	public List<Reservation> getAllPastReservations(Long id){
		String sql = "select * from reservation where user_id ="+id.toString()+" order by check_in_date desc";

		return getJdbcTemplate().query(sql,new RowMapper<Reservation>() {
			
			@Override
			public Reservation mapRow(ResultSet rs,int rowNum) throws SQLException{
				 Reservation res = new Reservation();
				 res.setReservationId(rs.getLong(1));
				 res.setUserId(rs.getLong(2));
				 res.setBookingDate(rs.getDate(3));
				 res.setCheckInDate(rs.getDate(4));
				 res.setCheckOutDate(rs.getDate(5));
				 res.setRoomType(rs.getString(6));
				 return res;
			}
		});

	}
}
