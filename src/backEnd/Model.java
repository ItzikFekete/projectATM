package backEnd;
import frontEnd.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.sqlite.SQLiteDataSource;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class Model {
	String []pesonalInfo;
	public static void connect() {
	Connection conn = null;
	
		try {
			
			String url = "jdbc:sqlite:C:\\Users\\myfek\\OneDrive\\Personal\\Gateshead "
					+ "College\\Project3\\ProjectATM.db";
			conn = DriverManager.getConnection(url);
			System.out.println("connection made");
			Statement st = conn.createStatement();
			String querie1= "INSERT INTO 'personalInfo'(personalTitle ,personalFirstName, "
					+ "personalLastMame,PersonallAddressL1, PersonallAddressL2, Personalcity, PersonalPostcode, application_Company,"
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
	
	
	
	public void regButtonactionPerformed(ActionEvent e) {
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		connect();
    }

		

	}


