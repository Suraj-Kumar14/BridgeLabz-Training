package com.greetings.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greetings.entity.Greetings;
import com.greetings.repository.GreetingRepository;

@Service
public class GreetingService {
	
	private final GreetingRepository greetingRepository;
	
	public GreetingService(GreetingRepository greetingRepository) {
		this.greetingRepository=greetingRepository;
	}
	
	public Greetings saveGreeting(Greetings greeting) {
		return greetingRepository.save(greeting);
	}
	
	public List<Greetings> getAllGreetings(){
		return greetingRepository.findAll();
	}
	
	public Greetings getGreetingById(Long id) {
		return greetingRepository.findById(id).orElse(null);
	}
	
	public void deleteGreeting(Long id) {
		greetingRepository.deleteById(id);
	}
}
