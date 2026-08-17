package com.employee_payroll.controller;

import com.employee_payroll.scope.SingletonBean;
import com.employee_payroll.scope.PrototypeBean;
import com.employee_payroll.scope.RequestBean;
import com.employee_payroll.scope.SessionBean;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScopeController {

	private final SingletonBean singletonBean;
	private final ObjectProvider<PrototypeBean> prototypeProvider;
	private final RequestBean requestBean;
	private final SessionBean sessionBean;

	public ScopeController(SingletonBean singletonBean, ObjectProvider<PrototypeBean> prototypeProvider,
			RequestBean requestBean, SessionBean sessionBean) {

		this.singletonBean = singletonBean;
		this.prototypeProvider = prototypeProvider;
		this.requestBean = requestBean;
		this.sessionBean = sessionBean;
	}

	@GetMapping("/scope/singleton")
	public String singleton() {

		return singletonBean.getMessage() + " - " + singletonBean.hashCode();
	}

	@GetMapping("/scope/prototype")
	public String prototype() {

		PrototypeBean prototypeBean = prototypeProvider.getObject();

		return prototypeBean.getMessage() + " - " + prototypeBean.hashCode();
	}

	@GetMapping("/scope/request")
	public String request() {

		return requestBean.getMessage() + " - " + requestBean.hashCode();
	}

	@GetMapping("/scope/session")
	public String session() {

		return sessionBean.getMessage() + " - " + sessionBean.hashCode();
	}
}