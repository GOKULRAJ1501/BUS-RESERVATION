package BusRese;

import java.util.Scanner;
import java.sql.SQLException;

public class BusReserve {

    public static void main(String[] args) throws SQLException {
        BusDAO busdao = new BusDAO();
        
        int userOpt = 1;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Gokul Travels");
        
        while (userOpt != 2) {
            System.out.println("Enter 1 to book ");
            System.out.println("Enter 2 to exit");
            System.out.println("Enter 3 to Info");
            userOpt = scanner.nextInt();
            
            if (userOpt == 1) {
                System.out.println("Enter your Boarding Point:");
                scanner.next();
                System.out.println("Enter your Departure Point:");
                scanner.next();
                
                busdao.displayBusInfo(); 
                Booking booking = new Booking();
                if (booking.isAvailable()) {
                    BookingDAO bookingdao = new BookingDAO();
                    bookingdao.addBooking(booking);
                    System.out.println("Your Booking is Confirmed");
                } else {
                    System.out.println("Sorry. The bus is full! Please try another date or bus.");
                }
                
            } else if (userOpt != 2) {
                System.out.println("Invalid option. Please enter 1 to book or 2 to exit.");
            }
        }
        
        System.out.println("Thank you for using Gokul Travels. Goodbye!");
        
        scanner.close();
    }
}
