package entity;

public class Utilities {
	private int utilitiy_id;
	private String utility_name;
	private Double utility_price;
	
	public Utilities() {}

	public Utilities(int utilitiy_id, String utility_name, Double utility_price) {
		this.utilitiy_id = utilitiy_id;
		this.utility_name = utility_name;
		this.utility_price = utility_price;
	}

	public int getUtilitiy_id() {
		return utilitiy_id;
	}

	public void setUtilitiy_id(int utilitiy_id) {
		this.utilitiy_id = utilitiy_id;
	}

	public String getUtility_name() {
		return utility_name;
	}

	public void setUtility_name(String utility_name) {
		this.utility_name = utility_name;
	}

	public Double getUtility_price() {
		return utility_price;
	}

	public void setUtility_price(Double utility_price) {
		this.utility_price = utility_price;
	}

	@Override
	public String toString() {
		return "Utilities [utilitiy_id=" + utilitiy_id + ", utility_name=" + utility_name 
				+ ", utility_price=" + utility_price + "]";
	}
}
/*utilitiy_id INT PRIMARY KEY IDENTITY,
utility_name NVARCHAR(50),
utility_price FLOAT*/