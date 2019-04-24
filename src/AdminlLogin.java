import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

public class AdminlLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminlLogin frame = new AdminlLogin();
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
	 Connection conn=null;
	 
	public AdminlLogin() {
		
		setTitle("Admin Login");
		conn= sqliteclass.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(10, 265, 504, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton NewButton1 = new JButton("Submit");
		NewButton1.setBounds(282, 203, 183, 23);
		NewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String query="select* from  Administrator where ID=? and Password=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1,textField_1.getText());
					pst.setString(2,passwordField.getText());
					ResultSet rs=pst.executeQuery();
					int i=0;
					
					while(rs.next()) {
						
						i=i+1;
					}
					 if(i==1)
					 {
						  	
					     adminprofile frame = new  adminprofile();
					     frame.setVisible(true);
				          	 dispose();
					    
					 }
					 else if(i>1)
						{
						 getToolkit().beep();
						 lblNewLabel_2.setText( "Warning:- Duplicate of this person exist"); 
						}
						else 
						{
							 getToolkit().beep();
							lblNewLabel_2.setText("Warning:- WRONG Credentials!!Try Again."); 
							 
						}
					 
					
					rs.close();
					pst.close();
					
				}catch(Exception e2) {
					
			        JOptionPane.showMessageDialog( null, e2);
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(NewButton1);
		
		 
		
		JLabel lblNewLabel = new JLabel(" UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(237, 117, 79, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel(" Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(237, 164, 79, 14);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		Image img= new ImageIcon(this.getClass().getResource( "/login.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		
		lblNewLabel_1.setBounds(51, 55, 156, 176);
		contentPane.add(lblNewLabel_1);
		
		 
		
		passwordField = new JPasswordField();
		passwordField.setBounds(309, 161, 156, 20);
		contentPane.add(passwordField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(309, 114, 156, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home frame = new home();
				frame.setVisible(true);
				 dispose();
			}
		});
		btnNewButton.setBounds(378, 237, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton(" Reset");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(null);
				passwordField.setText(null);
				lblNewLabel_2.setText(null);
				
				
			}
		});
		btnClear.setBounds(282, 237, 89, 23);
		contentPane.add(btnClear);
		
		
		
	}
}
