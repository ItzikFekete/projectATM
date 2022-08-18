package frontEnd;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import backEnd.Model;
import backEnd.User;

public class MenuMain extends JFrame implements ActionListener {

	JFrame Menu;
	JPanel infoPanel, toDoPanel, resultPanel;
	JLabel userId, greeting, transferWithdraw, tfrL, accountTypeL, depositLabel, wdrwLabel, actionedLabel,
			actionedLabel2, actionedLabel3, actionedLabel4, otherAccountL, otehrAccountl2, account1, balance1, account2,
			balance2, account3, balance3;
	JTextField fundsInput;
	JToggleButton deposit, transfer, withdraw;
	ButtonGroup dtw;

	JButton addAccount, submitButton, accSelected;
	// radiobutton finishing with 1 are to choose the account funds are going out.
	// Finishing with 2 is for where the funds are going to
	JRadioButton personalRB1, busRB1, comRB1, personalRB2, busRB2, comRB2;
	ButtonGroup rBGrouped1, rBGrouped2;
	String[] withdrowTrasnfer = { "", "Deposit", "Withdraw", "Transfer" };
	JComboBox<String> trnsfrWithdrw = new JComboBox<String>(withdrowTrasnfer);
	JSeparator sep, sep1, sep2;

	String tName;
	String personalAccName, companyName, communityName, accountName1;
	int account1Number, account2Name, account2Number, account3Name, account3Number;
	int account3Balance;
	int account2Balance;
	int account1Balance;
	String acc1Blnc, acc2Blnc, acc3Blnc;
	double amount, total, total2, deductionAcc, increaseAcc;
	User user;

	Connection con = Model.connect();
	Statement stmt;
	PreparedStatement psmt;
	ResultSet rs;

