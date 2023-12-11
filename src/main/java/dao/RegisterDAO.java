package dao;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import database.ConnectToDatabase;
import entity.Register;
import entity.RoomList;
import entity.Room_Allocation;
import entity.Show_Register;

public class RegisterDAO {
	// Hiển thị thông tin từ tbl_Register -> bảng
	public List<Register> getRegisterList(){
		List<Register> list = new ArrayList<>();
		var con = ConnectToDatabase.getConnect();
		try {
			var stmt = con.createStatement();
			var rs = stmt.executeQuery("select * from tbl_Register");
			while(rs.next()){
				var reg = new Register();
				
				reg.setRegister_no(rs.getInt("register_no"));
				reg.setCus_id(rs.getInt("cus_id"));
				reg.setMng_id(rs.getInt("mng_id"));
				reg.setRegister_day(rs.getDate("register_day").toLocalDate());
				reg.setDeposit(rs.getInt("deposit"));
				
				list.add(reg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null) {
					con.close();
				}
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
			}
		}
		return list;
	}
		
	public void insertRegisList(Register reg) {
		var con = ConnectToDatabase.getConnect();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into tbl_Register(cus_id, mng_id, register_day, deposit) values (?,?,?,?)");
			
			ps.setInt(1, reg.getCus_id());
			ps.setInt(2, reg.getMng_id());
			ps.setDate(3, java.sql.Date.valueOf(reg.getRegister_day()));
			ps.setInt(4, reg.getDeposit());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null) {
					con.close();
				}
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
			}
		}
	}
		
	public void updateRegisList(Register reg) {
		var con = ConnectToDatabase.getConnect();
		try(
			var ps = con.prepareStatement("update tbl_Register set cus_id=?, mng_id=?, register_day=?, deposit=? where register_no=?");
		) {
			ps.setInt(1, reg.getCus_id());
			ps.setInt(2, reg.getMng_id());
			ps.setDate(3, java.sql.Date.valueOf(reg.getRegister_day()));
			ps.setInt(4, reg.getDeposit());
			ps.setInt(5, reg.getRegister_no());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null) {
					con.close();
				}
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
			}
		}
	}

	public List<Show_Register> show_register() {
		List<Show_Register> sr_List = new ArrayList<>();
		var con = ConnectToDatabase.getConnect();
		try {
			var stmt = con.createStatement();
			var rs = stmt.executeQuery("SELECT tbl_Customer.cus_fullname, tbl_Customer.cus_dob, "
				+ "tbl_Customer.cus_contactNo, tbl_Customer.cus_address, tbl_Manager.mng_fullname, "
				+ "tbl_Register.deposit, tbl_Register.register_day, tbl_Register.register_no "
				+ "FROM tbl_Customer INNER JOIN tbl_Register ON tbl_Customer.cus_id = tbl_Register.cus_id "
				+ "INNER JOIN tbl_Manager ON tbl_Manager.mng_id = tbl_Register.mng_id ");
			while(rs.next()){
				var reg_list = new Show_Register();
				reg_list.setSr_cus_fullname(rs.getString("cus_fullname"));
				reg_list.setSr_cus_dob(rs.getDate("cus_dob").toLocalDate());
				reg_list.setSr_cus_contactNo(rs.getString("cus_contactNo"));
				reg_list.setSr_cus_address(rs.getString("cus_address"));
				reg_list.setSr_mng_fullname(rs.getString("mng_fullname"));
				reg_list.setSr_deposit(rs.getDouble("deposit"));
				reg_list.setSr_register_day(rs.getDate("register_day").toLocalDate());
				reg_list.setSr_register_no(rs.getInt("register_no"));
				
				sr_List.add(reg_list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null) {
					con.close();
				}
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
			}
		}
		return sr_List;
	}
	
	// Xổ thông tin từ Room ID khi room_status=0 (Unavailable) -> comboBox
	public List<String> getRoomId(){
		List<RoomList> roomList = new ArrayList<>();
		List<String> list_id = new ArrayList<>();
		var con = ConnectToDatabase.getConnect();
		try {
			var stmt = con.createStatement();
			var rs = stmt.executeQuery("select * from tbl_RoomList where room_status=0");
			while(rs.next()){
				var room_list = new RoomList();
				room_list.setRoom_id(rs.getString("room_id"));
				room_list.setBuilding(rs.getString("building"));
				room_list.setStorey(rs.getInt("storey"));
				room_list.setRoom_type(rs.getString("room_type"));
				room_list.setRoom_price(rs.getInt("room_price"));
				room_list.setRoom_area(rs.getDouble("room_area"));
				room_list.setRoom_status(rs.getBoolean("room_status"));

				roomList.add(room_list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null) {
					con.close();
				}
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
			}
		} for (var item : roomList) {
			list_id.add(item.getRoom_id());
		}
		return list_id;
	}
	

	// Thêm thông tin phòng sau khi đăng kí cho Customer
	public void insertRA(Room_Allocation ra) {
		var con = ConnectToDatabase.getConnect();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into tbl_Room_Allocation(room_id, register_no, ra_dayIn) values (?,?,?)");
			
			ps.setString(1, ra.getRoom_id());
			ps.setInt(2, ra.getRegister_no());
			ps.setDate(3, java.sql.Date.valueOf(ra.getRa_dayIn()));
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null) {
					con.close();
				}
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
			}
		}
	}

	// Thay đổi trạng thái phòng (Available/Unavailable)
	public void changeRoomStatus(RoomList roomStatus) {
		var con = ConnectToDatabase.getConnect();
		try( 
			var ps = con.prepareStatement("update tbl_RoomList set room_status=? where room_id=?");
		) {
			ps.setBoolean(1, roomStatus.isRoom_status());
			ps.setString(2, roomStatus.getRoom_id());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null) {
					con.close();
				}
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
			}
		}
	}
}
