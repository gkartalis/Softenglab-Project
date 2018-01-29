package ticketing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import java.awt.Font;

public class UserPan extends JFrame {
	Database db = new Database();
	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable flightsTable;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtFlightID;
	private JTextField txtPassport;

	public UserPan() {
		
		String[] arr = db.fetchLatestAnnouncement();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSearch = new JTextField();
		txtSearch.setToolTipText("Type here Flight information in order to filter the Flights");
		txtSearch.setBounds(154, 148, 349, 26);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblDate = new JLabel("Choose Flight Date");
		lblDate.setBounds(531, 190, 123, 16);
		contentPane.add(lblDate);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchFlights();
			}
		});
		btnSearch.setBounds(521, 148, 117, 29);
		contentPane.add(btnSearch);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 189, 473, 353);
		contentPane.add(scrollPane);
		
		flightsTable = new JTable();
		scrollPane.setViewportView(flightsTable);
		
		
		flightsTable.addMouseListener(new MouseAdapter() {
			@Override
			//Edw prepei na ftiaksoume na selectarei mono tin mia grami kai na afairei 
			// thesi apo ta Seats Available if not <= 0
			public void mouseClicked(MouseEvent e) {
				flightsTable.getSelectedRow();//returns selected row[i] i = 
				String value = flightsTable.getModel().getValueAt(flightsTable.getSelectedRow(),0).toString();
				txtFlightID.setText(value);
			}
		});
		
		DefaultTableModel model = new DefaultTableModel();
		flightsTable.setModel(model);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 638, 130);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel announcementTitle = new JLabel(arr[0]);
		announcementTitle.setHorizontalAlignment(SwingConstants.CENTER);
		announcementTitle.setBounds(6, 5, 626, 16);
		panel.add(announcementTitle);
		
		JTextArea announcement = new JTextArea(arr[1]);
		announcement.setEditable(false);
		announcement.setBounds(6, 33, 632, 90);
		panel.add(announcement);
		//Make announcement textArea Responsive
		announcement.setLineWrap(true);
		announcement.setWrapStyleWord(true);
		
		JLabel lblFlightInfo = new JLabel("Flight Information");
		lblFlightInfo.setBounds(30, 148, 117, 16);
		contentPane.add(lblFlightInfo);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setToolTipText("Choose Departure Date for Selected Flight");
		dateChooser.setBounds(525, 218, 119, 26);
		contentPane.add(dateChooser);
		
		
		JButton btnBookFlight = new JButton("Print Ticket");
		btnBookFlight.setToolTipText("Press it After Completing the form to Print the Ticket");
		btnBookFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Date date = dateChooser.getDate();
				    if (date == null) {
				    	JOptionPane.showMessageDialog(null, "Date Required","Failed! Date is Required!",
	                            JOptionPane.ERROR_MESSAGE);
				    }else {
					    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					    	String day = df.format(dateChooser.getDate());
						    	if(txtName.getText().isEmpty() || txtSurname.getText().isEmpty() || txtFlightID.getText().isEmpty() || txtPassport.getText().isEmpty()) {
						    		JOptionPane.showMessageDialog(null, "All Fields Required","Failed! Complete all Fields!",
				                            JOptionPane.ERROR_MESSAGE);
						    	}else {
						    		int sum = 1;
						    		db.addStatistics(sum, day);
						    		try {
										TimeUnit.SECONDS.sleep(3);
										JOptionPane.showMessageDialog(null,"Printing Ticket Completed!");
									} catch (InterruptedException e1) {
										e1.printStackTrace();
									}
						    		
						    	}
				   }	
			}
		});
		btnBookFlight.setBounds(684, 513, 128, 29);
		contentPane.add(btnBookFlight);
		
		JRadioButton rdbtnBusiness = new JRadioButton("Business");
		rdbtnBusiness.setBounds(521, 284, 141, 23);
		contentPane.add(rdbtnBusiness);
		
		JRadioButton rdbtnEconomy = new JRadioButton("Economy");
		rdbtnEconomy.setBounds(521, 314, 141, 23);
		contentPane.add(rdbtnEconomy);
		
		ButtonGroup group = new ButtonGroup();
		rdbtnEconomy.setSelected(true);
		group.add(rdbtnBusiness);
		group.add(rdbtnEconomy);
		JLabel lblSelectClass = new JLabel("Select Class");
		lblSelectClass.setBounds(527, 256, 93, 16);
		contentPane.add(lblSelectClass);
		
		JLabel lblName = new JLabel("Passenger Name");
		lblName.setBounds(684, 153, 111, 16);
		contentPane.add(lblName);
		
		JLabel lblPassengerSurname = new JLabel("Passenger Surname");
		lblPassengerSurname.setBounds(684, 228, 128, 16);
		contentPane.add(lblPassengerSurname);
		
		JLabel lblPassenger = new JLabel("Passenger Details");
		lblPassenger.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPassenger.setBounds(671, 110, 141, 26);
		contentPane.add(lblPassenger);
		
		txtName = new JTextField();
		txtName.setToolTipText("Fill in the Passenger Name");
		txtName.setBounds(684, 185, 130, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setToolTipText("Fill in the passengers Surname");
		txtSurname.setColumns(10);
		txtSurname.setBounds(682, 256, 130, 26);
		contentPane.add(txtSurname);
		
		JLabel lblSelectedFlightId = new JLabel("Selected Flight ID");
		lblSelectedFlightId.setBounds(684, 288, 111, 16);
		contentPane.add(lblSelectedFlightId);
		
		txtFlightID = new JTextField();
		txtFlightID.setToolTipText("Choose a Flight from the Table");
		txtFlightID.setEditable(false);
		txtFlightID.setColumns(10);
		txtFlightID.setBounds(682, 313, 130, 26);
		contentPane.add(txtFlightID);
		
		JLabel lblPassengerId = new JLabel("ID/Passport No");
		lblPassengerId.setBounds(684, 351, 111, 16);
		contentPane.add(lblPassengerId);
		
		txtPassport = new JTextField();
		txtPassport.setToolTipText("Fill Passport or ID number");
		txtPassport.setColumns(10);
		txtPassport.setBounds(682, 379, 130, 26);
		contentPane.add(txtPassport);
	}

	
	
	public void searchFlights() {
		ArrayList<Flights> list = db.flightList(txtSearch.getText());
		DefaultTableModel model = new DefaultTableModel();
		
		Object[] title = {
						"Flight ID",
						"Departure",
						"Destination",
						"Seats Available"
						};
		         
		model.setColumnIdentifiers(title);
		
		Object[] rowData = new Object[6];

		for(int i = 0; i < list.size(); i++) {	
			
			rowData[0] = list.get(i).getFlightID();
			rowData[1] = list.get(i).getDeparture();
			rowData[2] = list.get(i).getDestination();
			rowData[3] = list.get(i).getSeatsAvailable();
					
			model.addRow(rowData);
		}//if
		
		flightsTable.setModel(model);
	}//searchFlights()
}//UserPan
