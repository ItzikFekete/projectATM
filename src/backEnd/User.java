package backEnd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import frontEnd.WelcomeNDeposit;


public class User {
	
	public static int id;
	public static String email;
	public static String password;
	public static String title;
	public static String lastName;
	
	Statement stmt; 
	static Connection con = Model.con; 

	public User(ResultSet rs) throws SQLException {
		
		id = rs.getInt("id"); 
		email = rs.getString("personal_email");
		password = rs.getString("personal_password");
		title = rs.getString("personal_title");
		lastName = rs.getString("personal_lastName");
		
	}
	
	public static User login(String email, String password) {
		try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM Users WHERE personal_email = ? AND personal_password = ?")) {
			stmt.setString(1, email);
			stmt.setString(2, password);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new User(rs);
				}
			} catch (Exception e) {
				System.out.print(e.getMessage());
				
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());	
		}
		return null;
		
	}
	
//	public void Banking (ResultSet rs) throws SQLException{
//		
//		try{
//			stmt = con.createStatement();
//			rs = stmt.executeQuery("select * from bankingAccountsNBalances");
//			while (rs.next()) {
//				personalAccName= rs.getString("personalAccName");
//				companyName= rs.getString("companyName");
//				communityName= rs.getString("communityName"); 
//				account1Num= rs.getInt("account1Number");
//				account1Balance= rs.getInt("account1Balance"); 
//				account2Num=rs.getInt("account2Number");
//				account2Balance = rs.getInt("account2Balance");
//				account3Num= rs.getInt("account3Num");
//				account3Balance = rs.getInt("account3Balance");
//				stmt.execute(null);
//				break;
//			}
//			rs.close();
//			stmt.close();
//		}catch(Exception e){
//			
//		}
//		
//		
//		System.out.println(personalAccName +"\t" +companyName+"\t"+communityName+"\t"+ 
//		account1Num +"\t" + account1Balance+"\t"+account2Num +"\t" + account2Balance+
//		"\t"+account3Num +"\t" + account3Balance+"\t");
//	
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 
}
