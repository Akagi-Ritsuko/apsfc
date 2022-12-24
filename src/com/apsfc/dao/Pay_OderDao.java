package com.apsfc.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.apsfc.entity.Pay_Order;
import com.apsfc.po.Order;
import com.apsfc.util.DBConn;


import tk.mybatis.mapper.common.Mapper;

public interface Pay_OderDao extends Mapper<Pay_Order>  {
//基本增删改查
	public int save(Pay_Order order) ;

}
