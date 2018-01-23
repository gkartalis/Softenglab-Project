package ticketing;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

public class CreateNewUserPanel {
	JFrame frmAddNewUser;
	private JTextField txtName;
	private JTextField txtUsername;
	private JTextField txtSurname;
	private JPasswordField txtPassword;
	private JPasswordField txtPasswordNew;
	Database db = new Database();
	/**
	 * Create the application.
	 */
	public CreateNewUserPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		frmAddNewUser = new JFrame();
		frmAddNewUser.setTitle("Add New User");
		frmAddNewUser.setBounds(100, 100, 350, 400);
		frmAddNewUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddNewUser.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(40, 50, 61, 16);
		frmAddNewUser.getContentPane().add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(40, 85, 61, 16);
		frmAddNewUser.getContentPane().add(lblSurname);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(40, 120, 93, 16);
		frmAddNewUser.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(40, 155, 61, 16);
		frmAddNewUser.getContentPane().add(lblPassword);
		
		txtName = new JTextField();
		txtName.setBounds(166, 45, 130, 26);
		frmAddNewUser.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(166, 115, 130, 26);
		frmAddNewUser.getContentPane().add(txtUsername);
		
		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(166, 80, 130, 26);
		frmAddNewUser.getContentPane().add(txtSurname);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(166, 150, 130, 26);
		frmAddNewUser.getContentPane().add(txtPassword);
		
		JLabel lblRetypePassword = new JLabel("Retype Password");
		lblRetypePassword.setBounds(40, 190, 114, 16);
		frmAddNewUser.getContentPane().add(lblRetypePassword);
		
		txtPasswordNew = new JPasswordField();
		txtPasswordNew.setBounds(166, 185, 130, 26);
		frmAddNewUser.getContentPane().add(txtPasswordNew);
		
		JCheckBox checkAdmin = new JCheckBox("Check for Administrator Rights");
		checkAdmin.setBounds(40, 225, 253, 26);
		frmAddNewUser.getContentPane().add(checkAdmin);
		
		
		//Add additional checks (dbl check password)
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				 if(evt.getSource()==btnSubmit)
		            {
					 	int check = 0;
					 	char[] temp_pwd=txtPassword.getPassword();
		                String pwd=null;
		                pwd=String.copyValueOf(temp_pwd);
		                
		                if(checkAdmin.isSelected()) {
		                		check = 1;
		                	
		                }
		               
		                String query = "INSERT INTO `Users` (`name`, `surname`, `username`, `password`,`admin`)"+
		                	" VALUES ('"+txtName.getText()+"', '"+txtSurname.getText()+"','"+txtUsername.getText()+"','"+pwd+"','"+check+"')";
				 		                		
						db.executeSqlQuery(query,"inserted");
				
		            }
			}

//			}
		});
		btnSubmit.setBounds(40, 283, 117, 29);
		frmAddNewUser.getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddNewUser.dispose();
			}
		});
		btnBack.setBounds(179, 283, 117, 29);
		frmAddNewUser.getContentPane().add(btnBack);
		
		frmAddNewUser.setVisible(true);
	}
}
