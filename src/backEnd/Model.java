package backEnd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;



public class Model {
	public static Connection con; 
	public static Connection connect() {
	
	try {
		String url = "jdbc:sqlite:C:\\Users\\myfek\\OneDrive\\Personal\\"
				+ "Gateshead College\\Project3\\ATMSchoolProject.db";
		con = DriverManager.getConnection(url);
		JOptionPane.showMessageDialog(null, "Connected to Databse");
		return con; 
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);
		System.out.print(e);
		return con; }
	}
	public void regButtonactionPerformed(ActionEvent e) {
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		connect();
    }

	}


