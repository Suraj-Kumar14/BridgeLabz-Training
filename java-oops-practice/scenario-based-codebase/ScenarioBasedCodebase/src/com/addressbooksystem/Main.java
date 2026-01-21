package com.addressbooksystem;

public class Main {
	    public static void main(String[] args) {
	        AddressBookApplication book = new AddressBookApplication();

	        Address addr1 = new Address("Bhopal", "Madhya Pradesh", "462001");
	        Contact c1 = new Contact("Suraj", "Kumar", "9876543210", "suraj@email.com", addr1);

	        Address addr2 = new Address("Delhi", "Delhi", "110001");
	        Contact c2 = new Contact("Amit", "Sharma", "9123456780", "amit@email.com", addr2);

	        book.addContact(c1);
	        book.addContact(c2);

	        System.out.println("\nAll Contacts:");
	        book.displayContacts();

	        System.out.println("\nSearch by City 'Bhopal':");
	        book.searchByCityOrState("Bhopal");

	        System.out.println("\nEditing Suraj Kumar...");
	        Address newAddr = new Address("Indore", "Madhya Pradesh", "452001");
	        Contact updated = new Contact("Suraj", "Kumar", "9999999999", "suraj.new@email.com", newAddr);
	        book.editContact("Suraj", "Kumar", updated);

	        System.out.println("\nAll Contacts After Edit:");
	        book.displayContacts();

	        System.out.println("\nDeleting Amit Sharma...");
	        book.deleteContact("Amit", "Sharma");

	        System.out.println("\nFinal Contacts:");
	        book.displayContacts();
	    }
}



