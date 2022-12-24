package com.apsfc.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.apsfc.po.User;

class UserDaoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testLogin() {
		UserDao us=new UserDao();
		User user=new User();
		user=us.login("12345", "123456");
		System.out.println(user.getId());
	}

}
