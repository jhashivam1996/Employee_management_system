import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class EmplychangeID extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldold;
	private JTextField textFieldnew;
	private JTextField textFieldanew;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmplychangeID frame = new EmplychangeID();
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
	public EmplychangeID() {
		conn= sqliteclass.dbConnector();
		setTitle("Employee Password Change");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldold = new JTextField();
		textFieldold.setBounds(390, 146, 163, 20);
		contentPane.add(textFieldold);
		textFieldold.setColumns(10);
		
		textFieldnew = new JTextField();
		textFieldnew.setColumns(10);
		textFieldnew.setBounds(390, 190, 163, 20);
		contentPane.add(textFieldnew);
		
		textFieldanew = new JTextField();
		textFieldanew.setColumns(10);
		textFieldanew.setBounds(390, 233, 163, 20);
		contentPane.add(textFieldanew);
		
		JLabel lblNewLabel = new JLabel("Enter OLD Password");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(213, 149, 150, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterNewPassword = new JLabel("Enter NEW Password");
		lblEnterNewPassword.setForeground(Color.WHITE);
		lblEnterNewPassword.setBounds(213, 193, 150, 14);
		contentPane.add(lblEnterNewPassword);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm NEW Password");
		lblConfirmNewPassword.setForeground(Color.WHITE);
		lblConfirmNewPassword.setBounds(213, 236, 150, 14);
		contentPane.add(lblConfirmNewPassword);
		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(41, 421, 469, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnChange = new JButton(" Reset");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textFieldold.setText(null);
				textFieldnew.setText(null);
				textFieldanew.setText(null);
				lblNewLabel_2.setText(null);
			}
		});
		btnChange.setBounds(627, 391, 89, 23);
		contentPane.add(btnChange);
		
		JButton button = new JButton(" Change");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
                    if(textFieldnew.getText().equals(textFieldanew.getText()) )
                    {	
					String query=" Update Employeedata Set Password='" + textFieldold.getText()+"',  Password='" + textFieldnew.getText()+"'   where   Password='"+ textFieldold.getText()+"' ";
					PreparedStatement pst = conn.prepareStatement(query);
			        pst.execute();
			       
			        pst.close();
			        JOptionPane.showMessageDialog(null,"Password Changed");}
                    else
                    {
                    	lblNewLabel_2.setText("Warning:- Password field not matched"); 
                    }
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		button.setBounds(579, 356, 89, 23);
		contentPane.add(button);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employee ad= new  Employee();
				ad.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(529, 391, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		Image img= new ImageIcon(this.getClass().getResource( "/last.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 769, 446);
		contentPane.add(lblNewLabel_1);
		
	
	}

}
