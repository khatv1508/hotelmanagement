package hotelmanagement.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hotelmanagement.db.DBHelper;

public class AccountService {
	private static final String SELECT_AUTHOR = "select * from author where author_id=?";
	
	public String selectAuthor() throws SQLException{
		String result = "";
		
		PreparedStatement preparedStatement = DBHelper.getPreparedStatement(SELECT_AUTHOR);
		preparedStatement.setInt(1, 1);
		// Step 3: Execute the query or update query
        ResultSet rs = preparedStatement.executeQuery();
        // Step 4: Process the ResultSet object.
        while (rs.next()) {
            int id = rs.getInt("author_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            result = result.concat(id + "," + firstName + "," + lastName);
        }
		return result;
	}
}
