CREATE DATABASE  CompanyDB;
USE CompanyDB;

CREATE TABLE Department(
    DepartmentID INT PRIMARY KEY,
    DepartmentName VARCHAR(50)
);

CREATE TABLE Employee(
    EmployeeID INT PRIMARY KEY,
    EmployeeName VARCHAR(100),
    DepartmentID INT,
    Salary DECIMAL(10,2),
    FOREIGN KEY (DepartmentID) 
    REFERENCES Department(DepartmentID)
);

INSERT INTO Department VALUES
(1,'HR'),
(2,'IT'),
(3,'Finance'),
(4,'Marketing');

INSERT INTO Employee VALUES
(101,'Alice',1,50000),
(102,'Bob',2,65000),
(103,'Charlie',2,70000),
(104,'David',3,60000),
(105,'Eva',NULL,55000);


-- INNER JOIN
SELECT e.EmployeeID,e.EmployeeName,d.DepartmentName,e.Salary
FROM Employee e
INNER JOIN Department d
ON e.DepartmentID=d.DepartmentID;

-- Display Employees Working in the IT Department
SELECT e.EmployeeID,e.EmployeeName,d.DepartmentName
FROM Employee e
INNER JOIN Department d
ON e.DepartmentID = d.DepartmentID
WHERE d.DepartmentName = 'IT';

-- Display Employees with Salary Greater Than 60000 
SELECT e.EmployeeName,d.DepartmentName,e.Salary
FROM Employee e
INNER JOIN Department d
ON e.DepartmentID = d.DepartmentID
WHERE e.Salary > 60000;

-- Count Employees Department-wise
SELECT d.DepartmentName,COUNT(e.EmployeeID) AS TotalEmployees
FROM Employee e
INNER JOIN Department d
ON e.DepartmentID = d.DepartmentID
GROUP BY d.DepartmentName;

-- LEFT JOIN
SELECT e.EmployeeName,d.DepartmentName
FROM Employee e
LEFT JOIN Department d
ON e.DepartmentID=d.DepartmentID;

-- Find Employees Without a Department
SELECT e.EmployeeID,e.EmployeeName
FROM Employee e
LEFT JOIN Department d
ON e.DepartmentID = d.DepartmentID
WHERE d.DepartmentID IS NULL;

-- Display Employee Name and Department (Replace NULL)
SELECT e.EmployeeName,IFNULL(d.DepartmentName,'No Department') AS Department
FROM Employee e
LEFT JOIN Department d
ON e.DepartmentID = d.DepartmentID;

-- Display Employees Having Salary Greater Than 55000
SELECT e.EmployeeName,d.DepartmentName,e.Salary
FROM Employee e
LEFT JOIN Department d
ON e.DepartmentID = d.DepartmentID
WHERE e.Salary > 55000;

-- RIGHT JOIN
SELECT e.EmployeeName,d.DepartmentName
FROM Employee e
RIGHT JOIN Department d
ON e.DepartmentID=d.DepartmentID;

-- Find Departments Without Employees
SELECT d.DepartmentName
FROM Employee e
RIGHT JOIN Department d
ON e.DepartmentID = d.DepartmentID
WHERE e.EmployeeID IS NULL;

-- Count Employees in Every Department
SELECT d.DepartmentName,COUNT(e.EmployeeID) AS TotalEmployees
FROM Employee e
RIGHT JOIN Department d
ON e.DepartmentID = d.DepartmentID
GROUP BY d.DepartmentName;

-- FULL OUTER JOIN 
SELECT e.EmployeeName,d.DepartmentName
FROM Employee e
LEFT JOIN Department d
ON e.DepartmentID=d.DepartmentID
UNION
SELECT e.EmployeeName,d.DepartmentName
FROM Employee e
RIGHT JOIN Department d
ON e.DepartmentID=d.DepartmentID;