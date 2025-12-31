import java.util.Scanner;
//Create a class name LibraryFineCalculator to indicating the purpose of calculating fine for submitting the book after due date
public class LibraryFineCalculator {
    public static void main(String[] args) {
		//Create Scanner object
        Scanner sc = new Scanner(System.in);
        int finePerDay = 5;

        for (int i = 1; i <= 5; i++) {
            System.out.println("\nBook " + i);

            System.out.print("Enter due date (day number): ");
            int dueDate = sc.nextInt();

            System.out.print("Enter return date (day number): ");
            int returnDate = sc.nextInt();

            if (returnDate > dueDate) {
                int lateDays = returnDate - dueDate;
                int fine = lateDays * finePerDay;
                System.out.println("Book returned late.");
                System.out.println("Fine = Rs" + fine);
            } else {
                System.out.println("Book returned on time. No fine.");
            }
        }

        sc.close();
    }
}
