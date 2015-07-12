package com.mw2c.entities;

public class SongURL {
	private String song;
	private String URL;
	
	public SongURL(String song,String url){
		this.song=song;
		this.URL=url;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}
	
}
