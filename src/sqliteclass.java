
import java.sql.*;
import javax.swing.*;
 
public class sqliteclass {
 
	Connection con = null;
	public static Connection dbConnector()
	{
	try
	{
		Class.forName( "org.sqlite.JDBC");
		Connection con= DriverManager.getConnection("jdbc:sqlite:C:\\EMLOYEE MANAGMENT SYSTEM\\employeedata.sqlite");
		
		return con;
		
	} catch(Exception e1){
		
		JOptionPane.showConfirmDialog(null, e1);
		return null;
	}
	 
		
	}
	
}
