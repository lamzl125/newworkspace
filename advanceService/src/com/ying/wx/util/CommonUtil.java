package com.ying.wx.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.log4j.Logger;
import org.utils.HttpGetPost;
import org.utils.SysGlobals;


public class CommonUtil {
	private Logger log = Logger.getLogger(CommonUtil.class);
	/** APP_ID 应用从官方网站申请到的合法appId */
    public static final String WX_APP_ID = "wxb1d4578f52b9924c";
    /** 商户号 */
    public static final String WX_PARTNER_ID = "1266716801";
    /** 接口链接 */
    public static final String url="https://api.mch.weixin.qq.com/pay/unifiedorder";
    /** 商户平台和开发平台约定的API密钥，在商户平台设置  */
    public static final String key="abcdefghyjklmnopqrstuvwxyz123456";
    /** 回调地址*/
    public static final String notify_url=SysGlobals.getInstance().getProperty("userIconBaseUrl")+"/wxpaynotify";
     
    public String submitOrder(double realPayPrice,String ip,String tradeNo,String detail) {
    	String content="";
        int realpayPrice=(int)(realPayPrice*100);
        SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
        parameters.put("appid", WX_APP_ID);
        
       parameters.put("mch_id", WX_PARTNER_ID);
        parameters.put("nonce_str", UUID.randomUUID().toString().replace("-", ""));
        parameters.put("body", detail);
        parameters.put("out_trade_no",tradeNo);
        parameters.put("total_fee", "1");
        parameters.put("spbill_create_ip",ip);
        parameters.put("notify_url", notify_url);
        parameters.put("trade_type", "APP");
        
        String sign=createSign("UTF-8", parameters);
        parameters.put("sign", sign);
        
        try {
        	//调用统一下单       
           // content=HttpGetPost.sendPost(url, new String(toXml(nvps).getBytes()));
        	content=httpsRequest(url,"POST", getRequestXml(parameters));
            System.out.println("微信支付信息："+content);
        } catch (Exception e) {
			e.printStackTrace();
		}
        return content;
    }
    public String queryOrder(String tradeNo) {
    	String content="";
        SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
        parameters.put("appid", WX_APP_ID);
        
       parameters.put("mch_id", WX_PARTNER_ID);
        parameters.put("nonce_str", UUID.randomUUID().toString().replace("-", ""));
        parameters.put("out_trade_no",tradeNo);
        String sign=createSign("UTF-8", parameters);
        parameters.put("sign", sign);
        
        try {
        	//调用统一下单       
           // content=HttpGetPost.sendPost(url, new String(toXml(nvps).getBytes()));
        	content=httpsRequest("https://api.mch.weixin.qq.com/pay/orderquery","POST", getRequestXml(parameters));
            System.out.println("微信查询订单信息："+content);
        } catch (Exception e) {
			e.printStackTrace();
		}
        return content;
    }
    
    private String toXml(List<NameValuePair> params) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for (int i = 0; i < params.size(); i++) {
            sb.append("<"+params.get(i).getName()+">");
 
 
            sb.append(params.get(i).getValue());
            sb.append("");
        }
        sb.append("");
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    public static String getRequestXml(SortedMap<Object,Object> parameters){
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if ("attach".equalsIgnoreCase(k)||"body".equalsIgnoreCase(k)||"sign".equalsIgnoreCase(k)) {
                sb.append("<"+k+">"+"<![CDATA["+v+"]]></"+k+">");
            }else {
                sb.append("<"+k+">"+v+"</"+k+">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }
    public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
    		X509TrustManager x509m = new X509TrustManager() {
    			@Override
    			public X509Certificate[] getAcceptedIssuers() {
    				return null;
    			}
    			@Override
    			public void checkServerTrusted(X509Certificate[] chain,
    					String authType) throws CertificateException {
    			}
    			@Override
    			public void checkClientTrusted(X509Certificate[] chain,
    					String authType) throws CertificateException {
    			}
    		};
    	
    	try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { x509m };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            return buffer.toString();
        } catch (ConnectException ce) {
           ce.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String createSign(String characterEncoding,SortedMap<Object,Object> parameters){
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v) 
                   && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + key);
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }
}
