package com.shopping.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.shopping.dao.AdminDAO;
import com.shopping.dao.CartDAO;
import com.shopping.dao.CustomerDAO;
import com.shopping.dao.ProductDAO;
import com.shopping.dto.AdminDetails;
import com.shopping.dto.CartDetails;
import com.shopping.dto.CustomerDetails;
import com.shopping.dto.OrderDetails;
import com.shopping.dto.PaymentDetails;
import com.shopping.dto.ProductDetails;
import com.shopping.exception.customerDataInvalidException;

public class CustomerService {
	CustomerDAO customerDAO = new CustomerDAO();
	ProductDAO productDAO=new ProductDAO();
	CustomerDetails customerdetails;
	AdminDAO adminDAO = new AdminDAO();
	AdminDetails adminDetails = new AdminDetails();
	ProductService productService = new ProductService();
	CartService cartService=new CartService();
	OrderService orderService=new OrderService();
//	CustomerDetails customerDetails;
	PaymentService paymentService=new PaymentService();
	private List<AdminDetails> listofadmins = adminDAO.selectAllAdminDetails();
	private List<CustomerDetails> listofcustomers = customerDAO.selectAllCustomerDetails();
	Scanner scanner = new Scanner(System.in);

	public void customerRegstration() {
		System.out.println("Enter Customer Name");
		String cname = scanner.next();

		System.out.println("Enter Customer Emailid");
		while (true) {
			String cemailid = scanner.next();
			long emailidcount = listofcustomers.stream()
					.filter((customer) -> customer.getCustomeremailid().equals(cemailid)).count();
			try {
				if (!(cemailid.endsWith("@gmail.com"))) {
					throw new customerDataInvalidException("Invalid Email Id");
				} else {
					customerdetails.setCustomeremailid(cemailid);
				}
				if (emailidcount > 0) {
					throw new customerDataInvalidException("Emailid Already Existed");
				} else {
					break;
				}
			} catch (customerDataInvalidException e) {
				System.out.println(e.getExceptionmessage());
				System.out.println("Re_Enter Customer Emailid");

			}
		}

		System.out.println("Enter Customer Mobile Number");

		while (true) {
			long cmobilenumber = scanner.nextLong();

			long mobilecount = listofcustomers.stream()
					.filter((customer) -> customer.getCustomermobilenumber() == cmobilenumber).count();
			try {
				if (mobilecount > 0) {
					throw new customerDataInvalidException("Mobile Number Already Existede");
				} else {
					customerdetails.setCustomermobilenumber(cmobilenumber);
				}
				if (!(cmobilenumber >= 6000000000L && cmobilenumber <= 9999999999L)) {
					throw new customerDataInvalidException("Invalid Mobile Number");
				} else {

					break;
				}
			} catch (customerDataInvalidException e) {
				System.out.println(e.getExceptionmessage());
				System.out.println("Re-Enter the Mobile Number");
			}
		}
		System.out.println("Enter Customer Address");
		String caddress = scanner.next();
		while (true) {
			try {
				if (caddress == null) {
					throw new customerDataInvalidException("Address can't be empty");
				} else {
					break;
				}
			} catch (customerDataInvalidException e) {
				System.out.println(e.getExceptionmessage());
			}
		}
		// Gender Validation
		System.out.println("Enter the Gender (Male/Female)");
		while (true) {
			String cgender = scanner.next();
			try {
				if (!(cgender.equalsIgnoreCase("Male") || cgender.equalsIgnoreCase("Female"))) {
					throw new customerDataInvalidException("Invalid Gender. Please enter Male or Female");
				} else {
					customerdetails.setCustomergender(cgender);
					break;
				}

			} catch (customerDataInvalidException e) {
				System.out.println(e.getExceptionmessage());
				System.out.println("Re-Enter the Gender");
			}
		}
		// Password (basic input, no validation yet)
		System.out.println("Enter Customer Password");
		String cpassword = scanner.next();
		// Setting data into DTO

		customerdetails.setCustomername(cname);

		customerdetails.setCustomeraddress(caddress);
		customerdetails.setCustomerpassword(cpassword);
		// Saving in DB
		if (customerDAO.insertCustomerDetails(customerdetails)) {
			System.out.println(cname + " registration Successful!");
		} else {
			System.out.println("Server Error 500");
		}
	}

	public void CustomerLogin() {
		System.out.println("Enter the Emailid or Mobile Number");
		String emailidormobilenumber = scanner.next();
		System.out.println("Enter Customer Password");
		String password = scanner.next();
		customerdetails = customerDAO
				.selectCustomerDetailsByUsingEmailidOrMoblieNumberAndPassword(emailidormobilenumber, password);
		if (customerDAO != null) {// customer service
			System.out.println("Login successful");
			if (customerdetails.getCustomergender().equalsIgnoreCase("Male")) {
				System.out.println("Heloo Mr's :" + customerdetails.getCustomername());
				customerOperations();
			}
			if (customerdetails.getCustomergender().equalsIgnoreCase("Female")) {
				System.out.println("Heloo Miss :" + customerdetails.getCustomername());
				customerOperations();
			}

		} else {
			System.out.println("Invalid Emaild And Password");
		}
	}

	public void AdminLogin() {
		System.out.println("Enter the Email Id");
		String adminemailid = scanner.next();
		System.out.println("Enter the Password");
		String password = scanner.next();

		AdminDetails adminDetails = adminDAO.selectAdminDetailsByUsingEmailidAndPassword(adminemailid, password);
		if (adminDAO != null) {
			System.out.println("Login Successfull");
			if (adminDetails.getAdminemailid().equalsIgnoreCase("Emailid")) {
				System.out.println("Welcome To Mr's :" + adminDetails.getAdminemailid());

			}
			if (adminDetails.getAdminpassword().equalsIgnoreCase("Password")) {
				System.out.println("Heloo Miss :" + adminDetails.getAdminpassword());
			}
		} else {
			System.out.println("Invalid Emailid And Password ");
		}

	}

