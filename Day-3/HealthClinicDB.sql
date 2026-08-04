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
    
-- Read Doctor details based on Specialization
SELECT DoctorID, FirstName, LastName,Phone,Email 
FROM DOCTOR 
WHERE Specialization='General Physician';

SELECT * FROM Doctor;


-- Update Doctor Phone number
UPDATE Doctor
SET Phone='9878542654'
WHERE DoctorID=1;


-- Delete a Doctor details from database
DELETE FROM Doctor
WHere DoctorID=1;

-- Create the Department Table
CREATE TABLE Department(
	DepartmentId INT AUTO_INCREMENT PRIMARY KEY,
    DepartmentName VARCHAR(100) NOT NULL);

-- INSERT data into department table
INSERT INTO Department (DepartmentName)
	VALUES
	('General Medicine'),
	('Cardiology'),
	('Orthopedics'),
	('Neurology'),
	('Pediatrics');
    
    
-- Add DepartmentId column in Doctor table
ALTER TABLE Doctor
ADD DepartmentId INT;

-- Add foreign key reference in doctor
ALTER TABLE Doctor
ADD FOREIGN KEY(DepartmentId) REFERENCES Department(DepartmentId);

-- Insert data into doctor table
INSERT INTO Doctor
	(FirstName, LastName, Specialization, Phone, Email, DepartmentId)
	VALUES
	('Rohit','Sharma','General Physician','9876543210','rohit.sharma@gmail.com',1),
	('Priya','Verma','Cardiologist','9876543211','priya.verma@gmail.com',2),
	('Ankit','Singh','Orthopedic','9876543212','ankit.singh@gmail.com',3),
	('Neha','Gupta','Neurologist','9876543213','neha.gupta@gmail.com',4),
	('Rahul','Patel','Pediatrician','9876543214','rahul.patel@gmail.com',5),
	('Meena','Joshi','Cardiologist','9876543215','meena.joshi@gmail.com',2),
	('Vikas','Mishra','General Physician','9876543216','vikas.mishra@gmail.com',1),
	('Kavita','Shah','Orthopedic','9876543217','kavita.shah@gmail.com',3),
	('Deepak','Jain','Neurologist','9876543218','deepak.jain@gmail.com',4),
	('Pooja','Saxena','Pediatrician','9876543219','pooja.saxena@gmail.com',5);
 
-- Create the patient table
CREATE TABLE Patient (
PatientID INT AUTO_INCREMENT PRIMARY KEY,
FirstName VARCHAR(50) NOT NULL,
LastName VARCHAR(50) NOT NULL,
DateOfBirth DATE NOT NULL,
Gender CHAR(1) CHECK (Gender IN ('M','F','O')),
Phone VARCHAR(15) UNIQUE,
Address VARCHAR(200)
);

-- Insert data into patient table 
INSERT INTO Patient
	(FirstName, LastName, DateOfBirth, Gender, Phone, Address)
	VALUES
	('Aman','Kumar','1998-04-12','M','9000000001','Bhopal'),
	('Sneha','Verma','1995-06-18','F','9000000002','Indore'),
	('Ravi','Patel','1992-03-21','M','9000000003','Delhi'),
	('Pooja','Sharma','2000-01-15','F','9000000004','Mumbai'),
	('Arjun','Singh','1996-09-08','M','9000000005','Pune'),
	('Neha','Gupta','1994-07-11','F','9000000006','Nagpur'),
	('Vikas','Jain','1991-12-20','M','9000000007','Jaipur'),
	('Komal','Soni','1999-10-02','F','9000000008','Lucknow'),
	('Karan','Dubey','1997-08-14','M','9000000009','Kanpur'),
	('Riya','Mehta','2001-05-30','F','9000000010','Surat'),
	('Mohit','Yadav','1993-02-17','M','9000000011','Patna'),
	('Nidhi','Kapoor','1996-11-25','F','9000000012','Chandigarh'),
	('Saurabh','Mishra','1990-09-09','M','9000000013','Ranchi'),
	('Anjali','Rathore','1998-12-12','F','9000000014','Gwalior'),
	('Harsh','Gupta','1995-04-04','M','9000000015','Ujjain');

-- Create the appointment table
CREATE TABLE Appointment (
AppointmentID INT AUTO_INCREMENT PRIMARY KEY,
PatientID INT NOT NULL REFERENCES Patient(PatientID),
DoctorID INT NOT NULL REFERENCES Doctor(DoctorID),
AppointmentDate DATE NOT NULL,
TimeSlot TIME NOT NULL,
Status VARCHAR(20) DEFAULT 'Scheduled'
);


