package entity;

import java.time.LocalDate;

public class Show_Register {
	private String sr_cus_fullname;
	private LocalDate sr_cus_dob;
	private String sr_cus_address;
	private String sr_cus_contactNo;
	private String sr_mng_fullname;
	private Double sr_deposit;
	private LocalDate sr_register_day;
	private int sr_register_no;
	
	public Show_Register() {}

	public Show_Register(String sr_cus_fullname, LocalDate sr_cus_dob, String sr_cus_address, String sr_cus_contactNo,
			String sr_mng_fullname, Double sr_deposit, LocalDate sr_register_day, int sr_register_no) {
		this.sr_cus_fullname = sr_cus_fullname;
		this.sr_cus_dob = sr_cus_dob;
		this.sr_cus_address = sr_cus_address;
		this.sr_cus_contactNo = sr_cus_contactNo;
		this.sr_mng_fullname = sr_mng_fullname;
		this.sr_deposit = sr_deposit;
		this.sr_register_day = sr_register_day;
		this.sr_register_no = sr_register_no;
	}

	public String getSr_cus_fullname() {
		return sr_cus_fullname;
	}

	public void setSr_cus_fullname(String sr_cus_fullname) {
		this.sr_cus_fullname = sr_cus_fullname;
	}

	public LocalDate getSr_cus_dob() {
		return sr_cus_dob;
	}

	public void setSr_cus_dob(LocalDate sr_cus_dob) {
		this.sr_cus_dob = sr_cus_dob;
	}

	public String getSr_cus_address() {
		return sr_cus_address;
	}

	public void setSr_cus_address(String sr_cus_address) {
		this.sr_cus_address = sr_cus_address;
	}

	public String getSr_cus_contactNo() {
		return sr_cus_contactNo;
	}

	public void setSr_cus_contactNo(String sr_cus_contactNo) {
		this.sr_cus_contactNo = sr_cus_contactNo;
	}

	public String getSr_mng_fullname() {
		return sr_mng_fullname;
	}

	public void setSr_mng_fullname(String sr_mng_fullname) {
		this.sr_mng_fullname = sr_mng_fullname;
	}

	public Double getSr_deposit() {
		return sr_deposit;
	}

	public void setSr_deposit(Double sr_deposit) {
		this.sr_deposit = sr_deposit;
	}

	public LocalDate getSr_register_day() {
		return sr_register_day;
	}

	public void setSr_register_day(LocalDate sr_register_day) {
		this.sr_register_day = sr_register_day;
	}

	public int getSr_register_no() {
		return sr_register_no;
	}

	public void setSr_register_no(int sr_register_no) {
		this.sr_register_no = sr_register_no;
	}

	@Override
	public String toString() {
		return "Show_Register [sr_cus_fullname=" + sr_cus_fullname + ", sr_cus_dob=" + sr_cus_dob + ", sr_cus_address="
				+ sr_cus_address + ", sr_cus_contactNo=" + sr_cus_contactNo + ", sr_mng_fullname=" + sr_mng_fullname
				+ ", sr_deposit=" + sr_deposit + ", sr_register_day=" + sr_register_day + ", sr_register_no="
				+ sr_register_no + "]";
	}
}
