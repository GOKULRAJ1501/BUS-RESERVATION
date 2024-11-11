package BusRese;

import java.sql.*;

public class BusDAO {
	public void displayBusInfo() throws SQLException{
		String query = "select * from bus";
		Connection c = JdbcConnection.getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(query);
		
		while (rs.next()) {
			System.out.print("Bus No: " + rs.getInt(1) + "   ");
			System.out.print("Bus Name: " + rs.getString(2) + "   ");
			if(rs.getInt(3)==0) 
				System.out.print("AC: no " + "   ");
			else
				System.out.print("AC: yes " + "   ");
			System.out.println("Capacity: " + rs.getInt(4));
			
		}
		System.out.println("---------------------------------");
	}
	public int getCapacity(int id)throws SQLException{
		String query = "select capacity from bus where id=" + id;
		Connection c = JdbcConnection.getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(query);
		rs.next();
		return rs.getInt(1);
		
	}

}
