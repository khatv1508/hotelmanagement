package hotelmanagement.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hotelmanagement.db.DBHelper;
import hotelmanagement.gui.ResultMessage;
import hotelmanagement.model.Account;

public class AccountService {
	private static final String SELECT_AUTHOR = "select * from author where author_id=?";
	private static final String LOGIN_ACCOUNT = "select count(*) as count from hotelmanagement.account where account_name = ? and account_pass = ?";
	
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
	
	public ResultMessage login(Account account) throws SQLException{
		ResultMessage result = new ResultMessage();
		PreparedStatement preparedStatement = DBHelper.getPreparedStatement(LOGIN_ACCOUNT);
		if (preparedStatement != null){
			preparedStatement.setString(1, account.getAccountName());
			preparedStatement.setString(2, account.getAccountPass());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int count = rs.getInt("count");
				if(count == 1){
					result.setMsgCode(ResultMessage.MSG_CODE_SUCCESS);
					result.setContent(ResultMessage.MSG_LOGIN_SUCCESS); 
				} else {
					result.setMsgCode(ResultMessage.MSG_CODE_FAIL);
					result.setContent(ResultMessage.MSG_LOGIN_FAIL);
				}
			}
		}
		return result;
	}
}
