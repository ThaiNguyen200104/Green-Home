package dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.swing.JOptionPane;

import database.ConnectToDatabase;
import entity.Manager;

public class ManagerDAO {
	public List<Manager> getListManager(){
		List<Manager> list = new ArrayList<>();
		var con = ConnectToDatabase.getConnect();
		try {
			var stmt = con.createStatement();
			var rs = stmt.executeQuery("select * from tbl_Manager");
			while(rs.next()){
				var mng = new Manager();
				
				mng.setMng_id(rs.getInt("mng_id"));
				mng.setMng_fullname(rs.getString("mng_fullname"));
				mng.setMng_dob(rs.getDate("mng_dob").toLocalDate());
				mng.setMng_gender(rs.getBoolean("mng_gender"));
				mng.setMng_position(rs.getString("mng_position"));
				mng.setMng_IDNo(rs.getString("mng_IDNo"));
				mng.setMng_contactNo(rs.getString("mng_contactNo"));
				mng.setMng_address(rs.getString("mng_address"));
				mng.setMng_picture(rs.getString("mng_picture"));
				mng.setMng_dayIn(rs.getDate("mng_dayIn").toLocalDate());
				
				list.add(mng);
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

	public void insertManager(Manager mng) {
		var con = ConnectToDatabase.getConnect();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into tbl_Manager(mng_fullname, mng_dob, mng_gender, mng_position, mng_IDNo, mng_contactNo, "
					+ "mng_address, mng_picture, mng_dayIn) values (?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, mng.getMng_fullname());
			ps.setDate(2, Date.valueOf(mng.getMng_dob()));
			ps.setBoolean(3, mng.isMng_gender());
			ps.setString(4, mng.getMng_position());
			ps.setString(5, mng.getMng_IDNo());
			ps.setString(6, mng.getMng_contactNo());
			ps.setString(7, mng.getMng_address());
			ps.setString(8, mng.getMng_picture());
			ps.setDate(9, Date.valueOf(mng.getMng_dayIn()));
			
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
	
	public void updateManager(Manager mng) {
		var con = ConnectToDatabase.getConnect();
		try( 
			var cs = con.prepareStatement("update tbl_Manager set mng_fullname=?, mng_dob=?, mng_gender=?, mng_position=?, mng_IDNo=?, "
					+ "mng_contactNo=?, mng_address=?, mng_picture=?, mng_dayIn=? where mng_id=?");
		) {
			cs.setString(1,mng.getMng_fullname());
			cs.setDate(2, java.sql.Date.valueOf(mng.getMng_dob()));
			cs.setBoolean(3, mng.isMng_gender());
			cs.setString(4, mng.getMng_position());
			cs.setString(5, mng.getMng_IDNo());
			cs.setString(6, mng.getMng_contactNo());
			cs.setString(7, mng.getMng_address());
			cs.setString(8, mng.getMng_picture());
			cs.setDate(9, java.sql.Date.valueOf(mng.getMng_dayIn()));
			cs.setInt(10, mng.getMng_id());

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

	public void deleteManager(Manager mng) {
		var con = ConnectToDatabase.getConnect();
		try (
				var cs = con.prepareCall("delete from tbl_Manager where mng_id=?");
			){
			
			cs.setInt(1, mng.getMng_id());
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
