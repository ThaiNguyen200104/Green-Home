package entity;

public class Profit {
	private Double total_price;

	public Profit() {}
	
	public Profit(Double total_price) {
		this.total_price = total_price;
	}

	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	@Override
	public String toString() {
		return "Profit [total_price=" + total_price + "]";
	}
}
