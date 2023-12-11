package entity;

import java.time.LocalDate;

public class Register {
	private int register_no;
	private int cus_id;
	private int mng_id;
	private LocalDate register_day;
	private int deposit;
	
	public Register() {}

	public Register(int register_no, int cus_id, int mng_id, LocalDate register_day, int deposit) {
		this.register_no = register_no;
		this.cus_id = cus_id;
		this.mng_id = mng_id;
		this.register_day = register_day;
		this.deposit = deposit;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getRegister_no() {
		return register_no;
	}


	public void setRegister_no(int register_no) {
		this.register_no = register_no;
	}


	public int getCus_id() {
		return cus_id;
	}


	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}


	public int getMng_id() {
		return mng_id;
	}


	public void setMng_id(int mng_id) {
		this.mng_id = mng_id;
	}


	public LocalDate getRegister_day() {
		return register_day;
	}


	public void setRegister_day(LocalDate register_day) {
		this.register_day = register_day;
	}


	@Override
	public String toString() {
		return "Register [register_no=" + register_no + ", cus_id=" + cus_id + ", mng_id=" + mng_id + ", register_day="
				+ register_day + ", deposit=" + deposit + "]";
	}
}