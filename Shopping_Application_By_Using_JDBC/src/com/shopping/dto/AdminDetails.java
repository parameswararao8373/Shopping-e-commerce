package com.shopping.dto;

public class AdminDetails {

	private int adminid;
	private String adminemailid;
	private String adminpassword;
	private String adminrole;

	public AdminDetails() {
	}

	public AdminDetails(int adminid, String adminemailid, String adminpassword, String adminrole) {

		this.adminid = adminid;
		this.adminemailid = adminemailid;
		this.adminpassword = adminpassword;
		this.adminrole = adminrole;
	}

	
	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAdminemailid() {
		return adminemailid;
	}

	public void setAdminemailid(String adminemailid) {
		this.adminemailid = adminemailid;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	public String getAdminrole() {
		return adminrole;
	}

	public void setAdminrole(String adminrole) {
		this.adminrole = adminrole;
	}

	public void admindisplay() {
		System.out.println("Admin_id:" + getAdminid());
		System.out.println("Admin_Email_Id:" + getAdminemailid());
		System.out.println("Admin_Password:" + getAdminpassword());
		System.out.println("Admin_Role:" + getAdminrole());
	}

	@Override
	public String toString() {
		return "admin_details [adminid=" + adminid + ", adminemailid=" + adminemailid + ", adminpassword="
				+ adminpassword + ", adminrole=" + adminrole + "]";
	}

}
