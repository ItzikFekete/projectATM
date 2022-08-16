package frontEnd;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

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

import backEnd.Model;
import backEnd.User;
import backEnd.Account;


public class MenuMain extends JFrame implements ActionListener {
	
	JFrame Menu; 
	JPanel infoPanel, toDoPanel, resultPanel; 
	JLabel userId, greeting, transferWithdraw, tfrL, accountTypeL, depositLabel, wdrwLabel,
	actionedLabel, otherAccountL, otehrAccountl2, 
	account1, balance1, account2, balance2, account3, balance3;  
	JTextField fundsInput; 
	
	JButton addAccount, submitButton, accSelected; 
	//radiobutton finishing with 1 are to choose the account funds are going out. 
	//Finishing with 2 is for where the funds are going to
	JRadioButton account1RB1, account2RB1, account3RB1, account1RB2, account2RB2, account3RB2; 
	ButtonGroup rBGrouped1, rBGrouped2; 
	String [] withdrowTrasnfer= {"","Deposit", "Withdraw", "Transfer"}; 
	JComboBox <String> trnsfrWithdrw= new JComboBox <String>(withdrowTrasnfer);
	JSeparator sep, sep1, sep2;
	
	String tName;
	String personalAccName, companyName, communityName, accountName1; 
	int account1Number, account1Balance, account2Name, account2Number, account2Balance, 
	account3Name, account3Number, account3Balance;
	double amount, total; 

	Connection con = Model.connect(); 
	
