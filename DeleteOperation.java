import java.sql.*;

public class DeleteOperation{
		public static void main(String[] args){
			Connection c = null;
			Statement stmt = null;
			try{
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:test.db");
				c.setAutoCommit(false);
				stmt = c.createStatement();
				

				String sql = "DELETE FROM CLASS WHERE ID = 3";
				stmt.execute(sql);
				c.commit();


				ResultSet res = stmt.executeQuery("SELECT * FROM CLASS");
				while(res.next()){			
					int id = res.getInt("ID");
					String name = res.getString("NAME");
					int age = res.getInt("AGE");
					
					System.out.print("ID : "+id+" "+"NAME : "+name+" "+"AGE : "+age+" ");
				}
			}
			catch(Exception e){
				System.out.print("Invalid db");				
	
			}
			System.out.print("Deleted Sucessfully");
	}
}