package ticketing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ViewStats {

	private JFrame frmViewStatistics;
	private JTextField txtSoldTickets;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewStats window = new ViewStats();
//					window.frmViewStatistics.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
	public ViewStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Database db = new Database();
		frmViewStatistics = new JFrame();
		frmViewStatistics.setTitle("View Statistics");
		frmViewStatistics.setBounds(100, 100, 375, 200);
		frmViewStatistics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewStatistics.getContentPane().setLayout(null);
		
		JLabel lblViewStatitsicsFor = new JLabel("View Tickets Sold for Date:");
		lblViewStatitsicsFor.setBounds(6, 60, 176, 16);
		frmViewStatistics.getContentPane().add(lblViewStatitsicsFor);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setToolTipText("Choose Date to show Sold tickets");
		dateChooser.setBounds(194, 60, 119, 26);
		frmViewStatistics.getContentPane().add(dateChooser);
		
		JLabel lblTicketsSold = new JLabel("Tickets Sold:");
		lblTicketsSold.setBounds(6, 108, 89, 16);
		frmViewStatistics.getContentPane().add(lblTicketsSold);
		
		txtSoldTickets = new JTextField();
		txtSoldTickets.setBounds(194, 103, 119, 26);
		frmViewStatistics.getContentPane().add(txtSoldTickets);
		txtSoldTickets.setColumns(10);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String date = df.format(dateChooser.getDate());
				txtSoldTickets.setText(String.valueOf(db.showStatistics(date)));
			}
		});
		btnShow.setBounds(194, 143, 117, 29);
		frmViewStatistics.getContentPane().add(btnShow);
		
		frmViewStatistics.setVisible(true);
	}
	
}
