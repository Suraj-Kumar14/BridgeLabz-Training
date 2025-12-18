//Creating class with name DistributePens to indicating the purpose is to divide pen equally and also find the remaining non-distributed pens.
public class DistributePens
{
	public static void main(String [] args)
	{
		//Declare two int variable pens ,students and assign with 14 ,3 respectively.
		int pens=14,students=3;
		//Create two int variable penPerStudent, remainingPen and calculate them.
		int penPerStudent = pens/students;
		int remainingPen = pens%students;

		//Display result
		System.out.println("The Pen Per Student is "+penPerStudent+" and the remaining pen not distributed is "+remainingPen);
	}
}