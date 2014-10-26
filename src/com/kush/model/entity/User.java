package com.kush.model.entity;

public class User
{
	private String email;
	private String addr;
	private String pass;
	private String phone;
	private String role;
	
	public User(String email, String addr, String pass, String phone, String role) {
		super();
		this.email = email;
		this.addr = addr;
		this.pass = pass;
		this.phone = phone;
		this.role = role;
		System.out.println(email);
		System.out.println(addr);
		System.out.println(pass);
		System.out.println(phone);
		System.out.println(role);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
