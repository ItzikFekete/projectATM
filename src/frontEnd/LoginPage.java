package frontEnd;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import backEnd.Model;
import backEnd.User;

public class LoginPage extends JFrame implements ActionListener {

	MenuMain menuMain; 
	WelcomeNDeposit welcomePage; 
	
	JFrame LoginForm, welcome;
	JLabel emailL, passwordL, welcomeMessage, accountType;
	JTextField emailTF, passwordTF, personalDep, BusDep, communityDep;
	
	JButton login, continueButton;
	 Statement stmt;
	 Connection con = Model.connect();
	 ResultSet rs; 

	String userId, userEmail, userPassword, title, lastName;
	int titleNEmail;
	
	public LoginPage() {
		
		JFrame loginForm = new JFrame();
		loginForm.setSize(420, 300);
		loginForm.setTitle("Login form");
		loginForm.setLayout(null);

		emailL = new JLabel("Email:");
		emailL.setSize(80, 30);
		emailL.setLocation(40, 50);
		loginForm.add(emailL);

		emailTF = new JTextField();
		emailTF.setSize(200, 30);
		emailTF.setLocation(120, 50);
		loginForm.add(emailTF);

		passwordL = new JLabel("Password");
		passwordL.setSize(80, 30);
		passwordL.setLocation(40, 90);
		loginForm.add(passwordL);

		passwordTF = new JTextField();
		passwordTF.setSize(200, 30);
		passwordTF.setLocation(120, 90);
		loginForm.add(passwordTF);

		login = new JButton("Login");
		login.setSize(200, 40);
		login.setFont(new Font("Constantia Bold", Font.ITALIC, 20));
		login.addActionListener(this);
		login.setLocation(130, 150);
		loginForm.add(login);

		loginForm.setVisible(true);
	}

	public void actionPerformed(java.awt.event.ActionEvent e1) {
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from Users");
			User user = new User(rs);
			new MenuMain(user);
			while (rs.next()) {
				
				if (emailTF.getText().equals(User.email) && passwordTF.getText().equals(User.password)) {
					
					this.dispose();
					break; // stop checking for matches
					
				} else {
					// keep checking for a match
				}
			
			}
			rs.close();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Please use correct email and password");

			
	
		} catch (Exception e) {
			System.out.print(e.getMessage());
	
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginPage();

	}
}
