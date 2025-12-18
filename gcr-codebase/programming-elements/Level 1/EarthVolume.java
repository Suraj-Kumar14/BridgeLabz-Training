//Creating a class with name EarthVolume to indicating the purpose of compute the volume of Earth.
public class EarthVolume
{
	public static void main(String [] args)
	{
	//Declare three Double type Variable name radius, earthVolumeInKilometers, and earthVolumeInMiles.
	  double radius=6378, earthVolumeInKilometers, earthVolumeInMiles;
	  
	
	//Calculate the volume of Earth in Kilometers and Miles.
	  earthVolumeInKilometers = 4.0/3.0*Math.PI*Math.pow(radius,3); 
	  earthVolumeInMiles = earthVolumeInKilometers * 1.62;


	//Displaying the Volume of earth in cubic kilometers and cubic miles.
	  System.out.println("The volume of earth in cubic kilometers is "+earthVolumeInKilometers+" and cubic miles in "+earthVolumeInMiles);
	}
}
	   