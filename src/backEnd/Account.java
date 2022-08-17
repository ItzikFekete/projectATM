package backEnd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Account {
	public static String personalAccName, companyName, communityName;
	public static int account1Num, account2Num, account3Num;
	public static int account1Balance, account2Balance, account3Balance;

	Statement stmt;
	Connection con = Model.con;

	public Account(ResultSet rs) throws SQLException {
		
			personalAccName = rs.getString("personalAccName");
			companyName = rs.getString("companyName");
			communityName = rs.getString("communityName");
			account1Num = rs.getInt("account1Number");
			account2Num = rs.getInt("account2Number");
			account3Num = rs.getInt("account3Num");
			account1Balance = rs.getInt("account1Balance");
			account2Balance = rs.getInt("account2Balance");
			account3Balance = rs.getInt("account3Balance");

			System.out.println(personalAccName + "\t" + companyName);
	
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		new Account(null); 

	}

}
