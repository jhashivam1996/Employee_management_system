import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Emplyeetable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private  JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emplyeetable frame = new Emplyeetable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 Connection conn=null;
	
	/**
	 * Create the frame.
	 */
	
	
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public Emplyeetable() {
		conn= sqliteclass.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 36, 750, 257);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLoadTable = new JButton(" Load Table");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					String query="select rowid,EmpName,City,EmailID,Gender,ContactNO,Age,Salary,Department  from Employeedata";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel( DbUtils.resultSetToTableModel(rs));
					rs.close();
					pst.close();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog( null, e1);
				}
				
			}
		});
		btnLoadTable.setBounds(642, 328, 118, 23);
		contentPane.add(btnLoadTable);
		
		JLabel lblEmployeeList = new JLabel(" Employee List");
		lblEmployeeList.setBounds(336, 11, 102, 14);
		contentPane.add(lblEmployeeList);
		
		JButton btnNewButton = new JButton(" Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminprofile ad= new adminprofile();
				ad.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(642, 396, 118, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(" Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {

					String query=" Update Employeedata Set rowid='"+textField_1.getText()+"',Department='"+ textField_2.getText()+"', Salary='"+textField.getText()+"' where rowid='"+textField_1.getText()+"' ";
					PreparedStatement pst = conn.prepareStatement(query);
			        pst.execute();
			       
			        pst.close();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnNewButton_1.setBounds(284, 362, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(127, 397, 147, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSalary = new JLabel(" Salary");
		lblSalary.setBounds(71, 400, 46, 14);
		contentPane.add(lblSalary);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 329, 147, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmployeeName = new JLabel(" Rowid");
		lblEmployeeName.setBounds(71, 332, 46, 14);
		contentPane.add(lblEmployeeName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(127, 363, 147, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(39, 366, 82, 14);
		contentPane.add(lblDepartment);
		
		JLabel lblInr = new JLabel(" INR");
		lblInr.setBounds(277, 400, 46, 14);
		contentPane.add(lblInr);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {

					String query=" delete from Employeedata  where rowid='"+textField_1.getText()+"'";
					PreparedStatement pst = conn.prepareStatement(query);
			        pst.execute();
			       
			        pst.close();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnDelete.setBounds(284, 328, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnReset = new JButton(" Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				
			}
		});
		btnReset.setBounds(642, 362, 118, 23);
		contentPane.add(btnReset);
		 
		 
		
		
	}
}
