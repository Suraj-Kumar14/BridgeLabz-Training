//Create a class name SpringSeason to indicating the purpose to check it is spring season or not.
public class SpringSeason
{
	public static void main(String [] args)
	{
	   //Create two variable month and day
		 int month=Integer.parseInt(args[0]);
		 int day=Integer.parseInt(args[1]);
		 
		//Check whether the Season is spring or not. 
		 if((month==3 && day>=20)||(month==4)||(month==5)||(month==6 && day<=20))
		 {
			System.out.println("Its a Spring Season");
		 }
		 else
		 {
		    System.out.println("Not a Spring season");
		 }
		  
	}
}