package com.downloadmanager;

public class DownloadManager {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1=new Thread(new FileDownloader("Document.pdf"),"Thread-1");
		Thread t2=new Thread(new FileDownloader("Image.jpg"),"Thread-2");
		Thread t3=new Thread(new FileDownloader("Video.mp4"),"Thread-3");
		
		t1.start();
		t2.start();
		t3.start();
		
		//main thread waits
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("All downloads complete!");
	}

}
