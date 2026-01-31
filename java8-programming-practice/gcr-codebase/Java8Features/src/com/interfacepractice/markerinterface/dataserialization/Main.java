package com.interfacepractice.markerinterface.dataserialization;

public class Main {

	public static void main(String[] args) {
		
		UserData user=new UserData("suraj","example@123123");
		TempCache cache=new TempCache("ABC123");
		
		BackupService.backupObject(user);
		BackupService.backupObject(cache);

	}

}
