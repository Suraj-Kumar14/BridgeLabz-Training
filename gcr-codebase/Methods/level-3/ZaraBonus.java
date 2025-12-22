import java.util.Arrays;
public class ZaraBonus 
{

    // Method to generate salary (5-digit) and years of service (1-10)
    public static int[][] generateEmployees(int n) 
	{
        int[][] employees = new int[n][2]; // [salary, yearsOfService]
        for (int i = 0; i < n; i++) {
            employees[i][0] = (int)(Math.random() * 90000) + 10000; 
            employees[i][1] = (int)(Math.random() * 10) + 1;      
        }
        return employees;
    }

    // Method to calculate bonus and new salary
    public static double[][] calculateBonus(int[][] employees) 
	{
        int n = employees.length;
        double[][] newData = new double[n][3]; 

        for (int i = 0; i < n; i++) {
            double oldSalary = employees[i][0];
            int years = employees[i][1];
            double bonus;

            if (years > 5) {
                bonus = oldSalary * 0.05; // 5% bonus
            } else {
                bonus = oldSalary * 0.02; // 2% bonus
            }

            double newSalary = oldSalary + bonus;

            newData[i][0] = oldSalary;
            newData[i][1] = bonus;
            newData[i][2] = newSalary;
        }
        return newData;
    }

    // Method to calculate totals and display the table
    public static void displayTable(double[][] data, int[][] employees) 
	{
        double totalOld = 0;
        double totalBonus = 0;
        double totalNew = 0;

        System.out.println("Emp\tOld Salary\tYears\tBonus\tNew Salary");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < data.length; i++) {
            double oldSalary = data[i][0];
            double bonus = data[i][1];
            double newSalary = data[i][2];
            int years = employees[i][1];

            totalOld += oldSalary;
            totalBonus += bonus;
            totalNew += newSalary;

            System.out.printf("%d\t%.2f\t%d\t%.2f\t%.2f\n", i+1, oldSalary, years, bonus, newSalary);
        }

        System.out.println("---------------------------------------------------");
        System.out.printf("Total\t%.2f\t\t%.2f\t%.2f\n", totalOld, totalBonus, totalNew);
    }

    public static void main(String[] args) 
	{
        int n = 10; // number of employees

        int[][] employees = generateEmployees(n);           // Generate salaries and years
        double[][] updatedData = calculateBonus(employees); // Calculate bonus and new salary
        displayTable(updatedData, employees);              // Display the table
    }
}
