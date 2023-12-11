package entity;

import java.time.LocalDate;

public class Room_Allocation {
	
	private int ra_no;
	private String room_id;
	private int register_no;
	private LocalDate ra_dayIn;
	
	public Room_Allocation() {}

	public Room_Allocation(int ra_no, String room_id, int register_no, LocalDate ra_dayIn) {
		this.ra_no = ra_no;
		this.room_id = room_id;
		this.register_no = register_no;
		this.ra_dayIn = ra_dayIn;
	}

	public int getRa_no() {
		return ra_no;
	}

	public void setRa_no(int ra_no) {
		this.ra_no = ra_no;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public int getRegister_no() {
		return register_no;
	}

	public void setRegister_no(int register_no) {
		this.register_no = register_no;
	}

	public LocalDate getRa_dayIn() {
		return ra_dayIn;
	}

	public void setRa_dayIn(LocalDate ra_dayIn) {
		this.ra_dayIn = ra_dayIn;
	}

	@Override
	public String toString() {
		return "Room_Allocation [ra_no=" + ra_no + ", room_id=" + room_id + ", register_no=" + register_no
				+ ", ra_dayIn=" + ra_dayIn + "]";
	}
}
/*RA_no INT PRIMARY KEY IDENTITY,
room_id INT,
register_no INT*/