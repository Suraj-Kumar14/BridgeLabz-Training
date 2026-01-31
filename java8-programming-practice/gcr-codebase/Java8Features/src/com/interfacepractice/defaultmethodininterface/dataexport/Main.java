package com.interfacepractice.defaultmethodininterface.dataexport;

public class Main {

	public static void main(String[] args) {

		DataExport csv=new CsvExporter();
		DataExport pdf=new PdfExporter();
				
		csv.exportToCSV("Sales Report");
		csv.exportToJSON("Sales report");
		
		pdf.exportToPdf("Employee Report");
		pdf.exportToJSON("String Report");
		

	}

}
