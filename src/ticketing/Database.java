package ticketing;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Database {
		
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	
//	database(){
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airtickets","root","phpGuru1!");
////			stmt = conn.prepareStatement("Select * from Users where username=? and password =?");
//			return conn
//			
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airtickets","root","phpGuru1!");
			return conn;
			
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public String checkLogin(String username, String password) {
		String checkLogin = null;
	try {
		Connection conn = getConnection();
		stmt = conn.prepareStatement("Select * from Users where username=? and password =?");
		stmt.setString(1, username);
		stmt.setString(2, password);
		rs=stmt.executeQuery();
		if(rs.next() ) {
			if(rs.getInt("admin") == 1) {
				checkLogin = "admin";
			}else if (rs.getInt("admin") != 1) {
				checkLogin = "user";
			}
		}else {
			checkLogin = "false";
		}
	}catch(Exception e) {
		System.out.println("Error While Validating"+e);
		checkLogin = "false";
	}
	return checkLogin;
}
	
	public void executeSqlQuery(String query, String message) {
		Connection conn = getConnection();
		Statement stmt;
		JOptionPane.showMessageDialog(null,"PASSED");

		try {
			stmt = conn.createStatement();
			if(stmt.executeUpdate(query) == 1) {
				JOptionPane.showMessageDialog(null,"Data "+message+" succesfully");
				
				
			}else {
				JOptionPane.showMessageDialog(null,"Data NOT "+message);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public void printMessage(String message) {
		System.out.print(message);

	}
	
	public boolean isEmptySqlTable(String query) {
		boolean result = true;
		Connection conn = getConnection();
		Statement stmt;
		ResultSet rs;
		JOptionPane.showMessageDialog(null,"PASSED EMPTY");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next() == true) {
				result = false;
				System.out.println(result+"Einai gematos o pinakas");
				
			}else {
				System.out.println(result+"Einai adeios o pinakas");
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return result;
	};
	
	
	public void fetchLatestAnnouncement() {
		Connection conn = getConnection();
		String query = "SELECT 1 FROM `announcements` LIMIT 1;";
		
		if(!isEmptySqlTable(query)) {
			
			String query2 = "SELECT * FROM `announcements` WHERE `ID` = (SELECT MAX(ID) FROM `announcements`);";
			Statement stmt;
			ResultSet rs;
			
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query2);
				while(rs.next()) {
					
					String title = rs.getString("title");
					String announcement = rs.getString("announcement");
					//Print Latest Announcement To User via Warning JOptionPane
					JOptionPane.showMessageDialog(null, announcement,title,
			                JOptionPane.WARNING_MESSAGE);
					
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}//catch
		}//if

	}//fetchLatestAnnouncement()
}

