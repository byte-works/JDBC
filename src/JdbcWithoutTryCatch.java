// import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcWithoutTryCatch {
  
  public static void main(String[] args) throws SQLException {
    
    String dbUser = "student";
    String dbPassword = "123";
    String dbName = "demo";
    String dbUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
    
    // jdbs:<driver protocol>:<driver connection details>
    // jdbc:mysql://localhost:3306/demo?useSSL=false
    
    
    String sqlQuery = "select * from employees limit 5";
    
    
    // 1. Get a connection to database
    Connection connection = DriverManager.getConnection( dbUrl, dbUser, dbPassword );
    
    // 2. Create a statement
    Statement statement = connection.createStatement();
    
    // 3. Execute SQL query
    ResultSet resultSet = statement.executeQuery( sqlQuery );
    
    // 4. Process the result set
    while ( resultSet.next() ) {
      System.out.println( resultSet.getString( "last_name" ) + ", " + resultSet.getString( "first_name" ) );
    }
    
  }
  
}
