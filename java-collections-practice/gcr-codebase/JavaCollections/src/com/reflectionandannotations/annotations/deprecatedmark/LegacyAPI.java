package com.reflectionandannotations.annotations.deprecatedmark;

public class LegacyAPI {
	
	@Deprecated
	public void oldFeature() {	
		System.out.println("Old feature executed");
	}
	
	public void newFeature() {
		System.out.println("New feature executed");
	}
}
