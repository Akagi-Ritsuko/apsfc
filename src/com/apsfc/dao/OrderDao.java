package com.apsfc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.apsfc.po.Order;
import com.apsfc.util.DBConn;

public class OrderDao {

	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	private int totalpage = 0;
	private int currentpage = 0;

	/* ��ҳ�� */
	public int getTotalpage() {
		return totalpage;
	}

	/* ��ǰҳ */
	public int getCurrentpage() {
		return currentpage;
	}

	/* ��ҳ��ʾ������Ϣ */
	/* pageΪ�����ҳ�� */
	/* sizeÿҳ��ʾ��Ŀ�� */
	public List<Order> pageList(int page, int size) {
		List<Order> orderlist = new ArrayList<Order>();
		String sql = "SELECT COUNT(*) FROM orders";
		conn = DBConn.getConn();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int totalcount = 0;
			if (rs.next()) {
				totalcount = rs.getInt(1);
			}
			if (totalcount != 0) {
				/* ������ҳ�� */
			//	totalpage = totalcount / size + 1;
				if (totalcount % size == 0) {
					totalpage = totalcount / size;
				} else {
					totalpage = totalcount / size + 1;
				}
				int pagesize = 0;
				currentpage = page;
				if (page < 1) {
					currentpage = 1;
				}
				if (page > totalpage) {
					currentpage = totalpage;
				}
				if (currentpage == totalpage&&totalcount % size != 0) {
					pagesize = totalcount % size;
				} else {
					pagesize = size;
				}
				int start = (currentpage - 1) * size;
				sql = "select c.id as id,a.id as userid,b.id as menuid,c.id as orderid,realname,phone,address,b.name as menuname,menusum,price1,times,delivery from users a,menus b,orders c where a.id=c.userid and b.id=c.menuid limit "
						+ start + "," + pagesize;
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) {
					Order order = new Order();
					order.setId(Integer.parseInt(rs.getString("id")));
					order.setUserid(Integer.parseInt(rs.getString("userid")));
					order.setMenuid(Integer.parseInt(rs.getString("menuid")));
					order.setOrderid(Integer.parseInt(rs.getString("orderid")));
					order.setRealname(rs.getString("realname"));
					order.setPhone(rs.getString("phone"));
					order.setAddress(rs.getString("address"));
					order.setMenuname(rs.getString("menuname"));
					order.setMenusum(Integer.parseInt(rs.getString("menusum")));
					order.setPrice1(Float.parseFloat(rs.getString("price1")));
					order.setTimes(rs.getString("times"));
					order.setDelivery(Integer.parseInt(rs.getString("delivery")));
					orderlist.add(order);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return orderlist;
	}

	/* ���������ڲ�ѯ */
	public List<Order> getOrderByDate(String date) {
		List<Order> orderlist = new ArrayList<Order>();
		conn = DBConn.getConn();
		try {
			String sql = "select c.id as id,a.id as userid,b.id as menuid,c.id as orderid,realname,phone,address,b.name as menuname,menusum,price1,times,delivery from users a,menus b,orders c where a.id=c.userid and b.id=c.menuid and c.times like '%"
					+ date + "%'";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Order order = new Order();
				order.setId(Integer.parseInt(rs.getString("id")));
				order.setUserid(Integer.parseInt(rs.getString("userid")));
				order.setMenuid(Integer.parseInt(rs.getString("menuid")));
				order.setOrderid(Integer.parseInt(rs.getString("orderid")));
				order.setRealname(rs.getString("realname"));
				order.setPhone(rs.getString("phone"));
				order.setAddress(rs.getString("address"));
				order.setMenuname(rs.getString("menuname"));
				order.setMenusum(Integer.parseInt(rs.getString("menusum")));
				order.setPrice1(Float.parseFloat(rs.getString("price1")));
				order.setTimes(rs.getString("times"));
				order.setDelivery(Integer.parseInt(rs.getString("delivery")));
				orderlist.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return orderlist;
	}

	/* ����Ʒ���Ʋ�ѯ */
	public List<Order> getOrderByMenuname(String menuname) {
		List<Order> orderlist = new ArrayList<Order>();
		conn = DBConn.getConn();
		try {
			String sql = "select c.id as id,a.id as userid,b.id as menuid,c.id as orderid,realname,phone,address,b.name as menuname,menusum,price1,times,delivery from users a,menus b,orders c where a.id=c.userid and b.id=c.menuid and b.name like '%"
					+ menuname + "%'";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Order order = new Order();
				order.setId(Integer.parseInt(rs.getString("id")));
				order.setUserid(Integer.parseInt(rs.getString("userid")));
				order.setMenuid(Integer.parseInt(rs.getString("menuid")));
				order.setOrderid(Integer.parseInt(rs.getString("orderid")));
				order.setRealname(rs.getString("realname"));
				order.setPhone(rs.getString("phone"));
				order.setAddress(rs.getString("address"));
				order.setMenuname(rs.getString("menuname"));
				order.setMenusum(Integer.parseInt(rs.getString("menusum")));
				order.setPrice1(Float.parseFloat(rs.getString("price1")));
				order.setTimes(rs.getString("times"));
				order.setDelivery(Integer.parseInt(rs.getString("delivery")));
				orderlist.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return orderlist;
	}

	/* ���û�ID��ѯ */
	public List<Order> getOrderByUserid(int userid) {
		List<Order> orderlist = new ArrayList<Order>();
		conn = DBConn.getConn();
		try {
			String sql = "select c.id as id,a.id as userid,b.id as menuid,c.id as orderid,realname,phone,address,b.name as menuname,menusum,price1,times,delivery from users a,menus b,orders c where a.id=c.userid and b.id=c.menuid and c.userid="
					+ userid;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Order order = new Order();
				order.setId(Integer.parseInt(rs.getString("id")));
				order.setUserid(Integer.parseInt(rs.getString("userid")));
				order.setMenuid(Integer.parseInt(rs.getString("menuid")));
				order.setOrderid(Integer.parseInt(rs.getString("orderid")));
				order.setRealname(rs.getString("realname"));
				order.setPhone(rs.getString("phone"));
				order.setAddress(rs.getString("address"));
				order.setMenuname(rs.getString("menuname"));
				order.setMenusum(Integer.parseInt(rs.getString("menusum")));
				order.setPrice1(Float.parseFloat(rs.getString("price1")));
				order.setTimes(rs.getString("times"));
				order.setDelivery(Integer.parseInt(rs.getString("delivery")));
				orderlist.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return orderlist;
	}

	/*
	 * �޸Ķ���״̬ delivery=1,���������ͣ� delivery=0,����δ���ͣ�
	 */
	public int update(int id) {
		String sql = "";
		sql = "update orders set delivery=1 where id=" + id;
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

	public int add(Order order) {
		String sql = "";
		sql = "insert into orders(userid,menuid,menusum,times,delivery)"
				+ " values(" + order.getUserid() + "," + order.getMenuid()
				+ "," + order.getMenusum() + ",'" + order.getTimes() + "',"
				+ order.getDelivery() + ")";
		int temp = 0;
		Boolean temp1; 
		System.out.println(order.getUserid()+' '+order.getMenuid()+' '+order.getMenusum()+' '+order.getTimes()+' '+order.getDelivery());
		conn = DBConn.getConn();
		try {
			st = conn.createStatement();
			temp1 = st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			temp = -1;
		} finally {
			DBConn.close(conn, st, rs);
		}
		return temp;
	}

	public int delete(int id) {
		String sql = "";
		sql = "delete from orders where id=" + id;
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
	
	/* ���û��������ڲ�ѯ */
	public List<Order> getOrderByDate(int userid,String date) {
		List<Order> orderlist = new ArrayList<Order>();
		conn = DBConn.getConn();
		try {
			String sql = "select c.id as id,a.id as userid,b.id as menuid,c.id as orderid,realname,phone,address,b.name as menuname,menusum,price1,times,delivery from users a,menus b,orders c where a.id=c.userid and b.id=c.menuid and c.times like '%"
					+ date + "%' and c.userid="+userid;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Order order = new Order();
				order.setId(Integer.parseInt(rs.getString("id")));
				order.setUserid(Integer.parseInt(rs.getString("userid")));
				order.setMenuid(Integer.parseInt(rs.getString("menuid")));
				order.setOrderid(Integer.parseInt(rs.getString("orderid")));
				order.setRealname(rs.getString("realname"));
				order.setPhone(rs.getString("phone"));
				order.setAddress(rs.getString("address"));
				order.setMenuname(rs.getString("menuname"));
				order.setMenusum(Integer.parseInt(rs.getString("menusum")));
				order.setPrice1(Float.parseFloat(rs.getString("price1")));
				order.setTimes(rs.getString("times"));
				order.setDelivery(Integer.parseInt(rs.getString("delivery")));
				orderlist.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return orderlist;
	}

	/* ����Ʒ���Ʋ�ѯ */
	public List<Order> getOrderByMenuname(int userid,String menuname) {
		List<Order> orderlist = new ArrayList<Order>();
		conn = DBConn.getConn();
		try {
			String sql = "select c.id as id,a.id as userid,b.id as menuid,c.id as orderid,realname,phone,address,b.name as menuname,menusum,price1,times,delivery from users a,menus b,orders c where a.id=c.userid and b.id=c.menuid and b.name like '%"
					+ menuname +"%' and c.userid="+userid;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Order order = new Order();
				order.setId(Integer.parseInt(rs.getString("id")));
				order.setUserid(Integer.parseInt(rs.getString("userid")));
				order.setMenuid(Integer.parseInt(rs.getString("menuid")));
				order.setOrderid(Integer.parseInt(rs.getString("orderid")));
				order.setRealname(rs.getString("realname"));
				order.setPhone(rs.getString("phone"));
				order.setAddress(rs.getString("address"));
				order.setMenuname(rs.getString("menuname"));
				order.setMenusum(Integer.parseInt(rs.getString("menusum")));
				order.setPrice1(Float.parseFloat(rs.getString("price1")));
				order.setTimes(rs.getString("times"));
				order.setDelivery(Integer.parseInt(rs.getString("delivery")));
				orderlist.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return orderlist;
	}

	/* ���û�ID��ѯ */
	public List<Order> getOrderByDelivery(int userid,int delivery) {
		List<Order> orderlist = new ArrayList<Order>();
		conn = DBConn.getConn();
		try {
			String sql = "select c.id as id,a.id as userid,b.id as menuid,c.id as orderid,realname,phone,address,b.name as menuname,menusum,price1,times,delivery from users a,menus b,orders c where a.id=c.userid and b.id=c.menuid and c.userid="
					+ userid+" and delivery="+delivery;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Order order = new Order();
				order.setId(Integer.parseInt(rs.getString("id")));
				order.setUserid(Integer.parseInt(rs.getString("userid")));
				order.setMenuid(Integer.parseInt(rs.getString("menuid")));
				order.setOrderid(Integer.parseInt(rs.getString("orderid")));
				order.setRealname(rs.getString("realname"));
				order.setPhone(rs.getString("phone"));
				order.setAddress(rs.getString("address"));
				order.setMenuname(rs.getString("menuname"));
				order.setMenusum(Integer.parseInt(rs.getString("menusum")));
				order.setPrice1(Float.parseFloat(rs.getString("price1")));
				order.setTimes(rs.getString("times"));
				order.setDelivery(Integer.parseInt(rs.getString("delivery")));
				orderlist.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return orderlist;
	}

}
