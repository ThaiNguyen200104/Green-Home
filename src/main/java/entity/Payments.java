package entity;

import java.time.LocalDate;

public class Payments {
	private String payment_no;
	private int ra_no;
	private int utility_id;
	private int months;
	private LocalDate dayCheckIn;
	private LocalDate dayCheckOut;
	private Double total_amount;
	private boolean status;
	
	public Payments() {}
	
	public Payments(String payment_no) {
		this.payment_no = payment_no;
	}
	
	public Payments(String payment_no, int ra_no, int utility_id, int months, LocalDate dayCheckIn,
			LocalDate dayCheckOut, Double total_amount, boolean status) {
		this.payment_no = payment_no;
		this.ra_no = ra_no;
		this.utility_id = utility_id;
		this.months = months;
		this.dayCheckIn = dayCheckIn;
		this.dayCheckOut = dayCheckOut;
		this.total_amount = total_amount;
		this.status = status;
	}

	public String getPayment_no() {
		return payment_no;
	}

	public void setPayment_no(String payment_no) {
		this.payment_no = payment_no;
	}

	public int getRa_no() {
		return ra_no;
	}

	public void setRa_no(int ra_no) {
		this.ra_no = ra_no;
	}

	public int getUtility_id() {
		return utility_id;
	}

	public void setUtility_id(int utility_id) {
		this.utility_id = utility_id;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public LocalDate getDayCheckIn() {
		return dayCheckIn;
	}

	public void setDayCheckIn(LocalDate dayCheckIn) {
		this.dayCheckIn = dayCheckIn;
	}

	public LocalDate getDayCheckOut() {
		return dayCheckOut;
	}

	public void setDayCheckOut(LocalDate dayCheckOut) {
		this.dayCheckOut = dayCheckOut;
	}

	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payments [payment_no=" + payment_no + ", ra_no=" + ra_no + ", utility_id=" + utility_id + ", months="
				+ months + ", dayCheckIn=" + dayCheckIn + ", dayCheckOut=" + dayCheckOut + ", total_amount="
				+ total_amount + ", status=" + status + "]";
	}
}