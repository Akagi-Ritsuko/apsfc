package com.apsfc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;

import com.apsfc.dao.Pay_OderDao;
import com.apsfc.entity.Pay_Order;
import com.apsfc.po.Order;
import com.apsfc.util.DBConn;

import tk.mybatis.mapper.common.Mapper;

public class Pay_OrderImp  {

	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	private int totalpage = 0;
	private int currentpage = 0;
	
	
//	原始
	public int save(Pay_Order order) {
		String sql = "";
		sql = "insert into pay_order(order_no,body,money,status,pay_no,pay_time,add_time)"
				+ " values('"+order.getOrderNo()+"','"+order.getBody()+"','"+order.getMoney()+"','"+order.getStatus()+"','"+order.getPayno()+"','"+order.getPayTime()+"','"+order.getAddTime()+"')";
		int temp = 0;
		Boolean temp1; 
//		System.out.println(order.getUserid()+"++"+order.getMenuid()+' '+order.getMenusum()+' '+order.getTimes()+' '+order.getDelivery());
		conn = DBConn.getConn();
		try {
			st = conn.createStatement();
			temp = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			temp = -1;
		} finally {
			DBConn.close(conn, st, rs);
		}
		return temp;
	}

	public Pay_Order getPayOrderByNo(String orderNo){
		Pay_Order orderlist =new Pay_Order();
		conn = DBConn.getConn();
		try {
			String sql = "select * from pay_order where order_no='"+orderNo+"'";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Pay_Order order = new Pay_Order();
				order.setId(Integer.parseInt(rs.getString("id")));
				order.setAddTime(rs.getString("add_time"));
				order.setMoney(rs.getString("money"));
				order.setOrderNo(rs.getString("order_no"));
				order.setPayno(rs.getString("pay_no"));
				order.setPayTime(rs.getString("pay_time"));
				order.setBody(rs.getString("body"));
				order.setStatus(Integer.parseInt(rs.getString("status")));
				orderlist=order;
//				orderlist.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return orderlist;
	}

//	订单成功修改支付状态支付时间和支付单号
	public int updateWhenPay(Pay_Order orderDate) {
		String sql = "";
		sql = "update pay_order set status=1"+",pay_time='"+orderDate.getPayTime()+"',pay_no='"+orderDate.getPayno()+"'"+" where order_no='" + orderDate.getOrderNo()+"'";
		int temp = 0;
		conn = DBConn.getConn();
		try {
			st = conn.createStatement();
			temp = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			temp = -1;
		} finally {
			DBConn.close(conn, st, rs);
		}
		return temp;
	}
}
