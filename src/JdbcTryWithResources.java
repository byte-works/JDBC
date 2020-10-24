import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTryWithResources {
  
  public static void main(String[] args) throws SQLException {
    
    String dbUser = "student";
    String dbPassword = "123";
    String dbName = "demo";
    String dbUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
    
    
    String sqlQuery = "select * from employees limit 2";
  
    
    // 'try' with resources
    // 'try' use automatic resource management
    //  The following example uses a try-with-resources statement to automatically close a java.sql.Statement object:
    
    try (
      Connection connection = DriverManager.getConnection( dbUrl, dbUser, dbPassword );
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery( sqlQuery )
    ) {
      while ( resultSet.next() ) {
        System.out.println( resultSet.getString( "last_name" ) + ", " + resultSet.getString( "first_name" ) );
      }
    } catch ( Exception e ) {
      e.printStackTrace();
    }
    
  }
  
}
