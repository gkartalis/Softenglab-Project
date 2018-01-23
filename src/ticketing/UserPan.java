package ticketing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class UserPan extends JFrame {
	Database db = new Database();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	
	
	
	/**
	 * Create the frame.
	 */
	public UserPan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(6, 170, 39, 16);
		contentPane.add(lblFrom);
		
		textField = new JTextField();
		textField.setBounds(57, 165, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(199, 170, 26, 16);
		contentPane.add(lblTo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(230, 165, 130, 26);
		contentPane.add(textField_1);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(372, 170, 29, 16);
		contentPane.add(lblDate);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(413, 165, 90, 26);
		contentPane.add(textField_2);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSearch.setBounds(527, 165, 117, 29);
		contentPane.add(btnSearch);
		
		JButton btnBookFlight = new JButton("Book Flight");
		btnBookFlight.setBounds(527, 423, 117, 29);
		contentPane.add(btnBookFlight);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 226, 515, 172);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
//		Maybe ill post announcements from table inside panel
//		instead of JoptionBox
//		JPanel panel = new JPanel();
//		panel.setBounds(6, 6, 638, 156);
//		panel.setLayout(null);
//		
//		JLabel lblTitle = new JLabel("");
//		lblTitle.setBounds(84, 6, 464, 16);
//		
//		JLabel lblAnnouncement = new JLabel("");
//		lblAnnouncement.setBounds(6, 30, 626, 120);
//		
//		panel.add(lblTitle);
//		panel.add(lblAnnouncement);
//		contentPane.add(panel);
//		
	}

}
