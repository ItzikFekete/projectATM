package frontEnd;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import backEnd.Model;

public class firstMenu implements ActionListener {
	JFrame messageAndOption;
	JLabel message; 
	JButton continueJ; 
	
	Connection con = Model.connect();
	Statement stmt;
	ResultSet rs; 
	String userLName; 
	
	public firstMenu() {
		JFrame messageAndOptions= new JFrame();
		messageAndOptions.setSize(420, 300);
		messageAndOptions.setTitle("Welcome");
		messageAndOptions.setLayout(null);
		
		message = new JLabel("Welcome");
		message.setSize(80, 30);
		message.setLocation(40, 50);
		
		continueJ = new JButton();
		continueJ.setSize(220, 50);
		continueJ.setLocation(130, 150);
		continueJ.addActionListener(this);
		
		messageAndOptions.add(message); 
		messageAndOptions.add(continueJ); 
		
		messageAndOptions.setVisible(true);
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select personal_lastName from registrationAtm"); 
			while (rs.next()) {
				userLName = rs.getString(1); 
				System.out.println(userLName); 
				
			}
			rs.close();
			stmt.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new firstMenu();

	}

}
