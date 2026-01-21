package com.addressbooksystem;

import java.util.*;

class AddressBookApplication {
    private List<Contact> contacts;

    public AddressBookApplication() {
        contacts = new ArrayList<>();
    }

    // Add contact with duplicate validation
    public void addContact(Contact contact) {
        for (Contact c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(contact.getFirstName()) &&
                c.getLastName().equalsIgnoreCase(contact.getLastName())) {
                System.out.println("Duplicate contact found. Cannot add.");
                return;
            }
        }
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    // Edit contact by name
    public void editContact(String firstName, String lastName, Contact updatedContact) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);
            if (c.getFirstName().equalsIgnoreCase(firstName) &&
                c.getLastName().equalsIgnoreCase(lastName)) {
                contacts.set(i, updatedContact);
                System.out.println("Contact updated successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Delete contact by name
    public void deleteContact(String firstName, String lastName) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact c = iterator.next();
            if (c.getFirstName().equalsIgnoreCase(firstName) &&
                c.getLastName().equalsIgnoreCase(lastName)) {
                iterator.remove();
                System.out.println("Contact deleted successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Search by city or state
    public void searchByCityOrState(String keyword) {
        for (Contact c : contacts) {
            if (c.getAddress() != null &&
               (c.getAddress().getCity().equalsIgnoreCase(keyword) ||
                c.getAddress().getState().equalsIgnoreCase(keyword))) {
                System.out.println(c);
            }
        }
    }

    // Display all contacts sorted alphabetically
    public void displayContacts() {
        contacts.sort(Comparator.comparing(Contact::getFirstName)
                                .thenComparing(Contact::getLastName));
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}