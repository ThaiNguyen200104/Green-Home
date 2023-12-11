package entity;

public class PaymentDetails {
	private int payment_id;
	private String payment_no;
	private int ultility_id;
	private int ultility_amount;
	private double ultility_total_price;
	
	public PaymentDetails() {}
	
	public PaymentDetails(String payment_no, int ultility_id, int ultility_amount, double ultility_total_price) {
		this.payment_no = payment_no;
		this.ultility_id = ultility_id;
		this.ultility_amount = ultility_amount;
		this.ultility_total_price = ultility_total_price;
	}
	
	public PaymentDetails(int payment_id, String payment_no, int ultility_id, int ultility_amount,
			double ultility_total_price) {
		this.payment_id = payment_id;
		this.payment_no = payment_no;
		this.ultility_id = ultility_id;
		this.ultility_amount = ultility_amount;
		this.ultility_total_price = ultility_total_price;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getPayment_no() {
		return payment_no;
	}

	public void setPayment_no(String payment_no) {
		this.payment_no = payment_no;
	}

	public int getUltility_id() {
		return ultility_id;
	}

	public void setUltility_id(int ultility_id) {
		this.ultility_id = ultility_id;
	}

	public int getUltility_amount() {
		return ultility_amount;
	}

	public void setUltility_amount(int ultility_amount) {
		this.ultility_amount = ultility_amount;
	}

	public double getUltility_total_price() {
		return ultility_total_price;
	}

	public void setUltility_total_price(double ultility_total_price) {
		this.ultility_total_price = ultility_total_price;
	}

	@Override
	public String toString() {
		return "PaymentDetails [payment_id=" + payment_id + ", payment_no=" + payment_no + ", ultility_id="
				+ ultility_id + ", ultility_amount=" + ultility_amount + ", ultility_total_price="
				+ ultility_total_price + "]";
	}
}