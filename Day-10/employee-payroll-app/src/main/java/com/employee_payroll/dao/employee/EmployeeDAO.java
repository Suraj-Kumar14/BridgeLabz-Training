package com.employee_payroll.dao.employee;

import java.util.List;

import com.employee_payroll.model.Employee;

public interface EmployeeDAO {

    Employee save(Employee employee);

    Employee findById(Long id);

    List<Employee> findAll();

    Employee update(Long id, Employee employee);

    boolean deleteById(Long id);

    boolean existsByEmail(String email);
}