INSERT INTO Appointment
	(PatientID, DoctorID, AppointmentDate, TimeSlot, Status)
	VALUES
	(1,2,'2026-08-05','09:00:00','Scheduled'),
	(2,3,'2026-08-05','09:30:00','Completed'),
	(3,4,'2026-08-06','10:00:00','Scheduled'),
	(4,5,'2026-08-06','10:30:00','Cancelled'),
	(5,6,'2026-08-07','11:00:00','Completed'),
	(6,7,'2026-08-07','11:30:00','Scheduled'),
	(7,8,'2026-08-08','12:00:00','Scheduled'),
	(8,9,'2026-08-08','12:30:00','Completed'),
	(9,10,'2026-08-09','01:00:00','Scheduled'),
	(10,11,'2026-08-09','01:30:00','Scheduled'),
	(11,2,'2026-08-10','02:00:00','Completed'),
	(12,3,'2026-08-10','02:30:00','Scheduled'),
	(13,4,'2026-08-11','03:00:00','Cancelled'),
	(14,5,'2026-08-11','03:30:00','Scheduled'),
	(15,6,'2026-08-12','04:00:00','Completed'),
	(1,7,'2026-08-12','04:30:00','Scheduled'),
	(2,8,'2026-08-13','09:15:00','Completed'),
	(3,9,'2026-08-13','09:45:00','Scheduled'),
	(4,10,'2026-08-14','10:15:00','Scheduled'),
	(5,11,'2026-08-14','10:45:00','Completed');
    
    
CREATE INDEX idx_appointment_patient ON appointment(patientID);
CREATE INDEX idx_appointment_doctor ON appointment(doctorID);
CREATE INDEX idx_appointment_date ON appointment(AppointmentDate);


---------------------------
--  Operations On SQL
---------------------------

-- Find the patients whose name starts with 's'
SELECT * FROM patient
WHERE FirstName like 's%';

-- Find the patients whose name ends with 'a'
SELECT * FROM patient
WHERE lastName like '%a';

-- Retrieve first two patient whose name starts with 'a'
SELECT * FROM patient
WHERE FirstName LIKE 'a%'
LIMIT 2;

-- Find the patient who belongs to Pune
SELECT * FROM patient
WHERE address like 'pune';

SELECT * FROM patient
WHERE address='pune';

-- Show all patient name and Date of birth from the patient table
SELECT FirstName, DateOfBirth FROM patient;

-- Show details of patient whose DateOfBirth if before 1995
SELECT * FROM patient
WHERE DateOfBirth<'1995-01-01';

-- list all patient sorted by Date Of Birth
SELECT * FROM patient
ORDER BY DateOfBirth ASC;

-- Group the patient based on city
SELECT address, count(*) AS patientCount
 FROM patient
 GROUP BY Address;
 
 -- Display Address which has more then one patient
 SELECT address, COUNT(*) AS NoOfPatient
 FROM patient 
 GROUP BY address
 HAVING COUNT(*)>1;
 
-- Show patient name with their doctor name
SELECT p.FirstName AS PatientName , d.FirstName AS DoctorName
FROM appointment a
JOIN patient p on a.patientID=p.patientID
JOIN doctor d on a.doctorID=d.doctorID; 

-- Display only the doctor's first name and specialization.
SELECT FirstName,Specialization 
FROM Doctor;

-- Show all patients from Bhopal.
SELECT * FROM Patient
WHERE address='Bhopal';

-- Find all female patients.
SELECT * FROM Patient
WHere Gender='F';

-- Display all cardiologists.
SELECT * FROM Doctor
WHERE Specialization='cardiologist';

-- Show doctors whose phone number starts with '9876'.
SELECT * FROM Doctor
WHERE Phone LIKE '9876%';

-- Find patients born after 1998.
SELECT * FROM Patient
WHERE DateOfBirth>'1999-01-01';

-- Display appointments whose status is 'Scheduled'.
SELECT * FROM appointment
WHERE Status='Scheduled';

-- Show all unique addresses of patients.
SELECT DISTINCT address
FROM Patient;

-- Display doctors ordered by first name.
SELECT * FROM Doctor
ORDER BY FirstName;

-- Show doctors whose specialization contains "General".
SELECT * FROM Doctor
WHERE Specialization LIKE '%General%';

-- Find appointments after '2026-08-08'.
SELECT * FROM appointment
WHERE AppointmentDate>'2026-08-08';

-- Display patients not living in Delhi.
SELECT * FROM Patient
WHERE address!='Delhi';

-- Show all departments.
SELECT DepartmentName FROM Department;

-- Display all appointments.
SELECT * FROM appointment;

-- Display doctor emails only.
SELECT Email From Doctor;

-- Show appointment dates only.
SELECT AppointmentDate FROM appointment;


-- Display all Pediatricians.
SELECT * FROM doctor
WHERE Specialization='Pediatrician';

