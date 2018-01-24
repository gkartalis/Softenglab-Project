package ticketing;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private static CreateNewUserPanel obj = null;
	
	public static CreateNewUserPanel getObj() {
		if(obj == null) {
			obj = new CreateNewUserPanel();
		}return obj;
	}
	
	public void initialize() {
		frmAddNewUser = new JFrame();
		frmAddNewUser.setTitle("Add New User");
		frmAddNewUser.setBounds(100, 100, 350, 330);
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
		
		JCheckBox checkAdmin = new JCheckBox("Check for Administrator Rights");
		checkAdmin.setBounds(40, 186, 253, 26);
		frmAddNewUser.getContentPane().add(checkAdmin);
		
		
		//Add additional checks (dbl check password)
		//Check if all boxes
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
					 	int check = 0;
					 	char[] temp_pwd=txtPassword.getPassword();
		                String pwd=null;
		                pwd=String.copyValueOf(temp_pwd);
		                
				if(txtName.getText().isEmpty() || txtSurname.getText().isEmpty() || txtUsername.getText().isEmpty() || pwd.isEmpty()) {
					JOptionPane.showMessageDialog(null, "All Fields Required","Failed! Complete all Fields!",
                            JOptionPane.ERROR_MESSAGE);
				}else {
					
					if(checkAdmin.isSelected()) {
	                		check = 1;
	                }
	                String query = "INSERT INTO `Users` (`name`, `surname`, `username`, `password`,`admin`)"+
	                	" VALUES ('"+txtName.getText()+"', '"+txtSurname.getText()+"','"+txtUsername.getText()+"','"+pwd+"','"+check+"')";              		
					db.executeSqlQuery(query,"inserted");
					frmAddNewUser.dispose();
				}
		                
			}


		});
		btnSubmit.setBounds(40, 235, 117, 29);
		frmAddNewUser.getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddNewUser.dispose();
			}
		});
		btnBack.setBounds(179, 235, 117, 29);
		frmAddNewUser.getContentPane().add(btnBack);
		
	}
}
