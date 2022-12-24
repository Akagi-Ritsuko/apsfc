package com.apsfc.servlet.qiantai;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import com.apsfc.servlet.qiantai.order.Pay_OrderServiceImpl;

/**
 * Servlet implementation class Pay_OrderServlet
 */
public class Pay_OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay_OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String orderNo = request.getParameter("orderNo");
		Pay_OrderServiceImpl pSerImp=new Pay_OrderServiceImpl();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=formatter.format(new Date()); // 将日期时间格式化
		String payNo=System.currentTimeMillis()+"";
		boolean isSuccess=pSerImp.paySuccess(orderNo, payNo, date);
		PrintWriter out = response.getWriter();
		if(!isSuccess) {
			out.write("<script>alert('支付成功,点击返回订单页面!');window.location='./qiantai/order.jsp';</script>");
		}else {
			out.write("<script>alert('支付失败,请重新支付!');window.location='./qiantai/order.jsp';</script>");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
