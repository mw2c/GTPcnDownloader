package com.mw2c.downloader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mw2c.entities.ArtistURL;
import com.mw2c.entities.SongURL;
import com.mw2c.util.HTTPUtil;

public class SongsAnalyzer {
	private String sURL;
	private int tabNum;
	private ArrayList<SongURL> list;
	
	public SongsAnalyzer(String url){
		list = new ArrayList<SongURL>();
		this.sURL=url;
	}
	
	public ArrayList<SongURL> analyse(){
		String html=HTTPUtil.get(sURL);
		try{
		tabNum = Integer.parseInt(html.substring(html.indexOf("gtp数<b>")+7,html.indexOf("</b></td>")));
		}catch(Exception e){
			System.out.println("no tabs");
			return list;
		}
		String baseUrl=sURL.substring(0,sURL.length()-5);
		//System.out.println(baseUrl);
		if(tabNum>30){
			int page = tabNum/30;
			for(int i=0;i<=page;i++){
				if(i==0){
					analyseOnePage(html, list);
				}else{
					String content = HTTPUtil.get(baseUrl + (i+1) +".htm");
					//System.out.println(baseUrl + i +".htm");
					analyseOnePage(content, list);
				}
			}
		}else{
			analyseOnePage(html, list);
		}
		return list;
	}
	
	public void analyseOnePage(String html, ArrayList<SongURL> list){
		html=html.substring(html.indexOf("dotted"),html.indexOf("</TABLE></TD>"));
		//System.out.println(html);
		String regex = "<a href=.*target=_blank.*</a>";
		Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);
        Matcher ma = pa.matcher(html);
        while (ma.find()){
        	String item = ma.group();
            String url = item.substring(item.indexOf("id=")+3,item.indexOf("  target"));
            String song = item.substring(item.indexOf("_blank>")+7,item.indexOf("</a>"));
            song=song.replace("<b>", "");
            song=song.replace("</b>", "");
            //System.out.println("------" + item);
        	SongURL su = new SongURL(song,url);
        	list.add(su);
        }
	}
}
