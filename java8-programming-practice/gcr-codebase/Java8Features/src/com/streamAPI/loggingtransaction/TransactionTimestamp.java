package com.streamAPI.loggingtransaction;

import java.time.LocalDate;
import java.util.List;

public class TransactionTimestamp {

	public static void main(String[] args) {
		
		List<String>transactionId=List.of("1234ASDF",
				"95934DKJ",
				"9493DKCK",
				"483DJSIK",
				"1234EFS3",
				"1234DW23F");
		
		
		transactionId.stream()
						.forEach(id->System.out.println(LocalDate.now()+" transaction "+id));

	}

}
