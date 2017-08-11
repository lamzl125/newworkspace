package org.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
public class HttpGetPost {
	public static String sendPost(String url, String param) throws Exception{
		PrintWriter out = null;
		BufferedReader in = null;
		int timeout=5000;
		String result = "";
		try {
			//System.out.println(param);
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			//conn.setRequestProperty("Content-Type","text/html;charset=GBK");
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.setConnectTimeout(timeout);
			conn.setUseCaches(false);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out = new PrintWriter(conn.getOutputStream());
			out.print(param);
			out.flush();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += "\n" + line;
			}
			Logs.info(result);
			System.out.println(result);
		} catch (Exception e) {
			throw e;
		}
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
			}
		}
		return result;
	}	

}
