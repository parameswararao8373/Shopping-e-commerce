package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.dto.CartDetails;
import com.shopping.util.JDBCConnection;

public class CartDAO {

	private static final String insert="insert into cart_details(Customer_id,Product_id, Product_Quantity) values (?,?,?)";
	
	private static final String selectAll="Select * from cart_details where  Customer_id = ? ";
	
	
	public boolean insertCartDetails(CartDetails cartDetails) {
		try {
			Connection connection=JDBCConnection.forMQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setInt(1, cartDetails.getCustomerid());
			preparedStatement.setInt(2, cartDetails.getProductid());
			preparedStatement.setInt(3, cartDetails.getProductquantity());
			int result=preparedStatement.executeUpdate();
			if (result!=0) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public CartDetails selectCartDetails(int customerid) {
		CartDetails cartDetails=new CartDetails();
		try {
			Connection connection=JDBCConnection.forMQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(selectAll);
			preparedStatement.setInt(1,customerid);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				cartDetails.setCartid(resultSet.getInt("Cart_id"));
				cartDetails.setProductid(resultSet.getInt("Product_id"));
				cartDetails.setCustomerid(resultSet.getInt("Customer_id"));
				cartDetails.setProductquantity(resultSet.getInt("Product_Quantity"));
			}
			return cartDetails;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
