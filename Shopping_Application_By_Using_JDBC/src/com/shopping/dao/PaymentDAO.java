package com.shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.JdbcConnection;
import com.shopping.dto.PaymentDetails;
import com.shopping.util.JDBCConnection;

public class PaymentDAO {
	private static final String insert="insert into payment_details(Customer_id, Product_id, Payment_Type, Payment_Status, Amount, Payment_Date) values (?,?,?,?,?,?)";
	public boolean insertPaymentDetails(PaymentDetails paymentDetails) {
		
		try {
			Connection connection=JDBCConnection.forMQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setInt(1,paymentDetails.getCustomerid());
			preparedStatement.setInt(2,paymentDetails.getProductid());
			preparedStatement.setString(3,paymentDetails.getPaymenttype());
			preparedStatement.setString(4,paymentDetails.getPaymentstatus());
			preparedStatement.setDouble(5,paymentDetails.getAmount());
			preparedStatement.setDate(6,Date.valueOf(paymentDetails.getPaymentdate()));
			int result=preparedStatement.executeUpdate();
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
}
