package com.github.freeman.client.infrastructure.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Freeman
 * 发送get、post请求
 */
public class RestClient {

	private static final Logger LOG = LoggerFactory.getLogger(RestClient.class);
	
	/**
	 * 发送get请求，返回结果
	 * @param url
	 * @return result
	 * @throws Exception
	 */
	public static String get(String url){
		LOG.info("Getting from url '" + url + "'");
		String response = null;
		try {
			URL connectionUrl = new URL(url);
			HttpURLConnection openConnection = (HttpURLConnection) connectionUrl.openConnection();
			StringBuilder responseBuilder = new StringBuilder();
			BufferedReader in = new BufferedReader(new InputStreamReader(openConnection.getInputStream(), "UTF-8"));
			String input;
			while ((input = in.readLine()) != null) {
				responseBuilder.append(input).append("\r\n");
			}
			in.close();
			openConnection.disconnect();
			response = responseBuilder.toString();
		}catch(IOException e){
			LOG.error("网络故障", e);
		}
		return response;
	}
	
	public static String post(String url,String postParam) {
		String response = null;
		try {
			URL connectionUrl = new URL(url);
			byte[] postDataBytes = postParam.getBytes();
			HttpURLConnection conn = (HttpURLConnection) connectionUrl.openConnection();
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setDoOutput(true);
			conn.getOutputStream().write(postDataBytes);
			conn.getOutputStream().flush();
			StringBuilder responseBuilder = new StringBuilder();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String input;
			while ((input = in.readLine()) != null) {
				responseBuilder.append(input).append("\r\n");
			}
			in.close();
			conn.disconnect();
			response = responseBuilder.toString();
		}catch (IOException e){
			LOG.error("网络故障", e);
		}
		return response;
	}
	
}
