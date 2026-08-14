package com.employee_payroll.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_payroll.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

    boolean existsByDepartmentNameIgnoreCase(String departmentName);
    
    boolean existsByDepartmentNameIgnoreCaseAndDepartmentIdNot(String departmentName, Long departmentId);
}