	public void customerOperations() {
		System.out.println("Enter \n 1.For All Product Details \n 2.For Cart Details \n 3.For Order Details");
		switch (scanner.nextInt()) {
		case 1:
			int i = 1;
			System.out.println("All Product Details");
			List<ProductDetails> allproductDetails = productService.allProductdetails();
		//	List<OrderDetails> allorderDetails = orderService.all;
			for (ProductDetails productDetails : allproductDetails) {
				System.out.println("S.No: " + i++);
				System.out.println("Product Name:" + productDetails.getProductname());
				System.out.println("Product Brand:" + productDetails.getProductbrand());
				System.out.println("Product Price:" + productDetails.getProductprice());
				System.out.println("Product Category:" + productDetails.getProductcategory());
				System.out.println("Product MF Date:" + productDetails.getProductmfdate());
				System.out.println("Product EX Date:" + productDetails.getProductexdate());
				System.out.println("Product Quantity:" + productDetails.getProductquantity());
				System.out.println("Product Discount:" + productDetails.getProductdiscount());
				System.out.println("****------*****---***----****---****----***");
			}
			System.out.println("Enter S.No to Add To Cart Or BUY");
			ProductDetails productDetails = allproductDetails.get(scanner.nextInt()-1);
			System.out.println(productDetails.getProductid());
			System.out.println("Product Name:" + productDetails.getProductname());
			System.out.println("Product Brand:" + productDetails.getProductbrand());
			System.out.println("Product Price:" + productDetails.getProductprice());
			System.out.println("Product Category:" + productDetails.getProductcategory());
			System.out.println("Product MF Date:" + productDetails.getProductmfdate());
			System.out.println("Product EX Date:" + productDetails.getProductexdate());
			System.out.println("Product Quantity:" + productDetails.getProductquantity());
			System.out.println("Product Discount:" + productDetails.getProductdiscount());
			System.out.println("****------*****---***----****---****----***");
			
			System.out.println("Select \n 1.To Add The product To The CART \n 2.To BUY");
			switch (scanner.nextInt()) {
			case 1:
				System.out.println("Add The Product To The CART");
				System.out.println("Enter The Product Quantity");
				int quantity=scanner.nextInt();
				if (quantity<=productDetails.getProductquantity()) {
					CartDetails cartDetails=new CartDetails();
					cartDetails.setCustomerid(customerdetails.getCustomerid());
					cartDetails.setProductid(productDetails.getProductid());
					cartDetails.setProductquantity(quantity);
					cartService.addCartDetails(cartDetails);
				} else {
					System.out.println("Quantity is not avialible");
				}
				break;
			case 2:
			    System.out.println("To BUY");
			    System.out.println("Enter The Product Quantity");
			    int oquantity = scanner.nextInt();

			    System.out.println("Product Name: " + productDetails.getProductname());
			    System.out.println("Product Brand: " + productDetails.getProductbrand());
			    System.out.println("Product Price: " + productDetails.getProductprice());
			    System.out.println("Product Category: " + productDetails.getProductcategory());
			    System.out.println("Total Price: " +productDetails.getProductprice());
			    double discount=((productDetails.getProductdiscount()/100)*productDetails.getProductprice());
			    System.out.println("Total Discount: " + discount);
			    double totalAmount=productDetails.getProductprice()-discount;
			    System.out.println("Total Amount to Pay: " + totalAmount);
			    paymentService.paymentProcessDetails(customerdetails.getCustomerid(),totalAmount,productDetails.getProductid());
			  
			    
			    OrderDetails orderDetails=new OrderDetails();
			    orderDetails.setCustomerid(customerdetails.getCustomerid());
			    orderDetails.setProductid(productDetails.getProductid());
			    orderDetails.setProductquantity(oquantity);
			    orderDetails.setOrderaddress(customerdetails.getCustomeraddress());
			    orderDetails.setOrderdate(LocalDate.now());
			    
			    orderService.storeOrderAddress(customerdetails.getCustomeraddress(), orderDetails);
			    break;
			default:
				break;
			}
			break;
		case 2:
		{
		    System.out.println("Cart Details");
		    CartDetails details = cartService.showCartDetails(customerdetails.getCustomerid());
		    System.out.println("Cart Id         :" + details.getCartid());
		    System.out.println("Customer Id     :" + details.getCustomerid());
		    System.out.println("Product Id      :" + details.getProductid());
		    System.out.println("Product Quantity:" + details.getProductquantity());
		}
		break;

		case 3:
		{
		    System.out.println("Order Details");
		    OrderDetails orderDetails = ((OrderService) orderService)
		        .selectOrderDetails(customerdetails.getCustomerid());

		    System.out.println("Customer Id   :" + orderDetails.getCustomerid());
		    System.out.println("Order Id      :" + orderDetails.getOrderid());
		    System.out.println("Product Id    :" + orderDetails.getProductid());
		    System.out.println("Product Qty   :" + orderDetails.getProductquantity());
		    System.out.println("Order Address :" + orderDetails.getOrderaddress());
		    System.out.println("Order Date    :" + orderDetails.getOrderdate());
		}
		break;

		default:
			System.out.println("Invalid Requset...");
			break;
		}

	}
}