	public MenuMain(User user) {

		tName = User.title + " " + User.lastName;
		personalAccName = User.pAccName;
		companyName = User.cAccName;
		communityName = User.cAccName;
		account1Number = User.pAccNum;
		account1Balance = User.pAccBlnce;
		account2Number = User.bAccNum;
		account2Balance = User.bAccBlnce;
		account3Number = User.cAccNum;
		account3Balance = User.cAccBlnce;

		this.setSize(600, 600);
		this.setTitle("Hi" + tName);
		this.setLayout(null);

		userId = new JLabel("User: " + User.id);
		userId.setSize(80, 20);
		userId.setLocation(500, 15);
		this.add(userId);

		greeting = new JLabel();
		greeting.setText("Welcome " + tName + "");
		greeting.setSize(100, 20);
		greeting.setLocation(250, 25);
		this.add(greeting);

		account1 = new JLabel();
		account1.setText(" Account: " + account1Number);
		account1.setSize(220, 20);
		account1.setLocation(220, 50);
		this.add(account1);

		acc1Blnc = String.valueOf(User.pAccBlnce);
		balance1 = new JLabel();
		balance1.setText(acc1Blnc);
		balance1.setSize(180, 20);
		balance1.setLocation(450, 50);
		this.add(balance1);

		account2 = new JLabel();
		account2.setText(" Account: " + account2Number);
		account2.setSize(180, 20);
		account2.setLocation(220, 70);
		this.add(account2);

		acc2Blnc = String.valueOf(User.bAccBlnce);
		balance2 = new JLabel();
		balance2.setText(acc2Blnc);
		balance2.setSize(220, 20);
		balance2.setLocation(450, 70);
		this.add(balance2);

		account3 = new JLabel();
		account3.setText("Account: " + account3Number);
		account3.setSize(180, 20);
		account3.setLocation(220, 90);
		this.add(account3);

		acc3Blnc = String.valueOf(User.cAccBlnce);
		balance3 = new JLabel();
		balance3.setText(acc3Blnc);
		balance3.setSize(220, 20);
		balance3.setLocation(450, 90);
		this.add(balance3);

		sep = new JSeparator();
		sep.setSize(520, 20);
		sep.setLocation(20, 115);
		this.add(sep);

		accountTypeL = new JLabel("Would you like to add another bank Account?");
		accountTypeL.setSize(280, 20);
		accountTypeL.setLocation(20, 125);
		this.add(accountTypeL);

		addAccount = new JButton("GO");
		addAccount.setSize(80, 25);
		addAccount.setLocation(440, 125);
		this.add(addAccount);

		sep1 = new JSeparator();
		sep1.setSize(520, 20);
		sep1.setLocation(20, 155);
		this.add(sep1);

		transferWithdraw = new JLabel("Deposit, transfer or withdraw");
		transferWithdraw.setFont((new Font("Tahoma", Font.BOLD, 20)));
		transferWithdraw.setSize(350, 45);
		transferWithdraw.setLocation(20, 165);
		this.add(transferWithdraw);

		tfrL = new JLabel("Please choose if you want to:");
		tfrL.setSize(420, 20);
		tfrL.setLocation(20, 210);
		this.add(tfrL);

		deposit = new JToggleButton("Deposit");
		deposit.setSize(80, 20);
		deposit.setLocation(230, 210);
		deposit.addActionListener(this);
		this.add(deposit);

		transfer = new JToggleButton("Transfer");
		transfer.setSize(90, 20);
		transfer.setLocation(320, 210);
		transfer.addActionListener(this);
		this.add(transfer);

		withdraw = new JToggleButton("Withdraw");
		withdraw.setSize(90, 20);
		withdraw.setLocation(420, 210);
		withdraw.addActionListener(this);
		this.add(withdraw);

		dtw = new ButtonGroup();
		dtw.add(deposit);
		dtw.add(transfer);
		dtw.add(withdraw);

		personalRB1 = new JRadioButton("Personal");
		personalRB1.setSize(100, 20);
		personalRB1.setLocation(20, 250);
		personalRB1.setVisible(false);
		this.add(personalRB1);

		busRB1 = new JRadioButton("Business");
		busRB1.setSize(100, 20);
		busRB1.setLocation(120, 250);
		busRB1.setVisible(false);
		this.add(busRB1);

		comRB1 = new JRadioButton("Community");
		comRB1.setSize(110, 20);
		comRB1.setLocation(220, 250);
		comRB1.setVisible(false);
		comRB1.addActionListener(this);
		this.add(comRB1);

		rBGrouped1 = new ButtonGroup();
		rBGrouped1.add(personalRB1);
		rBGrouped1.add(busRB1);
		rBGrouped1.add(comRB1);

		depositLabel = new JLabel("How much would you like to deposit");
		depositLabel.setSize(250, 20);
		depositLabel.setLocation(30, 270);
		depositLabel.setVisible(false);
		this.add(depositLabel);

		fundsInput = new JTextField();
		fundsInput.setSize(70, 20);
		fundsInput.setLocation(340, 270);
		fundsInput.setVisible(false);
		this.add(fundsInput);

		submitButton = new JButton("Submit");
		submitButton.setSize(90, 25);
		submitButton.setLocation(430, 270);
		submitButton.setVisible(false);
		submitButton.addActionListener(this);
		this.add(submitButton);

		personalRB2 = new JRadioButton("Personal");
		personalRB2.setSize(100, 20);
		personalRB2.setLocation(20, 270);
		personalRB2.setVisible(false);
		this.add(personalRB2);

		busRB2 = new JRadioButton("Business");
		busRB2.setSize(100, 20);
		busRB2.setLocation(120, 270);
		busRB2.setVisible(false);
		this.add(busRB2);

		comRB2 = new JRadioButton("Community");
		comRB2.setSize(120, 20);
		comRB2.setLocation(220, 270);
		comRB2.setVisible(false);
		this.add(comRB2);

		rBGrouped2 = new ButtonGroup();
		rBGrouped2.add(personalRB2);
		rBGrouped2.add(busRB2);
		rBGrouped2.add(comRB2);

		actionedLabel = new JLabel("");
		actionedLabel.setSize(400, 20);
		actionedLabel.setLocation(20, 310);
		actionedLabel.setVisible(false);
		this.add(actionedLabel);

		actionedLabel2 = new JLabel("");
		actionedLabel2.setSize(400, 20);
		actionedLabel2.setLocation(190, 310);
		actionedLabel2.setVisible(false);
		this.add(actionedLabel2);

		actionedLabel3 = new JLabel("");
		actionedLabel3.setSize(180, 20);
		actionedLabel3.setLocation(20, 330);
		actionedLabel3.setVisible(false);
		this.add(actionedLabel);

		actionedLabel4 = new JLabel("");
		actionedLabel4.setSize(180, 20);
		actionedLabel4.setLocation(20, 330);
		actionedLabel4.setVisible(false);
		this.add(actionedLabel4);

		this.setVisible(true);

		addAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new WelcomeNDeposit(user);
			}

		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == deposit) {
			personalRB1.setVisible(true);
			busRB1.setVisible(true);
			comRB1.setVisible(true);
			depositLabel.setVisible(true);
			fundsInput.setVisible(true);
			submitButton.setVisible(true);
			if (e.getSource() == personalRB1 ) {
				amount = Double.parseDouble(fundsInput.getText());
				total = account1Balance + amount;
				this.onDepositClicked();
				actionedLabel.setVisible(true);
				actionedLabel.setText("Deposited. Your new account balance is £" + total);
			} else if (e.getSource() == busRB1) {
				amount = Double.parseDouble(fundsInput.getText());
				total = account2Balance + amount;
				this.onDepositClicked();
			} else if (e.getSource() == comRB1) {
				amount = Double.parseDouble(fundsInput.getText());
				total = account3Balance + amount;
				this.onDepositClicked();
			}
		} else if (e.getSource() == withdraw) {
			personalRB1.setVisible(true);
			busRB1.setVisible(true);
			comRB1.setVisible(true);
			depositLabel.setVisible(true);
			fundsInput.setVisible(true);
			submitButton.setVisible(true);
			if (e.getSource() == personalRB1) {
				amount = Double.parseDouble(fundsInput.getText());
				total = account1Balance - amount;
				
			} else if (e.getSource() == busRB1) {
				amount = Double.parseDouble(fundsInput.getText());
				total = account2Balance - amount;
				
			} else if (e.getSource() == comRB1) {
				amount = Double.parseDouble(fundsInput.getText());
				total = account3Balance - amount;
				
			}
		} else if (e.getSource() == transfer) {
			personalRB1.setVisible(true);
			busRB1.setVisible(true);
			comRB1.setVisible(true);
			depositLabel.setVisible(true);
			fundsInput.setVisible(true);
			submitButton.setVisible(true);
			this.onDepositClicked();
			
		}

	}

	// this.updateDB(rs);

	private void onDepositClicked() {
		actionedLabel.setVisible(true);
		actionedLabel.setText("Deposited. Your new account balance is £" + total);
		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	private void updateDB(ResultSet rs) {
		try {
			new User(rs);

			String sql = "UPDATE Users set  personalAccBalance = ?,busAccBalance= ?, " + "comAccBalance=? Where id=?;";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(2, User.pAccBlnce);
			pst.setDouble(3, User.bAccBlnce);
			pst.setDouble(4, User.cAccBlnce);
			pst.setInt(10, User.id);

			pst.execute();
			System.out.print("working?");
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuMain(null);

	}

}