-- Find doctors whose email ends with gmail.com.
SELECT * FROM Doctor
WHERE Email LIKE '%gmail.com';

-- Find patient names containing "ra".
SELECT * FROM Patient
WHERE FirstName LIKE '%ra%';

-- Find addresses ending with "pur".
SELECT * FROM Patient
WHERE address LIKE '%pur';

-- Find doctors whose first name has exactly five letters.
SELECT * FROM Doctor
WHERE LENGTH(FirstName)=5;

-- Find patient names having second letter 'a'.
SELECT * FROM Patient
WHERE FirstName LIKE '_a%';

-- Display doctors ordered by first name.
SELECT * FROM doctor
order by FirstName;

-- Sort appointments by status.
SELECT * FROM appointment
ORDER BY status;

-- Count total doctors.
SELECT COUNT(*) FROM Doctor;

-- Count female patients.
SELECT COUNT(*) FROM Patient
WHERE Gender Like 'F';

-- Count patients city-wise.
SELECT address, COUNT(*) AS NoOfPatient
FROM Patient
group by address;

-- Count doctors department-wise.
SELECT Specialization, COUNT(*) AS NoOfDoctor
FROM Doctor
GROUP BY Specialization;

-- Count appointments doctor-wise.
SELECT d.DoctorID, CONCAT(d.FirstName,' ',d.LastName) As DoctorName,  COUNT(a.AppointmentID) AS NoOfAppointment
FROM Doctor d
LEFT JOIN appointment a ON a.DoctorID=d.DoctorID
GROUP BY d.DoctorID, d.FirstName, d.LastName;

-- Count appointments patient-wise.
SELECT p.PatientID, CONCAT(p.FirstName,' ',p.LastName),COUNT(a.appointmentID) AS NoOfAppointment
FROM Patient p
RIGHT JOIN appointment a ON p.PatientID=a.PatientID
GROUP BY p.PatientID;



-- Display cities having more than one patient.
SELECT address, COUNT(*) AS NoOfPatient
FROM Patient 
GROUP BY address
HavING COUNT(*)>1;


-- Display departments having more than one doctor.
SELECT Specialization, COUNT(*) AS TotalDepartment FROM doctor
GROUP BY Specialization
Having COunt(*)>1;

-- Display doctors having more than two appointments.
SELECT d.DoctorID, CONCAT(d.FirstName,' ',d.LastName), COUNT(a.AppointmentID) AS TotalAppointment
FROM Doctor d
LEFT JOIN  appointment a ON a.DoctorID=d.DoctorID
GROUP BY d.DoctorID
HAVING COUNT(a.AppointmentID)>2;

-- Show patient name with doctor name.
SELECT CONCAT(p.FirstName,' ',p.LastName) AS PatientName,CONCAT(d.FirstName,' ',d.LastName) AS DoctorName
FROM Patient p
INNER JOIN Appointment a ON p.PatientID=a.PatientID
INNER JOIN Doctor d ON a.DoctorID=d.DoctorID;

-- Show patient name, doctor name and appointment date.
SELECT CONCAT(p.FirstName,' ',p.LastName) AS PatientName, CONCAT(d.FirstName,' ',d.LastName) AS DoctorName, AppointmentDate
FROM appointment a
JOIN patient p ON a.patientID=p.patientID
JOIN Doctor d ON d.DoctorID=a.DoctorID;

-- Show doctor name with department name.
SELECT CONCAT(d.FirstName,' ',d.LastName) AS DoctorName, DepartmentName
From Doctor d
INNER JOIN Department dp ON d.DepartmentID=dp.DepartmentID;

-- Display patient name with doctor specialization.
SELECT CONCAT(p.FirstName,' ',p.LastName) As PatientName, d.Specialization AS Specialty
FROM Patient p
INNER JOIN appointment a ON a.PatientID=p.PatientID
INNER JOIN Doctor d ON d.DoctorID=a.DoctorID;

-- Display patient city and doctor's department.
SELECT p.address AS City, d.Specialization AS Department
FROM Patient p
INNER JOIN appointment a ON p.PatientID=a.PatientID
INNER JOIN Doctor d ON d.DoctorID=a.DoctorID;

-- Show complete appointment details.
SELECT CONCAT(p.FirstName,' ',p.LastName) AS PatientName, CONCAT(d.FirstName,' ',d.LastName) AS DoctorName, dp.DepartmentName AS Department, AppointmentDate, status
FROM appointment a
JOIN  Patient p ON a.PatientID=p.PatientID
JOIN Doctor d ON d.DoctorID=a.DoctorID
JOIN Department dp ON dp.DepartmentID=d.DepartmentID;

