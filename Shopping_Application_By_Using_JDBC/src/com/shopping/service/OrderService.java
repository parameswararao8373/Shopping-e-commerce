package com.shopping.service;

import java.util.List;
import java.util.Scanner;

import com.shopping.dao.OrderDAO;
import com.shopping.dto.OrderDetails;
import com.shopping.dto.PaymentDetails;
import com.shopping.dto.ProductDetails;

public class OrderService {
    Scanner scanner = new Scanner(System.in);
    OrderDAO orderDAO = new OrderDAO();
    OrderDetails orderDetails=new  OrderDetails();

    public void storeOrderAddress(String cAddress, OrderDetails orderDetails) {
        System.out.println("Enter Options To Order Address \n 1.Address \n 2. Change Address");

        int option = scanner.nextInt();
        scanner.nextLine(); 

        switch (option) {
            case 1:
                
                if (cAddress != null && !cAddress.trim().isEmpty()) {
                    orderDetails.setOrderaddress(cAddress);
                    orderDAO.insertOrderDetails(orderDetails);
                    System.out.println(orderDetails);
                } else {
                    System.out.println("No address found for this customer. Please choose Change Address.");
                }
                break;

            case 2:
                System.out.println("Enter Address To Order:");
                String newAddress = scanner.nextLine(); 

                if (newAddress == null || newAddress.trim().isEmpty()) {
                    System.out.println("❌ Address cannot be empty! Order not saved.");
                } else {
                    orderDetails.setOrderaddress(newAddress);
                    orderDAO.insertOrderDetails(orderDetails);
                    System.out.println(orderDetails);
                }
                break;

            default:
                System.out.println("Invalid Request! Please choose 1 or 2.");
        }
    }
   
	public OrderDetails selectOrderDetails(int customerid) {
		
		return orderDAO.selectOrderDetails(customerid);
	} 
}
