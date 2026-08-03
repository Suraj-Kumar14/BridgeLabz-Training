CREATE DATABASE IF NOT EXISTS health_clinic;
USE health_clinic;

CREATE TABLE patient (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(100) NOT NULL,
    phone      VARCHAR(15),
    dob        DATE
);

CREATE TABLE doctor (
    doctor_id  INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(100) NOT NULL,
    specialty  VARCHAR(50)
);

CREATE TABLE appointment (
    appointment_id    INT PRIMARY KEY AUTO_INCREMENT,
    patient_id        INT NOT NULL,
    doctor_id         INT NOT NULL,
    appointment_date  DATETIME NOT NULL,
    status             VARCHAR(20) DEFAULT 'Scheduled',
    FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
    FOREIGN KEY (doctor_id)  REFERENCES doctor(doctor_id)
);

INSERT INTO patient (name, phone, dob) VALUES
('Ravi Kumar',   '9876500000', '1990-01-01'),
('Meena Sharma', '9123400000', '1988-05-05'),
('Amit Verma',   '9988776655', '1995-07-15'),
('Priya Singh',  '9876123456', '1992-09-20'),
('Rahul Gupta',  '9012345678', '1987-12-10'),
('Sneha Patel',  '9090909090', '1998-03-18'),
('Karan Mehta',  '9345678901', '1993-11-25');    

INSERT INTO doctor (name, specialty) VALUES
('Dr. Anita',   'Cardiology'),
('Dr. Suresh',  'Orthopedic'),
('Dr. Neha',    'Dermatology'),
('Dr. Rajesh',  'Neurology'),
('Dr. Pooja',   'Pediatrics'),
('Dr. Arvind',  'General Medicine'),
('Dr. Kiran',   'ENT');

INSERT INTO appointment (patient_id, doctor_id, appointment_date, status) VALUES
(1, 3, '2026-08-10 11:00:00', 'Scheduled'),
(1, 5, '2026-08-12 09:30:00', 'Completed'),
(2, 1, '2026-08-13 10:45:00', 'Scheduled'),
(3, 1, '2026-08-14 02:15:00', 'Pending'),
(4, 2, '2026-08-15 04:00:00', 'Completed');    


SELECT p.name AS patient,
	   d.name As doctor,
	   a.appointment_date
       FROM appointment a
       JOIN patient p ON a.patient_id=p.patient_id
       JOIN doctor d ON a.doctor_id=d.doctor_id
       ORDER BY a.appointment_date;

CREATE TABLE appointment_bad (
    appt_id           INT PRIMARY KEY AUTO_INCREMENT,
    patient_name      VARCHAR(100),
    patient_phone     VARCHAR(15),
    doctor_name       VARCHAR(100),
    doctor_specialty  VARCHAR(50),
    appt_date         DATETIME
);

INSERT INTO appointment_bad
    (patient_name, patient_phone, doctor_name, doctor_specialty, appt_date) VALUES
    ('Ravi Kumar', '9876500000', 'Dr. Anita',  'Cardiology', '2026-08-05 10:00:00'),
    ('Ravi Kumar', '9876500000', 'Dr. Suresh', 'Orthopedic', '2026-08-06 11:30:00'),
    ('Meena S',    '9123400000', 'Dr. Anita',  'Cardiology', '2026-08-07 09:00:00');
    
SELECT * FROM appointment_bad;

UPDATE appointment_bad
SET patient_phone = '9999999999'
WHERE patient_name = 'Ravi Kumar';

SET SQL_SAFE_UPDATES = 0;

UPDATE patient
SET phone = '9999999999'
WHERE name = 'Ravi Kumar';

SELECT * FROM patient;

ALTER TABLE doctor ADD COLUMN department_name VARCHAR(50);
UPDATE doctor SET department_name = 'Cardiology Dept' WHERE specialty = 'Cardiology';
UPDATE doctor SET department_name = 'Ortho Dept' WHERE specialty = 'Orthopedic';
SELECT * FROM doctor;

ALTER TABLE doctor DROP COLUMN department_name;

CREATE TABLE department (
    department_id   INT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(50) NOT NULL
);

ALTER TABLE doctor ADD COLUMN department_id INT;
ALTER TABLE doctor ADD FOREIGN KEY (department_id) REFERENCES department(department_id);


INSERT INTO department (department_name) VALUES ('Cardiology Dept'), ('Ortho Dept');

UPDATE doctor SET department_id = 1 WHERE specialty = 'Cardiology';
UPDATE doctor SET department_id = 2 WHERE specialty = 'Orthopedic';

UPDATE department SET department_name = 'Cardiology Department' WHERE department_id = 1;

SELECT d.name, d.specialty, dep.department_name
FROM doctor d JOIN department dep ON d.department_id = dep.department_id;

DELIMITER $$
CREATE PROCEDURE seed_appointments(IN n INT)
BEGIN 
	DECLARE i INT DEFAULT 0;
    WHILE i<n DO 
		INSERT INTO appointment(patient_id, doctor_id, appointment_date,status)
						VALUES
                        (1+FLOOR(RAND()*2),
                        1+FLOOR(RAND()*2),
                        DATE_ADD('2026-01-01',INTERVAL FLOOR(RAND()*365) DAY),
                        'Scheduled');
                        SET i=i+1;
					END WHILE;
				END$$
			DELIMITER ;
            
CALL seed_appointments(50000);

SELECT * FROM appointment WHERE patient_id = 1;

CREATE INDEX idx_appointment_patient ON appointment(patient_id);

SELECT * FROM appointment
WHERE doctor_id = 1 AND appointment_date > '2026-06-01';

DROP TABLE IF EXISTS appointment_bad;

DROP PROCEDURE IF EXISTS seed_appointments;