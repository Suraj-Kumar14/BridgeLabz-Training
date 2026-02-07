package com.scenarioquestion.consumerquestion;

import java.util.function.Consumer;

public class ConsumerOperation {

	public static void main(String[] args) {
		
		/*
		Scenario 3: Consumer (Perform Action)
		
		1.Print student details using Consumer.
		
		2.Log employee login activity using Consumer.
		
		3.Print order confirmation message using Consumer.
		
		4.Display account balance using Consumer.
		
		5.Send notification message using Consumer.
	 */
	
		System.out.println("1.Print student details using Consumer.");
		System.out.println("-----------------------------------------------");
		String name="Monu";
		Consumer<String>names=n->System.out.println(n);
		names.accept(name);
		
		
		System.out.println("\n2.Log employee login activity using Consumer.");
		System.out.println("------------------------------------------------");
		Consumer<String>log=s->System.out.println(s+" log succes");
		log.accept("Sonu");
		
		System.out.println("\n3.Print order confirmation message using Consumer.");
		System.out.println("-------------------------------------------------");
		String message="Order confirmation";
		Consumer<String>mes=m->System.out.println(m);
		mes.accept(message);
	
	
		System.out.println("\n4.Display account balance using Consumer.");
		System.out.println("-----------------------------------------------------");
		double balance=5000;
		Consumer<Double>balances=bal->System.out.println(bal);
		balances.accept(balance);
		
		System.out.println("\n5.Send notification message using Consumer.");
		System.out.println("-----------------------------------------------------");
		Consumer<String>notification=m->System.out.println(m);
		notification.accept("Battery discharge");
	}	

}
