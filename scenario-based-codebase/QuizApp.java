import java.util.Scanner;

public class QuizApp{
	static String[] question = {"Which planet is known as the 'Red Planet'?","What is the chemical symbol for water?","Who is known as the Father of the Indian Constitution?","What is the process by which plants make their food?","Which is the largest ocean in the world?"};
	static char[] answer = {'B','B','C','C','D'};
	static char[] userAnswer = new char[5];
	static String[][] options = {
		{"(A) Venus","(B) Mars","(C) Jupiter","(D) Saturn"},
			{"(A) O2","(B) H2O","(C) CO2","(D) N2"},
				{"(A) Mahatma Gandhi","(B) Jawaharlal Nehru","(C) B. R. Ambedkar","(D) Sardar Patel"},
					{"(A) Respiration","(B) Transpiration","(C) Photosynthesis","(D) Fermentation"},
						{"(A) Atlantic Ocean","(B) Indian Ocean","(C) Arctic Ocean","(D) Pacific Ocean"},
	};
	
	static Scanner sc = new Scanner(System.in);
 	
	public static void main(String args[]){
		
		while(true){
			System.out.println("\n---------------Choose Option--------------");
			System.out.println("Want to solve MCQ-> please enter 'M' : ");
			System.out.println("Want to see Answer-> please enter 'A' : ");
			System.out.println("For exit -> press 'E' :");
			System.out.println("--------------------------------------------");
			
			char c = sc.next().charAt(0);
			c = Character.toUpperCase(c);
			
			if(c=='E'){
				System.out.println("Thanks for use our service! Please come again");
				break;
			}
			
			switch(c){
				case 'M':
					//call the showQuestion method
					showQuestion();
					break;
				case 'A':
					showAnswer();
					break;
				default:
					System.out.println("Invalid input!");
			}
		}
	}
	public static void showQuestion(){
		for(int i=0;i<5;i++){
			System.out.println("\n---------------Question."+(i+1)+"--------------");
			System.out.println(question[i]);
			System.out.println("Chose Option");
			for(int j=0;j<4;j++){
				System.out.println(options[i][j]);
			}
			
			char c = sc.next().charAt(0);
			c = Character.toUpperCase(c);
			
			userAnswer[i] = c;
			//call method to validate the option
		}
		validateOuput();
	}
	//this method validate the option
	public static void validateOuput(){
		int correct = 0;
		int incorrect = 0;
		for(int i=0;i<5;i++){
			if(answer[i]==userAnswer[i]){
				correct+=1;
			}else{
				incorrect+=1;
			}
		}
		System.out.println("\n---------------Final Result--------------");
		System.out.println("Correct Questions: "+correct);
		System.out.println("Incorrect Questions: "+incorrect);
	}
	
	//this method show the answer of question
	public static void showAnswer(){
		for(int i=0;i<5;i++){
			System.out.println("\n---------------Question."+(i+1)+"--------------");
			System.out.println(question[i]);
			System.out.println("Option");
			for(int j=0;j<4;j++){
				System.out.println(options[i][j]);
			}
			System.out.println("Correct Options is: "+ answer[i]);
		}
	}
}