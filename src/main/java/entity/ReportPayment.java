package entity;

public class ReportPayment {
	private String rp_payment_no;
	private int rp_months;
	private int rp_lastMonth;
	private int rp_currentMonth;
	private Double rp_totalPrice;
	private String rp_mngName;
	
	public ReportPayment() {}
	
	public ReportPayment(Double rp_totalPrice) {
		this.rp_totalPrice = rp_totalPrice;
	}

	public ReportPayment(String rp_payment_no, int rp_months, int rp_lastMonth, int rp_currentMonth,
			Double rp_totalPrice, String rp_mngName) {
		this.rp_payment_no = rp_payment_no;
		this.rp_months = rp_months;
		this.rp_lastMonth = rp_lastMonth;
		this.rp_currentMonth = rp_currentMonth;
		this.rp_totalPrice = rp_totalPrice;
		this.rp_mngName = rp_mngName;
	}

	public String getRp_payment_no() {
		return rp_payment_no;
	}

	public void setRp_payment_no(String rp_payment_no) {
		this.rp_payment_no = rp_payment_no;
	}

	public int getRp_months() {
		return rp_months;
	}

	public void setRp_months(int rp_months) {
		this.rp_months = rp_months;
	}

	public int getRp_lastMonth() {
		return rp_lastMonth;
	}

	public void setRp_lastMonth(int rp_lastMonth) {
		this.rp_lastMonth = rp_lastMonth;
	}

	public int getRp_currentMonth() {
		return rp_currentMonth;
	}

	public void setRp_currentMonth(int rp_currentMonth) {
		this.rp_currentMonth = rp_currentMonth;
	}

	public Double getRp_totalPrice() {
		return rp_totalPrice;
	}

	public void setRp_totalPrice(Double rp_totalPrice) {
		this.rp_totalPrice = rp_totalPrice;
	}

	public String getRp_mngName() {
		return rp_mngName;
	}

	public void setRp_mngName(String rp_mngName) {
		this.rp_mngName = rp_mngName;
	}

	@Override
	public String toString() {
		return "ReportPayment [rp_payment_no=" + rp_payment_no + ", rp_months=" + rp_months + ", rp_lastMonth="
				+ rp_lastMonth + ", rp_currentMonth=" + rp_currentMonth + ", rp_totalPrice=" + rp_totalPrice
				+ ", rp_mngName=" + rp_mngName + "]";
	}
	
	
}
