package com.shopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dto.CustomerDetails;
import com.shopping.util.JDBCConnection;

public class CustomerDAO {

	private static final String insert = "insert into customer_details(Customer_Name, Customer_Email_id,"
			+ " Customer_Mobile_Number, Customer_Address, Customer_Gender, Customer_Password) values (?,?,?,?,?,?)";

	private static final String select_all_customers = "select * from customer_details";

	private static final String Customer_Login = "select * from customer_details where (Customer_Email_id=? or Customer_Mobile_Number=?) and Customer_Password=?";

	public boolean insertCustomerDetails(CustomerDetails customerdetails) {
		try {
			Connection connection = JDBCConnection.forMQLConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setString(1, customerdetails.getCustomername());
			preparedStatement.setString(2, customerdetails.getCustomeremailid());
			preparedStatement.setLong(3, customerdetails.getCustomermobilenumber());
			preparedStatement.setString(4, customerdetails.getCustomeraddress());
			preparedStatement.setString(5, customerdetails.getCustomergender());
			preparedStatement.setString(6, customerdetails.getCustomerpassword());

			int result = preparedStatement.executeUpdate();
			if (result != 0) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}
	}

	public List<CustomerDetails> selectAllCustomerDetails() {
		/* select * from customer_details */
		try {
			Connection connection = JDBCConnection.forMQLConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(select_all_customers);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<CustomerDetails> listofcoustomers = new ArrayList<CustomerDetails>();
			while (resultSet.next()) {
				CustomerDetails customerDetails = new CustomerDetails();
				customerDetails.setCustomeremailid(resultSet.getString("Customer_Email_id"));
				customerDetails.setCustomermobilenumber(resultSet.getLong("Customer_Mobile_Number"));
				customerDetails.setCustomerpassword(resultSet.getString("Customer_Password"));
				listofcoustomers.add(customerDetails);
			}
			return listofcoustomers;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public CustomerDetails selectCustomerDetailsByUsingEmailidOrMoblieNumberAndPassword(String emailidormobilenumber,
			String password) {
		/*
		 * select * from customer_details where Customer_Email_id=? or
		 * Customer_Mobile_Number=? and Customer_Password=?
		 */
		try {
			Connection connection = JDBCConnection.forMQLConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(Customer_Login);
			preparedStatement.setString(1, emailidormobilenumber);
			preparedStatement.setString(2, emailidormobilenumber);
			preparedStatement.setString(3, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				CustomerDetails customerDetails = new CustomerDetails();
				customerDetails.setCustomerid(resultSet.getInt("Customer_id"));
				customerDetails.setCustomeremailid(resultSet.getString("Customer_Email_id"));
				customerDetails.setCustomermobilenumber(resultSet.getLong("Customer_Mobile_Number"));
				customerDetails.setCustomerpassword(resultSet.getString("Customer_Password"));
				customerDetails.setCustomername(resultSet.getString("Customer_Name"));
				customerDetails.setCustomergender(resultSet.getString("Customer_Gender"));
				return customerDetails;
			} else {
				return null;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
