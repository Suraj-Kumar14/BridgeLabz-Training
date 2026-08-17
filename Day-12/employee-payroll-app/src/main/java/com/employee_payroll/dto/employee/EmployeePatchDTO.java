package com.employee_payroll.dto.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeePatchDTO {

    @Schema(example = "Rahul Sharma")
    private String name;

    @Schema(example = "rahul@company.com")
    private String email;

    @Schema(example = "1")
    private Long departmentId;

    @Schema(example = "70000.00")
    @Positive(message = "Salary must be greater than 0")
    private Double salary;
}