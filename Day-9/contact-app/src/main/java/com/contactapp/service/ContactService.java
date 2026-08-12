package com.contactapp.service;


import java.util.List;

import com.contactapp.dto.ContactDTO;

public interface ContactService {
	
	ContactDTO createContact(ContactDTO dto);
	
	List<ContactDTO> getAllContacts();
	
	ContactDTO getContactById(Long id);
	
	ContactDTO updateContact(Long id, ContactDTO dto);
	
	void deleteContact(Long id);
	
	List<ContactDTO> searchContactsByName(String name);
	
	List<ContactDTO> searchContactsByAddress(String address);
	
	ContactDTO searchContactsByEmail(String email);
	
	ContactDTO toggleFavorite(Long id);
	
	List<ContactDTO> getFavoriteContacts();
}
