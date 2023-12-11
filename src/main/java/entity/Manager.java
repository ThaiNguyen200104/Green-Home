package entity;

import java.time.LocalDate;

public class Manager {
	private int mng_id;
	private String mng_fullname;
	private LocalDate mng_dob;
	private boolean mng_gender;
	private String mng_position;
	private String mng_IDNo;
	private String mng_contactNo;
	private String mng_address;
	private String mng_picture;
	private LocalDate mng_dayIn;
	
	public Manager() {}
	
	public Manager(int mng_id, String mng_fullname, LocalDate mng_dob, boolean mng_gender, 
			String mng_position, String mng_IDNo, String mng_contactNo, String mng_address, 
			String mng_picture, LocalDate mng_dayIn) {
		this.mng_id = mng_id;
		this.mng_fullname = mng_fullname;
		this.mng_dob = mng_dob;
		this.mng_gender = mng_gender;
		this.mng_position = mng_position;
		this.mng_IDNo = mng_IDNo;
		this.mng_contactNo = mng_contactNo;
		this.mng_address = mng_address;
		this.mng_picture = mng_picture;
		this.mng_dayIn = mng_dayIn;
	}

	public int getMng_id() {
		return mng_id;
	}

	public void setMng_id(int mng_id) {
		this.mng_id = mng_id;
	}

	public String getMng_fullname() {
		return mng_fullname;
	}

	public void setMng_fullname(String mng_fullname) {
		this.mng_fullname = mng_fullname;
	}

	public LocalDate getMng_dob() {
		return mng_dob;
	}

	public void setMng_dob(LocalDate mng_dob) {
		this.mng_dob = mng_dob;
	}

	public boolean isMng_gender() {
		return mng_gender;
	}

	public void setMng_gender(boolean mng_gender) {
		this.mng_gender = mng_gender;
	}

	public String getMng_position() {
		return mng_position;
	}

	public void setMng_position(String mng_position) {
		this.mng_position = mng_position;
	}

	public String getMng_IDNo() {
		return mng_IDNo;
	}

	public void setMng_IDNo(String mng_IDNo) {
		this.mng_IDNo = mng_IDNo;
	}

	public String getMng_contactNo() {
		return mng_contactNo;
	}

	public void setMng_contactNo(String mng_contactNo) {
		this.mng_contactNo = mng_contactNo;
	}

	public String getMng_address() {
		return mng_address;
	}

	public void setMng_address(String mng_address) {
		this.mng_address = mng_address;
	}

	public String getMng_picture() {
		return mng_picture;
	}

	public void setMng_picture(String mng_picture) {
		this.mng_picture = mng_picture;
	}

	public LocalDate getMng_dayIn() {
		return mng_dayIn;
	}

	public void setMng_dayIn(LocalDate mng_dayIn) {
		this.mng_dayIn = mng_dayIn;
	}

	@Override
	public String toString() {
		return "Manager [mng_id=" + mng_id + ", mng_fullname=" + mng_fullname + ", mng_dob=" + mng_dob + ", mng_gender="
				+ mng_gender + ", mng_position=" + mng_position + ", mng_IDNo=" + mng_IDNo + ", mng_contactNo="
				+ mng_contactNo + ", mng_address=" + mng_address + ", mng_picture=" + mng_picture + ", mng_dayIn="
				+ mng_dayIn + "]";
	}
}

/*mng_id INT PRIMARY KEY IDENTITY,
mng_fullname NVARCHAR(50),
mng_dob DATE,
mng_gender BIT,
mng_position NVARCHAR(50),
mng_IDNo NVARCHAR(50),
mng_contactNo NVARCHAR(50),
mng_country NVARCHAR(200),
mng_picture NVARCHAR(200)
mng_dayIn DATE */