package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dto.ProductDetails;
import com.shopping.util.JDBCConnection;

public class ProductDAO {

	private static final String insert = "insert into product_details(Product_Name, Product_Brand, Product_Price, Product_M_F_Date, Product_Ex_Date, Product_Quantity, Product_Category, Product_Discount) values (?,?,?,?,?,?,?,?)";
	
	private static final String selectallproducts="select * from product_details";
	public boolean insertProductDetails(ProductDetails productDetails) {
		try {
			Connection connection = JDBCConnection.forMQLConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setString(1, productDetails.getProductname());
			preparedStatement.setString(2, productDetails.getProductbrand());
			preparedStatement.setDouble(3, productDetails.getProductprice());
			preparedStatement.setDate(4, productDetails.getProductmfdate());
			preparedStatement.setDate(5, productDetails.getProductexdate());
			preparedStatement.setInt(6, productDetails.getProductquantity());
			preparedStatement.setString(7, productDetails.getProductcategory());
//			preparedStatement.setString(7, productDetails.getProductcategory());
			preparedStatement.setDouble(8, productDetails.getProductdiscount());
			int result = preparedStatement.executeUpdate();
			if (result != 0) {
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
	public boolean insertMorethanOneProduct(List<ProductDetails> listofproducts) {
		try {
			Connection connection = JDBCConnection.forMQLConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			for(ProductDetails productDetails: listofproducts) {
				preparedStatement.setString(1, productDetails.getProductbrand());
				preparedStatement.setString(2, productDetails.getProductname());
				preparedStatement.setDouble(3, productDetails.getProductprice());
				preparedStatement.setDate(4, productDetails.getProductmfdate());
				preparedStatement.setDate(5, productDetails.getProductexdate());
				preparedStatement.setInt(6, productDetails.getProductquantity());
				preparedStatement.setString(7, productDetails.getProductcategory());
				preparedStatement.setDouble(8, productDetails.getProductdiscount());
				preparedStatement.addBatch();
			}
			
			int[] results = preparedStatement.executeBatch();
			if (results.length!=0) {
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
	
	public List<ProductDetails> getAllProductDetails() {
		try {
			Connection connection=JDBCConnection.forMQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(selectallproducts);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<ProductDetails> listofproducts = new ArrayList<ProductDetails>();
			if (resultSet.isBeforeFirst()) {
				while (resultSet.next()) {
					ProductDetails productDetails=new ProductDetails();
					productDetails.setProductid(resultSet.getInt("Product_id"));
					productDetails.setProductname(resultSet.getNString("Product_Name"));
					productDetails.setProductbrand(resultSet.getString("Product_Brand"));
					productDetails.setProductcategory(resultSet.getString("Product_Category"));
					productDetails.setProdutdiscount(resultSet.getDouble("Product_Discount"));
					productDetails.setProductexdate(resultSet.getDate("Product_Ex_Date"));
					productDetails.setProductmfdate(resultSet.getDate("Product_M_F_Date"));
					productDetails.setProductprice(resultSet.getDouble("Product_Price"));
					productDetails.setProductquantity(resultSet.getInt("Product_Quantity"));
					listofproducts.add(productDetails);	
				}
				
			} 
			return listofproducts;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
