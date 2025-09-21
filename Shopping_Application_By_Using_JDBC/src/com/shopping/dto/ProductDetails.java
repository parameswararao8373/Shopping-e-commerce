package com.shopping.dto;

import java.sql.Date;

public class ProductDetails {

	/*
	 * Product_id, Product_Name, Product_Brand, Product_Price, Product_M_F_Date,
	 * Product_Ex_Date, Product_Quantity, Product_Category, Product_Discount
	 */
	private int productid;
	private String productname;
	private String productbrand;
	private double productprice;
	private Date productmfdate;
	private Date productexdate;
	private int productquantity;
	private String productcategory;
	private double productdiscount;

	public ProductDetails() {
	}

	public ProductDetails(int productid, String productname, String productbrand, double productprice,
			Date productmfdate, Date productexdate, int productquantity, String productcategory,
			double productdiscount) {

		this.productid = productid;
		this.productname = productname;
		this.productbrand = productbrand;
		this.productprice = productprice;
		this.productmfdate = productmfdate;
		this.productexdate = productexdate;
		this.productquantity = productquantity;
		this.productcategory = productcategory;
		this.productdiscount = productdiscount;
	}

	

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductbrand() {
		return productbrand;
	}

	public void setProductbrand(String productbrand) {
		this.productbrand = productbrand;
	}

	public double getProductprice() {
		return productprice;
	}

	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}

	public Date getProductmfdate() {
		return productmfdate;
	}

	public void setProductmfdate(Date productmfdate) {
		this.productmfdate = productmfdate;
	}

	public Date getProductexdate() {
		return productexdate;
	}

	public void setProductexdate(Date productexdate) {
		this.productexdate = productexdate;
	}

	public int getProductquantity() {
		return productquantity;
	}

	public void setProductquantity(int productquantity) {
		this.productquantity = productquantity;
	}

	public String getProductcategory() {
		return productcategory;
	}

	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}

	public double getProductdiscount() {
		return productdiscount;
	}

	public void setProdutdiscount(double productdiscount) {
		this.productdiscount = productdiscount;
	}

	public void productdisplay() {
		System.out.println("Product_Id:" + getProductid());
		System.out.println("Product_Name:" + getProductname());
		System.out.println("Product_Brand:" + getProductbrand());
		System.out.println("Product_Price:" + getProductprice());
		System.out.println("Product_M_F_Date:" + getProductmfdate());
		System.out.println("Product_Ex_Date:" + getProductexdate());
		System.out.println("Product_Quantity:" + getProductquantity());
		System.out.println("Product_Category:" + getProductcategory());
		System.out.println("Product_Discount:" + getProductdiscount());
	}

	@Override
	public String toString() {
		return "Product_Details [productid=" + productid + ", productname=" + productname + ", productbrand="
				+ productbrand + ", productprice=" + productprice + ", productmfdate=" + productmfdate
				+ ", productexdate=" + productexdate + ", productquantity=" + productquantity + ", productcategory="
				+ productcategory + ", productdiscount=" + productdiscount + "]";
	}

	

}
