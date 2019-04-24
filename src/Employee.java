import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Employee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
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
	public Employee() {
		setTitle("Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Emplylogin adlg = new  Emplylogin();
				 adlg.setVisible(true);
				 dispose();
			}
		});
		btnNewButton.setBounds(7, 350, 144, 23);
		contentPane.add(btnNewButton);
		
		JButton btnChangePassword = new JButton("Change password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmplychangeID ad= new   EmplychangeID();
				ad.setVisible(true);
				dispose();
			}
		});
		btnChangePassword.setBounds(7, 384, 144, 23);
		contentPane.add(btnChangePassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register frame = new register();
				frame.setVisible(true);
				dispose();
			}
		});
		btnRegister.setBounds(7, 316, 144, 23);
		contentPane.add(btnRegister);
		
		JButton btnHome = new JButton(" Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homeframe frame = new  Homeframe();
				frame.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(7, 282, 144, 23);
		contentPane.add(btnHome);
		JLabel lblNewLabel = new JLabel(" ");
		Image img= new ImageIcon(this.getClass().getResource( "/human-resources.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 768, 445);
		contentPane.add(lblNewLabel);
		 
	}
}
