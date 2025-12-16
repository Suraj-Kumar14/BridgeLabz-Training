import java.util.Scanner;
class AreaOfCircle
{
   public static void main(String [] args)
   {
	Scanner kb=new Scanner(System.in);
        System.out.println("Enter radius: ");
	double rad=kb.nextDouble();
	
	double area=Math.PI*Math.pow(rad,2);
	System.out.printf("%.2f%n",area);
   }
}