package com.interfacepractice.defaultmethodininterface.dataexport;

public class CsvExporter implements DataExport{

	@Override
	public void exportToCSV(String data) {
		System.out.println("\nExporting data to csv: "+data);
		
	}

	@Override
	public void exportToPdf(String data) {
		// TODO Auto-generated method stub
		
	}

}
