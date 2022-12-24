package com.apsfc.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
@Table(name="pay_order")
public class Pay_Order implements Serializable {
	
	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="order_no")
	private String orderNo;
	@Column(name="body")
	private String body;
	@Column(name="money")
	private String money;
	@Column(name="status")
	private Integer status;
	@Column(name="pay_no")
	private String payno;
	@Column(name="pay_time")
	private String payTime;
	@Column(name="add_time")
	private String addTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPayno() {
		return payno;
	}
	public void setPayno(String payno) {
		this.payno = payno;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	
	@Override
	public String toString() {
		return "PayOrder [id=" + id + ", orderNo=" + orderNo + ", body=" + body + ", money=" + money + ", status="
				+ status +",payno="+payno+",payTime="+payTime+",addTime"+addTime+ "]";
	}
	
}
