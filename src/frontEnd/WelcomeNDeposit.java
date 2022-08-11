package frontEnd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import backEnd.Model;
import backEnd.User;

public class WelcomeNDeposit extends JFrame implements ActionListener {

	JLabel userId, message, notePs, personalOpeningMsg, busOpenMsg, 
	commOpenMsg, accountMsg, balanceMsg;
	JButton personal, business, community, depositButton, mainMenu;
	JTextField orgName, depositAmount;
	JSeparator sep, sep1;

	int min = 10000001;
	int max = 99999999;
	int accountNo = (int) Math.floor(Math.random() * (max - min + 1) + min);
	int overdraft = 1500;  
	

	Connection con = Model.connect();
	Statement stmt;
	ResultSet rs;
	String userTitle, userLName;

	public WelcomeNDeposit(User user) {

		this.setSize(600, 600);
		this.setTitle("Welcome");
		this.setLayout(new BorderLayout());

		userId = new JLabel("User ID: " + user.id);
		userId.setSize(250, 30);
		userId.setLocation(350, 15);

		message = new JLabel("<Html>Welcome " + user.title + " " + user.lastName + "<p><br> "
				+ "Please select if you are applying as an individual, Business or Community Centre</p></Html?");
		message.setSize(540, 180);
		message.setLocation(10, 20);
		
		personal = new JButton("Personal");
		personal.setText("Individual");
		personal.setSize(120, 40);
		personal.setLocation(80, 135);
		personal.addActionListener(this);
		this.add(personal);

		business = new JButton();
		business.setText("Business");
		business.setSize(120, 40);
		business.setLocation(80, 170);
		business.addActionListener(this);
		this.add(business);

		community = new JButton();
		community.setText("Community");
		community.setSize(120, 40);
		community.setLocation(80, 200);
		community.addActionListener(this);
		this.add(community);

		notePs = new JLabel("Ps. You will be able to add other type of accounts later");
		notePs.setSize(500, 50);
		notePs.setLocation(50, 230);
		this.add(notePs);

		sep = new JSeparator();
		sep.setSize(420, 15);
		sep.setLocation(70, 270);

		personalOpeningMsg = new JLabel("<html>You are qualified to £1,500 overdraft facility, "
				+ "with an inital deposit of £1,500<p>                     </p></html?");
		personalOpeningMsg.setSize(540, 50);
		personalOpeningMsg.setLocation(30, 280);
		personalOpeningMsg.setVisible(false);

		busOpenMsg = new JLabel("<html>Your Business qualifies to £2,500 overdraft facility, "
				+ "with an inital deposit of £2,500<p><br>What is the name of your Company?</p></html>");
		busOpenMsg.setSize(540, 50);
		busOpenMsg.setLocation(30, 280);
		busOpenMsg.setVisible(false);

		commOpenMsg = new JLabel("<html>Your Community Centre qualifies to £1,000 overdraft facility, "
				+ "with an inital deposit of £1,000<p> <br> Please provide the Community Centre name "
				+ "below </p></html>");
		commOpenMsg.setSize(540, 50);
		commOpenMsg.setLocation(30, 280);
		commOpenMsg.setVisible(false);

		orgName = new JTextField();
		orgName.setSize(240, 25);
		orgName.setLocation(250, 305);
		orgName.setVisible(false);

		accountMsg = new JLabel("How much would you like to deposit?");
		accountMsg.setSize(210, 50);
		accountMsg.setLocation(30, 330);
		accountMsg.setVisible(false);

		depositAmount = new JTextField("0");
		String text = depositAmount.getText();
		int depositamount = Integer.parseInt(text); 
		int balance = overdraft + depositamount; 
		NumberFormat.getCurrencyInstance(new Locale("en", "UK"))
        .format(overdraft);
		depositAmount.setSize(220, 25);
		depositAmount.setLocation(260, 340);
		depositAmount.setVisible(false);
		depositAmount.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e3) {
				char c = e3.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e3.consume(); // if it's not a number, ignore the event
				}
			}
		});
		this.add(depositAmount);
		
		depositButton = new JButton();
		depositButton.setText("Deposit");
		depositButton.setSize(120, 40);
		depositButton.setLocation(200, 370);
		depositButton.addActionListener(this);
		depositButton.setVisible(false);
		this.add(depositButton);

		sep1 = new JSeparator();
		sep1.setSize(420, 20);
		sep1.setLocation(60, 420);
		sep1.setVisible(false);
		
		balanceMsg = new JLabel("<html> Your SortCode is 12-34-56, Account number is"
				+ " " + accountNo +"<p><br> Your available balance is £"+ balance );
		balanceMsg.setSize(450, 150); 
		balanceMsg.setLocation(30, 380); 
		balanceMsg.setVisible(false);
		this.add(balanceMsg); 

		this.add(userId);
		this.add(message);
		this.add(personal);
		this.add(business);
		this.add(community);
		this.add(personalOpeningMsg);
		this.add(busOpenMsg);
		this.add(commOpenMsg);
		this.add(orgName);
		this.add(accountMsg);

		this.setVisible(true);

		this.add(sep);
		this.add(sep1);

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from registrationAtm");
			while (rs.next()) {
				userTitle = rs.getString("personal_title");
				userLName = rs.getString("personal_lastName");

			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == personal) {
			JOptionPane.showMessageDialog(null,
					"You are qualified to £1,500 overdraft " + "facility, with an inital deposit of £1,500");
			personalOpeningMsg.setVisible(true);
			accountMsg.setVisible(true);
			depositAmount.setVisible(true);
			depositButton.setVisible(true);
//			personalOpeningMsg.revalidate(); 
//			radioButtonChoice.setEditable(true);

		} else if (e.getSource() == business) {
			JOptionPane.showMessageDialog(null,
					"Your Business qualifies to £2,500 overdraft " + "facility, with an inital deposit of £2,500");
			busOpenMsg.setVisible(true);
			orgName.setVisible(true);
			accountMsg.setVisible(true);
			depositAmount.setVisible(true);
			depositButton.setVisible(true);

//			busOpenMsg.revalidate();
//			radioButtonChoice.setEditable(true);
		} else if (e.getSource() == community) {
			JOptionPane.showMessageDialog(null, "Your Community Centre qualifies to £1,000 overdraft "
					+ "facility, with an inital deposit of £2,500");
			commOpenMsg.setVisible(true);
			orgName.setVisible(true);
			accountMsg.setVisible(true);
			depositAmount.setVisible(true);
			depositButton.setVisible(true);
		}
		if(e.getSource()== depositButton) {
			personal.revalidate();
			business.revalidate();
			community.revalidate();
			System.out.print("Deposited");
			sep1.setVisible(true);
			if(e.getSource()==personal) {
				balanceMsg.setVisible(true);
			}else if (e.getSource()==business) {
				overdraft = 2500; 
				balanceMsg.setVisible(true); 
			}else if (e.getSource()== community) {
				overdraft =1000; 
				balanceMsg.setVisible(true);
			}
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginPage();

	}

}
