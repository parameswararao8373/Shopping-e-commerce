package com.shopping.dto;

public class CustomerDetails {

	private int customerid;
	private String customername;
	private String customeremailid;
	private long customermobilenumber;
	private String customeraddress;
	private String customergender;
	private String customerpassword;

	public CustomerDetails() {
	}

	public CustomerDetails(int customerid, String customername, String customeremailid, long customermobilenumber,
			String customeraddress, String customergender, String customerpassword) {

		this.customerid = customerid;
		this.customername = customername;
		this.customeremailid = customeremailid;
		this.customermobilenumber = customermobilenumber;
		this.customeraddress = customeraddress;
		this.customergender = customergender;
		this.customerpassword = customerpassword;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomeremailid() {
		return customeremailid;
	}

	public void setCustomeremailid(String customeremailid) {
		this.customeremailid = customeremailid;
	}

	public long getCustomermobilenumber() {
		return customermobilenumber;
	}

	public void setCustomermobilenumber(long customermobilenumber) {
		this.customermobilenumber = customermobilenumber;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public String getCustomergender() {
		return customergender;
	}

	public void setCustomergender(String customergender) {
		this.customergender = customergender;
	}

	public String getCustomerpassword() {
		return customerpassword;
	}

	public void setCustomerpassword(String customerpassword) {
		this.customerpassword = customerpassword;
	}



	@Override
	public String toString() {
		return "Customer_Details [customerid=" + customerid + ", customername=" + customername + ", customeremailid="
				+ customeremailid + ", customermobilenumber=" + customermobilenumber + ", customeraddress="
				+ customeraddress + ", customergender=" + customergender + ", customerpassword=" + customerpassword
				+ "]";
	}

}
