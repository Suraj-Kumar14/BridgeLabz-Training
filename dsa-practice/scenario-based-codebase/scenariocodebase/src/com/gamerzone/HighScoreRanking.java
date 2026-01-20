package com.gamerzone;

import java.util.ArrayList;
import java.util.List;

public class HighScoreRanking {
	
	List<Player>players=new ArrayList<>();
	
	//add player
	public void addPlayer(Player player) {
		players.add(player);
		System.out.println("Player added.");
	}
	
	//sort player rank
	public void sortPlayer() {
		int start=0,end=players.size()-1;
		quickSort(start,end);
		System.out.println("Players are sorted.");
	}
	
	//Quick sort
	private void quickSort(int start,int end) {
		if(start<end) {
			int pi=partition(start,end);
			quickSort(start,pi-1);
			quickSort(pi+1,end);
		}
	}
	
	//find pivot
	private int partition(int start,int end) {
		Player pivot=players.get(end);
		int i=start-1;
		for(int j=start;j<end;j++) {
			if(players.get(j).getScore()>pivot.getScore()) {
				i++;
				swap(i,j);
			}
		}
		swap(i+1,end);
		return i+1;
	}
	
	private void swap(int i,int j) {
		Player temp=players.get(i);
		players.set(i, players.get(j));
		players.set(j, temp);
	}
	
	//show player rank
	public void showPlayer() {
		System.out.println();
		System.out.println("----High score Ranking system----");
		if(!players.isEmpty()) {
			for(Player player:players) {
				System.out.println(player);
			}
		}else {
			System.out.println("No data available!");
		}
		System.out.println();
	}
}
