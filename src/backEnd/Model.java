package backEnd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;



public class Model {
	
	public static Connection connect() {
	Connection con = null;
	try {
		String url = "jdbc:sqlite:C:\\Users\\myfek\\OneDrive\\Personal\\"
				+ "Gateshead College\\Project3\\ATMSchoolProject.db";
		con = DriverManager.getConnection(url);
		JOptionPane.showMessageDialog(null, "Connected to Databse");
		return con; 
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);
		return null; 
	}
	
//		try {
//			
//			String url = "jdbc:sqlite:C:\\Users\\myfek\\OneDrive\\Personal\\Gateshead "
//					+ "College\\Project3\\ProjectATM.db";
//			con = DriverManager.getConnection(url);
//			System.out.println("connection made");
//			Statement st = conn.createStatement();
//			String querie1= "INSERT INTO 'personalInfo'(personal_title ,personal_first_name, "
//					+ "personal_last_name,PersonallAddressL1, PersonallAddressL2, Personalcity, PersonalPostcode, application_Company,"
//					+ " application_Community, phone, date, month, year, email, password) "
//					+ "VALUES ('title', 'firstNameT', 'lastNameT', 'address1A', 'address2A', 'cityA', 'postCodeA',"
//					+ "'areaCompany', 'areaCommunity', 'phoneA', 'dates', 'months', 'years', 'emailA', 'passwordT')";
//			st.execute(querie1);
//			conn.close();
			
//		 } catch (SQLException e) {  
//	            System.out.println(e.getMessage());  
//	        } finally {  
//	            try {  
//	                if (conn != null) {  
//	                    conn.close();  
//	                }  
//	            } catch (SQLException ex) {  
//	                System.out.println(ex.getMessage());  
//	            }  
//	        }
		}
	
	
	
	public void regButtonactionPerformed(ActionEvent e) {
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		connect();
    }

		

	}


