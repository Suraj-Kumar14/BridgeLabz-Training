package com.employee_payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee_payroll.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	boolean existsByEmail(String email);
	
    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    List<Employee> findEmployeesWithSalaryGreaterThan(@Param("salary") Double salary);
}
