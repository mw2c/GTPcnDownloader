package com.mw2c.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HTTPUtil {
	public static String cookieVal="";
	public static String post(String url,String params){
		String result="";
		String line="";
		try {
			URLConnection conn;
			URL realUrl=new URL(url);
			conn = realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("User-Agent","Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0)");
			conn.setRequestProperty("Cookie",cookieVal);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			PrintWriter out=new PrintWriter(conn.getOutputStream());
			out.print(params);
			out.flush();
			//List<String> list = ((Map<String, List<String>>)conn.getHeaderFields()).get("Set-Cookie");
			cookieVal=conn.getHeaderField("Set-Cookie");
		   /*for(String temp : list) {
			   cookieVal += temp + "; ";
		   }*/
		   System.out.println(cookieVal);
			BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream(),"gb2312"));
			while((line=in.readLine())!=null)
			{
				result+=line+"\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String get(String url,String params){
		String result="";
		URLConnection conn;
		BufferedReader br = null;
		try {
			URL realURL=new URL(url+"?"+params);
			conn=realURL.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("User-Agent","Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0)");
			conn.setRequestProperty("Cookie",cookieVal);
			br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"gb2312"));
			String line="";
			while ((line = br.readLine())!= null)
			{
				result += line+"\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(br!=null){
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static String get(String url){
		String result="";
		URLConnection conn;
		BufferedReader br = null;
		try {
			URL realURL=new URL(url);
			conn=realURL.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("User-Agent","Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0)");
			conn.setRequestProperty("Cookie",cookieVal);
			br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"gb2312"));
			String line="";
			while ((line = br.readLine())!= null)
			{
				result += line+"\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(br!=null){
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	

	public static boolean httpDownload(String httpUrl,String saveFile){
        int bytesum = 0;
        int byteread = 0;

        URL url = null;
		try {
			url = new URL(httpUrl);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}

        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream(saveFile);

            byte[] buffer = new byte[1204];
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                //System.out.println(bytesum);
                fs.write(buffer, 0, byteread);
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}