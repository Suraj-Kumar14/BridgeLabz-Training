import java.util.Scanner;
public class MovieTicketBookingApp {

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            //get customer name and movie type
            System.out.println("--- Welcome to the Movie Ticket Booking App ---");
            System.out.print("Enter customer name: ");
            String customerName = sc.nextLine();

            System.out.println("Available Movies: ");
            System.out.println("1. Action (Price: Rs180.00)");
            System.out.println("2. Comedy (Price: Rs150.00)");
            System.out.println("3. Horror (Price: Rs220.00)");
            System.out.print("Enter movie type (1/2/3): ");
            int movieChoice = sc.nextInt();

            // Variables to store price components
            double moviePrice = 0.0;
            String movieName = "";

            // Use switch to determine the base price and name
            switch (movieChoice) {
                case 1:
                    moviePrice = 180.00;
                    movieName = "Action Movie";
                    break;
                case 2:
                    moviePrice = 150.00;
                    movieName = "Comedy Movie";
                    break;
                case 3:
                    moviePrice = 220.00;
                    movieName = "Horror Movie";
                    break;
                default:
                    System.out.println("Invalid movie choice.");
                    break;
            }

            //Get Seat Type
            System.out.println("Available Seat Types: ");
            System.out.println("Gold (Rs70.00 extra)");
            System.out.println("Silver (No extra cost)");
            System.out.print("Enter seat type (Gold/Silver): ");            
            sc.nextLine();
            String seatType = sc.nextLine();

            // Use if-else to adjust price based on seat type
            if (seatType.equalsIgnoreCase("Gold")) {
                moviePrice +=70.00;
            } else if (seatType.equalsIgnoreCase("Silver")) {
                // No extra charge, price remains the same
            } else {
                System.out.println("Invalid seat type entered. Defaulting to Silver.");
            }

            // Get Snacks Selection
            System.out.print("Do you want snacks? (Yes/No): ");
            String wantsSnacks = sc.next();
            double snacksPrice = 0.0;
            
            // Use if to add snack cost if applicable
            if (wantsSnacks.equalsIgnoreCase("Yes")) {
                snacksPrice = 150;
                System.out.println("Snacks added to order (Rs150).");
            }

            //Calculate Total and Display Receipt
            double totalBill = moviePrice + snacksPrice;

            System.out.println("\n--- Receipt for " + customerName + " ---");
            System.out.println("Movie: " + movieName);
            System.out.println("Seat Type: " + seatType);
            System.out.println("Movie Ticket Subtotal: Rs" + moviePrice);
            System.out.println("Snacks Cost: Rs" + snacksPrice);
            System.out.println("Total Amount Due: Rs" + totalBill);
            System.out.println("---------------------------------------\n");

            //Loop control (Multiple Customers)
            System.out.print("Book for another customer? (Yes/No): ");
            String continueBooking = sc.next();

            if (continueBooking.equalsIgnoreCase("No")) {
                System.out.println("Thank you for using the booking app. Goodbye!");
                break; 
            }
        }        
        sc.close();
    }
}
