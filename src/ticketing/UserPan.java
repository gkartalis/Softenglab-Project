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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class UserPan extends JFrame {
	Database db = new Database();
	private JPanel contentPane;
	private JTextField txtSearch;
	private JTextField txtDate;
	private JTable flightsTable;

	public UserPan() {
		
		//fetch announcements from db
		String[] arr = db.fetchLatestAnnouncement();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(154, 165, 349, 26);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(560, 206, 29, 16);
		contentPane.add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(527, 234, 117, 26);
		contentPane.add(txtDate);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchFlights();
			}
		});
		btnSearch.setBounds(527, 165, 117, 29);
		contentPane.add(btnSearch);
		
		JButton btnBookFlight = new JButton("Book Flight");
		btnBookFlight.setBounds(527, 522, 117, 29);
		contentPane.add(btnBookFlight);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 198, 473, 353);
		contentPane.add(scrollPane);
		
		flightsTable = new JTable();
		scrollPane.setViewportView(flightsTable);
		
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
		
		JLabel lblFlightInfo = new JLabel("Flight Information");
		lblFlightInfo.setBounds(30, 170, 117, 16);
		contentPane.add(lblFlightInfo);
		
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
