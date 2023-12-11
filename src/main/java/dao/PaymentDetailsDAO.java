package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectToDatabase;
import entity.PaymentDetails;

public class PaymentDetailsDAO {
	
	// Xổ thông tin từ tbl_Payment_Detail -> table
	public List<PaymentDetails> getListPaymentDetails(){
		List<PaymentDetails> list = new ArrayList<>();
		var con = ConnectToDatabase.getConnect();
		try {
			var stmt = con.createStatement();
			var rs = stmt.executeQuery("select * from tbl_Payments_detail");
			while(rs.next()){
				var detail = new PaymentDetails();
				
				detail.setPayment_id(rs.getInt("payment_id"));
				detail.setPayment_no(rs.getString("payment_no"));
				detail.setUltility_id(rs.getInt("utility_id"));
				detail.setUltility_amount(rs.getInt("utility_amount"));
				detail.setUltility_total_price(rs.getDouble("utility_total_price"));
				
				list.add(detail);
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
	
	public void insertPaymentDetail(PaymentDetails detail) {
		var con = ConnectToDatabase.getConnect();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into tbl_Payments_detail(payment_no, utility_id, utility_amount, utility_total_price) "
					+ "values (?,?,?,?)");

			ps.setString(1, detail.getPayment_no());
			ps.setInt(2, detail.getUltility_id());
			ps.setInt(3, detail.getUltility_amount());
			ps.setDouble(4, detail.getUltility_total_price());
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
	
	public void updatePaymentDetail(PaymentDetails detail) {
		var con = ConnectToDatabase.getConnect();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("update tbl_Payments_detail set utility_amount=?, utility_total_price=? where payment_no=? "
					+ "AND utility_id=?");
			
			ps.setInt(1, detail.getUltility_amount());
			ps.setDouble(2, detail.getUltility_total_price());
			ps.setString(3, detail.getPayment_no());
			ps.setInt(4, detail.getUltility_id());
			
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
