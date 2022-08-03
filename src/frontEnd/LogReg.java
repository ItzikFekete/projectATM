package frontEnd;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import backEnd.Model;


public class LogReg extends Model  implements ActionListener {

	// Frame is the frame of the first pop up
	JFrame firstForm = new JFrame();
	// Labels to be used for asking the starting question
	JLabel labelQuestion1, labelQuestion2;
	// buttons will be to login or register
	JButton loginButton, registerButton;
	
	

	public LogReg() {
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
		if (e.getSource()==registerButton) {
			System.out.print("Taking to register"); 
		}
		
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LogReg();

	}

}

