package frontEnd;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import backEnd.Model;;

public class RegistrationForm implements ActionListener {

	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	PreparedStatement pst2 = null; 

	JFrame regInput = new JFrame();
	JLabel dob, titleL, fNameL, lNameL, companyL, communityL, addL, cityL, postcodeL, emailL, passwordL;
	// private JButton regButton, cancelButton;
	JTextField firstNameT, lastNameT, companyText, communityText, addT, cityT, postcodeT, emailT, passwordT;
	//JPasswordField securePassword;

	String[] titleToChoose = { "Mr", "Mrs.", "Ms.", "Master", "Doctor" };
	JComboBox<String> title = new JComboBox<>(titleToChoose);

	String[] date = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
			"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	JComboBox<String> dates = new JComboBox<>(date);
	String month[] = { "Jan", "feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sup", "Oct", "Nov", "Dec" };
	JComboBox<String> months = new JComboBox<>(month);
	String[] year = { "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981",
			"1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994",
			"1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007",
			"2008", "2009" };
	JComboBox<String> years = new JComboBox<>(year);
	JButton regButton, cancelButton;

	public RegistrationForm() {
		JFrame regInput = new JFrame();
		regInput.setTitle("Registration Form");

		titleL = new JLabel("Title");
		titleL.setSize(200, 30);
		titleL.setLocation(80, 20);

		title.setSize(85, 25);
		title.setLocation(80, 50);
		title.setSelectedIndex(0);

		fNameL = new JLabel("First Name");
		fNameL.setSize(200, 30);
		fNameL.setLocation(200, 20);

		firstNameT = new JTextField();
		firstNameT.setSize(200, 30);
		firstNameT.setLocation(200, 50);

		lNameL = new JLabel("Last Name");
		lNameL.setSize(200, 30);
		lNameL.setLocation(400, 20);

		lastNameT = new JTextField();
		lastNameT.setSize(200, 30);
		lastNameT.setLocation(400, 50);

		companyL = new JLabel("Company Name?");
		companyL.setSize(200, 30);
		companyL.setLocation(80, 80);

		companyText = new JTextField();
		companyText.setSize(250, 30);
		companyText.setLocation(80, 110);

		communityL = new JLabel("Community organisation name?");
		communityL.setSize(200, 30);
		communityL.setLocation(400, 80);

		communityText = new JTextField();
		communityText.setSize(250, 30);
		communityText.setLocation(400, 110);

		addL = new JLabel("Address:");
		addL.setSize(200, 30);
		addL.setLocation(80, 140);

		addT = new JTextField();
		addT.setSize(300, 30);
		addT.setLocation(80, 170);

		cityL = new JLabel("City");
		cityL.setSize(200, 30);
		cityL.setLocation(80, 200);

		cityT = new JTextField();
		cityT.setSize(200, 30);
		cityT.setLocation(80, 230);

		postcodeL = new JLabel("Postcode");
		postcodeL.setSize(200, 30);
		postcodeL.setLocation(400, 200);

		postcodeT = new JTextField();
		postcodeT.setSize(200, 30);
		postcodeT.setLocation(400, 230);

		emailL = new JLabel("Email:");
		emailL.setSize(200, 30);
		emailL.setLocation(80, 310);

		emailT = new JTextField();
		emailT.setSize(250, 30);
		emailT.setLocation(80, 340);

		passwordL = new JLabel("Password:");
		passwordL.setSize(200, 30);
		passwordL.setLocation(400, 310);

		passwordT = new JPasswordField();
		passwordT.setSize(250, 30);
		passwordT.setLocation(400, 340);

		dob = new JLabel("D.O.B.");
		dob.setFont(new Font("Ariel", Font.PLAIN, 15));
		dob.setSize(100, 30);
		dob.setLocation(80, 260);

		dates.setSize(40, 30);
		dates.setLocation(180, 270);
		dates.setSelectedIndex(0);

		months.setSize(80, 30);
		months.setLocation(220, 270);
		months.setSelectedIndex(1);

		years.setSize(80, 30);
		years.setLocation(300, 270);
		years.setSelectedIndex(30);
		regButton = new JButton("Register");
		// regButton.setText("Register");
		// regButton.setBounds(100, 300, 120, 150);
		// regButton.setBounds(0, 0, 600, 400);
		regButton.setSize(300, 40);
		regButton.setFont((new Font("Tahoma", Font.BOLD, 20)));
		regButton.setLocation(200, 450);
		regButton.addActionListener(this);
		cancelButton = new JButton("Cancel");
		cancelButton.setSize(300, 40);
		cancelButton.setFont((new Font("Tahoma", Font.BOLD, 20)));
		cancelButton.setLocation(525, 450);
		cancelButton.addActionListener(this);
		// regInput.getContentPane();
		regInput.add(titleL);
		regInput.add(title);
		regInput.add(fNameL);
		regInput.add(firstNameT);
		regInput.add(lNameL);
		regInput.add(lastNameT);
		regInput.add(companyL);
		regInput.add(communityL);
		regInput.add(communityText);
		regInput.add(companyText);
		regInput.add(addL);
		regInput.add(addT);
		regInput.add(cityL);
		regInput.add(cityT);
		regInput.add(postcodeL);
		regInput.add(postcodeT);
		regInput.add(emailL);
		regInput.add(emailT);
		regInput.add(passwordL);
		regInput.add(passwordT);
		regInput.add(dob);
		regInput.add(dates);
		regInput.add(months);
		regInput.add(years);
		regInput.add(regButton);
		regInput.add(cancelButton);
		regInput.setBounds(300, 90, 900, 600);
		regInput.setLayout(null);
		regInput.setResizable(false);
		regInput.setVisible(true);

	}

