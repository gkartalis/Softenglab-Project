package ticketing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PostAnouncement {

	JFrame frame;
	private JTextField txtAnnouncementTitle;
	Database db = new Database();
	
	/**
	 * Create the application.
	 */
	public PostAnouncement() {
		initialize();
	}
	private static PostAnouncement obj = null;
	
	public static PostAnouncement getObj() {
		if(obj == null) {
			obj = new PostAnouncement();
		}return obj;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("Post Announcement");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtAnnouncement = new JTextArea();
		txtAnnouncement.setBounds(160, 68, 252, 152);
		frame.getContentPane().add(txtAnnouncement);
		txtAnnouncement.setLineWrap(true);
		txtAnnouncement.setWrapStyleWord(true);
		
		JButton btnPost = new JButton("Post");
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtAnnouncementTitle.getText().isEmpty() || txtAnnouncement.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "All Fields Required","Failed! Complete all Fields!",
                            JOptionPane.ERROR_MESSAGE);
				}else {					
					String query = "INSERT INTO `announcements`(`title`, `announcement`) " +
								   "VALUES ('"+txtAnnouncementTitle.getText()+"','"+txtAnnouncement.getText()+"')";
					db.executeSqlQuery(query,"Announcement inserted");
					frame.dispose();
				}
			}
		});
		btnPost.setBounds(158, 232, 80, 29);
		frame.getContentPane().add(btnPost);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAnnouncement.setText(null);
				txtAnnouncementTitle.setText(null);
			}
		});
		btnReset.setBounds(250, 232, 75, 29);
		frame.getContentPane().add(btnReset);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnBack.setBounds(337, 232, 75, 29);
		frame.getContentPane().add(btnBack);
		
		txtAnnouncementTitle = new JTextField();
		txtAnnouncementTitle.setBounds(160, 25, 252, 26);
		frame.getContentPane().add(txtAnnouncementTitle);
		txtAnnouncementTitle.setColumns(10);
		
		JLabel lblAnnouncementTitle = new JLabel("Announcement Title");
		lblAnnouncementTitle.setBounds(15, 30, 133, 16);
		frame.getContentPane().add(lblAnnouncementTitle);
		
		JLabel lblAnnouncement = new JLabel("Announcement Text");
		lblAnnouncement.setBounds(15, 68, 133, 16);
		frame.getContentPane().add(lblAnnouncement);
		
		
	}
}
