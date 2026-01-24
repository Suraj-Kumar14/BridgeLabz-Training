package com.streams.objectserialization;

import java.io.*;

public class SaveAndRetriveObject {

	public static void main(String[] args) {
		Employee employee=new Employee("Allu",101,"CSE",25000);
		
		//serialization
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("employee.ser"))){
			
			oos.writeObject(employee);
			System.out.println("Object serialized successfully.");
			
		}  catch (IOException e) {
			System.out.println("File not found!");
		}
		
		//Deserialization
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("employee.ser"))){
			
			Employee deserilizedEmployee=(Employee) ois.readObject();
			System.out.println("Deserialized object: "+deserilizedEmployee);
			
		} catch (IOException e) {			
			System.out.println("IO Error occured!");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found!");
		}
	}

}
