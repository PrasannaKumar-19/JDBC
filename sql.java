import java.sql.*;

public class sql {
  public static void main( String args[] ) {
      Connection c = null;
Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	 c.setAutoCommit(false);
         System.out.println("Opened database successfully");
         stmt = c.createStatement();
         String sql = "INSERT INTO CLASS VALUES(1,'Prasanna',20)";
         stmt.executeUpdate(sql);
         sql = "INSERT INTO CLASS VALUES(2, 'Anshio',20)";
         stmt.executeUpdate(sql);
         sql = "INSERT INTO CLASS VALUES(3,'Abinesh',20)";
         stmt.executeUpdate(sql);
         stmt.close();
	 c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.print("Record Inserted");
      		   
   }
}