package com.apsfc.servlet.qiantai.order;

import java.util.ArrayList;
import java.util.List;

import com.apsfc.entity.Pay_Order;


public interface Pay_OrderService  {
//	保存订单
	public ArrayList<Pay_Order> add(Pay_Order order);
//	根据订单号查询订单
	public List<Pay_Order> getPayOrderInfo(String orderNo);
//	订单支付成功
	public  abstract boolean paySuccess(String orderNo,String payNo,String payTime);
	
////	查询用户所有订单
//	public ArrayList<Pay_Order> getPayOrderById(Integer id);
}
