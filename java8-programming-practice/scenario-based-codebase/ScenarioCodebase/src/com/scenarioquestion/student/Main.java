package com.scenarioquestion.student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		StudentDataList list=new StudentDataList();
		
		list.addStudent(new Student("Sonu kumar",101,"Sonu",21,"Male","Bihar",21,"7845784574","Mechanical Engineering"));
		list.addStudent(new Student("Allu arjun",103,"Allu",30,"Male","Tamilnadu",154,"9569564574","Electronics Engineering"));
		list.addStudent(new Student("Mohit kumar",102,"Mohit",28,"Male","patna",56,"4578454515","Biotech Engineering"));
		list.addStudent(new Student("Anjali kumari",106,"Anjali",24,"Female","Bhopal",17,"9854554574","Civil Engineering"));
		list.addStudent(new Student("Ravi Raj",105,"Ravi",23,"Male","Nawada",78,"9857454574","Computer Engineering"));
		list.addStudent(new Student("supriya kumari",107,"Supriya",21,"Female","Karnataka",97,"7645623574","Electronics Engineering"));
		list.addStudent(new Student("Sonali kumari",104,"Sonali",31,"Female","Noida",75,"7845784574","Mechanical Engineering"));
		list.addStudent(new Student("Suhani kumari",108,"Suhani",29,"Female","Goa",67,"7845784574","Biotech Engineering"));
		list.addStudent(new Student("Vansh Raj",110,"Vansh",27,"Male","Kerala",221,"7845784574","Civil Engineering"));
		list.addStudent(new Student("Anmol kumar",109,"Anmol",26,"Male","Mumbai",47,"7845784574","Computer Engineering"));
		list.addStudent(new Student("Vedika pathak",112,"Vedika",22,"Female","Delhi",89,"7845784574","Electronics Engineering"));
		list.addStudent(new Student("Payal gawande",111,"Payal",25,"Female","Ujjain",91,"7845784574","Civil Engineering"));
		list.addStudent(new Student("Sonu",113,"Sonu",27,"Male","Delhi",24,"7844784574","ComputerEngineering"));
		
		
		/*  ***Basic Filtering & Mapping

			1.Print all students whose rank is less than 50.
			
			2.Print all students whose age is greater than 25.
			
			3.Print the names of all students only.
			
			4.Print all students belonging to Mechanical Engineering.
			
			5.Print all students not from Mumbai.
		*/
		System.out.println("\n\n---------------- Basic Filtering & Mapping Problems---------------------");
		
		System.out.println("\n1.Print all students whose rank is less than 50.");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		List<Student>stud=list.students.stream().filter(e->e.getRank()<50).collect(Collectors.toList());
		stud.forEach(System.out::println);
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		
		
		
		System.out.println("\n2.Print all students whose age is greater than 25.");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		list.students.stream().filter(e->e.getAge()>25).forEach(System.out::println);		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		
		
		
		System.out.println("\n3.Print the names of all students only.");
		System.out.println("-------------------------------------------");
		list.students.stream().map(Student::getName).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("-------------------------------------------");
		
		
		System.out.println("\n4.Print all students belonging to Mechanical Engineering.");
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		list.students.stream().filter(e->e.getDepartment().equalsIgnoreCase("mechanical engineering")).forEach(System.out::println);
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
		
		System.out.println("\n5.Print all students not from Mumbai.");
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		list.students.stream().filter(e->e.getCity().equalsIgnoreCase("mumbai")).forEach(System.out::println);
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
				
		/*  *** Sorting & Limiting
		  
			1.Sort students by rank (ascending).
			
			2.Sort students by age (descending).
			
			3.Print top 5 students based on rank.
			
			4.Print last 3 students based on rank.
			
			5.Print students sorted by name and then rank.					  
		 */
		System.out.println("\n\n---------------- Sorting & Limiting Problems---------------------");
		
		System.out.println("\n1.Sort students by rank (ascending).");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		list.students.stream()						
						.sorted(Comparator.comparingInt(Student::getRank))
						.collect(Collectors.toList())
						.forEach(s->System.out.println(s.getName()+", Rank: "+s.getRank()));;
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		
		
		
		System.out.println("\n2.Sort students by age (descending).");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		list.students.stream()
						.sorted(Comparator.comparingInt(Student::getAge).reversed())
						.forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------------------------------------------------------- ");
		
		
		
		System.out.println("\n3.Print top 5 students based on rank.");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		list.students.stream()
						.sorted(Comparator.comparingInt(Student::getRank))
						.limit(5)
						.forEach(System.out::println);
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
		
		
		System.out.println("\n4.Print last 3 students based on rank.");
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		list.students.stream()
						.sorted(Comparator.comparingInt(Student::getRank).reversed())
						.limit(3)
						.forEach(System.out::println);
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
		
		
		System.out.println("\n5.Print students sorted by name and then rank.");
		System.out.println("--------------------------------------------------------------------------------------------------------------------- ");
		list.students.stream()
						.sorted(Comparator.comparing(Student::getName).thenComparing(Student::getRank))
						.forEach(System.out::println);
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
		
		/*
		 	*** Grouping & Aggregation

				1.Count the number of students in each department.
				
				2.Count the number of students in each city.
				
				3.Find the average age of students in each department.
				
				4.Find the average rank of students by gender.
				
				5.Find the total number of students in the organization.
				
				6.Find the department with the highest average rank.
		 */
		
		System.out.println("\n\n---------------- Grouping & Aggregation Problems---------------------");
		
		System.out.println("\n1.Count the number of students in each department.");
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		Map<String, Long> map = list.students.stream()
											.collect(Collectors.groupingBy(Student::getDepartment,Collectors.counting()));
		
		map.forEach((key, value) -> System.out.println(key + " - " + value));
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
							
		
		System.out.println("\n2.Count the number of students in each city.");
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		Map<String,Long>cities=list.students.stream()
											.collect(Collectors.groupingBy(Student::getCity,Collectors.counting()));
		
		cities.forEach((key,value)->System.out.println(key+" - "+value));
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		
		
		System.out.println("\n3.Find the average age of students in each department.");
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		list.students.stream()
					.collect(Collectors.groupingBy(Student::getDepartment,Collectors.averagingDouble(Student::getAge))).forEach((d,a)->System.out.println(d+"- "+a));
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		
		
		System.out.println("\n5.Find the total number of students in the organization.");
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println(list.students.stream()
											.count());
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		
		
		System.out.println("\n6.Find the department with the highest average rank.");
		System.out.println("--------------------------------------------------------------------------------------------------------------------");
		System.out.println(list.students.stream()
											.max(Comparator.comparing(Student::getRank)).get().getDepartment());
		System.out.println("--------------------------------------------------------------------------------------------------------------------");
	
		
		
		/*
		        *** Min / Max / Ranking Problems

				1.Find the student with the best (lowest) rank.
				
				2.Find the student with the worst (highest) rank.
				
				3.Find the second best rank holder.
				
				4.Find the third best rank holder.
				
				5.Find the youngest student.
				
				6.Find the oldest student.
		 */
		System.out.println("\n\n---------------- Min / Max / Ranking Problems---------------------");
		
		System.out.println("\n1.Find the student with the best (lowest) rank.");
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		//System.out.println(list.students.stream().sorted(Comparator.comparingInt(Student::getRank)).findFirst().get());
		System.out.println(list.students.stream().min(Comparator.comparing(Student::getRank)).get());
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		
		
		System.out.println("\n2.Find the student with the worst (highest) rank.");
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		System.out.println(list.students.stream().max(Comparator.comparing(Student::getRank)).get());
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		
		
		System.out.println("\n3.Find the second best rank holder.");
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		System.out.println(list.students.stream()
											.sorted(Comparator.comparing(Student::getRank))
											.skip(1)
											.findFirst()
											.get());
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		
		
		
		System.out.println("\n4.Find the third best rank holder.");
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		Student thirdRank=list.students.stream()
							.sorted(Comparator.comparing(Student::getRank)).skip(2).findFirst().get();
		
		System.out.println(thirdRank);
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		
		
		System.out.println("\n5.Find the youngest student.");
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		Student youngest=list.students.stream()
										.min(Comparator.comparing(Student::getAge)).get();
		System.out.println(youngest);
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		
		
		System.out.println("\n6.Find the oldest student.");
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		Student oldest=list.students.stream()
										.max(Comparator.comparing(Student::getAge)).get();
		System.out.println(oldest);
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		
				
		/*
				  **** FlatMap & Collections
				
				1.Print all contact numbers of all students.
				
				2.Count the total number of contact numbers.
				
				3.Find students who have more than one contact number.
				
				4.Print unique contact numbers.
		 */
		
		
		System.out.println("\n\n---------------- FlatMap & Collections Problems---------------------");
		
		System.out.println("\n1.Print all contact numbers of all students.");
		System.out.println("---------------------------------------------------------");
		list.students.stream()
						.flatMap(student->Stream.of(student.getContacts()))
						.forEach(System.out::println);
		System.out.println("---------------------------------------------------------");
		
		
		System.out.println("\n2.Count the total number of contact numbers.");
		System.out.println("---------------------------------------------------------");
		System.out.println(list.students.stream().flatMap(student->Stream.of(student.getContacts())).count());
		System.out.println("---------------------------------------------------------");
		
		
		System.out.println("\n3.Find students who have more than one contact number.");
		System.out.println("---------------------------------------------------------");
