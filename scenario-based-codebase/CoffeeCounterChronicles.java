//Create a class name CoffeeCounterChronicles to indicating the purpose of asking user to submit type of coffee
import java.util.Scanner;
public class CoffeeCounterChronicles
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);

        final double GST_RATE = 0.18;
        int choice;

        while (true) {
            System.out.println("\n===== Ravi's Cafe Menu =====");
            System.out.println("1. Espresso  - Rs120");
            System.out.println("2. Latte     - Rs150");
            System.out.println("3. Cappuccino- Rs140");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Thank you for visiting Ravi's Cafe ☕");
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            double pricePerCup = 0;
            String coffeeType = "";

            switch (choice) {
                case 1:
                    coffeeType = "Espresso";
                    pricePerCup = 120;
                    break;
                case 2:
                    coffeeType = "Latte";
                    pricePerCup = 150;
                    break;
                case 3:
                    coffeeType = "Cappuccino";
                    pricePerCup = 140;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    continue;
            }

            double total = pricePerCup * quantity;
            double gst = total * GST_RATE;
            double finalBill = total + gst;

            System.out.println("\n--- Bill Details ---");
            System.out.println("Coffee Type: " + coffeeType);
            System.out.println("Quantity: " + quantity);
            System.out.println("Base Amount: Rs" + total);
            System.out.println("GST (18%): Rs" + gst);
            System.out.println("Total Bill: Rs" + finalBill);
        }

        sc.close();
    }
}
