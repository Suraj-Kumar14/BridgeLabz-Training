package com.streamAPI.expiringmemberships;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Gym>members=new ArrayList<>();
		
		members.add(new Gym("Sumit kumar", LocalDate.of(2026, 2, 2)));
		members.add(new Gym("Amit Sharma", LocalDate.of(2026, 1, 15)));
		members.add(new Gym("Rahul Verma", LocalDate.of(2025, 12, 20)));
		members.add(new Gym("Neha Singh", LocalDate.of(2026, 3, 10)));
		members.add(new Gym("Pooja Gupta", LocalDate.of(2026, 4, 5)));
		members.add(new Gym("Rohit Yadav", LocalDate.of(2025, 11, 30)));
		members.add(new Gym("Anjali Mehta", LocalDate.of(2026, 2, 18)));
		members.add(new Gym("Vikas Patel", LocalDate.of(2026, 5, 1)));
		members.add(new Gym("Kiran Das", LocalDate.of(2025, 10, 25)));
		members.add(new Gym("Sunita Rao", LocalDate.of(2026, 6, 12)));

		members.stream()
				.filter(m->m.getExpiryDate().isAfter(LocalDate.now().plusDays(30)))
				.forEach(System.out::println);
	}

}
