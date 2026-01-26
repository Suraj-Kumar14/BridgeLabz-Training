package com.reflectionandannotations.reflection.retrieveannotations;

public class Reflection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class<Book>cls=Book.class;
		
		if(cls.isAnnotationPresent(Author.class)) {
			
			Author author=cls.getAnnotation(Author.class);
			
			System.out.println("Author Name: "+author.name());
		}
	}

}
