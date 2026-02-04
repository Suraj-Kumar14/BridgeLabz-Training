package com.downloadmanager;

import java.util.Random;

public class FileDownloader implements Runnable{
	
	private String fileName;
	private Random random =new Random();
	
	public FileDownloader(String fileName) {
		this.fileName=fileName;
	}
	
	@Override
	public void run() {
		try {
			for(int progress=0;progress<=100;progress+=25) {
				Thread.sleep(random.nextInt(1000));
				System.out.println("["+Thread.currentThread().getName()+"] Downloading "+fileName+" : "+progress+"%");
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
