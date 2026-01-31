package com.interfacepractice.staticmethodininterface.unitconversiontool;

public interface UnitConverter {
	
	static double milesConverter(double km) {
		return km*0.621317;
	}
	
	static double lbsConverter(double kg) {
		return kg*2.20462;
	}
}
 
