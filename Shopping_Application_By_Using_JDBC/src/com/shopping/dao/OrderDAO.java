package com.shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.shopping.dto.OrderDetails;
import com.shopping.util.JDBCConnection;

public class OrderDAO {
	private static final String insert="insert into order_details(Customer_id, Product_id, Product_Quantity, Order_Address, Order_Date) values(?,?,?,?,?)";
	private static final String selectOrderDetails="select * from order_details where Customer_id=?";
	OrderDetails orderDetails=new OrderDetails();
	public boolean insertOrderDetails(OrderDetails orderDetails) {
		
		try {
			Connection connection=JDBCConnection.forMQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setInt(1,orderDetails.getCustomerid());
			preparedStatement.setInt(2,orderDetails.getProductid());
			preparedStatement.setInt(3,orderDetails.getProductquantity());
			preparedStatement.setString(4,orderDetails.getOrderaddress());
			preparedStatement.setDate(5,Date.valueOf(LocalDate.now()));
			int result =preparedStatement.executeUpdate();
			if (result!=0) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public OrderDetails selectOrderDetails(int id) {
		
		try {
			Connection connection=JDBCConnection.forMQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(selectOrderDetails);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				orderDetails.setOrderid(resultSet.getInt("Order_id"));
				orderDetails.setCustomerid(resultSet.getInt("Customer_id"));
				orderDetails.setProductid(resultSet.getInt("Product_id"));
				orderDetails.setProductquantity(resultSet.getInt("Product_Quantity"));
				orderDetails.setOrderaddress(resultSet.getString("Order_Address"));
				orderDetails.setOrderdate(LocalDate.now());
			}
			return orderDetails;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
}

