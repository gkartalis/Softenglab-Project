package ticketing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;

public class ViewStats {

	private JFrame frmViewStatistics;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStats window = new ViewStats();
					window.frmViewStatistics.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmViewStatistics = new JFrame();
		frmViewStatistics.setTitle("View Statistics");
		frmViewStatistics.setBounds(100, 100, 450, 300);
		frmViewStatistics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewStatistics.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(355, 0, 95, 29);
		frmViewStatistics.getContentPane().add(btnNewButton);
	}
}
