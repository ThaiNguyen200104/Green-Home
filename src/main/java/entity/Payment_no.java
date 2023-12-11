package entity;

public class Payment_no {
	private String pay_number;

	public Payment_no() {}
	public Payment_no(String pay_number) {
		this.pay_number = pay_number;
	}

	public String getPay_number() {
		return pay_number;
	}

	public void setPay_number(String pay_number) {
		this.pay_number = pay_number;
	}

	@Override
	public String toString() {
		return "Payment_no [pay_number=" + pay_number + "]";
	}
}
