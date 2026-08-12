package com.contactapp.mapper;

import org.springframework.stereotype.Component;

import com.contactapp.dto.ContactDTO;
import com.contactapp.entity.Contact;

@Component
public class ContactMapper {

	public Contact toEntity(ContactDTO dto) {
		
		Contact contact = new Contact();
		
		contact.setId(dto.getId());
		contact.setName(dto.getName());
		contact.setPhone(dto.getPhone());
		contact.setEmail(dto.getEmail());
		contact.setAddress(dto.getAddress());
		contact.setFavorite(dto.isFavorite());
		
		return contact;
	}
	
	public ContactDTO toDTO(Contact contact) {
		
		ContactDTO dto = new ContactDTO();
		
		dto.setId(contact.getId());
		dto.setName(contact.getName());
		dto.setPhone(contact.getPhone());
		dto.setEmail(contact.getEmail());
		dto.setAddress(contact.getAddress());
		dto.setFavorite(contact.isFavorite());
		
		return dto;
	}
}
