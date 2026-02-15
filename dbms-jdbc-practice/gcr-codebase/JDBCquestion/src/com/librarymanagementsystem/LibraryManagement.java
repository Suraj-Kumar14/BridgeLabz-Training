package com.librarymanagementsystem;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryManagement {
	
	SingletonDBConnection connection=SingletonDBConnection.getInstance();
	
	//add student
	public void addStudent(StudentDTO student) throws SQLException {
		String sql="INSERT INTO student (student_name,department) VALUES (?,?)";
		
		PreparedStatement ps=connection.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, student.getStudent_name());
		ps.setString(2, student.getDepartment());
		
		int rows=ps.executeUpdate();
		if(rows>0) {
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()) {
				int id=rs.getInt(1);
				student.setStudentId(id);
				System.out.println("Employee added with id: "+id);
			}
		}
		
	}
	
	//add book
	public void addBook(BookDTO book)throws SQLException {
		String sql="INSERT INTO book (title,author,category,total_copies,available_copies)VALUES (?,?,?,?,?)";
	
		PreparedStatement ps=connection.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, book.getBookTitle());
		ps.setString(2, book.getAuthor());
		ps.setString(3, book.getCategory());
		ps.setLong(4, book.getTotal_copies());
		ps.setLong(5, book.getAviable_copies());
	
		int rows=ps.executeUpdate();
	
		if(rows>0) {
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()) {
				int id=rs.getInt(1);
				book.setBookId(id);
				System.out.println("Book added with bookId: "+id);
			}
		}	
	}
	
	//borrow book
	public void borrowBook(BorrowDTO borrow) throws SQLException {
		String sql="SELECT available_copies FROM book WHERE book_id=? ";
		PreparedStatement checkPs=connection.getConnection().prepareStatement(sql);
		
		checkPs.setInt(1, borrow.getBookId());
		
		ResultSet rs=checkPs.executeQuery();
		if(rs.next() && rs.getInt("available_copies")>0 ) {
			String insertSql="INSERT INTO borrow_record(student_id,book_id,borrow_date,due_date,return_date,fine) VALUES (?,?,?,?,NULL,?)";
			PreparedStatement insertPs=connection.getConnection().prepareStatement(insertSql,Statement.RETURN_GENERATED_KEYS);
			insertPs.setInt(1,borrow.getStudentId());
			insertPs.setInt(2, borrow.getBookId());
			insertPs.setDate(3, borrow.getBorrowDate());
			insertPs.setDate(4, borrow.getDueDate());
			insertPs.setBigDecimal(5, new BigDecimal("0.0"));
			
			int rows=insertPs.executeUpdate();
			if(rows>0) {
				ResultSet rs1=insertPs.getGeneratedKeys();
				if(rs1.next()) {
					int id=rs1.getInt(1);
					borrow.setBorrowId(id);
					System.out.println("Book Borrowed Successfully with id: "+id);
				}
			}
			String updateSql="UPDATE book SET available_copies=available_copies-1 WHERE book_id=?";
			
			PreparedStatement updatePs=connection.getConnection().prepareStatement(updateSql);
			
			updatePs.setInt(1, borrow.getBookId());
			
			updatePs.executeUpdate();
					
		}	else {
			System.out.println("Book not available");
		}
	}
	
	//return book
	public void returnBook(int borrowId) throws SQLException {
		String sql="SELECT due_date, book_id FROM borrow_record WHERE borrow_id=?";
		PreparedStatement ps=connection.getConnection().prepareStatement(sql);
		ps.setInt(1, borrowId);
		
		ResultSet rs=ps.executeQuery();
		
		
		if(rs.next()) {
			LocalDate dueDate=rs.getDate("due_date").toLocalDate();
			LocalDate returnDate=LocalDate.now();
			int bookId=rs.getInt("book_id");
			
			long lateDays=ChronoUnit.DAYS.between(dueDate, returnDate);
			double fine=(lateDays>0)?lateDays*10:0;
			
			String updateSql="UPDATE borrow_record SET return_date=?,fine=? WHERE borrow_id=?";
			PreparedStatement ups=connection.getConnection().prepareStatement(updateSql);
			
			ups.setDate(1,Date.valueOf(returnDate));
			ups.setDouble(2, fine);
			ups.setInt(3, borrowId);
			
			ups.executeUpdate();
			
			System.out.println("Book returned. Fine=Rs "+fine);
		}
		System.out.println("Invalid borrow ID. No such record found.");
	}
}
