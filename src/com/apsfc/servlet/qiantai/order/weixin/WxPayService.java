package com.apsfc.servlet.qiantai.order.weixin;

public interface WxPayService {
	public String nativePay(String body,String money);
}
