package hotelmanagement.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
	private static String jdbcURL = "jdbc:sqlserver://localhost;"
            + "databaseName=hotelmanagement2;"
            + "integratedSecurity=true";
    private static String jdbcUsername = "sa";
    private static String jdbcPassword = "nhan2894";
    
    // khoi tao connection toi DB
    public static PreparedStatement getPreparedStatement(String query){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            preparedStatement = connection.prepareStatement(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
