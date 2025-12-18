// Creating class with name SamsAverageMarks to indicating the purpose is to display Sam's average mark in PCM.
public class SamsAverageMarks
{ 
        public static void main(String [] args)
        {
	    //Creating four int variable name physics, chemistry, math, totalNumber and assign the value 95, 96, 94, and 300.
	    int physics=95, chemistry=96, math=94, totalNumber=300;


	    //Creating a int variable name sum to indicating the sum of all subject. 
	    int sum= physics+chemistry+math;
	    //Creating a Double variable name average which indicating the average of three numbers. 
	    int average=sum*100/300;

	    //Display result
	    System.out.println("Sam's average marks in PCM is "+average);
	}
}
	