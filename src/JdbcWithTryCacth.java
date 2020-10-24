import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcWithTryCacth {
  
  public static void main(String[] args) throws SQLException {
    
    String dbUser = "student";
    String dbPassword = "123";
    String dbName = "demo";
    String dbUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
    
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    
    String sqlQuery = "select * from employees limit 5";
    
    
    try {
      connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
      statement = connection.createStatement();
      resultSet = statement.executeQuery( sqlQuery );
      while ( resultSet.next() ) {
        System.out.println( resultSet.getString( "last_name" ) + ", " + resultSet.getString( "first_name" ) );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      if ( resultSet != null ) { resultSet.close(); }
      if ( statement != null ) { statement.close(); }
      if ( connection != null ) { connection.close(); }
    }
  }
  
  
}
