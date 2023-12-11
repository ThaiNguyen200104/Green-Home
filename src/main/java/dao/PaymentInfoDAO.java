package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectToDatabase;
import entity.PaymentInfo;

public class PaymentInfoDAO {
	public List<PaymentInfo> showPaymentInfo() {
		List<PaymentInfo> pi_List = new ArrayList<>();
		var con = ConnectToDatabase.getConnect();
		try {
			var stmt = con.createStatement();
			var rs = stmt.executeQuery("SELECT tbl_Payments.payment_no, tbl_Payments.day_checkin, tbl_Payments.day_checkout, "
					+ "tbl_Payments.total_amount, tbl_RoomList.room_id, tbl_Customer.cus_fullname,  tbl_Customer.cus_contactNo, "
					+ "tbl_Customer.cus_address, tbl_Room_Allocation.ra_no, tbl_Payments.months, tbl_RoomList.room_price "
					+ "FROM tbl_Payments INNER JOIN tbl_Room_Allocation ON tbl_Payments.ra_no = tbl_Room_Allocation.ra_no "
					+ "INNER JOIN tbl_RoomList ON tbl_Room_Allocation.room_id = tbl_RoomList.room_id "
					+ "INNER JOIN tbl_Register ON tbl_Register.register_no = tbl_Room_Allocation.register_no "
					+ "INNER JOIN tbl_Customer ON tbl_Register.cus_id = tbl_Customer.cus_id");
			
			while(rs.next()){
				var pi_list = new PaymentInfo();
				pi_list.setPi_payment_no(rs.getString("payment_no"));
				pi_list.setPi_day_checkIn(rs.getDate("day_checkin").toLocalDate());
				pi_list.setPi_day_checkOut(rs.getDate("day_checkout").toLocalDate());
				pi_list.setPi_totalAmount(rs.getDouble("total_amount"));
				pi_list.setPi_roomId(rs.getString("room_id"));
				pi_list.setPi_cusName(rs.getString("cus_fullname"));
				pi_list.setPi_cusContactNo(rs.getString("cus_contactNo"));
				pi_list.setPi_cusAddress(rs.getString("cus_address"));
				pi_list.setPi_ra_no(rs.getInt("ra_no"));
				pi_list.setPi_months(rs.getInt("months"));
				pi_list.setPi_room_price(rs.getDouble("room_price"));
				
				pi_List.add(pi_list);
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
		return pi_List;
	}
}
