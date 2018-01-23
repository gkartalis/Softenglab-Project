package ticketing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;

public class LoginApp extends JFrame {

	 JPanel contentPane;
	 JPasswordField txtPassword;
	 JTextField txtUsername;
	 private JFrame frame;
	 Database db = new Database();

	
	public LoginApp() {
		
		
		setTitle("Air Ticket App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(81, 100, 77, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(81, 145, 67, 16);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(170, 140, 111, 26);
		contentPane.add(txtPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(170, 95, 111, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 //checks if the button clicked
	            if(e.getSource()==btnLogin)
	            {
	                char[] temp_pwd=txtPassword.getPassword();
	                String pwd=null;
	                pwd=String.copyValueOf(temp_pwd);
	                //Print Username Password Debugging
	                System.out.println("Username,Pwd:"+txtUsername.getText()+","+pwd);
	                System.out.println(db.checkLogin(txtUsername.getText(), pwd));
	                //The entered username and password are sent via "checkLogin()" which return boolean
	                if(db.checkLogin(txtUsername.getText(), pwd)=="admin")
	                {
	                    dispose();
	                    AdminPanel AdminP = new AdminPanel();
	                    AdminP.setVisible(true);
	                    //a pop-up box
	                    JOptionPane.showMessageDialog(null, "You have logged in successfully as Admin","Success",
	                                        JOptionPane.INFORMATION_MESSAGE);
	                }else if(db.checkLogin(txtUsername.getText(), pwd)=="user") {
	                		dispose();
	                		db.fetchLatestAnnouncement();
	                    UserPan UserP = new UserPan();
	                    UserP.setVisible(true);
	                    UserP.searchFlights();
	                    
	                	//a pop-up box
	                    JOptionPane.showMessageDialog(null, "You have logged in successfully as User","Success",
	                                        JOptionPane.INFORMATION_MESSAGE);
	                }
	                else
	                {
	                    //a pop-up box
	                    JOptionPane.showMessageDialog(null, "Login failed!","Failed!!",
	                                        JOptionPane.ERROR_MESSAGE);
	                }
	            }//if
			}
		});
		btnLogin.setBounds(146, 178, 77, 29);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(235, 178, 77, 29);
		contentPane.add(btnReset);
		
		JLabel lblAirTicketApp = new JLabel("Air Ticket App Login");
		lblAirTicketApp.setBounds(172, 35, 140, 16);
		contentPane.add(lblAirTicketApp);
	
		setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480,320);
	}
	
//	public void selectLatestAnnouncement() {
//		String query = "SELECT 1 FROM `announcements` LIMIT 1;";
//		
//		if(!db.isEmptySqlTable(query)) {
//			query = "SELECT * FROM `announcements` WHERE `ID` = (SELECT MAX(ID) FROM `announcements`);";
//			db.executeSqlQuery(query, "Completedd");
////			while(db.rs.next()) {
////				
////			}
//			
//			JOptionPane.showMessageDialog(null, "Login failed!","Failed!!",
//                    JOptionPane.WARNING_MESSAGE);
//		}
//	}	
	
}
