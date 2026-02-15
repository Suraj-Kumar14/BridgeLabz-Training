package com.librarymanagementsystem;

import java.sql.*;

public class BorrowDTO {

    private int borrowId;
    private int studentId;
    private int bookId;
    private Date borrowDate;
    private Date dueDate;
    private Date returnDate;
    private double fine;
     

    public BorrowDTO(int studentId, int bookId, Date borrowDate, Date dueDate) {
		super();
		this.studentId = studentId;
		this.bookId = bookId;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
	}
    
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public Date getBorrowDate() { return borrowDate; }
    public void setBorrowDate(Date borrowDate) { this.borrowDate = borrowDate; }

    public Date getDueDate() { return dueDate; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

	public void setBorrowId(int id) {
		this.borrowId=id;		
	}

}