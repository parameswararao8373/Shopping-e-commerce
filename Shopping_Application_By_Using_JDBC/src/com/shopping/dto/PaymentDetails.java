package com.shopping.dto;

import java.time.LocalDate;

public class PaymentDetails {

	private int paymentid;
	private int customerid;
	private int productid;
	private String paymenttype;
	private String paymentstatus;
	private double amount;
	private LocalDate paymentdate;

	public PaymentDetails() {
	}

	public PaymentDetails(int paymentid, int customerid, int productid, String paymenttype, String paymentstatus,
			double amount, LocalDate paymentdate) {
		
		this.paymentid = paymentid;
		this.customerid = customerid;
		this.productid = productid;
		this.paymenttype = paymenttype;
		this.paymentstatus = paymentstatus;
		this.amount = amount;
		this.paymentdate = paymentdate;
	}

	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
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

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(LocalDate paymentdate) {
		this.paymentdate = paymentdate;
	}

	@Override
	public String toString() {
		return "PaymentDetails [paymentid=" + paymentid + ", customerid=" + customerid + ", productid=" + productid
				+ ", paymenttype=" + paymenttype + ", paymentstatus=" + paymentstatus + ", amount=" + amount
				+ ", paymentdate=" + paymentdate + "]";
	}
}