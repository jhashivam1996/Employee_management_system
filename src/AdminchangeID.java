import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AdminchangeID extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldold;
	private JTextField textFieldnew;
	private JTextField textFieldanew;
	private JLabel lblConfirmNewUserid;
	private JLabel lblChangePassword;
	private JTextField textFieldpold;
	private JTextField textFieldpnew;
	private JTextField textFieldapnew;
	private JLabel lblEnterOldPassword;
	private JLabel lblEnterNewPasswor;
	private JLabel lblConfirmNewPassword;
	private JButton btnNewButton;
	private JButton btnChange;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminchangeID frame = new AdminchangeID();
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
	private JButton btnBack;
	private JButton btnClear;
	private JLabel lblNewLabel_1;
	public AdminchangeID() {
		conn= sqliteclass.dbConnector();
		setTitle("Admin ChngeID");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldold = new JTextField();
		textFieldold.setBounds(264, 95, 168, 20);
		contentPane.add(textFieldold);
		textFieldold.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter OLD UserID:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(118, 98, 104, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblChangeUserid = new JLabel("Change UserID");
		lblChangeUserid.setBounds(305, 70, 87, 14);
		contentPane.add(lblChangeUserid);
		
		textFieldnew = new JTextField();
		textFieldnew.setColumns(10);
		textFieldnew.setBounds(264, 131, 168, 20);
		contentPane.add(textFieldnew);
		
		JLabel lblEnterNewUserid = new JLabel("Enter NEW UserID:");
		lblEnterNewUserid.setBounds(118, 134, 111, 14);
		contentPane.add(lblEnterNewUserid);
		
		textFieldanew = new JTextField();
		textFieldanew.setColumns(10);
		textFieldanew.setBounds(264, 169, 168, 20);
		contentPane.add(textFieldanew);
		
		lblConfirmNewUserid = new JLabel("Confirm NEW UserID:");
		lblConfirmNewUserid.setBounds(118, 172, 126, 14);
		contentPane.add(lblConfirmNewUserid);
		
		lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setBounds(305, 235, 104, 14);
		contentPane.add(lblChangePassword);
		
		textFieldpold = new JTextField();
		textFieldpold.setColumns(10);
		textFieldpold.setBounds(264, 260, 168, 20);
		contentPane.add(textFieldpold);
		
		textFieldpnew = new JTextField();
		textFieldpnew.setColumns(10);
		textFieldpnew.setBounds(264, 294, 168, 20);
		contentPane.add(textFieldpnew);
		
		textFieldapnew = new JTextField();
		textFieldapnew.setColumns(10);
		textFieldapnew.setBounds(264, 329, 168, 20);
		contentPane.add(textFieldapnew);
		
		lblEnterOldPassword = new JLabel("Enter OLD Password:");
		lblEnterOldPassword.setBounds(118, 263, 126, 14);
		contentPane.add(lblEnterOldPassword);
		
		lblEnterNewPasswor = new JLabel("Enter NEW Password:");
		lblEnterNewPasswor.setBounds(118, 297, 126, 14);
		contentPane.add(lblEnterNewPasswor);
		
		lblConfirmNewPassword = new JLabel("Confirm NEW Password:");
		lblConfirmNewPassword.setBounds(118, 332, 143, 14);
		contentPane.add(lblConfirmNewPassword);
		
		btnNewButton = new JButton("Change");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				try {

					String query=" Update Administrator Set ID='" +textFieldold.getText()+"', ID='" + textFieldnew .getText()+"'   where ID='"+ textFieldold.getText()+"' ";
					PreparedStatement pst = conn.prepareStatement(query);
			        pst.execute();
			        
			        JOptionPane.showMessageDialog(null,"UseID Changed"); 
			       
			        pst.close();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}		 
			}
		});
		btnNewButton.setBounds(546, 211, 89, 23);
		contentPane.add(btnNewButton);
		
		btnChange = new JButton(" Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
                     
					String query=" Update Administrator Set Password='" + textFieldpold.getText()+"',  Password='" + textFieldpnew .getText()+"'   where   Password='"+ textFieldpold.getText()+"' ";
					PreparedStatement pst = conn.prepareStatement(query);
			        pst.execute();
			        
			        
			        JOptionPane.showMessageDialog(null,"Password Changed"); 
			        
			       
			        pst.close();
			         
				}catch(Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
				 
			}
		});
		btnChange.setBounds(546, 372, 89, 23);
		contentPane.add(btnChange);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminprofile ad= new adminprofile();
				ad.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(659, 372, 89, 23);
		contentPane.add(btnBack);
		
		btnClear = new JButton(" Reset");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldold.setText( null);
				textFieldnew.setText( null);
				textFieldanew.setText( null);
				textFieldpold.setText( null);
				textFieldpnew.setText( null);
				textFieldapnew.setText( null);
			}
		});
		btnClear.setBounds(659, 211, 89, 23);
		contentPane.add(btnClear);
		
		lblNewLabel_1 = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource( "qwer.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 769, 446);
		contentPane.add(lblNewLabel_1);
	}

}
