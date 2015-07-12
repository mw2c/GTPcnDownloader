package com.mw2c.downloader;

public class GTPCnDecoder {
	public static String decode(String gtp){
		 gtp = gtp.replace("XG", "/") ;
		 gtp = gtp.replace("YI", "1") ;
		 gtp = gtp.replace("ER", "2") ;
		 gtp = gtp.replace("SN", "3") ;
		 gtp = gtp.replace("SI", "4") ;
		 gtp = gtp.replace("WU", "5") ;
		 gtp = gtp.replace("LU", "6") ;
		 gtp = gtp.replace("QI", "7") ;
		 gtp = gtp.replace("BA", "8") ;
		 gtp = gtp.replace("JU", "9") ;
		 gtp = gtp.replace("LN", "0") ;
		 gtp = gtp.replace("XD", ".rar") ;
		 gtp = gtp.replace("RM", "file") ;
		 return gtp ;
	}
}
