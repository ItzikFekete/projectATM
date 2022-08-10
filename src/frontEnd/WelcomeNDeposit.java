package frontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import backEnd.Model;
import backEnd.User;

public class WelcomeNDeposit extends JFrame implements ActionListener {

	JLabel userId, message, notePs, personalOpeningMsg, busOpenMsg, commOpenMsg, accountMsg, balanceMsg;
	JButton personal, business, community;
	JTextField orgName, depositAmount;
	JSeparator sep, sep1;
	
	int min = 10000001;
	int max = 99999999;

	Connection con = Model.connect();
	Statement stmt;
	ResultSet rs;
	String UId, userTitle, userLName;
	
//	NumberFormat depositAmount = NumberFormat.getCurrencyInstance(Locale.UK);
//	depositAmount.setMaximumFractionDigits(0);
//	format.setMaximumFractionDigits(0);
//	NumberFormatter formatter = new NumberFormatter(depositAmount);
//	formatter.setMinimum(5.0);
//	formatter.setMaximum(10000000.0);
//	formatter.setAllowsInvalid(false);
//	formatter.setOverwriteMode(true);
//
//	JFormattedTextField field = new JFormattedTextField(formatter);
//	field.setValue(5.0);

	public WelcomeNDeposit(User user) {
		
		this.setSize(600, 600);
		this.setTitle("Welcome");
		this.setLayout(null);

		userId = new JLabel("User ID: " + user.id);
		userId.setSize(250, 30);
		userId.setLocation(350, 15);

		message = new JLabel("<Html>Welcome " + user.title + " " + user.lastName + "<p><br> "
				+ "Please select if you are applying as an individual, Business or Community Centre</p></Html?");
		message.setSize(540, 180);
		message.setLocation(10, 20);
		personal = new JButton();
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
		busOpenMsg.setVisible (false); 
		
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
		
		depositAmount = new JTextField(); 
		depositAmount.setSize(220, 25);
		depositAmount.setLocation(260, 340);
		depositAmount.setVisible(false);
		depositAmount.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
		            e.consume();  // if it's not a number, ignore the event
		        }
		     }
		});

		
		sep1 = new JSeparator(); 
		sep1.setSize(420, 20); 
		sep1.setLocation(60, 370);
		sep1.setVisible(false);
		
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
		this.add(depositAmount);

		this.setVisible(true);

		this.add(sep);
		this.add(sep1);
		
		int accountNo = (int)Math.floor(Math.random()*(max-min+1)+min);
		System.out.println(accountNo); 

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
		
		if (e.getSource()==personal) { 
			JOptionPane.showMessageDialog(null, "You are qualified to £1,500 overdraft "
					+ "facility, with an inital deposit of £1,500");
			personalOpeningMsg.setVisible(true);
			sep1.setVisible(true);
			accountMsg.setVisible(true);
			depositAmount.setVisible(true);
//			personalOpeningMsg.revalidate(); 
//			radioButtonChoice.setEditable(true);
				
		}else if (e.getSource()==business) {
			
			busOpenMsg.setVisible(true);
			orgName.setVisible(true);
			sep1.setVisible(true);
			accountMsg.setVisible(true);
			depositAmount.setVisible(true);
			JOptionPane.showMessageDialog(null, "Your Business qualifies to £2,500 overdraft "
					+ "facility, with an inital deposit of £2,500" );
//			busOpenMsg.revalidate();
//			radioButtonChoice.setEditable(true);
		}else if (e.getSource()==community) {
			
			commOpenMsg.setVisible(true);
			orgName.setVisible(true);
			sep1.setVisible(true);
			accountMsg.setVisible(true);
			depositAmount.setVisible(true);
//			this.add(commOpenMsg);
//		community.addActionListener(new ActionListener() {
			JOptionPane.showMessageDialog(null, "Your Community Centre qualifies to £1,000 overdraft "
					+ "facility, with an inital deposit of £2,500");
//				commOpenMsg.revalidate();
//				radioButtonChoice.setEditable(true);
			}	
//		}
//		
	}

	

}