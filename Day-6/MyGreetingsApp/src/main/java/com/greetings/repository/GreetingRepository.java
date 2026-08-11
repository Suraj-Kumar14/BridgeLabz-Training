package com.greetings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greetings.entity.Greetings;

public interface GreetingRepository extends JpaRepository<Greetings,Long>{

}
