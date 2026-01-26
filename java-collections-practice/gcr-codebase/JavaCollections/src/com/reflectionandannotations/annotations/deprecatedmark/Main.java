package com.reflectionandannotations.annotations.deprecatedmark;

public class Main {

	public static void main(String[] args) {


		LegacyAPI api=new LegacyAPI();
		api.oldFeature();
		api.newFeature();

	}

}
