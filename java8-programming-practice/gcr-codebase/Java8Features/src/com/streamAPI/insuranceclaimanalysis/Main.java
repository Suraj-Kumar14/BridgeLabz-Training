package com.streamAPI.insuranceclaimanalysis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Claim>claims=new ArrayList<>();
		
		claims.add(new Claim(101,"Ravi","Child Insurance",100000));
		claims.add(new Claim(102,"Amit","Health Insurance",250000));
		claims.add(new Claim(103,"Suresh","Life Insurance",500000));
		claims.add(new Claim(104,"Neha","Car Insurance",150000));
		claims.add(new Claim(105,"Pooja","Home Insurance",300000));
		claims.add(new Claim(106,"Rahul","Travel Insurance",80000));
		claims.add(new Claim(107,"Anjali","Health Insurance",200000));
		claims.add(new Claim(108,"Vikas","Bike Insurance",60000));
		claims.add(new Claim(109,"Kiran","Term Insurance",700000));
		claims.add(new Claim(110,"Sunita","Senior Citizen Insurance",400000));
		
		claims.stream().collect(Collectors.groupingBy(Claim::getType,Collectors.averagingDouble(Claim::getAmount))).forEach((k,v)->System.out.println(k+" - "+v));

	}

}
