package com.reflectionandannotations.reflection.dependencyinjection;

public class Controller {
	
	@Inject
    private Service service;

    public void process() {
        service.work();
    }
}
