package com.huangtl.blog.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class MsgUtils {
	/**
	 * 鏈嶅姟http鍦板潃
	 */
	private static String BASE_URI = "http://yunpian.com";
	/**
	 * 鏈嶅姟鐗堟湰锟�
	 */
	private static String VERSION = "v1";
	/**
	 * 缂栫爜鏍煎紡
	 */
	private static String ENCODING = "UTF-8";
	/**
	 * 鏌ヨ处鎴蜂俊鎭殑http鍦板潃
	 */
	private static String URI_GET_USER_INFO = BASE_URI + "/" + VERSION + "/user/get.json";
	/**
	 * 閫氱敤鍙戯拷?鎺ュ彛鐨刪ttp鍦板潃
	 */
	private static String URI_SEND_SMS = BASE_URI + "/" + VERSION + "/sms/send.json";
	/**
	 * 妯℃澘鍙戯拷?鎺ュ彛鐨刪ttp鍦板潃
	 */
	private static String URI_TPL_SEND_SMS = BASE_URI + "/" + VERSION + "/sms/tpl_send.json";
	
	private static String APIKEY="e783e5662cd344088437777f03d1f3f8 ";
	
	/**
	 * 娉ㄥ唽楠岃瘉鐮佹ā锟�
	 * 妯＄増鍐呭锛氾拷?杩愬惂銆戞偍鏈娉ㄥ唽鐨勯獙璇佺爜涓猴細#code#锛屾杩庝娇锟�pro#锛岃鍦ㄦ敞鍐岄〉闈腑杈撳叆浠ュ畬鎴愭敞锟�
	 */
	public static String REG_TPL_ID="753731";
	
	/**
	 * 鏅拷?楠岃瘉鐮佹ā锟�
	 * 妯＄増鍐呭锛氾拷?杩愬惂銆戞偍鏈鎿嶄綔鐨勯獙璇佺爜涓猴細#code#锛屾杩庝娇锟�pro#
	 */
	public static String SC_TPL_ID="753739";
	
	/**
	 * 锟�锟斤拷鍙告満妯＄増ID
	 * 妯＄増鍐呭锛氾拷?杩愬惂銆戞彁閱掓偍锟�userName#锟�tel#锛夐個璇锋偍鍔犲叆浠栫殑杞﹂槦銆傝浣跨敤鎵嬫満鍒颁互涓嬪湴锟�锟斤拷瑁呰繍鍚у徃鏈虹増鍚庡姞鍏ヨ溅闃燂細#url#銆傝鎯呰鑷寸數瀹㈡湇锛屽鏈嶇數璇濓細4008856913
	 */
	public static String INVITE_TPL_ID="753825";
	
	/**
	 * 鍙栬处鎴蜂俊锟�
	 * @return json鏍煎紡瀛楃锟�
	 * @throws IOException 
	 */
	public static String getUserInfo() throws IOException{
		HttpClientBuilder builder=HttpClientBuilder.create();
		CloseableHttpClient client = builder.build() ;
		try{
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			pairs.add(new BasicNameValuePair("apikey",APIKEY));
			String url=URI_GET_USER_INFO+"?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, ENCODING));
			HttpGet method = new HttpGet(url);
			CloseableHttpResponse response = client.execute(method);
			HttpEntity entity = response.getEntity();
	        String result = null;
	        if (entity != null){
	            result = EntityUtils.toString(entity, "utf-8");
	        }
	        EntityUtils.consume(entity);
	        response.close();
	        return result;
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 鍙戠煭锟�
	 * @param apikey apikey
	 * @param text锟�锟斤拷淇″唴瀹癸拷?
	 * @param mobile锟�锟斤拷鍙楃殑鎵嬫満锟�
	 * @return json鏍煎紡瀛楃锟�
	 * @throws IOException 
	 */
	public static String sendSms(String mobile, String text){
		HttpClientBuilder builder=HttpClientBuilder.create();
		CloseableHttpClient client = builder.build() ;
		try{
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			pairs.add(new BasicNameValuePair("apikey",APIKEY));
			pairs.add(new BasicNameValuePair("text",text));
			pairs.add(new BasicNameValuePair("mobile",mobile));
			
			HttpPost method = new HttpPost(URI_SEND_SMS);
			method.setEntity(new UrlEncodedFormEntity(pairs,ENCODING));
			CloseableHttpResponse response = client.execute(method);
			HttpEntity entity = response.getEntity();
	        String result = null;
	        if (entity != null){
	            result = EntityUtils.toString(entity, ENCODING);
	        }
	        EntityUtils.consume(entity);
	        response.close();
	        return result;
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 閫氳繃妯℃澘鍙戯拷?鐭俊
	 * @param apikey apikey
	 * @param tpl_id锟�锟斤拷鏉縤d
	 * @param tpl_value锟�锟斤拷鏉垮彉閲忥拷?锟�xp:"#code#=1234&#company#=浜戠墖锟�
	 * @param mobile锟�锟斤拷鍙楃殑鎵嬫満锟�
	 * @return json鏍煎紡瀛楃锟�
	 * @throws IOException 
	 */
	public static String tplSendSms(String tpl_id, String tpl_value, String mobile) throws IOException{
		HttpClientBuilder builder=HttpClientBuilder.create();
		CloseableHttpClient client = builder.build();
		try{
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			pairs.add(new BasicNameValuePair("apikey",APIKEY));
			pairs.add(new BasicNameValuePair("tpl_id",tpl_id));
			pairs.add(new BasicNameValuePair("tpl_value",tpl_value));
			pairs.add(new BasicNameValuePair("mobile",mobile));
			
			HttpPost method = new HttpPost(URI_TPL_SEND_SMS);
			method.setEntity(new UrlEncodedFormEntity(pairs,ENCODING));
			CloseableHttpResponse response = client.execute(method);
			HttpEntity entity = response.getEntity();
	        String result = null;
	        if (entity != null){
	            result = EntityUtils.toString(entity, ENCODING);
	        }
	        EntityUtils.consume(entity);
	        response.close();
	        return result;
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getTplValue(Map<String,String> valueMap){
		StringBuffer tpl_value=new StringBuffer();
		if(valueMap!=null && !valueMap.isEmpty()){
			for(Map.Entry<String, String> entry:valueMap.entrySet()){
				try {
					tpl_value.append(String.format("#%1$s#=%2$s&",entry.getKey(),URLEncoder.encode(entry.getValue(),ENCODING)));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(tpl_value.length()>0){
				tpl_value.setLength(tpl_value.length()-1);
			}
		}
		return tpl_value.toString();
	}
} 

