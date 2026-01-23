package com.binarysearchtree.musicapp;

public class MusicOrganizer {
	Track root;
	
	//add music
	public Track insertTrack(Track root,int id,String name) {
		if(root==null) {
			System.out.println("music added.");
			return new Track(id,name);
		}
		if(id<root.getTrackId()) {
			root.left=insertTrack(root.left,id,name);
		}else if(id>root.getTrackId()) {
			root.right=insertTrack(root.right,id,name);
		}else {
			System.out.println("Music already exits. ");
		}
		return root;
	}
	
	//search music
	public void searchTrack(Track root,int id) {
		if(root==null) {
			System.out.println("Empty playList.");
			return;
		}	
		if(id==root.getTrackId()) {
			System.out.println(root);
		}
		else if(id<root.getTrackId()) {
			searchTrack(root.left,id);
		}else {
			searchTrack(root.right,id);
		}			
	}
	
	//show playlist
	public void inorder(Track root) {
		if(root!=null) {
			inorder(root.left);
			System.out.println(root);
			inorder(root.right);
		}
	}
}
