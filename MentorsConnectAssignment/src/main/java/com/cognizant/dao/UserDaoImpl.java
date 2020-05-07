package com.cognizant.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public boolean checkUser(User user) {
		boolean flag=false;
		String sql="select * from user_table";
		List<User>userList= jdbcTemplate.query(sql,(rs, rowNum) -> new User(rs.getInt(1), rs.getString(2), rs.getString(3))) ;
		for(User user1:userList) {
			if(user.getUserName().equalsIgnoreCase(user1.getUserName()) && (user.getPassword().equalsIgnoreCase(user1.getPassword()))) {
				
				flag=true;
				break;
			}
					
		}
		return flag;
	}

}