//		list.students.stream()
//						.filter(s->s.getContacts().size()>1)
//						.collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("---------------------------------------------------------");
		
		
		System.out.println("\n4.Print unique contact numbers.");
		System.out.println("---------------------------------------------------------");
		list.students.stream()
						.flatMap(student->Stream.of(student.getContacts()))
						.distinct()
						.collect(Collectors.toList())
						.forEach(System.out::println);
		System.out.println("---------------------------------------------------------");
						
				
		/*
		 	*** Conditional & Matching

				1.Check if any student belongs to Biotech Engineering.
				
				2.Check if all students are above age 20.
				
				3.Check if no student belongs to Civil Engineering.
		 */
					
		
		System.out.println("\n\n---------------------------- Conditional & Matching-------------------------------------------");
		
		System.out.println("\n1.Check if any student belongs to Biotech Engineering.");
		System.out.println("---------------------------------------------------------------------------------------------------");
//		list.students.stream()
//						.filter(s->s.getDepartment().equalsIgnoreCase("Biotech Engineering"))
//						.forEach(System.out::println);
		
		boolean found=list.students.stream()
						.anyMatch(student->student.getDepartment().equalsIgnoreCase("Biotech Engineering"));
		
		if (found) {
            System.out.println("At least one student belongs to Biotech Engineering.");
        } else {
            System.out.println("No student belongs to Biotech Engineering.");
        }		
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		
		
		System.out.println("\n2.Check if all students are above age 20.");
		System.out.println("----------------------------------------------------------------------------------------------------");
		boolean found1=list.students.stream().allMatch(s->s.getAge()>20);
		
		if(found1) {
			System.out.println("All students are above age 20.");
		}else {
			System.out.println("Not all students are above age 20.");
		}
		System.out.println("----------------------------------------------------------------------------------------------------");
		
		
		System.out.println("\n3.Check if no student belongs to Civil Engineering.");
		System.out.println("----------------------------------------------------------------------------------------------------");
		boolean checkCivil=list.students.stream().noneMatch(s->s.getDepartment().equalsIgnoreCase("Civil Engineering"));
		if(checkCivil) {
			System.out.println("No student belongs to civil engineering.");
		}else {
			System.out.println("At least one student belongs to civil engineering");
		}
		System.out.println("----------------------------------------------------------------------------------------------------");
		
		
		/*
		 	*** Gender-Based Analysis

				1.Count male and female students.
				
				2.Find the average age of male students.
				
				3.Find the average age of female students.
				
				4.Find the highest ranked male student.
				
				5.Find the highest ranked female student.
		 */
		
		System.out.println("\n\n-----------------Gender-Based Analysis----------------------");
		
		System.out.println("\n1.Count male and female students.");
		System.out.println("-------------------------------------------------------------");
		System.out.println(list.students.stream()
											.collect(Collectors.groupingBy(Student::getGender,Collectors.counting())));
		System.out.println("-------------------------------------------------------------");
		
		
		System.out.println("\n2.Find the average age of male students.");
		System.out.println("-------------------------------------------------------------");
		double averageAge=list.students.stream()
										.filter(s->s.getGender().equalsIgnoreCase("male"))
										.mapToInt(s->s.getAge())
										.average()
										.orElse(0);
		System.out.println("Average age of male student: "+averageAge);
		System.out.println("--------------------------------------------------------------");
		
		
		System.out.println("\n3.Find the average age of female students.");
		System.out.println("--------------------------------------------------------------");
		double femaleAverageAge=list.students.stream()
												.filter(s->s.getGender().equalsIgnoreCase("female"))
												.mapToDouble(s->s.getAge())
												.average()
												.orElse(0);
		System.out.println("Avergae age of female students: "+femaleAverageAge);
		System.out.println("--------------------------------------------------------------");
		
		
		System.out.println("\n4.Find the highest ranked male student.");
		System.out.println("--------------------------------------------------------------");
		int maleHighestRank=list.students.stream()
											.filter(s->s.getGender().equalsIgnoreCase("male"))
											.mapToInt(s->s.getRank())
											.min()											
											.orElse(0);
		System.out.println("Highest rank of male student: "+maleHighestRank);	
		System.out.println("--------------------------------------------------------------");
		
		
		System.out.println("\n5.Find the highest ranked female student.");
		System.out.println("--------------------------------------------------------------");
		int femaleHighestRank=list.students.stream()
											.filter(s->s.getGender().equalsIgnoreCase("female"))
											.mapToInt(s->s.getRank())
											.min()
											.orElse(0);
		System.out.println("Highest rank of female student: "+femaleHighestRank);
		System.out.println("--------------------------------------------------------------");
		
		
		/*
		 	*** Department-Specific Queries

				1.List students department-wise with names only.
				
				2.Find the youngest student in Computer Engineering.
				
				3.Find the top-ranked student in Mechanical Engineering.
				
				4.Count students in Electronics Engineering from Karnataka.
		 */
		
		System.out.println("\n\n-------------------Department-Specific Queries-------------------");
		System.out.println("\n1.List students department-wise with names only.");
		System.out.println("---------------------------------------------------------------------");
		list.students.stream()
							.collect(Collectors.groupingBy(Student::getDepartment,Collectors.mapping(Student::getName,Collectors.toList())))
							.forEach((k,v)->System.out.println(k+" - "+v));
		System.out.println("---------------------------------------------------------------------");
		
		
		System.out.println("\n2.Find the youngest student in Computer Engineering.");
		System.out.println("---------------------------------------------------------------------");
		System.out.println(list.students.stream()
										.filter(s->s.getDepartment().equalsIgnoreCase("Computer engineering"))
										.min(Comparator.comparing(Student::getAge))
										.get()
										.getName()
										);	
		System.out.println("--------------------------------------------------------------------");
		
		
		
		System.out.println("\n3.Find the top-ranked student in Mechanical Engineering.");
		System.out.println("--------------------------------------------------------------------");
		System.out.println(list.students.stream()
										.filter(s->s.getDepartment().equalsIgnoreCase("mechanical engineering"))
										.min(Comparator.comparing(Student::getRank))
										.get()
										.getName());
		System.out.println("--------------------------------------------------------------------");
		
		
		
		System.out.println("\n4.Count students in Electronics Engineering from Karnataka.");
		System.out.println("--------------------------------------------------------------------");
		System.out.println(list.students.stream()
						.filter(s->s.getDepartment().equalsIgnoreCase("electronics engineering"))
						.filter(s->s.getCity().equalsIgnoreCase("karnataka"))
						.count()
						);
		System.out.println("--------------------------------------------------------------------");
		
		
		/*
			***  Advanced Level
		
					1.Convert the student list into a Map<Id, Name>.
					
					2.Convert the student list into a Map<Department, List<Student>>.
					
					3.Find students whose name starts with ‘S’.
					
					4.Find students whose name length is greater than 5.
					
					5.Find students whose rank is even.
					
					6.Find students whose rank is odd. 
		 */
		
		
		System.out.println("\n\n--------------------------Advanced Level--------------------------");
		
		System.out.println("\n1.Convert the student list into a Map<Id, Name>.");
		System.out.println("---------------------------------------------------------------------");
		Map<Integer,String>mapIdName=list.students.stream()
													.collect(Collectors.toMap(Student::getId,Student::getName));
		
		mapIdName.forEach((id,name)->System.out.println(id+"--"+name));
		System.out.println("---------------------------------------------------------------------");
		
		
		System.out.println("\n2.Convert the student list into a Map<Department, List<Student>>.");
		System.out.println("---------------------------------------------------------------------");
		Map<String,List<Student>>mapNestedList=list.students.stream()
															.collect(Collectors.groupingBy(Student::getDepartment,Collectors.toList()));
		mapNestedList.forEach((k,v)->System.out.println(k+" - "+v));
		System.out.println("---------------------------------------------------------------------");
		
		
		System.out.println("\n3.Find students whose name starts with ‘S’.");
		System.out.println("---------------------------------------------------------------------");
		list.students.stream().filter(s->s.getFirstName().startsWith("S")).forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------");
		
		
		System.out.println("\n4.Find students whose name length is greater than 5.");
		System.out.println("---------------------------------------------------------------------");
		list.students.stream().filter(s->s.getName().length()>5).forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------");
		
		
		System.out.println("\n5.Find students whose rank is even.");
		System.out.println("---------------------------------------------------------------------");
		list.students.stream().filter(s->s.getRank()%2==0).forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------");
		
		
		System.out.println("\n6.Find students whose rank is odd.");
		System.out.println("---------------------------------------------------------------------");
		list.students.stream().filter(s->s.getRank()%2!=0).forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------");
	
	
		/*
		  	*** Bonus Challenges

				1.Find the top 3 youngest students.
				
				2.Find the top 3 oldest students.
				
				3.Partition students based on age > 25.
				
				4.Partition students based on rank < 100.
				
				5.Find the city having maximum students.
				
				6.Find the department having minimum students.
		 */
	
			System.out.println("\n\n-----------------------------Bonus Challenges----------------------------");
			
			System.out.println("\n1.Find the top 3 youngest students.");
			System.out.println("------------------------------------------------------------------------------");
			list.students.stream()
							.sorted(Comparator.comparing(Student::getAge))
							.limit(3)
							.forEach(System.out::println);
			System.out.println("------------------------------------------------------------------------------");
			
			
			System.out.println("\n2.Find the top 3 oldest students.");
			System.out.println("------------------------------------------------------------------------------");
			list.students.stream()
							.sorted(Comparator.comparing(Student::getAge).reversed())
							.limit(3)
							.forEach(System.out::println);
			System.out.println("------------------------------------------------------------------------------");
			
			
			System.out.println("\n3.Partition students based on age > 25.");
			System.out.println("------------------------------------------------------------------------------");
			Map<Boolean,List<Student>>partitioned=list.students.stream()
							.collect(Collectors.partitioningBy(s->s.getAge()>25));
			
