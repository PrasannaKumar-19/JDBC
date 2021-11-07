import java.sql.*;

public class SelectOperation {
  public static void main( String args[] ) {
      Connection c = null;
Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	 c.setAutoCommit(false);
         System.out.println("Opened database successfully");
         stmt = c.createStatement();
         ResultSet result = stmt.executeQuery("SELECT * FROM CLASS");
         while (result.next()){
         	int id = result.getInt("ID");
		String name = result.getString("NAME");
		int age = result.getInt("AGE");
		System.out.println("ID = "+id+" "+"NAME :"+name+" "+"AGE :"+age);
	 }
	 result.close();
         stmt.close();
	 c.commit();
         c.close();
       } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.print("Operation done sucessfully");
      		   
   }
}