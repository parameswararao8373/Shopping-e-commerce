package com.shopping.service;

import java.util.Scanner;

import com.shopping.dao.AdminDAO;
import com.shopping.dto.AdminDetails;

public class AdminService {

	Scanner scanner=new Scanner(System.in);
	AdminDAO adminDAO=new AdminDAO();
	ProductService productService = new ProductService();
	
	public void adminLogin() {
		
		System.out.println("Enter the Admin Emailid");
		String emailid=scanner.next();
		System.out.println("Enter the Admin Password");
		String password=scanner.next();
		AdminDetails adminDetails=adminDAO.selectAdminDetailsByUsingEmailidAndPassword(emailid, password);
		
		if (adminDetails!=null) {
			System.out.println("Admin Login Successfully");
			System.out.println("Welcome "+adminDetails.getAdminemailid());
			System.out.println("Enter \n 1.To Insert Product Details \n 2.To Insert Product BasedOnBrand");
			
			switch (scanner.nextInt()) {
			case 1:
				System.out.println("Insert Product Details");
				productService.storeProductDetails();
				break;
			case 2:
				System.out.println("Insert Product Based On Brand");
				productService.storeProductsByUsingBrand();
				break;
			default:
				System.out.println("Invalid Request");
				break;
			}
		} else {
			
		}
		

	}
}
