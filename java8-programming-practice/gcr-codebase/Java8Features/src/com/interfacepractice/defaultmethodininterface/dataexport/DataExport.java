package com.interfacepractice.defaultmethodininterface.dataexport;

public interface DataExport {
	void exportToCSV(String data);
	void exportToPdf(String data);
	
	default void exportToJSON(String data) {
		System.out.println("Exporting data to JSON.");
		System.out.println("{ \"report\": \""+data+"\"}");
	}
}
