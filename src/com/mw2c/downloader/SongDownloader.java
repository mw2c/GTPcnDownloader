package com.mw2c.downloader;

import java.io.File;
import java.util.ArrayList;

import com.mw2c.entities.ArtistURL;
import com.mw2c.entities.SongURL;
import com.mw2c.util.HTTPUtil;

public class SongDownloader {
	
	public static final String baseURL="http://www.gtp.cn/gtp/asp/list.asp?action=end&id=";
	public static final String endfix="&key=www.gtp.cn";
	public static final String downloadPrefix="http://down.gtp.cn/";
	public SongDownloader(String url){
		//"http://www.gtp.cn/gtp/htm/A-Z/A.htm"
		ArtistListAnalyzer a = new ArtistListAnalyzer(url);//url
		String alpha = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("."));
		File folder = new File("E:/gtpcn/"+alpha);
		if(!folder.isDirectory()){
			folder.mkdirs();
		}
		ArrayList<ArtistURL> aus = a.analyse();
		for(int i=0;i<aus.size();i++){
			SongsAnalyzer sa = new SongsAnalyzer(aus.get(i).getURL());
			File dir = new File(folder.getAbsolutePath()+"/"+aus.get(i).getArtist());
			if(!dir.isDirectory()){
				dir.mkdirs();
			}
			ArrayList<SongURL> sus = sa.analyse();
			for(int j=0;j<sus.size();j++){
				try {
				//System.out.println(sus.get(j).getURL());
					String s=HTTPUtil.get(baseURL+sus.get(j).getURL()+endfix);
					String code=s.substring(s.indexOf("gtpcn('")+7,s.lastIndexOf("')"));
					String downurl = downloadPrefix+GTPCnDecoder.decode(code);
					System.out.println(aus.get(i).getArtist()+" - " +sus.get(j).getSong());
					HTTPUtil.httpDownload(downurl, dir.getAbsolutePath()+"/"+sus.get(j).getSong()+downurl.substring(downurl.lastIndexOf(".")));
				
					int sleepTime=/*5000+*/(int)(Math.random()*100);
					System.out.println("sleep " + sleepTime + " ms");
					Thread.sleep(sleepTime);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
