package LigaDeFotbal;

import java.sql.*;

public class Database2 {
	public static void main(String[] args) throws Exception 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bdp3","root","");
			System.out.println("Xampp Mysql Connected..");
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery("select * from antrenor");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
