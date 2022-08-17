package frontEnd;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import org.sqlite.core.DB;

import backEnd.Model;
import backEnd.User;
import backEnd.Account;

public class WelcomeNDeposit extends JFrame implements ActionListener {

	JLabel userId, message, notePs, personalOpeningMsg, busOpenMsg, 
	commOpenMsg, accountMsg, balanceNo1Msg;
	JButton depositButton, anotherAcct, mainMenu;
	JToggleButton personal, business, community;
	ButtonGroup accountTypeGrp; 
	JTextField coName, ccName, depositAmount;
	JSeparator sep, sep1;

	int min = 10000001;
	int max = 99999999;
	int accountNo1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
	double balanceNo1, amount, overdraft;
	
	User user = null;
	

	Connection con = Model.connect();
	Statement stmt;
	PreparedStatement psmt;
	ResultSet rs;
	String companyName, communityName, personalAcc, email;
	//Below strings is just for the DB purpose but are not being used in this page
	String accountNo2, balanceNo2, accountNo3, balanceNo3; 
	int userid;
	String pAccName, bAccName, cAccName; 

	public WelcomeNDeposit(User user) {
		this.user = user;

		this.setSize(600, 600);
		this.setTitle("Welcome");
		this.setLayout(null);

		userId = new JLabel("User ID: " + User.id);
		userId.setSize(250, 30);
		userId.setLocation(350, 15);

		message = new JLabel("<Html>Welcome " + User.title + " " + User.lastName + "<p><br> "
				+ "Please select if you are applying as an individual, Business or Community Centre</p></Html?");
		message.setSize(540, 180);
		message.setLocation(10, 20);
		
		personal = new JToggleButton("Personal");
		personal.setText("Individual");
		personal.setSize(120, 40);
		personal.setLocation(80, 135);
		personal.addActionListener(this);
		this.add(personal);

		business = new JToggleButton();
		business.setText("Business");
		business.setSize(120, 40);
		business.setLocation(80, 170);
		business.addActionListener(this);
		this.add(business);

		community = new JToggleButton();
		community.setText("Community");
		community.setSize(120, 40);
		community.setLocation(80, 200);
		community.addActionListener(this);
		this.add(community);
		
		accountTypeGrp = new ButtonGroup(); 
		accountTypeGrp.add(personal);
		accountTypeGrp.add(business);
		accountTypeGrp.add(community);

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

		coName = new JTextField();
		coName.setSize(240, 25);
		coName.setLocation(250, 305);
		coName.setVisible(false);
		
		ccName = new JTextField();
		ccName.setSize(240, 25);
		ccName.setLocation(250, 305);
		ccName.setVisible(false);

		accountMsg = new JLabel("How much would you like to deposit?");
		accountMsg.setSize(210, 50);
		accountMsg.setLocation(30, 330);
		accountMsg.setVisible(false);

		depositAmount = new JTextField("0"); 
		depositAmount.setSize(220, 25);
		depositAmount.setLocation(260, 340);
		depositAmount.setVisible(false);
//		depositAmount.addKeyListener(new KeyAdapter() {
//			public void keyTyped(KeyEvent e3) {
//				char c = e3.getKeyChar();
//				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
//					e3.consume(); // if it's not a number, ignore the event
//				}
//			}
//		});
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
		
		balanceNo1Msg = new JLabel();
		balanceNo1Msg.setSize(450, 150); 
		balanceNo1Msg.setLocation(30, 380); 
		balanceNo1Msg.setVisible(false);
		
		anotherAcct = new JButton("<html>Another<br> Account?</html?"); 
		anotherAcct.setSize(120, 50); 
		anotherAcct.setLocation(70, 480); 
		anotherAcct.setVisible(false); 
		anotherAcct.addActionListener(this); 
		
		
		mainMenu = new JButton("<html> Main <br> Menu</html>");
		mainMenu.setSize(120, 50);
		mainMenu.setLocation(305, 480);
		mainMenu.setVisible(false);
		mainMenu.addActionListener(this);
		
		this.add(userId);
		this.add(message);
		this.add(personal);
		this.add(business);
		this.add(community);
		this.add(personalOpeningMsg);
		this.add(busOpenMsg);
		this.add(commOpenMsg);
		this.add(coName);
		this.add(ccName);
		this.add(accountMsg);

		this.setVisible(true);

		this.add(sep);
		this.add(sep1);
		
		this.add(mainMenu);
		this.add(balanceNo1Msg);
		this.add(anotherAcct); 
		
		userid = User.id;
		email = User.email;
		
			
		
	}
	
	private void onAccountTypeClicked() {
		accountMsg.setVisible(true);
		depositAmount.setVisible(true);
		depositButton.setVisible(true);
		mainMenu.setVisible(true);

		personalOpeningMsg.setVisible(false);
		busOpenMsg.setVisible(false);
		coName.setVisible(false);
		commOpenMsg.setVisible(false);
		ccName.setVisible(false);
	}

	private void onPersonalClicked() {
		this.overdraft = 1500;
		onAccountTypeClicked();
		personalOpeningMsg.setVisible(true);
		personalAcc= "Personal"; 
	}

	private void onBusinessClicked() {
		this.overdraft = 2500;
		onAccountTypeClicked();
		busOpenMsg.setVisible(true);
		coName.setVisible(true);
	}

	private void onCommunityClicked() {
		this.overdraft = 1000;
		onAccountTypeClicked();
		commOpenMsg.setVisible(true);
		ccName.setVisible(true);
	}
	
	private void onDepositClicked() {
		amount = Double.parseDouble(depositAmount.getText());
		balanceNo1 = overdraft + amount;
		balanceNo1Msg.setText("<html> Your SortCode is 12-34-56, Account number is"
				+ " " + accountNo1 +"<p><br> Your available balance is £" +  balanceNo1);		

		sep1.setVisible(true);
		balanceNo1Msg.setVisible(true);	
		anotherAcct.setVisible(true);
		
		String sql ="insert into Accounts values (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pst =con .prepareStatement(sql);
			pst.setString(2, personalAcc);
			pst.setString (3, coName.getText());
			pst.setString(4, ccName.getText());
			pst.setInt(5, accountNo1);
			pst.setDouble(6, balanceNo1);
			pst.setString(7, accountNo2);
			pst.setString(8, balanceNo2);
			pst.setString(9, accountNo3);
			pst.setString(10, balanceNo3);
			pst.setString(11, User.email);
			pst.setInt(12, User.id);
			pst.execute();
			System.out.print("working?");			
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}

	
	
	private void onAnotherAcctClicked () {
		accountTypeGrp.clearSelection();
		
		
	}
	private void onMenuClicked() {
		
		
		this.dispose();
		new MenuMain(user);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == personal) {
			this.onPersonalClicked();
		} else if (e.getSource() == business) {
			this.onBusinessClicked();
		} else if (e.getSource() == community) {
			this.onCommunityClicked();
		} else if (e.getSource() == depositButton) {
			this.onDepositClicked();
		} else if (e.getSource() == anotherAcct) {
			this.onAnotherAcctClicked();
		} else if (e.getSource() == mainMenu) {
			this.onMenuClicked();
		}
		try {
			psmt = con.prepareStatement("select * from Accounts WHERE id=?;");
			psmt.setInt(1, userid);
			 
			rs = psmt.executeQuery();
			new Account (rs); 
			while (rs.next()) {
				new Account (rs); 
				break; 
			}
			
			
		}catch(Exception e1) {
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WelcomeNDeposit(null);

	}

}
