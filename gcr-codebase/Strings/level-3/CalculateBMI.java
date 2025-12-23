import java.util.Scanner;
// Create CalculateBMI Class to compute the BMI and their status
public class CalculateBMI {

    public static void main(String args[]) {
		// Creating Scanner object to take input from user
		Scanner sc = new Scanner(System.in);
		
		//int size 
		int numberOfperson = 3;

		//creating the heightAndweight double array to store height and weight of 10 people
		double heightAndweight[][] = new double[numberOfperson][2];
		
		//Taking input as str from user
		for(int i=0;i<numberOfperson;i++){
			System.out.println("Enter the "+(i+1)+" person weight in kg..");
			heightAndweight[i][0] = sc.nextDouble();
			System.out.println("Enter the "+(i+1)+" person height in cm.. ");
			heightAndweight[i][1] = sc.nextDouble();
		}

        // Calling the createRandomPCMmarks 
        String[][] dataPerson= computeTheBMI(heightAndweight, numberOfperson);
		
		//Display ouput
		display(dataPerson, numberOfperson);
		
    }

    // Method to generate the random PCM makrs of student
    public static String[][] computeTheBMI(double heightAndweight[][], int n) {
		String dataPerson[][] = new String[n][4];
	
		for(int i=0;i<n;i++){
			double weight = heightAndweight[i][0];
			double height = heightAndweight[i][1];
			
			//calling method to get BMI and Status
			String BMIorStatus[] = calculateBMIorStatus(weight,height);
			
			dataPerson[i][0] = String.valueOf(weight);//weight
			dataPerson[i][1] = String.valueOf(height);//height
			dataPerson[i][2] = BMIorStatus[0];//BMI
			dataPerson[i][3] = BMIorStatus[1];//status
		}
        return dataPerson;
    }

    // Method to compute the total, average, and percentage
    public static String[] calculateBMIorStatus(double weight, double height) {
		
		double heightMeter = height/100.0;
		double BMI = (double)weight/(heightMeter*heightMeter);
		
		String personStatus = "";
		//status
		if(BMI>=40.0){
			personStatus+="Obese";	
		}
		else if(BMI>=25.0 && BMI<=39.9){
			personStatus+="Overweight";	
		}
		else if(BMI>=18.5 && BMI<=24.9){
			personStatus+="Normal";	
		}
		else if(BMI<=18.4){
			personStatus+="Underweight";	
		}
		return new String[]{String.format("%.2f", BMI), personStatus};
    }

    // Method to display the output
    public static void display(String dataPerson[][], int n) {
		System.out.println("\n\nPerson BMI and Status result");
		System.out.println("-----------------------");
		System.out.println("\nWeight\t\tHeight\t\tBMI\t\tStatus");

		for(int i = 0; i < dataPerson.length; i++){
			System.out.println(
				dataPerson[i][0] + "\t\t" +
				dataPerson[i][1] + "\t\t" +
				dataPerson[i][2] + "\t\t" +
				dataPerson[i][3] + "\t\t" 
			);
		}
    }
}