	public MenuMain(User user) {
		
		tName = User.title+" " + User.lastName; 
		personalAccName = Account.personalAccName;
		companyName = Account.companyName;
		communityName = Account.communityName;
		account1Number = Account.account1Num;
		account1Balance = Account.account1Balance; 
		account2Number = Account.account2Num;
		account2Balance = Account.account2Balance;
		account3Number = Account.account3Num;
		account3Balance = Account.account3Balance;
		
		if (personalAccName=="null") {
			accountName1 = Account.companyName;
		}else{
			accountName1 = "";
		};
		if (companyName == "null") {
			accountName1 = Account.communityName;
		}else{
			accountName1 = "";
		}; 
		if (communityName == "null") {
			accountName1= Account.personalAccName;
		}else{
			accountName1 = "";
		};
		
		this.setSize(600,600);
		this.setTitle("Hi" +tName);
		this.setLayout(null);
		
		userId = new JLabel("User: " + User.id); 
		userId.setSize(80,20);
		userId.setLocation(500, 15);
		this.add(userId); 
		
		greeting = new JLabel (); 
		greeting.setText("Welcome " + tName +"");
		greeting.setSize(100,20);
		greeting.setLocation(250, 25);
		this.add(greeting);
		
		account1 = new JLabel();
		account1.setText(accountName1+ " Account: " + account1Number);
		account1.setSize(220, 20);
		account1.setLocation(220, 50); 
		this.add(account1); 
		
		balance1 = new JLabel(); 
		balance1.setText(String.valueOf(Account.account1Balance));
		balance1.setSize(180, 20);
		balance1.setLocation(450, 50);
		this.add(balance1);
		
		account2 = new JLabel();
		account2.setText(accountName1 + " Account: " + account1Number);
		account2.setSize(180, 20);
		account2.setLocation(220, 70); 
		this.add(account2); 
		
		balance2 = new JLabel(); 
		balance2.setText(String.valueOf(Account.account2Balance));
		balance2.setSize(220, 20);
		balance2.setLocation(450, 70);
		this.add(balance2);
		
		account3 = new JLabel();
		account3.setText(accountName1 + " Account: " + account1Number);
		account3.setSize(180, 20);
		account3.setLocation(220, 90); 
		this.add(account3); 
		
		balance2 = new JLabel(); 
		balance2.setText(String.valueOf(Account.account3Balance));
		balance2.setSize(220, 20);
		balance2.setLocation(450, 90);
		this.add(balance2);
		
		sep = new JSeparator();
		sep.setSize(520, 20);
		sep.setLocation(20, 115);
		this.add(sep);
		
		accountTypeL= new JLabel("Would you like to add another bank Account?"); 
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
		
		transferWithdraw= new JLabel("Deposit, transfer or withdraw"); 
		transferWithdraw.setFont((new Font("Tahoma", Font.BOLD, 20)));
		transferWithdraw.setSize(350, 45);
		transferWithdraw.setLocation(20,165);
		this.add(transferWithdraw); 
		
		tfrL = new JLabel("Please choose the account that you "
				+ "want to transfer or withdraw from");
		tfrL.setSize(420, 20);
		tfrL.setLocation(20, 210);
		this.add(tfrL); 
		
		account1RB1 = new JRadioButton("Personal");
		account1RB1.setSize(100, 20);
		account1RB1.setLocation(20, 230);
		this.add(account1RB1); 
		
		account2RB1 = new JRadioButton("Business");
		account2RB1.setSize(100, 20);
		account2RB1.setLocation(120, 230);
		this.add(account2RB1);
		
		account3RB1 = new JRadioButton("Community");
		account3RB1.setSize(110, 20);
		account3RB1.setLocation(220, 230);
		this.add(account3RB1);
		
		rBGrouped1 = new ButtonGroup(); 
		rBGrouped1.add(account1RB1);
		rBGrouped1.add(account2RB1);
		rBGrouped1.add(account3RB1);
		
		trnsfrWithdrw.setSize(100,20);
		trnsfrWithdrw.setLocation(450, 230);
		this.add(trnsfrWithdrw); 
		
		depositLabel = new JLabel("How much would you like to deposit"); 
		depositLabel.setSize(250, 20);
		depositLabel.setLocation(30, 260);
		depositLabel.setVisible(false);
		this.add(depositLabel);
				
		fundsInput = new JTextField(); 
		fundsInput.setSize(70, 20);
		fundsInput.setLocation(340, 260);
		fundsInput.setVisible(false);
		this.add(fundsInput); 
		
		submitButton = new JButton("Submit"); 
		submitButton.setSize(90, 25);
		submitButton.setLocation(430, 260);
		submitButton.setVisible(false);
		this.add(submitButton);
		
		account1RB2 = new JRadioButton("Personal");
		account1RB2.setSize(100, 20);
		account1RB2.setLocation(20, 260);
		account1RB2.setVisible(false);
		this.add(account1RB2); 
		
		account2RB2 = new JRadioButton("Business");
		account2RB2.setSize(100, 20);
		account2RB2.setLocation(120, 260);
		account2RB2.setVisible(false);
		this.add(account2RB2);
		
		account3RB2 = new JRadioButton("Community");
		account3RB2.setSize(120, 20);
		account3RB2.setLocation(220, 260);
		account3RB2.setVisible(false);
		this.add(account3RB2);
		
		rBGrouped2 = new ButtonGroup(); 
		rBGrouped2.add(account1RB2);
		rBGrouped2.add(account2RB2);
		rBGrouped2.add(account3RB2);
		
		actionedLabel = new JLabel("");
		actionedLabel.setSize(400, 20);
		actionedLabel.setLocation(20, 300);
		actionedLabel.setVisible(false);
		this.add(actionedLabel);
		
		this.setVisible(true);
		
		addAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new WelcomeNDeposit(user); 
			}
			
		});
		
		trnsfrWithdrw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String acc = (String)trnsfrWithdrw.getSelectedItem();
				switch (acc) {
				case "Deposit":
					depositLabel.setVisible(true);
					fundsInput.setVisible(true);
					submitButton.setVisible(true);					 
					break; 
				case "Transfer":
					account1RB2.setVisible(true);
					account2RB2.setVisible(true);
					account3RB2.setVisible(true);
					fundsInput.setVisible(true);
					submitButton.setVisible(true);
					
					break; 
				case "Withdraw":
					depositLabel.setText("Howmuch would you like to withdraw?");
					depositLabel.setVisible(true);
					fundsInput.setVisible(true);
					submitButton.setVisible(true);
					break;
				default:
					JOptionPane.showMessageDialog(null,  "Please make a selection"); 
				}
				
			}
			
		});
		
		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String acc = (String)trnsfrWithdrw.getSelectedItem();
				switch (acc){
					case "Deposit":
					
						amount = Double.parseDouble(fundsInput.getText());
						total = amount+account1Balance;
						actionedLabel.setVisible(true); 
						actionedLabel.setText("Deposited. Your new account balance is £"+ total); 
				}
				
			}
			
		});
		
		
		
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuMain(null); 

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
