package loginReg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class logReg implements ActionListener {

	// Frame is the frame of the first pop up
	JFrame firstForm = new JFrame();
	// Labels to be used for asking the starting question
	JLabel labelQuestion1, labelQuestion2;
	// buttons will be to login or register
	JButton loginButton, registerButton;

	logReg() {
		JFrame firstForm = new JFrame();

		labelQuestion1 = new JLabel();
		labelQuestion1.setBounds(30, 25, 400, 100);
		labelQuestion1.setText("If you have an account please click Login");
		labelQuestion2 = new JLabel();
		labelQuestion2.setBounds(30, 45, 400, 100);
		labelQuestion2.setText("If you don't have an account please click to register");
		loginButton = new JButton("Login");
		loginButton.setBounds(50, 170, 120, 50);
		loginButton.addActionListener(this);
		registerButton = new JButton("Register");
		registerButton.setBounds(200, 170, 120, 50);
		registerButton.addActionListener(this);
		firstForm.add(labelQuestion1);
		firstForm.add(labelQuestion2);
		firstForm.add(loginButton);
		firstForm.add(registerButton);
		firstForm.setSize(420, 300);
		firstForm.setLayout(null);
		firstForm.setVisible(true);

	}

	@Override
	public void actionPerformed (ActionEvent e) {
		// TODO Auto-generated method stub

	

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new logReg();

	}

}
//You cannot create a class in an if-statement, 
//you can only instantiate one (that's what the new keyword does). 
//So yes, you can obviously instantiate a class within an if-statement. 
//If you however need to create a class, you either define it as nested class or
//introduce a new file. Other than that: 
//class names in Java are Camel case and you should also name your variables properly