-- Show appointments of Cardiologists only.
 SELECT * FROM appointment a
 JOIN Doctor d ON a.DoctorID=d.DoctorID
 WHERE d.Specialization='Cardiologist';
 
 -- Show all appointments of General Physicians.
 SELECT * FROM appointment a
 JOIN Doctor d ON d.DoctorID=a.DoctorID
 WHERE d.Specialization='General Physician';
 
 -- Display appointments of patients living in Bhopal.
SELECT  a.AppointmentID,
CONCAT(p.FirstName, ' ', p.LastName) AS PatientName,
a.AppointmentDate,
a.Status
FROM Patient p
JOIN appointment a ON a.PatientID=p.PatientID
WHERE p.address='Bhopal';

-- Display doctor name with patient phone number.
SELECT CONCAT(d.FirstName,' ',d.LastName) AS DoctorName, p.Phone AS PatientPhoneNO
FROM Doctor d
JOIN appointment a ON a.DoctorID=d.DoctorID
JOIN Patient p ON p.PatientID=a.PatientID;

-- Show doctor email with department.
SELECT d.Email AS Email, dp.DepartmentName As Department
FROM Doctor d 
JOIN Department dp ON dp.DepartmentID=d.DepartmentID;

-- Show all doctors including those without appointments.
SELECT * FROM doctor d
LEFT JOIN appointment a ON d.DoctorID=a.DoctorID;

-- Show all patients including those who never booked an appointment.
SELECT * FROM Patient p 
LEFT JOIN appointment a ON p.PatientID=a.PatientID;

-- Show all departments even if no doctor belongs to them.
SELECT * FROM Department dp
Left join Doctor d ON d.DepartmentID=dp.DepartmentID;

-- Display all doctors and patient names if available.
SELECT CONCAT(d.FirstName,' ',d.LastName) AS DoctorName, CONCAT(p.FirstName,' ',p.LastName) AS PatientName
FROM Doctor d 
LEFT JOIN appointment a ON d.DoctorID=a.DoctorID
LEFT JOIN Patient p ON p.PatientID=a.PatientID;

-- Show all patients and their doctor names
SELECT  CONCAT(p.FirstName,' ',p.LastName) AS PatientName, CONCAT(d.FirstName,' ',d.LastName) AS DoctorName
FROM Patient p
LEFT JOIN appointment a ON a.PatientID=p.PatientID
LEFT JOIN Doctor d ON a.DoctorID=d.DoctorID;

-- Show all appointments even if doctor information is missing.
SELECT * FROM Doctor d
RIGHT JOIN appointment a ON a.DoctorID=d.DoctorID;

-- Display all departments with doctor names.
SELECT dp.DepartmentName, CONCAT(d.FirstName,' ',d.LastName) AS DoctorName
FROM Doctor d
RIGHT JOIN Department dp ON dp.DepartmentID=d.DepartmentID;

-- Show all doctors and appointment information.
SELECT CONCAT(d.FirstName,' ',d.LastName) AS DoctorName, a.appointmentID, a.AppointmentDate,a.TimeSlot,a.Status
FROM appointment a
RIGHT JOIN Doctor d ON a.DoctorID=d.DoctorID;

-- Display all patients and all appointments even if there is no matching record.
SELECT p.PatientID, p.FirstName, a.appointmentID
FROM Patient p
LEFT JOIN appointment a ON a.PatientID=p.PatientID

UNION

SELECT p.patientID, p.FirstName, a.appointmentID
FROM Patient p 
RIGHT JOIN appointment a ON a.PatientID=p.PatientID;


-- Find doctors who have appointments.
SELECT CONCAT(FirstName,' ',LastName) AS DoctorName
FROM Doctor 
WHERE DoctorID IN(SELECT DoctorID FROM appointment);

-- Find doctors without appointments.
SELECT CONCAT(FirstName,' ',LastName) AS DoctorName
FROM Doctor 
WHERE DoctorID NOT IN (SELECT DoctorID FROM appointment);

-- Find patients who visited Cardiologists.
SELECT CONCAT(FirstName,' ',LastName) AS PatientName
FROM Patient
WHERE PatientID IN(SELECT PatientID FROM appointment WHERE DoctorID IN (SELECT DoctorID FROM Doctor WHERE Specialization='Cardiologist')); 


-- Find patients who never booked appointments.
SELECT CONCAT(FirstName,' ',LastName) AS PatientName
FROM Patient
WHERE PatientID NOT IN (SELECT PatientID FROM appointment);

-- Find department having maximum doctors.
SELECT DepartmentName FROM Department
WHERE DepartmentID=(SELECT DepartmentID From Doctor GROUP BY DepartmentID ORDER BY COUNT(DoctorID) DESC LIMIT 1);

-- 