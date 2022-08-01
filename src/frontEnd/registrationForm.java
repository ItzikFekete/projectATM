package frontEnd;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;;

public class RegistrationForm implements ActionListener {

	JFrame regInput = new JFrame();
	JLabel dob, titleL, companyL;
	// private JButton regButton, cancelButton;
	JTextField firstNameT, lastNameT, areaCompany, areaCommunity, address1A, address2A, cityA, postCodeA, emailA,
			phoneA, passwordT;

	String[] titleToChoose = { "Mr", "Mrs.", "Ms.", "Master", "Doctor" };
	JComboBox<String> title = new JComboBox<>(titleToChoose);

	String[] date = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
			"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	JComboBox<String> dates = new JComboBox<>(date);
	String month[] = { "Jan", "feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sup", "Oct", "Nov", "Dec" };
	JComboBox<String> months = new JComboBox<>(month);
	String year[] = { "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981",
			"1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994",
			"1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007",
			"2008", "2009" };
	JComboBox<String> years = new JComboBox<>(year);
	JButton regButton, cancelButton;

	public RegistrationForm() {
		JFrame regInput = new JFrame();
		regInput.setTitle("Registration Form");
		regInput.setLocation(200, 10);

		titleL = new JLabel("Please enter your name");
		titleL.setSize(200, 25);
		titleL.setLocation(80, 30);

		title.setSize(85, 25);
		title.setLocation(110, 50);
		title.setSelectedIndex(0);

		firstNameT = new JTextField("First Name");
		firstNameT.setSize(200, 30);
		firstNameT.setLocation(200, 50);

		lastNameT = new JTextField("Last Name");
		lastNameT.setSize(200, 30);
		lastNameT.setLocation(400, 50);

		companyL = new JLabel("Please write below your organisation");
		companyL.setSize(500, 30);
		companyL.setLocation(90, 80);

		areaCompany = new JTextField("if Company");
		areaCompany.setSize(400, 30);
		areaCompany.setLocation(90, 110);

		areaCommunity = new JTextField("If Community");
		areaCommunity.setSize(400, 30);
		areaCommunity.setLocation(90, 140);

		address1A = new JTextField("First line of address");
		address1A.setSize(300, 30);
		address1A.setLocation(90, 180);

		address2A = new JTextField("Second line of address");
		address2A.setSize(350, 30);
		address2A.setLocation(90, 220);

		cityA = new JTextField("City");
		cityA.setSize(250, 30);
		cityA.setLocation(90, 250);

		postCodeA = new JTextField("PostCode");
		postCodeA.setSize(250, 30);
		postCodeA.setLocation(350, 250);
		emailA = new JTextField("Email address");
		emailA.setSize(250, 30);
		emailA.setLocation(90, 300);
		passwordT = new JTextField("please enter your passowrd");
		passwordT.setSize(250, 30);
		passwordT.setLocation(400, 300);
		phoneA = new JTextField("Phone number");
		phoneA.setSize(200, 30);
		phoneA.setLocation(90, 340);
		dob = new JLabel("D.O.B.");
		dob.setFont(new Font("Ariel", Font.PLAIN, 15));
		dob.setSize(100, 30);
		dob.setLocation(100, 390);

		dates.setSize(100, 20);
		dates.setLocation(180, 390);
		dates.setSelectedIndex(0);

		months.setSize(100, 20);
		months.setLocation(250, 390);
		months.setSelectedIndex(1);

		years.setSize(100, 20);
		years.setLocation(350, 390);
		years.setSelectedIndex(30);
		regButton = new JButton("Register");
		//regButton.setText("Register");
		// regButton.setBounds(100, 300, 120, 150);
		// regButton.setBounds(0, 0, 600, 400);
		regButton.setSize(300, 40);
		regButton.setFont((new Font("Tahoma", Font.BOLD, 20)));
		regButton.setLocation(200, 450);
		cancelButton = new JButton("Cancel");
		cancelButton.setSize(300, 40);
		cancelButton.setFont((new Font("Tahoma", Font.BOLD, 20)));
		cancelButton.setLocation(525, 450);
		regInput.getContentPane();
		regInput.add(titleL);
		regInput.add(title);
		regInput.add(firstNameT);
		regInput.add(lastNameT);
		regInput.add(areaCommunity);
		regInput.add(areaCompany);
		regInput.add(companyL);
		regInput.add(address1A);
		regInput.add(address2A);
		regInput.add(cityA);
		regInput.add(postCodeA);
		regInput.add(phoneA);
		regInput.add(emailA);
		regInput.add(passwordT);
		regInput.add(dob);
		regInput.add(dates);
		regInput.add(months);
		regInput.add(years);
		regInput.add(regButton);
		//regInput.add(cancelButton);
		regInput.setBounds(300, 90, 900, 600);
		regInput.setLayout(null);
		regInput.setResizable(false);
		regInput.setVisible(true);

	}

	public static void connect() {
		Connection conn = null;

		try {

			String url = "jdbc:sqlite:C:\\Users\\myfek\\OneDrive\\Personal\\Gateshead "
					+ "College\\Project3\\ProjectATM.db";
			conn = DriverManager.getConnection(url);
			System.out.println("connection made");
			Statement st = conn.createStatement();
			String querie1 = "INSERT INTO 'personalInfo'(personal_title ,personal_first_name, "
					+ "personal_last_name,firstLAdd, secondLAdd, city, postcode, application_Company,"
					+ " application_Community, phone, date, month, year, email, password) "
					+ "VALUES ('title', 'firstNameT', 'lastNameT', 'address1A', 'address2A', 'cityA', 'postCodeA',"
					+ "'areaCompany', 'areaCommunity', 'phoneA', 'dates', 'months', 'years', 'emailA', 'passwordT')";
			st.execute(querie1);
			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new RegistrationForm();
		connect();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		

		if (e.getSource() == regButton) {
			System.out.println("registering?");

			String personal_title = (String) title.getSelectedItem();
			String personal_first_name = firstNameT.getSelectedText();
			String personal_last_name = lastNameT.getSelectedText();
			String firstLAdd = address1A.getSelectedText();
			String secondLAdd = address2A.getSelectedText();
			String city = cityA.getSelectedText();
			String postcode = postCodeA.getSelectedText();
			String application_Company = areaCompany.getSelectedText();
			String application_Community = areaCommunity.getSelectedText();
			String phone = phoneA.getSelectedText();
			String date = (String) dates.getSelectedItem();
			String month = (String) months.getSelectedItem();
			String year = (String) years.getSelectedItem();
			String email = emailA.getSelectedText();
			String password = passwordT.getSelectedText();
			JOptionPane.showMessageDialog(null, "Registered" + title + lastNameT);
			// connect(); I tried this
		} else if (e.getSource() == cancelButton) {
			System.out.print("cancelled");
		}
	}
}