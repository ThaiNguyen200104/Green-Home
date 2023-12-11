package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectToDatabase;
import entity.Payment_no;
import entity.Payments;
import entity.RoomList;
import entity.Room_Allocation;
import entity.Utilities;

public class PaymentDAO {
	// Xổ thông tin từ tbl_Payment -> table
	public List<Payments> getListPayment(){
		List<Payments> list = new ArrayList<>();
		var con = ConnectToDatabase.getConnect();
		try {
			var stmt = con.createStatement();
			var rs = stmt.executeQuery("select * from tbl_Payments");
			while(rs.next()){
				
				var pay = new Payments();
				pay.setPayment_no(rs.getString("payment_no"));
				pay.setRa_no(rs.getInt("ra_no"));
				pay.setMonths(rs.getInt("months"));
				pay.setDayCheckIn(rs.getDate("day_checkin").toLocalDate());
				pay.setDayCheckOut(rs.getDate("day_checkout").toLocalDate());
				pay.setTotal_amount(rs.getDouble("total_amount"));
				pay.setStatus(rs.getBoolean("payment_status"));
				
				list.add(pay);
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
	
	public void insertPayment(Payments pay) {
		var con = ConnectToDatabase.getConnect();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into tbl_Payments(payment_no, ra_no, months, day_checkin, day_checkout, total_amount, "
					+ "payment_status) values (?,?,?,?,?,?,?)"
			);
			ps.setString(1, pay.getPayment_no());
			ps.setInt(2, pay.getRa_no());
			ps.setInt(3, pay.getMonths());
			ps.setDate(4, Date.valueOf(pay.getDayCheckIn()));
			ps.setDate(5, Date.valueOf(pay.getDayCheckOut()));
			ps.setDouble(6, pay.getTotal_amount());
			ps.setBoolean(7, pay.isStatus());
			
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
	
	public void updatePayment(Payments pay) {
		var con = ConnectToDatabase.getConnect();
		try(
			var cs = con.prepareStatement("update tbl_Payments set ra_no=?, months=?, day_checkin=?, day_checkout=?, total_amount=?, "
					+ "payment_status=? where payment_no=?");
		) {
			cs.setInt(1,pay.getRa_no());
			cs.setInt(2, pay.getMonths());
			cs.setDate(3, java.sql.Date.valueOf(pay.getDayCheckIn()));
			cs.setDate(4, java.sql.Date.valueOf(pay.getDayCheckOut()));
			cs.setDouble(5, pay.getTotal_amount());
			cs.setBoolean(6, pay.isStatus());
			cs.setString(7, pay.getPayment_no());

			cs.executeUpdate();
			
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

	
	// ---------------------------- Payments - SHOW function ---------------------------
	
	// Xổ payment_no (tbl_Payments)
	public List<Payment_no> getPaymentNo() {
		var con = ConnectToDatabase.getConnect();
		List<Payment_no> payList = new ArrayList<>();
		try {
			var stmt = con.createStatement();
			var rs = stmt.executeQuery("SELECT payment_no FROM tbl_Payments "
					+ "WHERE payment_no=(SELECT MAX(payment_no) "
					+ "FROM tbl_Payments)");
			
			while(rs.next()){
				var pay_no = new Payment_no();
				
				pay_no.setPay_number(rs.getString("payment_no"));	
				payList.add(pay_no);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
		return payList;
	}
	
	// Xổ thông tin cho comboBox (SHOW)
	public List<String> getShowRoomId(){
		List<RoomList> roomList = new ArrayList<>();
		List<String> list_id = new ArrayList<>();
		var con = ConnectToDatabase.getConnect();
			try {
				var stmt = con.createStatement();
				var rs = stmt.executeQuery("SELECT * from tbl_RoomList WHERE room_status=1");
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
				JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
			}
			for (var item : roomList) {
				list_id.add(item.getRoom_id());
			} 
		return list_id;
	}
	
	// Xổ thông tin cho comboBox (CHECK OUT)
	public List<String> getCORoomId(){
		List<RoomList> coList = new ArrayList<>();
		List<String> list_co = new ArrayList<>();
		var con = ConnectToDatabase.getConnect();
			try {
				var stmt = con.createStatement();
				var rs = stmt.executeQuery("select * from tbl_RoomList where room_status=0");
				while(rs.next()){
					var co_list = new RoomList();
				
					co_list.setRoom_id(rs.getString("room_id"));
					co_list.setBuilding(rs.getString("building"));
					co_list.setStorey(rs.getInt("storey"));
					co_list.setRoom_type(rs.getString("room_type"));
					co_list.setRoom_price(rs.getInt("room_price"));
					co_list.setRoom_area(rs.getDouble("room_area"));
					co_list.setRoom_status(rs.getBoolean("room_status"));
						
					coList.add(co_list);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
			} 
			for (var item : coList) {
				list_co.add(item.getRoom_id());
			} 
		return list_co;
	}
	
	
	
	// ---------------------------- Room_Allocation function ---------------------------
	
	// Xổ thông tin từ tbl_Room_Allocation ra cho comboBox (SHOW, MONTHLY CHECK, CHECK OUT)
	public List<Room_Allocation> getRAList(){
		List<Room_Allocation> raList = new ArrayList<>();
		var con = ConnectToDatabase.getConnect();
			try {
				var stmt = con.createStatement();
				var rs = stmt.executeQuery("select * from tbl_Room_Allocation");
				while(rs.next()){
					var ra_list = new Room_Allocation();
					
					ra_list.setRa_no(rs.getInt("ra_no"));
					ra_list.setRoom_id(rs.getString("room_id"));
					ra_list.setRegister_no(rs.getInt("register_no"));
					ra_list.setRa_dayIn(rs.getDate("ra_dayIn").toLocalDate());
					
					raList.add(ra_list);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
			}
		return raList;
	}
	
	
	// ---------------------------- Utility function ---------------------------
	
	// Xổ giá thông tin từ tbl_Utility
	public List<Utilities> getUtilityList(){
		List<Utilities> utiList = new ArrayList<>();
		var con = ConnectToDatabase.getConnect();
			try {
				var stmt = con.createStatement();
				var rs = stmt.executeQuery("select * from tbl_Utilities");
				while(rs.next()){
					var uti_list = new Utilities();
					
					uti_list.setUtilitiy_id(rs.getInt("utility_id"));
					uti_list.setUtility_name(rs.getString("utility_name"));
					uti_list.setUtility_price(rs.getDouble("utility_price"));
					utiList.add(uti_list);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
			}
		return utiList;
	}

	
	// ---------------------------- CHECK OUT function ---------------------------
	
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