import java.util.Scanner;
class RectanglePerimeter
{
    public static void main(String [] args)
    {
	Scanner kb =new Scanner(System.in);

	//Taking length from the user
        System.out.println("Enter Length: ");
	double len=kb.nextDouble();

	// Taking width from the user 
	System.out.println("Enter Width: ");
	double width=kb.nextDouble();

        // Calculating perimeter of a rectangle
	double perimeter=2*(len + width);

	//Displaying output
	System.out.printf("Perimeter of Rectangle is %.2f%n",perimeter);
    }
}

	