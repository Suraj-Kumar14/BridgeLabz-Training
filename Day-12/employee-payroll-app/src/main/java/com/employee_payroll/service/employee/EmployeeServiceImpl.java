package com.employee_payroll.service.employee;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.employee_payroll.dto.employee.EmployeePatchDTO;
import com.employee_payroll.dto.employee.EmployeeRequestDTO;
import com.employee_payroll.dto.employee.EmployeeResponseDTO;
import com.employee_payroll.exception.DepartmentNotFoundException;
import com.employee_payroll.exception.DuplicateEmailException;
import com.employee_payroll.exception.EmployeeNotFoundException;
import com.employee_payroll.model.Department;
import com.employee_payroll.model.Employee;
import com.employee_payroll.repository.DepartmentRepository;
import com.employee_payroll.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}

	private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public EmployeeResponseDTO createEmployee(EmployeeRequestDTO request) {

		if (employeeRepository.existsByEmail(request.getEmail())) {
			throw new DuplicateEmailException("Employee with email " + request.getEmail() + " already exists");
		}

		Department department = departmentRepository.findById(request.getDepartmentId())
				.orElseThrow(() -> new DepartmentNotFoundException(
						"Department not found with departmentId: " + request.getDepartmentId()));

		Employee employee = toEmployee(request);
		employee.setDepartment(department);

		Employee savedEmployee = employeeRepository.save(employee);

		return toResponse(savedEmployee);
	}
	

	@Override
	public Page<EmployeeResponseDTO> getAllEmployees(int page, int size, String sortBy, String direction) {

		Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

		Pageable pageable = PageRequest.of(page, size, sort);

		logger.debug("Fetching employees from repository");
		return employeeRepository.findAll(pageable).map(this::toResponse);
	}

	@Override
	public EmployeeResponseDTO getEmployeeById(Long id) {
		logger.debug("Searching employee with id: {}", id);
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

		return toResponse(employee);
	}

	@Override
	public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO request) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

		if (!employee.getEmail().equalsIgnoreCase(request.getEmail())
				&& employeeRepository.existsByEmail(request.getEmail())) {
			throw new DuplicateEmailException("Employee with email " + request.getEmail() + " already exists");
		}

		Department department = departmentRepository.findById(request.getDepartmentId()).orElseThrow(
				() -> new DepartmentNotFoundException("Department not found with id: " + request.getDepartmentId()));

		employee.setName(request.getName());
		employee.setEmail(request.getEmail());
		employee.setSalary(request.getSalary());
		employee.setDepartment(department);

		Employee updatedEmployee = employeeRepository.save(employee);

		return toResponse(updatedEmployee);
	}

	@Override
	public void deleteEmployee(Long id) {

		if (!employeeRepository.existsById(id)) {
			throw new EmployeeNotFoundException("Employee not found with id: " + id);
		}

		employeeRepository.deleteById(id);

	}

	private Employee toEmployee(EmployeeRequestDTO request) {

		Employee employee = new Employee();

		employee.setName(request.getName());
		employee.setEmail(request.getEmail());
		employee.setSalary(request.getSalary());

		return employee;
	}

	private EmployeeResponseDTO toResponse(Employee employee) {

		EmployeeResponseDTO response = new EmployeeResponseDTO();

		response.setId(employee.getId());
		response.setName(employee.getName());
		response.setEmail(employee.getEmail());
		response.setDepartmentId(employee.getDepartment().getDepartmentId());
		response.setDepartmentName(employee.getDepartment().getDepartmentName());
		response.setSalary(employee.getSalary());
		response.setJoiningDate(employee.getJoiningDate());

		return response;
	}

	@Override
	public List<EmployeeResponseDTO> getEmployeesWithSalaryGreaterThan(Double salary) {

		return employeeRepository.findEmployeesWithSalaryGreaterThan(salary).stream().map(this::toResponse).toList();
	}

	@Override
	public EmployeeResponseDTO patchEmployee(Long id, EmployeePatchDTO dto) {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

		if (dto.getName() != null) {
			employee.setName(dto.getName());
		}

		if (dto.getEmail() != null) {
			employee.setEmail(dto.getEmail());
		}

		if (dto.getSalary() != null) {
			employee.setSalary(dto.getSalary());
		}

		if (dto.getDepartmentId() != null) {

			Department department = departmentRepository.findById(dto.getDepartmentId())
					.orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + dto.getDepartmentId()));

			employee.setDepartment(department);
		}

		Employee updatedEmployee = employeeRepository.save(employee);

		return toResponse(updatedEmployee);
	}
}