package com.shopping.dto;

public class CartDetails {

	private int cartid;
	private int productid;
	private int customerid;
	private int productquantity;

	public CartDetails() {
	}

	public CartDetails(int cartid, int productid, int customerid, int productquantity) {

		this.cartid = cartid;
		this.productid = productid;
		this.customerid = customerid;
		this.productquantity = productquantity;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getProductquantity() {
		return productquantity;
	}

	public void setProductquantity(int productquantity) {
		this.productquantity = productquantity;
	}

	public void cartdisplay() {
		System.out.println("Cart_Id:" + getCartid());
		System.out.println("Product_Id:" + getProductid());
		System.out.println("Customer_Id:" + getCustomerid());
		System.out.println("Product_Quantity:" + getProductquantity());
	}

	@Override
	public String toString() {
		return "Cart_Details [cartid=" + cartid + ", productid=" + productid + ", customerid=" + customerid
				+ ", productquantity=" + productquantity + "]";
	}

}
