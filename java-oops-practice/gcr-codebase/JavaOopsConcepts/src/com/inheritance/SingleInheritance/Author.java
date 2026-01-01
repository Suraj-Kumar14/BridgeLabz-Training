package com.inheritance.SingleInheritance;

public class Author extends Book {
		public String name;
		public String bio;
		
		//constructor
		public Author(String title,int publicationYear,String name,String bio) {
			super(title,publicationYear);
			this.name=name;
			this.bio=bio;
		}
		
		@Override
		public void displayInfo() {
			super.displayInfo();
			System.out.println("Author name: "+name);
			System.out.println("Author Bio: "+bio);
		}

}
