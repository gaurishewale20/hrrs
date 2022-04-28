package com.example.hrrs.dao.impl;

import java.math.BigDecimal;
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


import com.example.hrrs.dao.UserDao;
import com.example.hrrs.constants.Constants;
import com.example.hrrs.controller.bean.User;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	@Override
	public User getUserById(String userId) {
		String sql = "select cast(aes_decrypt(unhex(`user_pswd`),'secret') as char(50)), "
				+ "role_id,user.id,name,phone,email,gender from user"
				+ " join user_role on user.id = user_role.user_id where user.user_id=?" ;
		
		return getJdbcTemplate().queryForObject(sql,new Object[] {userId},new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs,int rowNum) throws SQLException{
				 User user = new User();
				 user.setUserId(userId);
				 user.setPassword(rs.getString(1));
				 user.setRoleId(rs.getLong(2));
				 user.setId(rs.getLong(3));
				 user.setName(rs.getString(4));
				 user.setPhone(rs.getBigDecimal(5));
				 user.setEmail(rs.getString(6));
				 user.setGender(rs.getString(7));
				 return user;
			}
		});
	
	}
	

	@Override
	public User getUserByIdNo(Long id) {
		String sql = "select user_id,name,phone,email,gender from user where id=?" ;
		
		return getJdbcTemplate().queryForObject(sql,new Object[] {id},new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs,int rowNum) throws SQLException{
				 User user = new User();
				 user.setUserId(rs.getString(1));
				 user.setId(id);
				 user.setName(rs.getString(2));
				 user.setPhone(rs.getBigDecimal(3));
				 user.setEmail(rs.getString(4));
				 user.setGender(rs.getString(5));
				 return user;
			}
		});
	
	}
	
	@Override
	public int createNewUser(User user) {
		
		String sql1 = "insert into user (user_id,user_pswd,name,phone,email,gender) values (? ,hex(aes_encrypt(? ,'secret')),?,?,?,?);";
//						insert into user(user_id, user_pswd) values(?, hex(aes_encrypt(?, 'secret')));
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		getJdbcTemplate().update(new PreparedStatementCreator(){
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
				PreparedStatement ps = con.prepareStatement(sql1,new String[] {"id"});
				ps.setString(1, user.getUserId());
				ps.setString(2,user.getPassword());
				ps.setString(3,user.getName());
				ps.setBigDecimal(4,user.getPhone());
				ps.setString(5,user.getEmail());
				ps.setString(6,user.getGender());
				
				return ps;
			}
		},keyHolder);
		
		
		Long id = keyHolder.getKey().longValue();
		String sql2 = "insert into user_role (role_id,user_id) values (? , ?);";

		return getJdbcTemplate().update(new PreparedStatementCreator(){
		
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
					PreparedStatement ps = con.prepareStatement(sql2);
					ps.setInt(1, Constants.ROLE_USER);
					ps.setLong(2,id);
					return ps;
			}
		});

	}
	
	@Override 
	public List<User> getAllUsers(){
		String sql = "select * from user";

		return getJdbcTemplate().query(sql,new RowMapper<User>() {
			
			@Override
			public User mapRow(ResultSet rs,int rowNum) throws SQLException{
				User user = new User();
				user.setId(rs.getLong(1));
				user.setUserId(rs.getString(2));
				user.setName(rs.getString(4));
				user.setPhone(rs.getBigDecimal(5));
				user.setEmail(rs.getString(6));
				user.setGender(rs.getString(7));
				return user;
			}
		});

	}
}
