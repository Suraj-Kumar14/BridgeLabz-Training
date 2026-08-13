package com.employee_payroll.service.employee;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.employee_payroll.dao.department.DepartmentDAO;
import com.employee_payroll.dao.employee.EmployeeDAO;
import com.employee_payroll.dto.employee.EmployeeRequestDTO;
import com.employee_payroll.dto.employee.EmployeeResponseDTO;
import com.employee_payroll.exception.DepartmentNotFoundException;
import com.employee_payroll.exception.DuplicateEmailException;
import com.employee_payroll.exception.EmployeeNotFoundException;
import com.employee_payroll.model.Department;
import com.employee_payroll.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeDAO employeeDAO;
	private final DepartmentDAO departmentDAO;

	public EmployeeServiceImpl(EmployeeDAO employeeDAO, DepartmentDAO departmentDAO) {

		this.employeeDAO = employeeDAO;
		this.departmentDAO = departmentDAO;
	}

	@Override
	public EmployeeResponseDTO createEmployee(EmployeeRequestDTO request) {

		if (employeeDAO.existsByEmail(request.getEmail())) {

			throw new DuplicateEmailException("Employee with email " + request.getEmail() + " already exists");
		}

		Department department = departmentDAO.findById(request.getDepartmentId());

		if (department == null) {

			throw new DepartmentNotFoundException("Department not found with id: " + request.getDepartmentId());
		}

		Employee employee = new Employee();

		employee.setName(request.getName());
		employee.setEmail(request.getEmail());
		employee.setDepartmentId(request.getDepartmentId());
		employee.setSalary(request.getSalary());

		Employee savedEmployee = employeeDAO.save(employee);

		return convertToResponse(savedEmployee, department);
	}

	@Override
	public EmployeeResponseDTO getEmployeeById(Long id) {

		Employee employee = employeeDAO.findById(id);

		if (employee == null) {

			throw new EmployeeNotFoundException("Employee not found with id: " + id);
		}

		Department department = departmentDAO.findById(employee.getDepartmentId());

		return convertToResponse(employee, department);
	}

	@Override
	public List<EmployeeResponseDTO> getAllEmployees() {

		return employeeDAO.findAll().stream().map(employee -> {

			Department department = departmentDAO.findById(employee.getDepartmentId());

			return convertToResponse(employee, department);
		}).toList();
	}

	@Override
	public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO request) {

		Employee employee = employeeDAO.findById(id);

		if (employee == null) {

			throw new EmployeeNotFoundException("Employee not found with id: " + id);
		}

		Department department = departmentDAO.findById(request.getDepartmentId());

		if (department == null) {

			throw new DepartmentNotFoundException("Department not found with id: " + request.getDepartmentId());
		}

		employee.setName(request.getName());

		employee.setEmail(request.getEmail());

		employee.setDepartmentId(request.getDepartmentId());

		employee.setSalary(request.getSalary());

		Employee updatedEmployee = employeeDAO.update(id, employee);

		return convertToResponse(updatedEmployee, department);
	}

	@Override
	public void deleteEmployee(Long id) {

		if (employeeDAO.findById(id) == null) {

			throw new EmployeeNotFoundException("Employee not found with id: " + id);
		}

		employeeDAO.deleteById(id);
	}

	private EmployeeResponseDTO convertToResponse(Employee employee, Department department) {

		return new EmployeeResponseDTO(employee.getId(), employee.getName(), employee.getEmail(),
				employee.getDepartmentId(), department.getDepartmentName(), employee.getSalary(),
				employee.getJoiningDate());
	}
}