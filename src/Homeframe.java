import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Homeframe extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homeframe frame = new Homeframe();
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
	public Homeframe() {
		setTitle(" EMPLOYEE  MANAGEMENT  SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JComboBox comboBox = new JComboBox();
		comboBox.addItem( "Administrator");
		comboBox.addItem( "Employee");
		comboBox.setSelectedItem( null);
		comboBox.setBounds(97, 363, 149, 34);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton(" Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
		 try {String st="Administrator";
			 if(comboBox.getSelectedItem().toString()==st)
			 {   
				  
				 home hm = new home();
					hm.setVisible(true);
					 dispose();
				 
			 }
			 else
			 { Employee frame = new Employee();
				frame.setVisible(true);
				 dispose();}
			}
			catch(Exception e1) {
				JOptionPane.showMessageDialog( null,"You have not Selected any Option ");
				
			}}
		});
		btnNewButton.setBounds(551, 392, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblWorkAs = new JLabel(" Work as");
		lblWorkAs.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWorkAs.setBounds(29, 371, 83, 14);
		contentPane.add(lblWorkAs);

		JButton btnClose = new JButton(" Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnClose.setBounds(650, 392, 89, 23);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel = new JLabel(" ");
		Image img= new ImageIcon(this.getClass().getResource( "land-great-employee.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 768, 445);
		contentPane.add(lblNewLabel);
		
	}
}
