import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.*;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public register() {
		conn= sqliteclass.dbConnector();
		setTitle("Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(186, 67, 185, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(186, 98, 185, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(186, 129, 185, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(186, 160, 185, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(186, 191, 185, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel = new JLabel("Employee's Name");
		lblNewLabel.setBounds(70, 70, 106, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmailId = new JLabel(" Email ID");
		lblEmailId.setBounds(99, 132, 77, 14);
		contentPane.add(lblEmailId);
		
		JLabel lblContactNo = new JLabel(" Contact No.");
		lblContactNo.setBounds(99, 163, 77, 14);
		contentPane.add(lblContactNo);
		
		JLabel lblCity = new JLabel(" City");
		lblCity.setBounds(99, 101, 61, 14);
		contentPane.add(lblCity);
		
		JLabel lblAge = new JLabel(" Age");
		lblAge.setBounds(99, 194, 77, 14);
		contentPane.add(lblAge);
		
		JLabel lblNewLabel_1 = new JLabel(" General  Information");
		lblNewLabel_1.setBounds(318, 42, 160, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblFerfer = new JLabel("Login  Information");
		lblFerfer.setBounds(330, 258, 106, 14);
		contentPane.add(lblFerfer);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(186, 289, 185, 20);
		contentPane.add(textField_5);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(99, 292, 77, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(99, 323, 77, 14);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel(" Confirm Password");
		lblConfirmPassword.setBounds(61, 354, 115, 14);
		contentPane.add(lblConfirmPassword);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gender="Male";
			}
		});
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(186, 223, 61, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gender="Female";
			}
		});
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(256, 223, 68, 23);
		contentPane.add(rdbtnFemale);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(99, 227, 46, 14);
		contentPane.add(lblGender);
		
		btnSave = new JButton("Register");
		 
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( passwordField.getText().equals( passwordField_1.getText()) )
				 {
			try {	
				 
				String query="insert or ignore into Employeedata (EmpName,City,EmailID,ContactNO,Age,UserID,Password,Gender) values(?,?,?,?,?,?,?,?)";
				PreparedStatement pst = conn.prepareStatement(query);
			
			    pst.setString( 1,textField.getText());
				pst.setString( 2,textField_1.getText());
				pst.setString( 3, textField_2.getText());
				pst.setString( 4,textField_3.getText());
				pst.setString( 5,textField_4.getText());
				pst.setString( 6,textField_5.getText());
				pst.setString( 7,passwordField.getText());
				
				pst.setString( 8,gender);
				 
						
				pst.execute();
					
				 pst.close();
				 				JOptionPane.showMessageDialog( null,"Data Saved");

			}catch(Exception e1) {
				JOptionPane.showMessageDialog(null, e1);
			}}
			 else
             {
             	JOptionPane.showMessageDialog(null,"Password field not matched");
             }
			}
			});
		btnSave.setBounds(512, 350, 106, 23);
		contentPane.add(btnSave);
		
		JButton btnHome = new JButton(" Cancel");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employee frame = new Employee();
				frame.setVisible(true);
				 dispose();
			}
		});
		btnHome.setBounds(456, 388, 106, 23);
		contentPane.add(btnHome);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 320, 185, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton(" Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				passwordField.setText(null);
				passwordField_1.setText(null);	 
				
			}
		});
		btnNewButton.setBounds(572, 388, 106, 23);
		contentPane.add(btnNewButton);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(186, 351, 185, 20);
		contentPane.add(passwordField_1);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(488, 55, 153, 174);
		contentPane.add(desktopPane);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource( "/qwer.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(0, 0, 731, 445);
		contentPane.add(lblNewLabel_2);
		
		
		
		
		
		 
				
				
			
		 
		 
	}
	String gender=null;
}
