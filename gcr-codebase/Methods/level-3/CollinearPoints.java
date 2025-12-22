import java.util.Scanner;
public class CollinearPoints
{

    // Method to check collinearity using slope formula
    public static boolean areCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) 
	{
        // Slope AB
        double slopeAB = (double)(y2 - y1) / (x2 - x1);
        // Slope BC
        double slopeBC = (double)(y3 - y2) / (x3 - x2);
        // Slope AC
        double slopeAC = (double)(y3 - y1) / (x3 - x1);

        return slopeAB == slopeBC && slopeBC == slopeAC;
    }

    // Method to check collinearity using area of triangle formula
    public static boolean areCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) 
	{
        double area = 0.5 * (x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2));
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input for three points
        System.out.print("Enter x1 y1: ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();

        System.out.print("Enter x2 y2: ");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        System.out.print("Enter x3 y3: ");
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        // Check using slope
        if (areCollinearBySlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear by slope method.");
        } else {
            System.out.println("Points are not collinear by slope method.");
        }

        // Check using area
        if (areCollinearByArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear by area method.");
        } else {
            System.out.println("Points are not collinear by area method.");
        }
		sc.close();
    }
}
