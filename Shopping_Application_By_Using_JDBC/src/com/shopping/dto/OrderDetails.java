package com.shopping.dto;

import java.sql.Date;
import java.time.LocalDate;

public class OrderDetails {

	private int orderid;
	private int customerid;
	private int productid;
	private int productquantity;
	private String orderaddress;
	private LocalDate orderdate;

	public OrderDetails() {
	}

	public OrderDetails(int orderid, int customerid, int productid, int productquantity, String orderaddress,
			LocalDate orderdate) {

		this.orderid = orderid;
		this.customerid = customerid;
		this.productid = productid;
		this.productquantity = productquantity;
		this.orderaddress = orderaddress;
		this.orderdate = orderdate;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getProductquantity() {
		return productquantity;
	}

	public void setProductquantity(int productquantity) {
		this.productquantity = productquantity;
	}

	public String getOrderaddress() {
		return orderaddress;
	}

	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress;
	}

	public LocalDate  getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDate localDate) {
		this.orderdate = localDate;
	}

	@Override
	public String toString() {
		return "Order_Details [orderid=" + orderid + ", customerid=" + customerid + ", productid=" + productid
				+ ", producyquantity=" + productquantity + ", orderaddress=" + orderaddress + ", orderdate=" + orderdate
				+ "]";
	}

	

}
