package com.shopping.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shopping.dao.ProductDAO;
import com.shopping.dto.ProductDetails;

public class ProductService {
	Scanner scanner=new Scanner(System.in);
	ProductDAO productDAO=new ProductDAO();
	ProductDetails productDetails=new ProductDetails();
	
	public void storeProductDetails() {
	
		System.out.println("Enter the Product Name");
		String pname=scanner.next();
		System.out.println("Enter the Product Brand");
		String pbrand=scanner.next();
		System.out.println("Enter the Product Price");
		double pprice=scanner.nextDouble();
		System.out.println("Enter the Product M F Date");
		String pmfdate=scanner.next();
		System.out.println("Enter the Product Ex Date");
		String pexdate=scanner.next();
		System.out.println("Enter the Product Quantity");
		int pquantity=scanner.nextInt();
		System.out.println("Enter the Product Category");
		String pcategory=scanner.next();
		System.out.println("Enter the Product Discount");
		double pdiscount=scanner.nextDouble();

		ProductDetails productDetails=new ProductDetails();
		productDetails.setProductname(pname);
		productDetails.setProductbrand(pbrand);
		productDetails.setProductprice(pprice);
		/* valueOf()
		 * date,arg String */
		productDetails.setProductmfdate(Date.valueOf(pmfdate));
		productDetails.setProductexdate(Date.valueOf(pexdate));
		productDetails.setProductquantity(pquantity);
		productDetails.setProductcategory(pcategory);
		productDetails.setProdutdiscount(pdiscount);
		/* DAO insert method */
	boolean result=	productDAO.insertProductDetails(productDetails);
	if (result) {
		System.out.println("Insertd Successfully");
	} else {
		System.out.println("There was Error ");
	}
	}
	public void storeProductsByUsingBrand() {
		ArrayList<ProductDetails> list=new ArrayList<ProductDetails>();
		System.out.println("Enter the Product Brand");
		String pbrand=scanner.next();
		System.out.println("Number of Products under "+ pbrand+ "Brand");
		int number=scanner.nextInt();
		String nu[] = {"First","Second","Third","Fouth","Fifth"};
		
		for(int i=0; i < number; i++) {
			System.out.println("Enter "+nu[i]+" Product Details");
			System.out.println("Enter Product Name");
			String pname=scanner.next();
			System.out.println("Enter Product Price");
			double pprice=scanner.nextDouble();
			System.out.println("Enter Product M F Date");
			String pmfdate=scanner.next();
			System.out.println("Enter Product Ex Date");
			String pexdate=scanner.next();
			System.out.println("Enter Product Quantity");
			int pquantity=scanner.nextInt();
			System.out.println("Enter Product Category");
			String pcategory=scanner.next();
			System.out.println("Enter Product Discount");
			double pdiscount=scanner.nextDouble();

			ProductDetails productDetails=new ProductDetails();
			productDetails.setProductname(pname);
			productDetails.setProductbrand(pbrand);
			productDetails.setProductprice(pprice);
			/* valueOf()
			 * date,arg String */
			productDetails.setProductmfdate(Date.valueOf(pmfdate));
			productDetails.setProductexdate(Date.valueOf(pexdate));
			productDetails.setProductquantity(pquantity);
			productDetails.setProductcategory(pcategory);
			productDetails.setProdutdiscount(pdiscount);
			
			list.add(productDetails);
		}
		if (productDAO.insertMorethanOneProduct(list)) {
			System.out.println("Product insertd successfully...");
		} else {
			System.out.println("Server error 500");
		}
	}
	public List<ProductDetails> allProductdetails() {
		return productDAO.getAllProductDetails();
		

	}
}
