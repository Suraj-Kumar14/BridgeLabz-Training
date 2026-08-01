-- Health Clinic App

-- DDL Operations

-- Create a new Database HealthClinicDB
CREATE DATABASE HealthClinicDB;

-- Use HealthClinicDB Database 
USE HealthClinicDB;

-- Create the Doctor Table
CREATE TABLE Doctor(
    DoctorID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName  VARCHAR(50) NOT NULL,
    Specialization VARCHAR(100) NOT NULL,
    Phone VARCHAR(15) UNIQUE,
    CreatedOn DATETIME DEFAULT CURRENT_TIMESTAMP
    );

-- Modify Structure and Add one more column to the Doctor Table
ALTER TABLE Doctor 
ADD Email VARCHAR(100) UNIQUE;


-- DML Operations

-- Insert data to the Doctor tables
INSERT INTO Doctor(FirstName,LastName,Specialization, Phone,Email)
	VALUES('Arun','Kumar','Physician','7845954854','Arun123@gmail.com'),
	      ('Suraj','Kumar','Cardiologist','6258487845','suraj123@gmail.com');

    
-- Read Doctor details based on Specialization
SELECT DoctorID, FirstName, LastName,Phone,Email 
FROM DOCTOR 
WHERE Specialization='Physician';


-- Update Doctor Phone number
UPDATE Doctor
SET Phone='9878542654'
WHERE DoctorID=1;


-- Delete a Doctor details from database
DELETE FROM Doctor
WHere DoctorID=1;