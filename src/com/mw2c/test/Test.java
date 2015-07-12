package com.mw2c.test;

import java.util.ArrayList;
import java.util.List;

import com.mw2c.downloader.ArtistListAnalyzer;
import com.mw2c.downloader.GTPCnDecoder;
import com.mw2c.downloader.SongDownloader;
import com.mw2c.downloader.SongsAnalyzer;
import com.mw2c.entities.SongURL;
import com.mw2c.util.HTTPUtil;

public class Test {
	public static void main(String[] args) {
		//ArtistListAnalyzer a = new ArtistListAnalyzer("http://www.gtp.cn/gtp/htm/A-Z/A.htm");
		//a.analyse();
		//SongsAnalyzer s = new SongsAnalyzer("http://www.gtp.cn/gtp/htm/music_singer/Music_Singer_List_288_1.htm");
		//ArrayList<SongURL> l=s.analyse();
		//for(int i=0;i<l.size();i++){
		//	System.out.println(l.get(i).getSong() + " " + l.get(i).getURL());
		//}
		//SongDownloader sd = new SongDownloader("http://www.gtp.cn/gtp/htm/A-Z/.htm");
		SongDownloader sd = new SongDownloader("http://www.gtp.cn/gtp/htm/A-Z/Z.htm");
		/*String s=HTTPUtil.get("http://www.gtp.cn/gtp/htm/music_singer/Music_Singer_List_169_1.htm");
		SongsAnalyzer sa = new SongsAnalyzer("http://www.gtp.cn/gtp/htm/music_singer/Music_Singer_List_169_1.htm");
		ArrayList<SongURL> al=new ArrayList<SongURL>();
		sa.analyseOnePage(s, al);
		//s=s.replace("<b>", "");
		//s=s.replace("<\\b>", "");
		for(int i=0;i<al.size();i++){
			System.out.println(al.get(i).getSong());
		}*/
		
		//String s=HTTPUtil.get("http://www.gtp.cn/gtp/asp/list.asp?id=JOGQFMERK8&action=end&key=www.gtp.cn");
		//String s=HTTPUtil.post("http://www.gtp.cn/gtp/asp/list.asp?id=JOGQFMERK8&action=end&key=http://www.gtp.cn/gtp/asp/play.asp?id=JOGQFMERK8", "aa2=&key=&id=");
		//System.out.println(GTPCnDecoder.decode("RMXGERLNLNJUXGYIERXGERLNLNJUYIERSNYIYIWUSNERSNWULNXD"));
		//System.out.println(s);
	}

}
