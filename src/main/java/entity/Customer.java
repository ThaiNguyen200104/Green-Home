package entity;

import java.time.LocalDate;

public class Customer {
	private int cus_id;
	private String cus_fullname;
	private LocalDate cus_dob;
	private boolean gender;
	private String cus_IDNo;
	private String cus_contactNo;
	private String cus_address;
	private String cus_picture;
	
	public Customer() {}
	
	public Customer(int cus_id, String cus_fullname, LocalDate cus_dob, boolean gender, String cus_IDNo,
			String cus_contactNo, String cus_address, String cus_picture) {
		this.cus_id = cus_id;
		this.cus_fullname = cus_fullname;
		this.cus_dob = cus_dob;
		this.gender = gender;
		this.cus_IDNo = cus_IDNo;
		this.cus_contactNo = cus_contactNo;
		this.cus_address = cus_address;
		this.cus_picture = cus_picture;
	}

	public int getCus_id() {
		return cus_id;
	}

	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}

	public String getCus_fullname() {
		return cus_fullname;
	}

	public void setCus_fullname(String cus_fullname) {
		this.cus_fullname = cus_fullname;
	}

	public LocalDate getCus_dob() {
		return cus_dob;
	}

	public void setCus_dob(LocalDate cus_dob) {
		this.cus_dob = cus_dob;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getCus_IDNo() {
		return cus_IDNo;
	}

	public void setCus_IDNo(String cus_IDNo) {
		this.cus_IDNo = cus_IDNo;
	}

	public String getCus_contactNo() {
		return cus_contactNo;
	}

	public void setCus_contactNo(String cus_contactNo) {
		this.cus_contactNo = cus_contactNo;
	}

	public String getCus_address() {
		return cus_address;
	}

	public void setCus_address(String cus_address) {
		this.cus_address = cus_address;
	}

	public String getCus_picture() {
		return cus_picture;
	}

	public void setCus_picture(String cus_picture) {
		this.cus_picture = cus_picture;
	}

	@Override
	public String toString() {
		return "Customer [cus_id=" + cus_id + ", cus_fullname=" + cus_fullname + ", cus_dob=" + cus_dob + ", gender="
				+ gender + ", cus_IDNo=" + cus_IDNo + ", cus_contactNo=" + cus_contactNo + ", cus_address="
				+ cus_address + ", cus_picture=" + cus_picture + "]";
	}
}