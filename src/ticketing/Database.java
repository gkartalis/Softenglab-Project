package ticketing;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Database {
		
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	
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

		try {
			stmt = conn.createStatement();
			if(stmt.executeUpdate(query) == 1) {
				JOptionPane.showMessageDialog(null,message+" Succesfully");
				
				
			}else {
				JOptionPane.showMessageDialog(null,message+" Not Succesfully");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public boolean isEmptySqlTable(String query) {
		boolean result = true;
		Connection conn = getConnection();
		Statement stmt;
		ResultSet rs;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next() == true) {
				result = false;
				//Announcement Table Not Empty
				
			}else {
				//Announcement Table Empty
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return result;
	};
	
	
	public String[] fetchLatestAnnouncement() {
		Connection conn = getConnection();
		String query = "SELECT 1 FROM `announcements` LIMIT 1;";
		
		String[] arr = new String[2];
		arr[0] = "";
		arr[1] = "";
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
					arr[0] = title;
					arr[1] = announcement;
					return arr;
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				return arr;
			}//catch
		}//if
		return arr;

	}//fetchLatestAnnouncement()
	
	
	
	
	public ArrayList<Flights> flightList(String searchValue){
        
		   ArrayList<Flights> list = new ArrayList<Flights>();
		   Connection conn = getConnection();
		   Statement st;
		   ResultSet rs;
		   String searchQuery = "SELECT * FROM `flights` WHERE CONCAT(`flightID`, `departure`, `destination`, `seatsAvailable`) LIKE '%"+searchValue+"%'";
	   try {
		   st = conn.createStatement();
		   rs = st.executeQuery(searchQuery);
	   
		   Flights flights;
		   while(rs.next()){
			   flights = new Flights(
				   rs.getInt("flightID"),
				   rs.getString("departure"),
				   rs.getString("destination"),
				   rs.getInt("seatsAvailable")
			   );
			   list.add(flights);
		   }
		   
	   } catch (SQLException ex) {
		   ex.printStackTrace();
	   }
	   return list;
	   }
	
	public void addStatistics(int sum, String day) {
		
		Connection conn = getConnection();
		String queryCheck = "SELECT * FROM `Statistics` WHERE `date` = '"+ day +"' ";
		ResultSet rs;
		Statement stmt;
		Statement stmtCheck;
		
		try {
			stmtCheck = conn.createStatement();
			rs = stmtCheck.executeQuery(queryCheck);
			if(rs.next()) {
				System.out.println("Yparxw san hmerominia hdh edw");
				String queryUpdate = "UPDATE `Statistics` SET `bookings` = `bookings` + 1 WHERE `date` = '"+day+"';";
				stmt = conn.createStatement();
				stmt.executeUpdate(queryUpdate);
			}else {
				String queryInsert = "INSERT INTO `Statistics` (`date`, `bookings`) VALUES ('"+day+"', 1);";
				stmt = conn.createStatement();
				stmt.executeUpdate(queryInsert);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	//show Statistics by pressing Show button on ViewStats panel
	public int showStatistics(String date) {
		Connection conn = getConnection();
		String query = "SELECT * FROM `Statistics` WHERE `date` = '"+ date +"' ";
		Statement stmt;
		int bookings = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				bookings = rs.getInt("bookings");
			}
			return bookings;
		}catch(Exception e) {
			e.printStackTrace();
			return bookings;
		}
	}
}

