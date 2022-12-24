package com.apsfc.servlet.qiantai.order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.apsfc.dao.Pay_OderDao;
import com.apsfc.dao.impl.Pay_OrderImp;
import com.apsfc.entity.Pay_Order;
import com.apsfc.service.base.BaseService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.lang.*;


public class Pay_OrderServiceImpl implements Pay_OrderService {
////	MyBatis
//	
//	@Override
//	public Pay_Order add(String body, String money) {
//		Pay_Order order =null;
//		try {
//			order=new Pay_Order();
//			order.setBody(body);
//			order.setMoney(money);
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String date=formatter.format(new Date()); // 将日期时间格式化
//			order.setAddTime(date);
//			order.setOrderNo(System.currentTimeMillis()+"");
//			order.setStatus(0);//订单状态未支付
//			Integer i=super.save(order);
//			if(i==null||i<=0) {
//				throw new Exception("订单保存失败");
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return order;
//	}
//
//	@Override
//	public Pay_Order getPayOrderInfo(String orderNo) {
//		Pay_Order order =null;
//		try {
//			Pay_Order orderWhere= new Pay_Order();
//			orderWhere.setOrderNo(orderNo);
//			order=super.selectOne(orderWhere);
//		}catch(Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//		return order;
//	}
//
//	@Override
//	public boolean paySuccess(String orderNo, String payNo, String payTime) {
//		try {
//			Pay_Order order =getPayOrderInfo(orderNo);
//			if(order==null) {
//				throw new Exception("订单不存在");
//			}
//			if(order.getStatus().intValue()==1) {
//				return true;//订单已支付
//			}
////			订单未支付，在支付成功修改订单支付状态和订单支付时间还有支付单号
//			Pay_Order orderData=new Pay_Order();
//			orderData.setStatus(1);
//			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String date=formatter.format(payTime);//日期格式化
//			orderData.setPayTime(date);
//			order.setPayno(payNo);
//			
//			Example example =new Example (Pay_Order.class);
//			Criteria criteria =example.createCriteria();
//			super.updateSelective(orderData, example);
//			return true;
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}


	
	
	
	
	
	
	
	//原始
	@Override
	public ArrayList<Pay_Order> add(Pay_Order order) {
//		Pay_Order order=new Pay_Order();
//		order.setOrderNo(odNo);
//		order.setBody(body);
//		order.setMoney(money);
		order.setStatus(0);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=formatter.format(new Date()); // 将日期时间格式化
		order.setAddTime(date);
		Pay_OrderImp payDao =new Pay_OrderImp();
		payDao.save(order);
		
		return null;
	}

	@Override
	public List<Pay_Order> getPayOrderInfo(String orderNo) {
		List<Pay_Order> orderlist = new ArrayList<Pay_Order>();

		
		try {
			Pay_Order orderWhere=new Pay_Order();
			orderWhere.setOrderNo(orderNo);
			
			Pay_OrderImp payDao =new Pay_OrderImp();
			orderlist=payDao.getPayOrderByNo(orderNo);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}

		return orderlist;
	}

	@Override
	public boolean paySuccess(String orderNo, String payNo, String payTime)    {
		try {
			List<Pay_Order> orderlist=getPayOrderInfo(orderNo);
			if(orderlist==null) {
				throw new Exception("订单不存在");
			}
			if(orderlist.get(0).getStatus() ==1) {
				return true;
			}
			
//			修改支付时间和支付状态和支付单号
			Pay_Order orderDate=new Pay_Order();
			Pay_OrderImp payImp=new Pay_OrderImp();
			orderDate.setStatus(1);
			orderDate.setPayTime(payTime);
			orderDate.setPayno(payNo);
			orderDate.setOrderNo(orderNo);
			payImp.updateWhenPay(orderDate);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}



}
