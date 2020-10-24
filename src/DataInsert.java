// inserting a row (a record) into database
// statement.executeUpdate(sql);

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataInsert {
  
  public static void main(String[] args) throws SQLException {
    
    String dbUserName = "student";
    String dbPassword = "123";
    String dbName = "demo";
    String dbURL = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
  
    String sql = "INSERT INTO employees (last_name, first_name, email, department, salary) " +
      "VALUES ('Wrigth', 'Eric', 'eric.wright@foo.com', 'HR', 33000.00)";
  
    try (
      Connection connection = DriverManager.getConnection( dbURL, dbUserName, dbPassword );
      Statement statement = connection.createStatement();
    ) {
      statement.executeUpdate( sql );
    } catch ( Exception e ) {
      e.printStackTrace();
    }
    
  }
  
}
