-- ============================================================
-- TRIGGERS (MySQL)

CREATE TABLE Students
(
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(100),
    Marks INT
);

CREATE TABLE StudentLog
(
    LogID INT AUTO_INCREMENT PRIMARY KEY,
    StudentID INT,
    Message VARCHAR(100)
);

INSERT INTO Students VALUES
(1,'Rahul',80),
(2,'Priya',90);


DELIMITER $$
CREATE TRIGGER BeforeInsertStudent
BEFORE INSERT
ON Students
FOR EACH ROW
BEGIN
    IF NEW.Marks < 0 THEN
        SET NEW.Marks = 0;
    END IF;
END $$
DELIMITER ;


INSERT INTO Students
VALUES(3,'Amit',-20);

SELECT * FROM Students;


DELIMITER $$
CREATE TRIGGER AfterInsertStudent
AFTER INSERT
ON Students
FOR EACH ROW
BEGIN
    INSERT INTO StudentLog
    (
        StudentID,
        Message
    )
    VALUES
    (
        NEW.StudentID,
        'New Student Added'
    );
END $$
DELIMITER ;

-- Test

INSERT INTO Students
VALUES(4,'Neha',75);

SELECT * FROM StudentLog;


SHOW TRIGGERS;

SHOW CREATE TRIGGER AfterInsertStudent;

DROP TRIGGER AfterInsertStudent;
