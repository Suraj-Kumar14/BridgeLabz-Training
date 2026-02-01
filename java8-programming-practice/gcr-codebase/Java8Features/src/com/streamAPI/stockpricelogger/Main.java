package com.streamAPI.stockpricelogger;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Stock>stocks=new ArrayList<>();
		
		stocks.add(new Stock("tcs", 3500));
		stocks.add(new Stock("infosys", 1500));
		stocks.add(new Stock("wipro", 450));
		stocks.add(new Stock("reliance", 2500));
		stocks.add(new Stock("hdfc", 1700));

		stocks.stream().forEach(System.out::println);
	}

}
