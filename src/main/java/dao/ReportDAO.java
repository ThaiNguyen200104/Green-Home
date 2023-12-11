package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectToDatabase;
import entity.Profit;
import entity.ReportPayment;

public class ReportDAO {
	
	// Xổ dữ liệu Payment ra bảng Report
	public List<ReportPayment> showReport() {
		List<ReportPayment> rp_List = new ArrayList<>();
		var con = ConnectToDatabase.getConnect();
		try {
			var stmt = con.createStatement();
			var rs = stmt.executeQuery("SELECT tbl_Payments.payment_no, tbl_Payments.months, tbl_Payments.total_amount, "
					+ "tbl_Manager.mng_fullname FROM tbl_Payments "
					+ "INNER JOIN tbl_Room_Allocation ON tbl_Payments.ra_no = tbl_Room_Allocation.ra_no "
					+ "INNER JOIN tbl_RoomList ON tbl_Room_Allocation.room_id = tbl_RoomList.room_id "
					+ "INNER JOIN tbl_Register ON tbl_Register.register_no = tbl_Room_Allocation.register_no "
					+ "INNER JOIN tbl_Manager ON tbl_Register.mng_id = tbl_Manager.mng_id");
			
			while(rs.next()){
				var rp_list = new ReportPayment();
				rp_list.setRp_payment_no(rs.getString("payment_no"));
				rp_list.setRp_months(rs.getInt("months"));
				rp_list.setRp_totalPrice(rs.getDouble("total_amount"));
				rp_list.setRp_mngName(rs.getString("mng_fullname"));
				
				rp_List.add(rp_list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null) {
					con.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rp_List;
	}
	
	
	public List<Profit> getProfit(int fromMonth, int toMonth) {
		List<Profit> rp_list = new ArrayList<>();
		var con = ConnectToDatabase.getConnect();
		try {
			var cs = con.prepareCall("{call getProfit(?,?)}");
			cs.setInt(1,  fromMonth);
			cs.setInt(2,  toMonth);
			
			var rs = cs.executeQuery();
			
			while(rs.next()) {
				var profit = new Profit();
				
				profit.setTotal_price(rs.getDouble("profit"));
				
				rp_list.add(profit);
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
		return rp_list;
	}
}
