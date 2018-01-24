package ticketing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JLabel;
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

public class UserPan extends JFrame {
	Database db = new Database();
	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable flightsTable;

	public UserPan() {
		
		//fetch announcements from db
		String[] arr = db.fetchLatestAnnouncement();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(154, 165, 349, 26);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblDate = new JLabel("Choose Flight Date");
		lblDate.setBounds(521, 199, 123, 16);
		contentPane.add(lblDate);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchFlights();
			}
		});
		btnSearch.setBounds(527, 165, 117, 29);
		contentPane.add(btnSearch);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 198, 473, 353);
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
				System.out.println(value);
			}
		});
		
		DefaultTableModel model = new DefaultTableModel();
		flightsTable.setModel(model);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 638, 152);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel announcementTitle = new JLabel(arr[0]);
		announcementTitle.setHorizontalAlignment(SwingConstants.CENTER);
		announcementTitle.setBounds(6, 5, 626, 16);
		panel.add(announcementTitle);
		
		JTextArea announcement = new JTextArea(arr[1]);
		announcement.setEditable(false);
		announcement.setBounds(6, 33, 626, 113);
		panel.add(announcement);
		//Make announcement textArea Responsive
		announcement.setLineWrap(true);
		announcement.setWrapStyleWord(true);
		
		JLabel lblFlightInfo = new JLabel("Flight Information");
		lblFlightInfo.setBounds(30, 170, 117, 16);
		contentPane.add(lblFlightInfo);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(525, 218, 119, 26);
		contentPane.add(dateChooser);
		
		
		JButton btnBookFlight = new JButton("Book Flight");
		btnBookFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String day = df.format(dateChooser.getDate());
				int sum = 1;
				db.addStatistics(sum, day);
			}
		});
		btnBookFlight.setBounds(527, 522, 117, 29);
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
