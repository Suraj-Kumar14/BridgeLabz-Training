package com.contactapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contactapp.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Long>{

	
}
