import java.util.*;
public class FindGCDAndLCM {
    public static void main(String[] args) {
		
        // Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//Taking input from user
		System.out.print("Enter number1: ");
        int number = sc.nextInt();
		System.out.print("Enter number2: ");
        int s = sc.nextInt();

        System.out.println("The GCD is " + findGCD(number, s));
        System.out.println("The LCM is " + findLCM(number, s));

    }
	//This method solve GCD
    public static int findGCD(int n, int s) {
        while (s != 0) {
            int temp = s;
            s = n % s;
            n = temp;
        }
        return n;
    }
	//This method solve LCM
    public static int findLCM(int n, int s) {
        return (n * s) / findGCD(n, s);
    }
}