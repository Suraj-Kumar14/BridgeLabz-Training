package com.contactapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contactapp.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Long>{

	List<Contact> findByNameContainingIgnoreCase(String name);
	
	List<Contact> findByAddress(String phone);
	
	Optional<Contact> findByEmail(String email);
	
	boolean existsByEmail(String email);

	boolean existsByPhone(String phone);
	
	List<Contact> findByFavoriteTrue();
}
