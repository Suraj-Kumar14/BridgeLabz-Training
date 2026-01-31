package com.interfacepractice.defaultmethodininterface.dataexport;

public class PdfExporter implements DataExport{

	@Override
	public void exportToCSV(String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exportToPdf(String data) {
		System.out.println("\nExporting data to pdf: "+data);		
	}

}
