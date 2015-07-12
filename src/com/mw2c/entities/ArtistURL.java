package com.mw2c.entities;

public class ArtistURL {
	private String artist;
	private String URL;
	public ArtistURL(String artist, String URL){
		this.artist=artist;
		this.URL=URL;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	
}
