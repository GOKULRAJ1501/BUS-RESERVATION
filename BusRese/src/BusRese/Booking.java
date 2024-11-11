package BusRese;
import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
	String passengerName;
	int BusNo;
	Date date;
	String number;
	String  IdProof;
	
	Booking(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name");
		passengerName =scanner.next();
		System.out.println("Enter the Bus No");
		BusNo = scanner.nextInt();
		System.out.println("Enter the date dd-mm-yyyy");
		String dateInput = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (true) {
            System.out.println("Enter your Mobile Number:");
            number = scanner.next();
            
            if (number.length() == 10 && number.matches("\\d+")) {
                break; 
            } else {
                System.out.println("Invalid mobile number. Please enter a 10-digit number.");
            }
        }
		
		
		System.out.println("Enter your AADHAR No");
		 while (true) {
	            System.out.println("Enter your AADHAR No (12 digits):");
	            IdProof = scanner.next();
	            
	            if (IdProof.length() == 12 && IdProof.matches("\\d+")) {
	                break; 
	            } else {
	                System.out.println("Invalid ID proof number. Please enter a 12-digit number.");
	            }
	        }
		}
	
	public boolean isAvailable() throws SQLException {
		BusDAO busdao = new BusDAO();
		BookingDAO bookingdao = new BookingDAO();
		int capacity=busdao.getCapacity(BusNo);
		
		int booked = bookingdao.getBookedCount(BusNo,date);
		
		
		return booked<capacity;
	}

}
