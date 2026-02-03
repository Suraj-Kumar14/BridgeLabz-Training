package com.scenarioquestion.banking_finance;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Account>accounts=Arrays.asList(new Account(101,"Sonu",10000),
				                            new Account(102,"Allu",20000),
				                            new Account(103,"Ravi",15000),
				                            new Account(104,"Bholu",5000),
				                            new Account(105,"Sohit",35000),				
				                            new Account(106,"Mohit",25000)
											);

		
		System.out.println("\n1.Use lambda to check minimum balance rule.");
		System.out.println("-------------------------------------------------------------");
		accounts.stream().filter(x->x.getAmount()<6000).forEach(x->System.out.println(x.getName()+" your amount "+x.getAmount()+" is low please maintain around atleast 6000"));
		System.out.println("-------------------------------------------------------------");
		
		
		System.out.println("\n2.Use lambda to calculate simple interest.");
		System.out.println("-------------------------------------------------------------");
		accounts.stream().forEach(a->System.out.println(a.getName()+" - "+a.getAmount()+" - Simple Interest for a rate of 10% for time period of 5 years: "+(a.getAmount()*10*5)/100));
		System.out.println("-------------------------------------------------------------");
		
		
		System.out.println("\n3.Use lambda to validate withdrawal amount.");
		System.out.println("-------------------------------------------------------------");
		
		double withdrawalAmount=4000;
		int accountNumber=104;
		
		accounts.stream().filter(account->account.getAccountNumber()==accountNumber)
						.forEach(x->{
							if(!(withdrawalAmount<=x.getAmount())) {
								System.out.println("Amount is invalid");
							}else {
								x.setAmount(x.getAmount()-withdrawalAmount);
								System.out.println("Withdraw seccess");
							}
						});
		System.out.println("------------------------------------------------------------");
		
		
		System.out.println("\n4.Use lambda to print account details.");
		System.out.println("------------------------------------------------------------");
		accounts.stream().forEach(x->System.out.println("Name: "+x.getName()+", Account Number: "+x.getAccountNumber()+", Balance: "+x.getAmount()));
		System.out.println("------------------------------------------------------------");
			
		
		System.out.println("\n5.Use lambda to compare two account balances.");
		System.out.println("------------------------------------------------------------");
		Account a1=accounts.get(0);
		Account a2=accounts.get(1);
		accounts.stream().sorted((acc1,acc2)->Double.compare(acc1.getAmount(),acc2.getAmount())).forEach(System.out::println);
		System.out.println("------------------------------------------------------------");
		
	}

}
