package entity;

public class Pay_Uti_Detail {
	private String payment_no;
	private String utility_name;
	private double utility_price;
	
	public Pay_Uti_Detail() {}
	
	public Pay_Uti_Detail(String payment_no, String utility_name, double utility_price) {
		this.payment_no = payment_no;
		this.utility_name = utility_name;
		this.utility_price = utility_price;
	}

	public String getPayment_no() {
		return payment_no;
	}

	public void setPayment_no(String payment_no) {
		this.payment_no = payment_no;
	}

	public String getUtility_name() {
		return utility_name;
	}

	public void setUtility_name(String utility_name) {
		this.utility_name = utility_name;
	}

	public double getUtility_price() {
		return utility_price;
	}

	public void setUtility_price(double utility_price) {
		this.utility_price = utility_price;
	}

	@Override
	public String toString() {
		return "Pay_Uti_Detail [payment_no=" + payment_no + ", utility_name=" + utility_name + ", utility_price=" + utility_price + "]";
	}
}
