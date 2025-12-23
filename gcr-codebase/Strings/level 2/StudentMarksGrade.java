import java.util.Scanner;
// Create StudentMarksGrade Class to compute the grade of student based on the marks PCM
public class StudentMarksGrade {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.println("Enter the number of stduent: ");
        int numberStudent = sc.nextInt();

        // Calling the createRandomPCMmarks 
        int[][] randomPCM= createRandomPCMmarks(numberStudent);

        // Create trimmed string using user-defined substring
        int data[][] = calculateDataPCM(randomPCM,numberStudent);
		
		//calling method to find the grage
		String gragePCM[] = calculateGrage(data,numberStudent);
		
		//Display ouput
		display(randomPCM,data,gragePCM, numberStudent);
		
    }

    // Method to generate the random PCM makrs of student
    public static int[][] createRandomPCMmarks(int n) {
		int pcmArrays[][] = new int[n][3];
	
		for(int i=0;i<n;i++){
			pcmArrays[i][0] = (int)(Math.random()*100);
			pcmArrays[i][1] = (int)(Math.random()*100);
			pcmArrays[i][2] = (int)(Math.random()*100);
		}
        return pcmArrays;
    }

    // Method to compute the total, average, and percentage
    public static int[][] calculateDataPCM(int randomPCM[][], int n) {
		
		int calculateData[][] = new int[n][3];
		for(int i=0;i<randomPCM.length;i++){
			//total
			calculateData[i][0] = randomPCM[i][0]+randomPCM[i][1]+randomPCM[i][2];
			//average
			calculateData[i][1] = (randomPCM[i][0]+randomPCM[i][1]+randomPCM[i][2])/3;
			//percentage -> 
			calculateData[i][2] = (int)((randomPCM[i][0]+randomPCM[i][1]+randomPCM[i][2])/300.0)*100;;
		}
		return calculateData;
    }
	
	//This method find the grade of PCM based on the percentage
	public static String[] calculateGrage(int data[][], int n){
		String gradeArray[] = new String[n];
		
		for(int i=0;i<n;i++){
			int percentage = data[i][2];
			if(percentage>=80){
				gradeArray[i]= "A grade";
			}else if(percentage>=70&&percentage<=79){
				gradeArray[i]= "B grade";
			}else if(percentage>=60&&percentage<=69){
				gradeArray[i]= "C grade";
			}else if(percentage>=50&&percentage<=59){
				gradeArray[i]= "D grade";
			}else if(percentage>=40&&percentage<=49){
				gradeArray[i]= "E grade";
			}else{
				gradeArray[i]= "R grade";
			}
		}
		return gradeArray;
	}

    // Method to display the output
    public static void display(int randomPCM[][], int data[][], String gragePCM[], int n) {
		System.out.println("\n\nStudent result");
		System.out.println("-----------------------");
		System.out.println("\nPhysic\t\tChemistry\tMath\t\tTotal\t\tAverage\t\tPercentage\tGrade");

		for(int i = 0; i < data.length; i++){
			System.out.println(
				randomPCM[i][0] + "\t\t" +
				randomPCM[i][1] + "\t\t" +
				randomPCM[i][2] + "\t\t" +
				data[i][0] + "\t\t" +
				data[i][1] + "\t\t" +
				data[i][2] + "\t\t" +
				gragePCM[i]
			);
		}
    }
}