package com.shopping.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.shopping.dao.PaymentDAO;
import com.shopping.dao.ProductDAO;
import com.shopping.dto.PaymentDetails;

public class PaymentService {
	Scanner scanner=new Scanner(System.in);
	PaymentDAO paymentDAO=new PaymentDAO();
	public void paymentProcessDetails(int id,double amount,int pid) {
		
		PaymentDetails paymentDetails=new PaymentDetails();
		paymentDetails.setCustomerid(id);
		paymentDetails.setPaymentdate(LocalDate.now());
		
		System.out.println("Enter \n 1.For UPI \n 2.For Cash on Delivery \n 3.Debit \n 4.Net Payment \n 5.EMI");
		switch (scanner.nextInt()) {
		case 1:
			paymentDetails.setPaymenttype("UPI");
			paymentDetails.setPaymentstatus("Payment Sucess");
			break;
		case 2:
			paymentDetails.setPaymenttype("Cash on Delivery");
			paymentDetails.setPaymentstatus("Under Processing");
			break;
		case 3:
			paymentDetails.setPaymenttype("Debit");
			paymentDetails.setPaymentstatus("Under Processing");
			break;
		case 4:
			paymentDetails.setPaymenttype("Net Payment");
			paymentDetails.setPaymentstatus("Under Sucess");
			break;
		case 5:
			paymentDetails.setPaymenttype("EMI");
			paymentDetails.setPaymentstatus("Under Processing");
			break;
		default:
			break;
		}
		while(true) {
			System.out.println("Enter Amount");
			double uamount=scanner.nextDouble();
			if (uamount == amount) {
				paymentDetails.setCustomerid(id);
				paymentDetails.setPaymentdate(LocalDate.now());
				paymentDetails.setProductid(pid);
				paymentDetails.setAmount(uamount);
				//System.out.println(paymentDetails);
				if (paymentDAO.insertPaymentDetails(paymentDetails)) {
					System.out.println("Order Placed Succesfull....");
					break;
				} else {
					System.out.println("Server Error 500");
				}
			} else {
				System.out.println("Invalid Amount");
				System.out.println("Re-Enter The Amount");
			}
		}

	}
}
