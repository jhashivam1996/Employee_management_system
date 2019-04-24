import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
public class Emplylogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emplylogin frame = new Emplylogin();
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
	public Emplylogin() {
		setTitle("Employee Login");
		conn= sqliteclass.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel label = new JLabel(" ");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(36, 265, 436, 14);
		contentPane.add(label);
		
		JButton NewButton1 = new JButton("Submit");
		NewButton1.setBounds(284, 196, 188, 23);
		NewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="select* from Employeedata where UserID=? and Password=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,passwordField.getText());
					ResultSet rs=pst.executeQuery();
					
					int i=0;
					while(rs.next()) {
						
						i=i+1;
					}
					if(i==1)
					{
					     
					    Emplyprofile frame = new Emplyprofile();
					  frame.setVisible(true);
					  dispose();
					}
					else if(i>1)
					{
						getToolkit().beep();
						label.setText("Warning:- Duplicate of this person exist" ); 
					}
					else 
					{
						getToolkit().beep();
						label.setText("Warning:- WRONG Credentials,Please try again!!" ); 
					 
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e2) {
					
			        JOptionPane.showMessageDialog( null, e2);
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.add(NewButton1);
		
		 
		
		JLabel lblNewLabel = new JLabel(" UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(218, 114, 79, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel(" Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(218, 158, 79, 14);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		Image img= new ImageIcon(this.getClass().getResource( "/login.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		
		lblNewLabel_1.setBounds(49, 51, 159, 185);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(307, 112, 165, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(307, 156, 165, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employee frame = new Employee();
				frame.setVisible(true);
				 dispose();
			}
		});
		btnNewButton.setBounds(383, 231, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Reset");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				passwordField.setText(null);
				label.setText(null);
				
			}
		});
		btnClear.setBounds(284, 231, 89, 23);
		contentPane.add(btnClear);
		
		
		
		 
		
		 
	}

}
