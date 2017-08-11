package com.ztest;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Te {
	public static void main(String[] args) {
		try {
			// URL url = new
			// URL("http://127.0.0.1:8888/fileSys/getFile.action?filePath=/c/v/b/&fileName=test.zip");
//			String pram = "json={\"cmd\": \"sendVoiceTalk\",\"talkID\":\"1\",\"userName\":\"137280409@qq.com\"}";
			String u="http://192.168.1.106/mschool/service.action?cmd=sendVoiceTalk&talkID=1&userName=137280409@qq.com";
			URL url = new URL(u);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "text/html");
			conn.setRequestProperty("Cache-Control", "no-cache");
			conn.setRequestProperty("Charsert", "UTF-8");
			conn.connect();
			conn.setConnectTimeout(10000);
			OutputStream out = conn.getOutputStream();

			File file = new File("g:\\ojdbc14.jar");
			DataInputStream in = new DataInputStream(new FileInputStream(file));
			int bytes = 0;
			byte[] buffer = new byte[1024];
			while ((bytes = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytes);
			}
			in.close();
			out.flush();
			out.close();
			conn.getInputStream();
			conn.disconnect();
		} catch (Exception e) {
			System.out.println("发送文件出现异常！" + e);
			e.printStackTrace();
		}
		
		
	}
	
}
