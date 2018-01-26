package ticketing;

import javax.swing.*;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;

public class LoginApp extends JFrame {

	 JPanel contentPane;
	 JPasswordField txtPassword;
	 JTextField txtUsername;
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
			
	                char[] tempPWD=txtPassword.getPassword();
	                String pwd=null;
	                pwd=String.copyValueOf(tempPWD);
	                if(db.checkLogin(txtUsername.getText(), pwd)=="admin")
	                {
	                    dispose();
	                    AdminPanel adminP = new AdminPanel();
	                    adminP.setVisible(true);
	                  
	                }else if(db.checkLogin(txtUsername.getText(), pwd)=="user") {
	                		dispose();
	                		db.fetchLatestAnnouncement();
	                    UserPan userP = new UserPan();
	                    userP.setVisible(true);
	                    userP.searchFlights();
	                    
	                }
	                else
	                {
	                    JOptionPane.showMessageDialog(null, "Login failed!","Failed! Try Again!",
	                                        JOptionPane.ERROR_MESSAGE);
	                }
	            }//if
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
}
