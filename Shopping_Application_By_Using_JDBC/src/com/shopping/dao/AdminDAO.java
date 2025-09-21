package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dto.AdminDetails;
import com.shopping.util.JDBCConnection;

public class AdminDAO {

	private static final String insert="insert into admin_details(Admin_Email_Id, Admin_Password, Admin_Role) values (?,?,?)";
	private static final String select_all_admins ="select * from admin_details";
	private static final String Admin_login="select * from admin_details where (Admin_Email_Id=? ) and Admin_Password=?";
	public  boolean insertAdminDetails(AdminDetails adminDetails) {
		try {
			Connection connection=JDBCConnection.forMQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setString(1, adminDetails.getAdminemailid());
			preparedStatement.setString(2, adminDetails.getAdminrole());
			preparedStatement.setString(3, adminDetails.getAdminpassword());
			
			int result = preparedStatement.executeUpdate();
			if (result !=0) {
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
	public  List<AdminDetails> selectAllAdminDetails() {
		// TODO Auto-generated method stub
		try {
			Connection connection=JDBCConnection.forMQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(select_all_admins);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<AdminDetails> listofadmins=new ArrayList<AdminDetails>();
			while (resultSet.next()) {
				AdminDetails adminDetails=new AdminDetails();
				adminDetails.setAdminemailid(resultSet.getString("Admin_Email_Id"));
				adminDetails.setAdminpassword(resultSet.getString("Admin_Password"));
				adminDetails.setAdminrole(resultSet.getString("Admin_Role"));
				listofadmins.add(adminDetails);			
				}
				return listofadmins;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public AdminDetails selectAdminDetailsByUsingEmailidAndPassword(String adminemailid,String password) {
		/*
		 * select * from admin_details where Admin_Email_Id=? or
		 * and Admin_Password=?
		 */
		try {
			Connection connection=JDBCConnection.forMQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(Admin_login);
			preparedStatement.setString(1, adminemailid);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				AdminDetails adminDetails=new AdminDetails();
				adminDetails.setAdminemailid(resultSet.getString("Admin_Email_Id"));
				adminDetails.setAdminpassword(resultSet.getString("Admin_Password"));
				adminDetails.setAdminrole(resultSet.getString("Admin_Role"));
				return adminDetails;
			} else {
				return null;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
