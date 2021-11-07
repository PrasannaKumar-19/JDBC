import java.sql.*;

public class Updateoperation{
	public static void main(String[] args){
		Connection c = null;
		Statement stmt = null;
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			

			String sql = "UPDATE CLASS set AGE = 19 where ID = 2";
	 		stmt.execute(sql);
	 		c.commit();
			
			ResultSet res = stmt.executeQuery("SELECT * FROM CLASS");
			while(res.next()){
				int id = res.getInt("ID");
				String name = res.getString("NAME");
				int age = res.getInt("AGE");
					
				System.out.print("ID: " +id+" "+"NAME: " +name+" "+"AGE: " +age);
			}

			res.close();
			stmt.close();

			c.close();
		}
		catch(Exception e){
			System.err.print(e.getClass().getName() + ":"+ e.getMessage());
			System.exit(0);
		}
		System.out.print("Updated Sucessfully");
	}
}
				
