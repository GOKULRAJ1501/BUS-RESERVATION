package BusRese;
import java.util.Date;
import java.sql.*;

public class BookingDAO {
	public int getBookedCount(int BusNo , Date date) throws SQLException{
		String query = "select count(passanger_name) from booking where bus_no=? and travel_date=?";
		Connection con = JdbcConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		pst.setInt(1, BusNo);
		pst.setDate(2, sqldate);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	
	public void addBooking(Booking booking) throws SQLException{
		String query = "Insert into booking values(?,?,?,?,?)";
		Connection con = JdbcConnection.getConnection();
		java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, booking.passengerName);
		pst.setInt(2, booking.BusNo);
		pst.setDate(3, sqldate);
		pst.setString(4,booking.number);
		pst.setString(5, booking.IdProof);
		
		pst.executeUpdate();
		
	}

	

}
