import java.util.Random;
import java.util.Scanner;
public class StudentGrading 
{

    // Method to generate random 2-digit scores for PCM
    public static int[][] generateScores(int numStudents) 
	{
        Random rand = new Random();
        int[][] scores = new int[numStudents][3]; 
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = rand.nextInt(41) + 60; 
            }
        }
        return scores;
    }

    // Method to calculate grade based on percentage
    public static String getGrade(double percentage) 
	{
        if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else if (percentage >= 40) return "E";
        else return "R";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();

        int[][] scores = generateScores(numStudents);

        System.out.println("\nStudent Results:");
        System.out.println("ID\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage\tGrade");

        for (int i = 0; i < numStudents; i++) {
            int physics = scores[i][0];
            int chemistry = scores[i][1];
            int math = scores[i][2];
            int total = physics + chemistry + math;
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            String grade = getGrade(percentage);

            System.out.printf("%d\t%d\t%d\t\t%d\t%d\t%.2f\t%.2f%%\t\t%s\n",
                    i + 1, physics, chemistry, math, total, average, percentage, grade);
        }

        scanner.close();
    }
}