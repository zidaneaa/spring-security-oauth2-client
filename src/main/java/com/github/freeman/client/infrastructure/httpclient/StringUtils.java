package com.github.freeman.client.infrastructure.httpclient;

import java.util.Map;

public class StringUtils extends org.apache.commons.lang.StringUtils{

	
	public static String parseMapToString(Map<String,Object> map){
		if(map == null){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for(Map.Entry<String, Object> entry : map.entrySet()){
			sb.append(entry.getKey()).append("=").append(entry.getValue());
			sb.append("&");
		}
		String s = sb.toString();
		if(s.endsWith("&")){
			s = substringBeforeLast(s, "&");
		}
		return s;
	}
}
