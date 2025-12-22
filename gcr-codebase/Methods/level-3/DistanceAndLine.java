import java.util.Scanner;
public class DistanceAndLine 
{

    // Method to calculate Euclidean distance
    public static double euclideanDistance(double x1, double y1, double x2, double y2) 
	{
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance;
    }

    // Method to calculate equation of a line (slope and y-intercept)
    public static double[] lineEquation(double x1, double y1, double x2, double y2) 
	{
        double m, b;

        if (x2 - x1 != 0) {
            m = (y2 - y1) / (x2 - x1);       
            b = y1 - m * x1;                 
        } else {
            m = Double.POSITIVE_INFINITY;    
            b = Double.NaN;                  
        }

        return new double[]{m, b};
    }

    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);

        // Input two points
        System.out.print("Enter x1 y1: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.print("Enter x2 y2: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        // Calculate Euclidean distance
        double distance = euclideanDistance(x1, y1, x2, y2);
        System.out.printf("Euclidean Distance: %.4f\n", distance);

        // Calculate equation of line
        double[] line = lineEquation(x1, y1, x2, y2);
        double slope = line[0];
        double intercept = line[1];

        if (Double.isInfinite(slope)) {
            System.out.println("The line is vertical: x = " + x1);
        } else {
            System.out.printf("Equation of line: y = %.4fx + %.4f\n", slope, intercept);
        }

        sc.close();
    }
}
