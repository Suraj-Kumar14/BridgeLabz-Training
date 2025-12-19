import java.util.Scanner;
//Create a class name Copy2DTo1DArray to indicating the purpose to 2D dimensional array into singal dimension array.
public class Copy2DTo1DArray
{
	public static void main (String [] args)
	{
		//Create a Scanner object
		Scanner sc =new Scanner(System.in);
		//Create a variable rows,columns and take input
		System.out.print("Enter rows: ");
		int rows =sc.nextInt();
		System.out.print("Enter columns: ");
		int columns =sc.nextInt();
		//Create a 2D array
		int [][] matrix=new int [rows][columns];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				System.out.print("Enter elements: ");
				matrix [i][j]=sc.nextInt();
			}
		}
		//Create a 1D array
		int [] arr=new int [rows*columns];
		int index=0;
		//copy elements of 2D array into 1D array
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				arr[index]=matrix[i][j];
				index++;
			}
		}
		
		//Display 1D array elements
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		sc.close();
	}
}