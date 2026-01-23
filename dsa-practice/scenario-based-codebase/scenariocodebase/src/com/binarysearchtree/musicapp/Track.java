package com.binarysearchtree.musicapp;

public class Track {
	private int trackId;
	private String name;
	Track left,right;
	
	public Track(int trackId, String name) {
		super();
		this.trackId = trackId;
		this.name = name;
		left=right=null;
	}
	
	public int getTrackId() {
		return trackId;
	}
	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}
	public String getName() {
		return name;
	}
	public Track getLeft() {
		return left;
	}
	public Track getRight() {
		return right;
	}

	@Override
	public String toString() {
		return "Track [trackId=" + trackId + ", music_name=" + name + "]";
	}
	
	
	
}
