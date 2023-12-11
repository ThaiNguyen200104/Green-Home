package dao;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import database.ConnectToDatabase;
import entity.RoomList;

public class RoomDAO {
	public List<RoomList> getListRoomList(){
		List<RoomList> list = new ArrayList<>();
		var con = ConnectToDatabase.getConnect();
		try {
			var stmt = con.createStatement();
			var rs = stmt.executeQuery("select * from tbl_RoomList");
			while(rs.next()){
				var room = new RoomList();
				
				room.setRoom_id(rs.getString("room_id"));
				room.setBuilding(rs.getString("building"));
				room.setStorey(rs.getInt("storey"));
				room.setRoom_type(rs.getString("room_type"));
				room.setRoom_price(rs.getInt("room_price"));
				room.setRoom_area(rs.getDouble("room_area"));
				room.setRoom_status(rs.getBoolean("room_status"));
					
				list.add(room);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
		
	public void insertRoomList(RoomList room) {
		var con = ConnectToDatabase.getConnect();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into tbl_RoomList(room_id, building, storey, room_type, room_price, room_area, room_status) "
					+ "values (?,?,?,?,?,?,?)");
		
			ps.setString(1, room.getRoom_id());
			ps.setString(2, room.getBuilding());
			ps.setInt(3, room.getStorey());
			ps.setString(4, room.getRoom_type());
			ps.setInt(5, room.getRoom_price());
			ps.setDouble(6, room.getRoom_area());
			ps.setBoolean(7, room.isRoom_status());
			
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
	
	public void updateRoomList(RoomList room) {
		var con = ConnectToDatabase.getConnect();
		try(
			var ps = con.prepareStatement("update tbl_RoomList set building=?, storey=?, room_type=?, room_price=?, room_area=?, "
					+ "room_status=? where room_id=?");
		) {
			ps.setString(1, room.getBuilding());
			ps.setInt(2, room.getStorey());
			ps.setString(3, room.getRoom_type());
			ps.setInt(4, room.getRoom_price());
			ps.setDouble(5, room.getRoom_area());
			ps.setBoolean(6, room.isRoom_status());
			ps.setString(7, room.getRoom_id());

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

	public void deleteRoomList(RoomList room) {
		var con = ConnectToDatabase.getConnect();
		try (
			var cs = con.prepareCall("DELETE FROM tbl_RoomList WHERE room_id = ?")
		){
			cs.setString(1, room.getRoom_id());
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

