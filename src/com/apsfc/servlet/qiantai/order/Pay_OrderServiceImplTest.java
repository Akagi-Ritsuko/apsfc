package com.apsfc.servlet.qiantai.order;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.apsfc.entity.Pay_Order;

import tk.mybatis.mapper.common.Mapper;

class Pay_OrderServiceImplTest {

	@BeforeEach
	void setUp() throws Exception {
	}



	@Test
	void testGetPayOrderInfo() {
		Pay_Order orderlist = new Pay_Order();
		Pay_OrderServiceImpl pay=new Pay_OrderServiceImpl();
		String orderNo="1671885094578";
		Pay_Order od=new Pay_Order();
		od.setOrderNo(orderNo);
		orderlist=pay.getPayOrderInfo(od.getOrderNo());
		System.out.println(orderlist.toString());
	}

	@Test
	void testPaySuccess() {
		Pay_OrderServiceImpl payImp=new Pay_OrderServiceImpl();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=formatter.format(new Date()); // 将日期时间格式化
		String payNo=System.currentTimeMillis()+"";
		String orderNo="1671885094578";
		System.out.print(payImp.paySuccess(orderNo, payNo, date)); 
	}



}
