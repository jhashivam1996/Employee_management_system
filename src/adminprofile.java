import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Image;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminprofile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminprofile frame = new adminprofile();
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
	private JButton btnLogoff;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	 
	public adminprofile() {
		
		setTitle("Admin profile");
		conn= sqliteclass.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadList = new JButton(" Employee LIST");
		btnLoadList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Emplyeetable emp=new  Emplyeetable();
			 emp.setVisible( true);
				 dispose();
			}
		});
		btnLoadList.setBounds(601, 343, 127, 23);
		contentPane.add(btnLoadList);
		
		btnLogoff = new JButton(" LogOFF");
		btnLogoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home hm = new home();
				hm.setVisible(true);
				 dispose();
			}
		});
		btnLogoff.setBounds(601, 411, 127, 23);
		contentPane.add(btnLogoff);
		
		textField = new JTextField();
		textField.setBounds(238, 124, 168, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAdmin = new JLabel("Admin Name");
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setBounds(139, 128, 89, 14);
		contentPane.add(lblAdmin);
		
     
		
		
		
		JButton btnChangeid = new JButton(" ChangeID");
		btnChangeid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  AdminchangeID emp=new  AdminchangeID();
				 emp.setVisible( true);
				 dispose();
			}
		});
		btnChangeid.setBounds(461, 411, 127, 23);
		contentPane.add(btnChangeid);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(238, 158, 168, 23);
		contentPane.add(textField_1);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setForeground(Color.WHITE);
		lblUserid.setBounds(139, 196, 64, 14);
		contentPane.add(lblUserid);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(238, 192, 168, 23);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(238, 330, 168, 23);
		contentPane.add(textField_3);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.WHITE);
		lblCity.setBounds(139, 162, 47, 14);
		contentPane.add(lblCity);
		
		JLabel lblSalary = new JLabel("Salary/M");
		lblSalary.setForeground(Color.WHITE);
		lblSalary.setBounds(139, 334, 64, 14);
		contentPane.add(lblSalary);
		
		JButton btnNewButton = new JButton(" Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
                    
					String query=" Update  Administrator Set Name='" + textField.getText()+"',city='"+textField_1.getText()+"',EmaiID='"+textField_5.getText()+"',Mobile='"+textField_6.getText()+"' ";
					PreparedStatement pst = conn.prepareStatement(query);
			        pst.execute();
			       
			        pst.close();
			        JOptionPane.showMessageDialog(null," Data Updated Except UserID and Salary");}
                   
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setBounds(461, 377, 127, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblPersionalInformation = new JLabel(" Persional Information");
		lblPersionalInformation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPersionalInformation.setForeground(Color.YELLOW);
		lblPersionalInformation.setBounds(304, 85, 175, 14);
		contentPane.add(lblPersionalInformation);
		
		JLabel lblInr = new JLabel(" INR");
		lblInr.setBounds(416, 334, 46, 14);
		contentPane.add(lblInr);
		
		textField_4 = new JTextField();
		textField_4.setBounds(238, 296, 168, 23);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblWorkPost = new JLabel("Work Post");
		lblWorkPost.setForeground(Color.WHITE);
		lblWorkPost.setBounds(139, 300, 70, 14);
		contentPane.add(lblWorkPost);
		
		textField_5 = new JTextField();
		textField_5.setBounds(238, 226, 168, 23);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(238, 262, 168, 23);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setForeground(Color.WHITE);
		lblEmailId.setBounds(139, 231, 46, 14);
		contentPane.add(lblEmailId);
		
		JLabel lblContactNo = new JLabel("Contact No.");
		lblContactNo.setForeground(Color.WHITE);
		lblContactNo.setBounds(139, 266, 70, 14);
		contentPane.add(lblContactNo);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(569, 11, 149, 184);
		contentPane.add(desktopPane);
		
		JLabel imagelbl = new JLabel(" ");
		imagelbl.setBounds(-15, 0, 164, 238);
		desktopPane.add(imagelbl);
		
		JButton btnSearchEmployee = new JButton("Search Empl.");
		btnSearchEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchemply emp=new searchemply();
				emp.setVisible(true);
				dispose();
			}
		});
		btnSearchEmployee.setBounds(601, 377, 127, 23);
		contentPane.add(btnSearchEmployee);
    	
		
		JButton btnLoadProfile = new JButton(" Load Profile");
		btnLoadProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ImageIcon format=null;
				try {

					String query="select Image from Administrator where rowid=1";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
						 if(rs.next())
					 {	 
					byte[] imagedata= rs.getBytes("Image");
				    format = new ImageIcon(imagedata);	 
					imagelbl.setIcon(format);
					 }		
					rs.close();
					pst.close();
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				try {

					String query="select Name,ID,Password,city,Salary,post,EmaiID,Mobile,Image from Administrator where rowid=1";
					
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					textField.setText(rs.getString("Name"));
					textField_1.setText(rs.getString("city" ));
					textField_2.setText(rs.getString("ID"));
					textField_3.setText(rs.getString("Salary"));
					textField_4.setText(rs.getString("Post"));
					textField_5.setText(rs.getString("EmaiID"));
					textField_6.setText(rs.getString("Mobile"));
					
					rs.close();
					pst.close();
				}catch(Exception e1) {
					 e1.printStackTrace();
				}
			}
		});
		btnLoadProfile.setBounds(461, 343, 127, 23);
		contentPane.add(btnLoadProfile);
		
		JLabel label = new JLabel(" ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Image img= new ImageIcon(this.getClass().getResource( "/large.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 769, 445);
		contentPane.add(label);
		
		
	}
  }
