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
	private JTextField txtDeparture;
	private JTextField txtDestination;
	private JTextField txtDate;
	private JTable flightsTable;
	private JTable table;

	   
	
	
	/**
	 * Create the frame.
	 */
	public UserPan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(6, 170, 39, 16);
		contentPane.add(lblFrom);
		
		txtDeparture = new JTextField();
		txtDeparture.setBounds(57, 165, 130, 26);
		contentPane.add(txtDeparture);
		txtDeparture.setColumns(10);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(199, 170, 26, 16);
		contentPane.add(lblTo);
		
		txtDestination = new JTextField();
		txtDestination.setColumns(10);
		txtDestination.setBounds(230, 165, 130, 26);
		contentPane.add(txtDestination);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(564, 245, 29, 16);
		contentPane.add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(527, 265, 117, 26);
		contentPane.add(txtDate);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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

		flightsTable = new JTable();
		scrollPane.setViewportView(flightsTable);
		
		DefaultTableModel model = new DefaultTableModel();
		Object[] columnsName = new Object[4];
		flightsTable.setModel(model);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 638, 152);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel announcementTitle = new JLabel("Title");
		announcementTitle.setHorizontalAlignment(SwingConstants.CENTER);
		announcementTitle.setBounds(6, 5, 626, 16);
		panel.add(announcementTitle);
		
		JTextArea announcement = new JTextArea();
		announcement.setEditable(false);
		announcement.setBounds(6, 33, 626, 113);
		panel.add(announcement);
		
		columnsName[0] = "Flight ID";
		columnsName[1] = "Departure";
		columnsName[2] = "Destination";
		columnsName[3] = "Available Seats";
		
		model.setColumnIdentifiers(columnsName);
		
		Object[] title = {
				"Flight ID",
				"Departure",
				"Destination",
				"Seats Available"
				};
         
        model.setColumnIdentifiers(title);
		
		
		Object[] rowData = new Object[6];
		
		for(int i = 0; i < flightList().size(); i++) {
			
			rowData[0] = flightList().get(i).getFlightID();
			rowData[1] = flightList().get(i).getDeparture();
			rowData[2] = flightList().get(i).getDestination();
			rowData[3] = flightList().get(i).getSeatsAvailable();
			
			model.addRow(rowData);
		}
		System.out.println(flightList().size());
		
	}
	
	
	
	public ArrayList<Flights> flightList(){
        
		   ArrayList<Flights> list = new ArrayList<Flights>();
		   Connection conn = db.getConnection();
		   Statement st;
		   ResultSet rs;

	   try {
		   st = conn.createStatement();
		   rs = st.executeQuery("SELECT `flightID`, `departure`, `destination`, `seatsAvailable` FROM `flights`");
	   
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
}
