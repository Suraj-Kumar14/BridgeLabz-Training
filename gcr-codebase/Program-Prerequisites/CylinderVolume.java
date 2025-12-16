import java.util.Scanner;
class CylinderVolume
{
    public static void main(String [] args)
    {
	Scanner kb =new Scanner(System.in);
	
	System.out.println("Enter Radius: ");
	double rad=kb.nextDouble();

	System.out.println("Enter Height: ");
	double height=kb.nextDouble();

	double vol=Math.PI*Math.pow(rad,2)*height;

	System.out.printf("Volume of Cylinder is: %.2f%n", vol);
     }
}