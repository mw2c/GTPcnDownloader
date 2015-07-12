package com.mw2c.downloader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mw2c.entities.ArtistURL;
import com.mw2c.util.HTTPUtil;

//
public class ArtistListAnalyzer {
	private String sURL;
	private static final String sURLprefix="http://www.gtp.cn/gtp";
	
	public ArtistListAnalyzer(String sURL){
		this.sURL=sURL;
	}
	
	public ArrayList<ArtistURL> analyse(){
		ArrayList<ArtistURL> resultList=new ArrayList<ArtistURL>();
		String html = HTTPUtil.get(sURL);
		html=html.substring(html.indexOf("<TR align=middle> <td width=40>"),html.indexOf("</TABLE></TD>"));
		String regex = "<a href=.*?</a>";
		Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);
        Matcher ma = pa.matcher(html);
        while (ma.find()){
        	String item = ma.group();
            String url = sURLprefix + item.substring(14,item.indexOf("'>"));
            String artist = item.substring(item.indexOf("'>")+2,item.indexOf("</a>"));
            //System.out.println("artist: "+ artist + "url: " + url);
        	ArtistURL au = new ArtistURL(artist,url);
        	resultList.add(au);
        	
        }		
		return resultList;
	}
}
