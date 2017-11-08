package com.example.polly.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;  
import org.apache.http.HttpStatus;  
import org.apache.http.NameValuePair;  
import org.apache.http.client.ClientProtocolException;  
import org.apache.http.client.HttpClient;  
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;  
import org.apache.http.util.EntityUtils;  
  
import com.alibaba.fastjson.JSONObject;

public class HttpUtil {
	public static String httpGet(String url, String value){  
        HttpClient httpClient = new DefaultHttpClient();  
        String sb = "";  
        String result = "";  
        try {    
            HttpGet httpGet = new HttpGet(url+"?"+value);  
          
            HttpResponse response = httpClient.execute(httpGet);  
            if (response.getStatusLine().getStatusCode() == 200) {  
                /* 读返回数据 */  
                result = EntityUtils.toString(response.getEntity());  
            } else {  
                result += "发送失败:" + response.getStatusLine().getStatusCode();  
            }  
              
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  

    /**  
     * 发送post请求--用于接口接收的参数为JSON字符串  
     * @param url 请求地址  
     * @param params map格式的字符串  
     * @return  
     */  
    public static String httpPost(String url,Map<String,Object> map){  
    	// 创建默认的httpClient实例.    
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        // 创建httppost    
        HttpPost httppost = new HttpPost(url);  
        String result = null;
        // 创建参数队列    
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for(Map.Entry<String, Object> mapEnty : map.entrySet()){
        	formparams.add(new BasicNameValuePair(mapEnty.getKey().toString(), mapEnty.getValue().toString()));
        }
        
        UrlEncodedFormEntity uefEntity;  
        try {  
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
            httppost.setEntity(uefEntity);  
            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity entity = response.getEntity();
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpStatus.SC_OK) {    
                    // Read the response body    
                    result = EntityUtils.toString(response.getEntity(),"UTF-8");    
                }
                return result;
            } finally {  
                response.close();  
            }  
        } catch (final Exception e) {  
            e.printStackTrace(); 
            return result;
        }finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }   
    }  
    
    public static void main(String[] args) {  
//        String url = "https://api.weibo.com/oauth2/access_token";  
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("grant_type", "authorization_code");
//        map.put("client_id", "3472698345");
//        map.put("client_secret", "a26c3f2cf4c26109df1489de1997104e");
//        map.put("redirect_uri", "http://172.16.19.118:8090/shiro_system/weibogetlogin");
//        map.put("code", "688586d337d98936d58a7d0184e211e5");   
//        String result = httpPost(url,map);
//        System.out.println("========result========="+result);
    	String result = httpGet("https://api.weibo.com/2/users/show.json", "access_token=2.007OUSzGdTFBnD2a155edaa78wLFJE&uid=6402559606");
    	System.out.println("========result========="+result);
    }
}
