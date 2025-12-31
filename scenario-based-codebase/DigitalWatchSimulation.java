//Create a class name DigitalWatchSimulation
public class DigitalWatchSimulation{
	public static void main(String [] args){
	System.out.println("-----Digital Watch Simulation-----");
	for(int i=0;i<23;i++)
	{
		if(i==13){
		System.out.println(i+":00hr  power cut!");
		break;
		}
		for(int j=0;j<=9;j++)
		{
			System.out.println(i+":0"+j+" hr");
		}
		for(int j=10;j<=59;j++)
		{
			System.out.println(i+":"+j+" hr");
		}
	}
	}
}
	