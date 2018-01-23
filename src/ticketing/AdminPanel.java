package ticketing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel extends JFrame {

	private JPanel contentPane;
	Database db = new Database();

	/**
	 * Create the frame.
	 */
	public AdminPanel() {
		setTitle("Administrator Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCreate = new JButton("Create New User");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					 CreateNewUserPanel createNew = new CreateNewUserPanel();
//					add something that prevents button to be clicked again and after closing CreateNewUser re - enable it	 
//					 btnCreate.setEnabled(false);
		            }
			
		});
		btnCreate.setBounds(155, 42, 147, 46);
		contentPane.add(btnCreate);
		
		JButton btnStatistics = new JButton("View Statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStatistics.setBounds(155, 118, 147, 46);
		contentPane.add(btnStatistics);
		
		JButton btnPost = new JButton("Post announcement");
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnPost)
	            {

				 PostAnouncement Post = new PostAnouncement();
				 
	            }
			}
		});
		btnPost.setBounds(155, 190, 147, 46);
		contentPane.add(btnPost);
		
	}
}
