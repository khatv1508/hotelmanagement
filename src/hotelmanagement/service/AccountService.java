package hotelmanagement.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hotelmanagement.db.DBHelper;
import hotelmanagement.gui.ResultMessage;
import hotelmanagement.model.Account;

public class AccountService {
	private static final String SELECT_ACCOUNT = "select * from Account where account_id=?";
	private static final String LOGIN_ACCOUNT = "select count(*) as count from Account where account_name = ? and account_pass = ?";
	
	public Account getAccount() throws SQLException{
		Account account = new Account();
		
		PreparedStatement preparedStatement = DBHelper.getPreparedStatement(SELECT_ACCOUNT);
		if(preparedStatement != null) {
			preparedStatement.setInt(1, 1);
			// Step 3: Execute the query or update query
	        ResultSet rs = preparedStatement.executeQuery();
	        // Step 4: Process the ResultSet object.
	        while (rs.next()) {
	        	account.setAccountId(rs.getInt("account_id"));
	        	account.setAccountName(rs.getString("account_name"));
	        }
		}
		return account;
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
					result.setMsgCode(ResultMessage.MSG_LOGIN_SUCCESS);
				} else {
					result.setMsgCode(ResultMessage.MSG_CODE_FAIL);
					result.setContent(ResultMessage.MSG_LOGIN_FAIL);
				}
			}
		}
		return result;
	}
}
