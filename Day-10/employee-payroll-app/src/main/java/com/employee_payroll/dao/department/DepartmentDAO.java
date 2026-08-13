package com.employee_payroll.dao.department;

import java.util.List;

import com.employee_payroll.model.Department;

public interface DepartmentDAO {

    Department save(Department department);

    Department findById(Long departmentId);

    List<Department> findAll();

    boolean existsByName(String departmentName);

    boolean deleteById(Long departmentId);
}