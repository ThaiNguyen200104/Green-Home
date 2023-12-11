package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectToDatabase;
import entity.Customer;

public class CustomerDAO {
	// Hiển thị thông tin từ tbl_Customer -> bảng
	public List<Customer> getListCustomer(){
		List<Customer> list = new ArrayList<>();
		var con = ConnectToDatabase.getConnect();
		try {
			var stmt = con.createStatement();
			var rs = stmt.executeQuery("select * from tbl_Customer");
			while(rs.next()){
				var cus = new Customer();
				
				cus.setCus_id(rs.getInt("cus_id"));
				cus.setCus_fullname(rs.getString("cus_fullname"));
				cus.setCus_dob(rs.getDate("cus_dob").toLocalDate());
				cus.setGender(rs.getBoolean("cus_gender"));
				cus.setCus_IDNo(rs.getString("cus_IDNo"));
				cus.setCus_contactNo(rs.getString("cus_contactNo"));
				cus.setCus_address(rs.getString("cus_address"));
				cus.setCus_picture(rs.getString("cus_picture"));
				
				list.add(cus);
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
	
	public void insertCustomer(Customer cus) {
		var con = ConnectToDatabase.getConnect();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into tbl_Customer(cus_fullname, cus_dob, cus_gender, cus_IDNo, cus_contactNo, cus_address, "
					+ "cus_picture) values (?,?,?,?,?,?,?)"
			);
			
			ps.setString(1, cus.getCus_fullname());
			ps.setDate(2, Date.valueOf(cus.getCus_dob()));
			ps.setBoolean(3, cus.isGender());
			ps.setString(4, cus.getCus_IDNo());
			ps.setString(5, cus.getCus_contactNo());
			ps.setString(6, cus.getCus_address());
			ps.setString(7, cus.getCus_picture());
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
	
	public void updateCustomer(Customer cus) {
		var con = ConnectToDatabase.getConnect();
		try(
			var cs = con.prepareStatement("update tbl_Customer set cus_fullname=?, cus_dob=?, cus_gender=?, cus_IDNo=?, cus_contactNo=?, "
					+ "cus_address=?, cus_picture=? where cus_id=?");
		) {
			cs.setString(1,cus.getCus_fullname());
			cs.setDate(2, java.sql.Date.valueOf(cus.getCus_dob()));
			cs.setBoolean(3, cus.isGender());
			cs.setString(4, cus.getCus_IDNo());
			cs.setString(5, cus.getCus_contactNo());
			cs.setString(6, cus.getCus_address());
			cs.setString(7, cus.getCus_picture());
			cs.setInt(8, cus.getCus_id());

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

	public void deleteCustomer(Customer cus) {
		var con = ConnectToDatabase.getConnect();
		try (
			var cs = con.prepareCall("delete from tbl_Customer where cus_id=?");
		) {
			cs.setInt(1, cus.getCus_id());
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
}
