package com.reflectionandannotations.annotations.customcachingsystem;

public class Calculator {
	
	  @CacheResult
	    public int square(int x) {
	        System.out.println("Computing square");
	        return x * x;
	    }
}
