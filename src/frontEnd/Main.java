package frontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Main extends JFrame implements ActionListener {

	// Frame is the frame of the first pop up
	JFrame firstForm = new JFrame();
	// Labels to be used for asking the starting question
	JLabel labelQuestion1, labelQuestion2;
	// buttons will be to login or register
	public JButton loginButton, registerButton;
	public boolean isLogin = true;

	LoginPage loginForm;
	RegistrationForm registrationForm;


	public Main() {
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
		add(labelQuestion1);
		add(labelQuestion2);
		add(loginButton);
		add(registerButton);
		setSize(420, 300);
		setLayout(null);
		setVisible(true);
	}


	@Override
	public void actionPerformed (ActionEvent e) {
		if (e.getSource()==this.registerButton) {
			registrationForm = new RegistrationForm();
			this.dispose();
		}else if (e.getSource()==this.loginButton) {
			loginForm = new LoginPage();
			this.isLogin = true;
			this.dispose();
		}
		
	}
	public static void main(String[] args) {
		 new Main();
	}

}

