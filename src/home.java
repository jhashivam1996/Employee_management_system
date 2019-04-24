import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
 
public class home extends JFrame{

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	/**
	 * Create the frame.
	 */
	public home() {
		setTitle("Administrator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 485);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton adminLogin = new JButton(" LogIn");
		adminLogin.setBounds(10, 398, 129, 23);
		adminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 AdminlLogin adlg = new AdminlLogin();
				 adlg.setVisible(true);
				 dispose();
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(adminLogin);
		
		
		
		JButton btnNewButton = new JButton(" Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homeframe frame = new  Homeframe();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 364, 129, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		 
		Image img= new ImageIcon(this.getClass().getResource( "/sawan.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 769, 446);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		 
	}
}
