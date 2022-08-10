package backEnd;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	
	public int id;
	public String email;
	public String password;
	public String title;
	public String lastName;

	public User(ResultSet rs) throws SQLException {
		id = rs.getInt("personal_id"); 
		email = rs.getString("personal_email");
		password = rs.getString("personal_password");
		title = rs.getString("personal_title");
		lastName = rs.getString("personal_lastName");
	}
	
	
}