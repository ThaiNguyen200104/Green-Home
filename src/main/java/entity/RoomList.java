package entity;

public class RoomList {
	private String room_id;
	private String building;
	private int storey;
	private String room_type;
	private int room_price;
	private Double room_area;
	private boolean room_status;
	
	public RoomList() {}
	
	public RoomList(String room_id) {
		this.room_id = room_id;
	}
	
	public RoomList(String room_id, String building, int storey, String room_type, 
			int room_price, Double room_area, boolean room_status) {
		this.room_id = room_id;
		this.building = building;
		this.storey = storey;
		this.room_type = room_type;
		this.room_price = room_price;
		this.room_area = room_area;
		this.room_status = room_status;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public int getStorey() {
		return storey;
	}

	public void setStorey(int storey) {
		this.storey = storey;
	}
	
	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public int getRoom_price() {
		return room_price;
	}

	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}

	public Double getRoom_area() {
		return room_area;
	}

	public void setRoom_area(Double room_area) {
		this.room_area = room_area;
	}

	public boolean isRoom_status() {
		return room_status;
	}

	public void setRoom_status(boolean room_status) {
		this.room_status = room_status;
	}

	@Override
	public String toString() {
		return "RoomList [room_id=" + room_id + ", building=" + building + ", storey=" + storey 
				+ ", room_type=" + room_type + ", room_price=" + room_price + ", room_area=" 
				+ room_area + ", room_status=" + room_status + "]";
	}
}