	public void actionPerformed(java.awt.event.ActionEvent e1) {
		if (e1.getSource() == regButton) {
			System.out.print("Registering");

			try {
				String query = "insert into registrationAtm values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				pst = con.prepareStatement(query);
				pst.setString(2, titleL.getText());
				pst.setString(3, firstNameT.getText());
				pst.setString(4, lastNameT.getText());
				pst.setString(5, addT.getText());
				pst.setString(6, cityT.getText());
				pst.setString(7, postcodeT.getText());
				pst.setInt(8, Integer.parseInt((String) dates.getSelectedItem()));
				pst.setString(9, (String) months.getSelectedItem());
				pst.setInt(10, Integer.parseInt((String) years.getSelectedItem()));
				pst.setString(11, emailT.getText());
//				pst.setString(12, passwordT.getText());
				pst.execute();
//				String queryTable2 = "insert into detailsAtm values(?,?) "; 
//				pst2 = con.prepareStatement(queryTable2);
//				pst2.setString(2, companyText.getText());
//				pst2.setString(3, communityText.getText());
//				pst2.execute();
				JOptionPane.showInputDialog(null, "Welcome" +  lastNameT+ "\n Your details have been registered");
				
				
			} catch (Exception e) {

			}
		} else if (e1.getSource() == cancelButton) {
			System.out.print("Cancel");

		}
	}
//		
//
//		if (e1.getSource() == regButton) {
//			System.out.println("registering?");
//			String personal_title = (String) title.getSelectedItem();
//			String personal_first_name = firstNameT.getSelectedText();
//			String personal_last_name = lastNameT.getSelectedText();
//			String firstLAdd = addT.getSelectedText();
//			String secondLAdd = address2A.getSelectedText();
//			String city = cityT.getSelectedText();
//			String postcode = postcodeT.getSelectedText();
//			String application_Company = companyText.getSelectedText();
//			String application_Community =communityText.getSelectedText();
//			String phone = phoneA.getSelectedText();
//			String date = (String) dates.getSelectedItem();
//			String month = (String) months.getSelectedItem();
//			String year = (String) years.getSelectedItem();
//			String email = emailT.getSelectedText();
//			String password = passwordT.getSelectedText();
//			// JOptionPane.showMessageDialog(null, "Registered" + title + lastNameT);

//		} else if (e1.getSource() == cancelButton) {
//			System.out.print("cancelled");
//		}
//	}

//	public static void connect() {
//		
//
//		try {
//
//			String url = "jdbc:sqlite:C:\\Users\\myfek\\OneDrive\\Personal\\Gateshead "
//					+ "College\\Project3\\ProjectATM.db";
//			con = DriverManager.getConnection(url);
//			System.out.println("connection made");
//			Statement st = conn.createStatement();
//			String querie1 = "INSERT INTO 'personalInfo'(personal_title ,personal_first_name, "
//					+ "personal_last_name,firstLAdd, secondLAdd, city, postcode, application_Company,"
//					+ " application_Community, phone, date, month, year, email, password) "
//					+ "VALUES  (personal_title, 'firstNameT', 'lastNameT', 'addT', 'address2A', 'cityT', 'postcodeT',"
//					+ "'companyText', 'areaCommunity', 'phoneA', 'dates', 'months', 'years', 'emailT', 'passwordT')";
//			st.execute(querie1);
//			con.close();
//
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException ex) {
//				System.out.println(ex.getMessage());
//			}
//		}
//		

//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new RegistrationForm();
//		connect();

	}

}
