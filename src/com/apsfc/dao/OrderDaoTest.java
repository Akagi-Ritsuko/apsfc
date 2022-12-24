package com.apsfc.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.apsfc.po.Order;

class OrderDaoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAdd() throws ParseException {
		Order order=new Order();
//		order.setId(34);
		order.setUserid(13);
		order.setMenuid(24);
		order.setMenusum(2);
		order.setTimes("2022-12-23 17:59:11");
		order.setDelivery(0);
		OrderDao oderD=new OrderDao();
		System.out.println(oderD.add(order));
		

	}

}
