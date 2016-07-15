package com.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.constants.ServerInfo;
import com.net.xml.bean.XmlData;
import com.net.xml.dto.XmlParser;

/**
 * 
 * http请求类，用于发送xml请求
 * 
 */
public class HttpRequester
{
	private HttpRequester(){}
	
	/**
	 * 发送xml请求
	 * @param xmlRequestStr xml请求字符串
	 * @return 服务器响应的数据
	 */
	public static XmlData postRequest(String xmlRequestStr)
	{
		return postRequest(ServerInfo.IP_ADDRESS_WEBSERVICE, 20000, 20000, xmlRequestStr);
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
	
	/**
	 * 使用给定的HttpURLConnection对象、请求信息字符串，向目标地址发送请求信息，并获取目标返回的结果
	 * @param httpURLConnection
	 * @param xmlRequestStr 请求信息字符串
	 * @return 目标地址响应请求信息后，返回的处理结果信息
	 */
	public static InputStream postRequest(HttpURLConnection httpURLConnection, String xmlRequestStr)
	{
		InputStream inputStream = null;
		
		try
		{
			httpURLConnection.getOutputStream().write(xmlRequestStr.getBytes());
			httpURLConnection.getOutputStream().flush();
			inputStream = httpURLConnection.getInputStream();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return inputStream;
	}
	
	/**
	 * 创建HttpURLConnection连接
	 * @param UrlSpec 请求目的地址
	 * @param connectTimeout 连接超时时间
	 * @param readTimeout 读取数据超时时间
	 * @return 创建成功时，返回HttpURLConnection对象
	 */
	public static HttpURLConnection createConnection(String UrlSpec, int connectTimeout, int readTimeout)
	{
		HttpURLConnection httpURLConnection = null;
		
		try
		{
			URL url = new URL(UrlSpec);
			httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setDoOutput(true); //可以写入信息
			httpURLConnection.setDoInput(true); //可以读取信息
			httpURLConnection.setConnectTimeout(connectTimeout);
			httpURLConnection.setReadTimeout(readTimeout);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return httpURLConnection;
	}
	
}
