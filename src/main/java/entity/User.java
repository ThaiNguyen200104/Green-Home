package entity;

import java.time.LocalDate;

public class User {
	private int usr_id;
	private String usr_name;
	private String usr_pw;
	private String usr_type;
	private LocalDate usr_create_day;
	
	public User() {}
	
	public User(int usr_id, String usr_name, String usr_pw, String usr_type, 
			LocalDate usr_create_day) {
		this.usr_id = usr_id;
		this.usr_name = usr_name;
		this.usr_pw = usr_pw;
		this.usr_type = usr_type;
		this.usr_create_day = usr_create_day;
	}

	public int getUsr_id() {
		return usr_id;
	}

	public void setUsr_id(int usr_id) {
		this.usr_id = usr_id;
	
	}

	public String getUsr_name() {
		return usr_name;
	}

	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}

	public String getUsr_pw() {
		return usr_pw;
	}

	public void setUsr_pw(String usr_pw) {
		this.usr_pw = usr_pw;
	}

	public String getUsr_type() {
		return usr_type;
	}

	public void setUsr_type(String usr_type) {
		this.usr_type = usr_type;
	}

	public LocalDate getUsr_create_day() {
		return usr_create_day;
	}

	public void setUsr_create_day(LocalDate usr_create_day) {
		this.usr_create_day = usr_create_day;
	}

	@Override
	public String toString() {
		return "User [usr_id=" + usr_id + ", usr_name=" + usr_name + ", usr_pw=" + usr_pw 
				+ ", usr_type=" + usr_type + ", usr_create_day=" + usr_create_day + "]";
	}
}
/*usr_id INT PRIMARY KEY IDENTITY,
usr_name NVARCHAR(50),
usr_pw NVARCHAR(20),
usr_type NVARCHAR(20),
usr_create_day DATE */