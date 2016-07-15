package com.net;

import java.io.InputStream;
import java.net.HttpURLConnection;

import com.net.xml.bean.XmlData;
import com.net.xml.dto.XmlParser;

public class HttpRequesterHelper
{
	public static XmlData postRequest(String xmlRequestStr)
	{
		return postRequest(
				Constants.SERVER_IP_ADDRESS, 
				20000, 
				20000, 
				xmlRequestStr);
	}
	
	/**
	 * 发送http请求，请求方法为POST
	 * @param UrlSpec 请求的目标地址
	 * @param connectTimeout 连接超时时间
	 * @param readTimeout 读取数据超时时间
	 * @param xmlRequestStr xml请求信息
	 * @return
	 */
	public static XmlData postRequest(String UrlSpec, int connectTimeout, int readTimeout, String xmlRequestStr)
	{
		XmlData resultData = null;
		
		HttpURLConnection httpURLConnection = HttpRequester.createConnection(UrlSpec, connectTimeout, readTimeout);
		InputStream replyInfoStream = HttpRequester.postRequest(httpURLConnection, xmlRequestStr);
		resultData = XmlParser.parseXml(replyInfoStream);
		httpURLConnection.disconnect();
		
		return resultData;
	}
	
}
