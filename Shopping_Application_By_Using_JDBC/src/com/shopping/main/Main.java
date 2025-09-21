package com.shopping.main;

import java.util.Scanner;

import com.shopping.dao.CustomerDAO;
import com.shopping.service.AdminService;
import com.shopping.service.CustomerService;

public class Main {

	public static void main(String[] args) {
		CustomerService customerservice = new CustomerService();
		AdminService adminService=new AdminService();
		Scanner scanner = new Scanner(System.in);
		String str = "****----****Welcome To A14_Shopping****-----*****";
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		boolean repeat = true;
		while (repeat) {
			System.out.println("\nEnter");
			System.out.println("1. Admin Login");
			System.out.println("2. Customer Registration");
			System.out.println("3. Customer Login");

			int choice;
			try {
				choice = Integer.parseInt(scanner.nextLine()); // safer than nextInt
			} catch (NumberFormatException e) {
				System.out.println("Invalid input! Please enter a number.");
				continue;
			}

			String answer;
			switch (choice) {
			case 1:
				System.out.println("Admin Login");
				adminService.adminLogin();
				System.out.println("Do You Want To Continue 😊😊😊 \n Yes \n No");
				answer = scanner.nextLine();
				if (answer.equalsIgnoreCase("Yes")) {
					System.out.println("Proceeding for Admin Login...");
				} else {
					System.out.println("Thank You. Visit Again 😊😊😊");
					repeat = false; // stop loop
				}
				break;

			case 2:
				System.out.println("Customer Registration");
				customerservice.customerRegstration();
				System.out.println("Do You Want To Continue 😊😊😊 \n Yes \n No");
				answer = scanner.nextLine();
				if (answer.equalsIgnoreCase("Yes")) {
					System.out.println("Proceeding for Customer Registration...");
				} else {
					System.out.println("Thank You. Visit Again 😊😊😊");
					repeat = false;
				}
				break;

			case 3:
				System.out.println("Customer Login");
				customerservice.CustomerLogin();
				System.out.println("Do You Want To Continue 😊😊😊 \n Yes \n No");
				answer = scanner.nextLine();
				if (answer.equalsIgnoreCase("Yes")) {
					System.out.println("Proceeding for Customer Login...");
				} else {
					System.out.println("Thank You. Visit Again 😞😞😞");
					repeat = false;
				}
				break;
			default:
				System.out.println("Invalid Request. Please choose between");
				break;
			}
		}
	}
}
