package ticketing;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ViewStats {

	JFrame frmViewStatistics;
	private JTextField txtSoldTickets;


	public ViewStats() {
		initialize();
	}
	
	private static ViewStats obj = null;
	/**
	 * Initialize the contents of the frame.
	 */
	public static ViewStats getObj() {
		if(obj == null) {
			obj = new ViewStats();
		}return obj;
	}
	
	
	public void initialize() {
		Database db = new Database();
		frmViewStatistics = new JFrame();
		frmViewStatistics.setTitle("View Statistics");
		frmViewStatistics.setBounds(100, 100, 375, 160);
		frmViewStatistics.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmViewStatistics.getContentPane().setLayout(null);
		
		JLabel lblViewStatitsicsFor = new JLabel("View Tickets Sold for Date:");
		lblViewStatitsicsFor.setBounds(41, 10, 169, 16);
		frmViewStatistics.getContentPane().add(lblViewStatitsicsFor);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(215, 5, 119, 26);
		dateChooser.setToolTipText("Choose Date to show Sold tickets");
		frmViewStatistics.getContentPane().add(dateChooser);
		
		JLabel lblTicketsSold = new JLabel("Tickets Sold:");
		lblTicketsSold.setBounds(38, 42, 81, 16);
		frmViewStatistics.getContentPane().add(lblTicketsSold);
		
		txtSoldTickets = new JTextField();
		txtSoldTickets.setBounds(215, 37, 119, 26);
		frmViewStatistics.getContentPane().add(txtSoldTickets);
		txtSoldTickets.setColumns(10);
		
		JButton btnShow = new JButton("Show");
		btnShow.setBounds(90, 90, 77, 29);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String date = df.format(dateChooser.getDate());
				txtSoldTickets.setText(String.valueOf(db.showStatistics(date)));
			}
		});
		frmViewStatistics.getContentPane().add(btnShow);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(179, 90, 75, 29);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmViewStatistics.dispose();
			}
		});
		frmViewStatistics.getContentPane().add(btnBack);
		
	}


	
}
