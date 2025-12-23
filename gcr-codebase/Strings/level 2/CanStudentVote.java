import java.util.Scanner;
public class  CanStudentVote
{
   // Generate ages of n students (2-digit ages from user input)
    public static int[] getStudentAges(int n, Scanner sc) {
        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }
        return ages;
    }

    //check voting eligibility
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }

    //  Display result in tabular format
    public static void displayResult(String[][] data) {
        System.out.println("\nAge\tCan Vote");
        System.out.println("----------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfStudents = 10;

        int[] ages = getStudentAges(numberOfStudents, sc);
        String[][] votingResult = checkVotingEligibility(ages);
        displayResult(votingResult);

        sc.close();
    }
}
