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
	Connection con=Model.con; 
	public  Account (ResultSet rs1) throws SQLException{
		personalAccName = rs1.getString("personalAccName"); 
		companyName= rs1.getString("companyName");
		communityName = rs1.getString("communityName");
		account1Num = rs1.getInt("account1Number");
		account2Num = rs1.getInt("account2Number");
		account3Num = rs1.getInt("account3Num");
		account1Balance = rs1.getInt("account1Balance");
		account2Balance = rs1.getInt("account2Balance");
		account3Balance= rs1.getInt("account3Balance");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
