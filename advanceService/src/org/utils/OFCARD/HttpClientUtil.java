package org.utils.OFCARD;

/**
 * Created by admin on 14-11-17.
 */

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

    /**
     * 发送get请求
     * @param url 请求地址
     * @param param 请求参数
     * @param readTimeout 数据读取时间（毫秒）
     * @param connectTimeout 连接超时时间（毫秒）
     * @return
     * @throws Exception
     */
    public static String sendGetRequest(String url,String param,int readTimeout, int connectTimeout)throws Exception{

        HttpClient httpClient = new DefaultHttpClient();

        httpClient.getParams().setIntParameter("http.socket.timeout", readTimeout );
        httpClient.getParams().setIntParameter("http.connection.timeout", connectTimeout );

        HttpGet httpGet = new HttpGet(url+"?"+param);

        HttpEntity httpEntity = null;

        try{

            HttpResponse httpResponse = httpClient.execute(httpGet);
            if(httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK){
                throw new Exception(httpResponse.getStatusLine().toString());
            }else {
                httpEntity = httpResponse.getEntity();
                String result=null;
                if(httpEntity != null){
                    result = EntityUtils.toString(httpEntity);
                }
                return result;
            }

        }catch (Exception e){
            throw new Exception("异常情况",e);
        }finally {
            httpGet.abort();
            EntityUtils.consume(httpEntity);
            httpClient.getConnectionManager().shutdown();
        }
    }

    /**
     * 发送post请求
     * @param url 请求地址
     * @param mapparam 参数
     * @param coding 编码
     * @param readTimeout 数据读取时间（毫秒）
     * @param connectTimeout 连接超时时间（毫秒）
     * @return
     * @throws Exception
     */
    public static String sendPostRequest(String url,Map<String,String> mapparam,String coding,int readTimeout, int connectTimeout)throws Exception{

        HttpClient httpClient = new DefaultHttpClient();

        httpClient.getParams().setIntParameter("http.socket.timeout", readTimeout );
        httpClient.getParams().setIntParameter("http.connection.timeout", connectTimeout );

        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        // 先迭代HashMap
        Iterator<Map.Entry<String, String>> it = mapparam.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
            String key = entry.getKey();
            nvps.add(new BasicNameValuePair(key, entry.getValue()));
        }

        httpPost.setEntity(new UrlEncodedFormEntity(nvps, coding));

        HttpResponse httpResponse = null;
        HttpEntity httpEntity = null;

        try{
            httpResponse  = httpClient.execute(httpPost);
            if(httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK){
                throw new Exception(httpResponse.getStatusLine().toString());
            }else {
                httpEntity = httpResponse.getEntity();
                String result=null;
                if(httpEntity != null){
                    result = EntityUtils.toString(httpEntity);
                }
                return result;
            }
        }catch (Exception e) {
            throw new Exception("异常情况",e);
        }finally {
            httpPost.abort();
            EntityUtils.consume(httpEntity);
            httpClient.getConnectionManager().shutdown();
        }
    }
}
