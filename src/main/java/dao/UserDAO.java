package dao;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import database.ConnectToDatabase;
import entity.User;

public class UserDAO {
	public List<User> getUserList(){
		List<User> list = new ArrayList<>();
		var con = ConnectToDatabase.getConnect();
		try {
			var stmt = con.createStatement();
			var rs = stmt.executeQuery("select * from tbl_User");
			while(rs.next()){
				var usr = new User();
				
				usr.setUsr_id(rs.getInt("usr_id"));
				usr.setUsr_name(rs.getString("usr_name"));
				usr.setUsr_pw(rs.getString("usr_pw"));
				usr.setUsr_type(rs.getString("usr_type"));
				usr.setUsr_create_day(rs.getDate("usr_create_day").toLocalDate());
				
				list.add(usr);
			}
		} catch(Exception e) {
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
		
	public void insertUserList(User usr) {
		var con = ConnectToDatabase.getConnect();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into tbl_User(usr_name, usr_pw, usr_type, usr_create_day) values (?,?,?,?)");
				
			ps.setString(1, usr.getUsr_name());
			ps.setString(2, usr.getUsr_pw());
			ps.setString(3, usr.getUsr_type());
			ps.setDate(4, java.sql.Date.valueOf(usr.getUsr_create_day()));
				
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
		
	public void updateUserList(User usr) {
		var con = ConnectToDatabase.getConnect();
		try( 
			var ps = con.prepareStatement("update tbl_User set usr_name=?, usr_pw=?, usr_type=?, usr_create_day=? where usr_id=?");
		) {
			ps.setString(1, usr.getUsr_name());
			ps.setString(2, usr.getUsr_pw());
			ps.setString(3, usr.getUsr_type());
			ps.setDate(4, java.sql.Date.valueOf(usr.getUsr_create_day()));
			ps.setInt(5, usr.getUsr_id());

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