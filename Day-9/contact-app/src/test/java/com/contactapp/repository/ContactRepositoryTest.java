package com.contactapp.repository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.contactapp.entity.Contact;

@DataJpaTest
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    void shouldSaveContactSuccessfully() {

        Contact contact = new Contact();

        contact.setName("Ankur Verma");
        contact.setPhone("9876789843");
        contact.setEmail("ankur@gmail.com");
        contact.setAddress("Noida");

        Contact savedContact = contactRepository.save(contact);

        assertNotNull(savedContact.getId());
        assertEquals("Ankur Verma", savedContact.getName());
        assertEquals("9876789843", savedContact.getPhone());
        assertEquals("ankur@gmail.com", savedContact.getEmail());
        assertEquals("Noida", savedContact.getAddress());
    }
    
    @Test
    void shouldFindContactByIdSuccessfully() {

        Contact contact = new Contact();

        contact.setName("Ankur Verma");
        contact.setPhone("9876789843");
        contact.setEmail("ankur@gmail.com");
        contact.setAddress("Noida");

        Contact savedContact = contactRepository.save(contact);

        Optional<Contact> result =
                contactRepository.findById(savedContact.getId());

        assertTrue(result.isPresent());
        assertEquals("Ankur Verma", result.get().getName());
        assertEquals("9876789843", result.get().getPhone());
    }
    
    @Test
    void shouldFindAllContactsSuccessfully() {

        Contact contact1 = new Contact();

        contact1.setName("Ankur Verma");
        contact1.setPhone("9876789843");
        contact1.setEmail("ankur@gmail.com");
        contact1.setAddress("Noida");

        Contact contact2 = new Contact();

        contact2.setName("Rahul Kumar");
        contact2.setPhone("9876543210");
        contact2.setEmail("rahul@gmail.com");
        contact2.setAddress("Bhopal");

        contactRepository.save(contact1);
        contactRepository.save(contact2);

        List<Contact> contacts = contactRepository.findAll();

        assertEquals(2, contacts.size());
        assertEquals("Ankur Verma", contacts.get(0).getName());
        assertEquals("Rahul Kumar", contacts.get(1).getName());
    }
}