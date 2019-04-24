import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
public class Emplyprofile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emplyprofile frame = new Emplyprofile();
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	public Emplyprofile() {
		setTitle("Employee Profile");
		conn= sqliteclass.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setBounds(117, 124, 105, 14);
		contentPane.add(lblEmployeeName);
		
		textField = new JTextField();
		textField.setBounds(250, 121, 162, 20);
		contentPane.add(textField);
		textField.setColumns(10);
				
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(216, 53, 162, 20);
		contentPane.add(textField_1);
		
		JLabel lblEnterUserid = new JLabel(" Enter UserID");
		lblEnterUserid.setBounds(138, 56, 84, 14);
		contentPane.add(lblEnterUserid);
		
		JLabel lblEmployeeInformation = new JLabel("Employee Information");
		lblEmployeeInformation.setBounds(325, 96, 154, 14);
		contentPane.add(lblEmployeeInformation);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(250, 151, 162, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(250, 182, 162, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(250, 213, 162, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(250, 244, 162, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(250, 306, 162, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(250, 337, 162, 20);
		contentPane.add(textField_7);
		
		JLabel lblCity = new JLabel("Belongs to");
		lblCity.setBounds(117, 154, 105, 14);
		contentPane.add(lblCity);
		
		JLabel lblEmailid = new JLabel("EmailID");
		lblEmailid.setBounds(117, 185, 105, 14);
		contentPane.add(lblEmailid);
		
		JLabel lblContactNo = new JLabel("Contact No.(+91)");
		lblContactNo.setBounds(117, 216, 105, 14);
		contentPane.add(lblContactNo);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(117, 250, 105, 14);
		contentPane.add(lblAge);
		
		JLabel lblDepartmernt = new JLabel("Department");
		lblDepartmernt.setBounds(117, 312, 105, 14);
		contentPane.add(lblDepartmernt);
		
		JLabel lblSalary = new JLabel("Salary/M");
		lblSalary.setBounds(117, 340, 105, 14);
		contentPane.add(lblSalary);
		
		textField_10 = new JTextField();
		textField_10.setBounds(250, 275, 162, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(117, 284, 46, 14);
		contentPane.add(lblGender);
		
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				textField_10.setText(null);

				
			}
		});
		btnNewButton.setBounds(590, 355, 124, 23);
		contentPane.add(btnNewButton);
		
		JButton btnLogoff = new JButton(" LogOut");
		btnLogoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employee amp=new Employee();
				amp.setVisible(true);
				dispose();
			}
		});
		btnLogoff.setBounds(590, 389, 124, 23);
		contentPane.add(btnLogoff);
		
		JButton btnUpdate = new JButton(" Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 try
				 {	String query=" Update or ignore Employeedata Set  EmpName='" + textField.getText()+"',EmailID='" +textField_3.getText()+"',ContactNO='" +textField_4.getText()+"',Age='" +  textField_5.getText()+"',City='" +textField_2.getText()+"'   where UserID='"+textField_1.getText()+"'";
					PreparedStatement pst = conn.prepareStatement(query);
			        pst.execute();
			       
			        pst.close();
			        JOptionPane.showMessageDialog(null,"Data Updated except Salary,Department,Job_post and Job_place");}
                   
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				   }
			}
		});
		btnUpdate.setBounds(590, 321, 124, 23);
		contentPane.add(btnUpdate);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(556, 38, 160, 180);
		contentPane.add(desktopPane);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setBounds(-12, 11, 162, 163);
		desktopPane.add(lblNewLabel);
		

		JButton btnCheckProfile = new JButton("Check profile");
		btnCheckProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ImageIcon format=null;
				try {

					String query="select Image from Employeedata where UserID='"+textField_1.getText()+"' ";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					 if(rs.next())
					 {	 
					byte[] imagedata= rs.getBytes("Image");
				    format = new ImageIcon(imagedata);
				    lblNewLabel.setIcon(format);
					 }		
					rs.close();
					pst.close();
				}catch(Exception e1) {
					 e1.printStackTrace();
				}
				
				try {

					String query="select EmpName,UserID,EmailID,Gender,ContactNO,Age,Department,jobpost,Jobplace,Password,City,Salary from Employeedata where UserID='"+textField_1.getText()+"' ";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					textField.setText(rs.getString("EmpName" ));
					textField_2.setText(rs.getString("City" ));
					textField_3.setText(rs.getString("EmailID" ));
					textField_4.setText(rs.getString("ContactNO"));
					textField_5.setText(rs.getString("Age"));
					textField_6.setText(rs.getString("Department"));
					textField_7.setText(rs.getString("Salary"));
					textField_8.setText(rs.getString("Jobpost"));
					textField_9.setText(rs.getString("Jobplace"));
					textField_10.setText(rs.getString("Gender"));
					rs.close();
					pst.close();
				}catch(Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
			}

		 
		});
		btnCheckProfile.setBounds(590, 284, 124, 23);
		contentPane.add(btnCheckProfile);
		
		JLabel lblInr = new JLabel(" INR");
		lblInr.setBounds(422, 309, 46, 14);
		contentPane.add(lblInr);
		
		textField_8 = new JTextField();
		textField_8.setBounds(250, 368, 162, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(250, 399, 162, 20);
		contentPane.add(textField_9);
		
		
		JLabel lblJobPost = new JLabel("Job Post");
		lblJobPost.setBounds(117, 371, 105, 14);
		contentPane.add(lblJobPost);
		
		JLabel lblJobPlace = new JLabel("Job Place");
		lblJobPlace.setBounds(117, 402, 105, 14);
		contentPane.add(lblJobPlace);
		
		JLabel label = new JLabel(" ");
		Image img= new ImageIcon(this.getClass().getResource( "/home.jpg")).getImage();
		 label.setIcon(new ImageIcon(img));
		label.setBounds(0, 1, 768, 445);
		contentPane.add(label);
		
		
		
		
		
		
		
		
		

	}
}