//			System.out.println("Age >25: "+partitioned.get(true));//
//			System.out.println("Age <=25: "+partitioned.get(true));
			
			System.out.println("Age >25:=");			
			partitioned.get(true).forEach(System.out::println);
			System.out.println("Age <=25:=");
			partitioned.get(false).forEach(System.out::println);
			System.out.println("------------------------------------------------------------------------------");
			
			
			System.out.println("\n4.Partition students based on rank < 100.");
			System.out.println("------------------------------------------------------------------------------");
			Map<Boolean,List<Student>>partitionByRank=list.students.stream()
																	.collect(Collectors.partitioningBy(s->s.getRank()<100));
			
			System.out.println("--Rank <100 --");
			partitionByRank.get(true).forEach(System.out::println);
			System.out.println("-- Rank >=100 --");
			partitionByRank.get(false).forEach(System.out::println);
			System.out.println("------------------------------------------------------------------------------");
			
			
			System.out.println("\n5.Find the city having maximum students.");
			System.out.println("-----------------------------------------------------------------------------");
			list.students.stream()
							.collect(Collectors.groupingBy(Student::getCity,Collectors.counting()))
							.entrySet()
							.stream()
							.max(Map.Entry.comparingByValue())
							.ifPresent(e->System.out.println(e.getKey()));
			System.out.println("-----------------------------------------------------------------------------");
							
							
			System.out.println("\n6.Find the department having minimum students.");
			System.out.println("-----------------------------------------------------------------------------");
			list.students.stream()
							.collect(Collectors.groupingBy(Student::getDepartment,Collectors.counting()))
							.entrySet()
							.stream()
							.min(Map.Entry.comparingByValue())
							.ifPresent(e->System.out.println(e.getKey()));
			System.out.println("-----------------------------------------------------------------------------");

			
	
	
	
	
	
	
	
	
	}

}
