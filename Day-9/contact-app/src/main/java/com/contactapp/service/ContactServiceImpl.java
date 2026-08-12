package com.contactapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contactapp.dto.ContactDTO;
import com.contactapp.entity.Contact;
import com.contactapp.exception.ContactNotFoundException;
import com.contactapp.exception.DuplicateContactException;
import com.contactapp.mapper.ContactMapper;
import com.contactapp.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private final ContactRepository contactRepository;
	private final ContactMapper mapper;
	
	public ContactServiceImpl(ContactRepository contactRepository,ContactMapper mapper) {
		this.contactRepository=contactRepository;
		this.mapper=mapper;
	}
	
	@Override
	public ContactDTO createContact(ContactDTO dto) {

	    if (contactRepository.existsByEmail(dto.getEmail())) {
	        throw new DuplicateContactException(
	                "Contact already present with email: " + dto.getEmail()
	        );
	    }

	    if (contactRepository.existsByPhone(dto.getPhone())) {
	        throw new DuplicateContactException(
	                "Contact already present with phone: " + dto.getPhone()
	        );
	    }

	    Contact contact = mapper.toEntity(dto);

	    Contact savedContact = contactRepository.save(contact);

	    return mapper.toDTO(savedContact);
	}
	
	@Override
	public List<ContactDTO> getAllContacts(){
		return contactRepository.findAll().stream().map(mapper::toDTO).toList();
	}
	
	public ContactDTO getContactById(Long id) {
		Contact contact = contactRepository.findById(id).orElseThrow(()-> new ContactNotFoundException("Contact not found with id: "+id));
		
	
		return mapper.toDTO(contact);
		
	}
	
	@Override
	public ContactDTO updateContact(Long id, ContactDTO dto) {
		Contact existingContact = contactRepository.findById(id).orElseThrow(()-> new ContactNotFoundException("Contact not found with id: "+id));
		
		existingContact.setName(dto.getName());
		existingContact.setPhone(dto.getPhone());
		existingContact.setEmail(dto.getEmail());
		existingContact.setAddress(dto.getAddress());
		
		Contact update= contactRepository.save(existingContact);
		
		return mapper.toDTO(update);

		
	}
	
	@Override
	public void deleteContact(Long id) {
		
		if(!contactRepository.existsById(id)) {
			throw new ContactNotFoundException("Contact not found with id: "+id);
		}
		contactRepository.deleteById(id);
	}

	@Override
	public List<ContactDTO> searchContactsByName(String name) {
		
		return contactRepository.findByNameContainingIgnoreCase(name)
				.stream().map(mapper::toDTO).toList();
	}

	@Override
	public List<ContactDTO> searchContactsByAddress(String address) {
		
		return contactRepository.findByAddress(address).stream().map(mapper::toDTO).toList();
	}

	@Override
	public ContactDTO searchContactsByEmail(String email) {
		Contact contact = contactRepository.findByEmail(email).orElseThrow(()-> new ContactNotFoundException("Contact not found with email: "+email));
		
		return mapper.toDTO(contact);
	}

	@Override
	public ContactDTO toggleFavorite(Long id) {

	    Contact contact = contactRepository.findById(id)
	            .orElseThrow(() ->
	                new ContactNotFoundException(
	                    "Contact not found with id: " + id
	                )
	            );

	    contact.setFavorite(!contact.isFavorite());

	    Contact updatedContact = contactRepository.save(contact);

	    return mapper.toDTO(updatedContact);
	}

	@Override
	public List<ContactDTO> getFavoriteContacts() {
		return contactRepository.findByFavoriteTrue().stream().map(mapper::toDTO).toList();
	}
	
	
}
