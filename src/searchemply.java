import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import java.awt.Image;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class searchemply extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchemply frame = new searchemply();
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
	public searchemply() {
		setTitle("Search ");
		conn= sqliteclass.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,785,485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblSearchByName = new JLabel(" Search by Name");
		lblSearchByName.setForeground(Color.ORANGE);
		lblSearchByName.setBounds(212, 14, 116, 14);
		contentPane.add(lblSearchByName);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(259, 76, 217, 348);
		contentPane.add(desktopPane);
		
		JLabel label = new JLabel(" ");
		label.setBounds(25, 6, 182, 26);
		desktopPane.add(label);
		
		JLabel label_1 = new JLabel(" ");
		label_1.setBounds(25, 43, 182, 26);
		desktopPane.add(label_1);
		
		JLabel label_10 = new JLabel(" ");
		label_10.setBounds(25, 80, 182, 26);
		desktopPane.add(label_10);
		
		JLabel label_11 = new JLabel(" ");
		label_11.setBounds(25, 117, 182, 26);
		desktopPane.add(label_11);
		
		JLabel label_12 = new JLabel(" ");
		label_12.setBounds(25, 154, 182, 26);
		desktopPane.add(label_12);
		
		JLabel label_14 = new JLabel(" ");
		label_14.setBounds(25, 191, 182, 26);
		desktopPane.add(label_14);
		
		JLabel label_15 = new JLabel(" ");
		label_15.setBounds(25, 225, 182, 26);
		desktopPane.add(label_15);
		
		JLabel label_16 = new JLabel(" ");
		label_16.setBounds(25, 262, 182, 26);
		desktopPane.add(label_16);
		
		JLabel label_17 = new JLabel(" ");
		label_17.setBounds(25, 299, 182, 26);
		desktopPane.add(label_17);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmployeeName.setForeground(Color.WHITE);
		lblEmployeeName.setBounds(148, 88, 91, 14);
		contentPane.add(lblEmployeeName);
		
		JLabel lblBelongsTo = new JLabel("Belongs to");
		lblBelongsTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBelongsTo.setForeground(Color.WHITE);
		lblBelongsTo.setBounds(148, 126, 77, 14);
		contentPane.add(lblBelongsTo);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmailId.setForeground(Color.WHITE);
		lblEmailId.setBounds(148, 164, 46, 14);
		contentPane.add(lblEmailId);
		
		JLabel lblContactNo = new JLabel("Contact No.(+91)");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactNo.setForeground(Color.WHITE);
		lblContactNo.setBounds(148, 201, 100, 14);
		contentPane.add(lblContactNo);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAge.setForeground(Color.WHITE);
		lblAge.setBounds(148, 238, 46, 14);
		contentPane.add(lblAge);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDepartment.setForeground(Color.WHITE);
		lblDepartment.setBounds(148, 274, 77, 14);
		contentPane.add(lblDepartment);
		
		JLabel lblSalarym = new JLabel("Salary/M");
		lblSalarym.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSalarym.setForeground(Color.WHITE);
		lblSalarym.setBounds(148, 311, 59, 14);
		contentPane.add(lblSalarym);
		
		JLabel lblJobPost = new JLabel("Job Post");
		lblJobPost.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJobPost.setForeground(Color.WHITE);
		lblJobPost.setBounds(148, 347, 59, 14);
		contentPane.add(lblJobPost);
		
		JLabel lblJobPlace = new JLabel("Job Place");
		lblJobPlace.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJobPlace.setForeground(Color.WHITE);
		lblJobPlace.setBounds(148, 382, 59, 14);
		contentPane.add(lblJobPlace);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(565, 41, 133, 158);
		contentPane.add(desktopPane_1);
		
		JLabel lblEmpimage = new JLabel("");
		lblEmpimage.setBounds(-18, 0, 151, 169);
		desktopPane_1.add(lblEmpimage);
		
		JLabel lblGender = new JLabel("Gender ");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGender.setForeground(new Color(255, 255, 255));
		lblGender.setBounds(589, 216, 46, 14);
		contentPane.add(lblGender);
		
		JLabel label_3 = new JLabel("");
		label_3.setForeground(Color.GREEN);
		label_3.setBounds(638, 216, 70, 14);
		contentPane.add(label_3);
		
		JLabel warnig = new JLabel("");
		warnig.setForeground(Color.YELLOW);
		warnig.setFont(new Font("Sitka Subheading", Font.PLAIN, 12));
		warnig.setBounds(49, 39, 158, 14);
		contentPane.add(warnig);
		
	
		
		
		textField = new JTextField();
		textField.setBackground(Color.GREEN);
		textField.setForeground(new Color(0, 0, 0));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				
				ImageIcon format=null;
				try {

					String query="select Image from Employeedata where EmpName='"+textField.getText()+"' ";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					 while(rs.next())
					 {	 
					byte[] imagedata= rs.getBytes("Image");
				    format = new ImageIcon(imagedata);
				    lblEmpimage.setIcon(format);
					 }		
					rs.close();
					pst.close();
				}catch(Exception e1) {
					 e1.printStackTrace();
				}
				
				try {

					String query="select EmpName,UserID,EmailID,ContactNO,Age,Department,jobpost,Jobplace,Password,City,Salary,Gender from Employeedata where  EmpName='"+textField.getText()+"' ";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					int i=0;
					while(rs.next())
					{  i=i+1;
						label.setText(rs.getString("EmpName" ));
						label_1.setText(rs.getString("City" ));
						label_10 .setText(rs.getString("EmailID" ));
						label_11.setText(rs.getString("ContactNO"));
						label_12.setText(rs.getString("Age"));
						label_14.setText(rs.getString("Department"));
						label_15.setText(rs.getString("Salary"));
					    label_16.setText(rs.getString("Jobpost"));
					    label_17.setText(rs.getString("Jobplace"));
					    label_3.setText(rs.getString("Gender"));
					    
					    
					    }
					if(i==0)
					{      warnig.setText("Sorry, NO Records found!!");	 
					label.setText(null);
					label_1.setText( null);
					label_10 .setText( null);
					label_11.setText( null);
					label_12.setText( null);
					label_14.setText( null);
					label_15.setText( null);
				    label_16.setText( null);
				    label_17.setText( null);
				    label_3.setText( null);
				    lblEmpimage.setIcon(null);
					}
					
					else if(i>=1){
						warnig.setText(null);	
					}
				
					 
					
					rs.close();
					pst.close();
					
				}catch(Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
				
				
			}
			
			
		});
		textField.setBounds(49, 11, 158, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				adminprofile adf= new adminprofile();
				adf.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(546, 401, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnHome = new JButton(" Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home hm=new home();
				hm.setVisible(true);
				dispose();					
			}
		});
		btnHome.setBounds(645, 401, 89, 23);
		contentPane.add(btnHome);
		
		
		JLabel label_2 = new JLabel(" ");
		 
		Image img= new ImageIcon(this.getClass().getResource( "/black.jpg")).getImage();
		label_2.setIcon(new ImageIcon(img));
		label_2.setBounds(0, 0, 769, 446);
		contentPane.add(label_2);
		
		
		
		
		
		
	}
}
