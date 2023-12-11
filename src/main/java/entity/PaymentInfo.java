package entity;

import java.time.LocalDate;

public class PaymentInfo {
	private String pi_payment_no;
	private LocalDate pi_day_checkIn;
	private LocalDate pi_day_checkOut;
	private Double pi_totalAmount;
	private String pi_roomId;
	private String pi_cusName;
	private String pi_cusContactNo;
	private String pi_cusAddress;
	private int pi_ra_no;
	private int pi_months;
	private double pi_room_price;
	
	public PaymentInfo() {}

	public PaymentInfo(String pi_payment_no, LocalDate pi_day_checkIn, LocalDate pi_day_checkOut, Double pi_totalAmount,
			String pi_roomId, String pi_cusName, String pi_cusContactNo, String pi_cusAddress, int pi_ra_no,
			int pi_months, double pi_room_price) {
		this.pi_payment_no = pi_payment_no;
		this.pi_day_checkIn = pi_day_checkIn;
		this.pi_day_checkOut = pi_day_checkOut;
		this.pi_totalAmount = pi_totalAmount;
		this.pi_roomId = pi_roomId;
		this.pi_cusName = pi_cusName;
		this.pi_cusContactNo = pi_cusContactNo;
		this.pi_cusAddress = pi_cusAddress;
		this.pi_ra_no = pi_ra_no;
		this.pi_months = pi_months;
		this.pi_room_price = pi_room_price;
	}

	public String getPi_payment_no() {
		return pi_payment_no;
	}

	public void setPi_payment_no(String pi_payment_no) {
		this.pi_payment_no = pi_payment_no;
	}

	public LocalDate getPi_day_checkIn() {
		return pi_day_checkIn;
	}

	public void setPi_day_checkIn(LocalDate pi_day_checkIn) {
		this.pi_day_checkIn = pi_day_checkIn;
	}

	public LocalDate getPi_day_checkOut() {
		return pi_day_checkOut;
	}

	public void setPi_day_checkOut(LocalDate pi_day_checkOut) {
		this.pi_day_checkOut = pi_day_checkOut;
	}

	public Double getPi_totalAmount() {
		return pi_totalAmount;
	}

	public void setPi_totalAmount(Double pi_totalAmount) {
		this.pi_totalAmount = pi_totalAmount;
	}

	public String getPi_roomId() {
		return pi_roomId;
	}

	public void setPi_roomId(String pi_roomId) {
		this.pi_roomId = pi_roomId;
	}

	public String getPi_cusName() {
		return pi_cusName;
	}

	public void setPi_cusName(String pi_cusName) {
		this.pi_cusName = pi_cusName;
	}

	public String getPi_cusContactNo() {
		return pi_cusContactNo;
	}

	public void setPi_cusContactNo(String pi_cusContactNo) {
		this.pi_cusContactNo = pi_cusContactNo;
	}

	public String getPi_cusAddress() {
		return pi_cusAddress;
	}

	public void setPi_cusAddress(String pi_cusAddress) {
		this.pi_cusAddress = pi_cusAddress;
	}

	public int getPi_ra_no() {
		return pi_ra_no;
	}

	public void setPi_ra_no(int pi_ra_no) {
		this.pi_ra_no = pi_ra_no;
	}

	public int getPi_months() {
		return pi_months;
	}

	public void setPi_months(int pi_months) {
		this.pi_months = pi_months;
	}

	public double getPi_room_price() {
		return pi_room_price;
	}

	public void setPi_room_price(double pi_room_price) {
		this.pi_room_price = pi_room_price;
	}

	@Override
	public String toString() {
		return "PaymentInfo [pi_payment_no=" + pi_payment_no + ", pi_day_checkIn=" + pi_day_checkIn
				+ ", pi_day_checkOut=" + pi_day_checkOut + ", pi_totalAmount=" + pi_totalAmount + ", pi_roomId="
				+ pi_roomId + ", pi_cusName=" + pi_cusName + ", pi_cusContactNo=" + pi_cusContactNo + ", pi_cusAddress="
				+ pi_cusAddress + ", pi_ra_no=" + pi_ra_no + ", pi_months=" + pi_months + ", pi_room_price="
				+ pi_room_price + "]";
	}

	
}
