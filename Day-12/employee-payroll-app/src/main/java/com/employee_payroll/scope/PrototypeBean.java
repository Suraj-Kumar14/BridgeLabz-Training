package com.employee_payroll.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {

	public String getMessage() {
		return "Prototype bean";
	}
}
