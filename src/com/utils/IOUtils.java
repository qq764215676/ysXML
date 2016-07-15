package com.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * IO操作工具类
 * 
 */
public class IOUtils
{
	private IOUtils(){}
	
	/**
	 * 将流转换为字符串
	 * @param inputStream
	 * @return
	 */
	public static String streamToString(InputStream inputStream)
	{
		StringBuffer xmlStr = new StringBuffer();
		
		try
		{
			InputStreamReader isr = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(isr);
			String str;
			while((str = br.readLine()) != null)
			{
				xmlStr.append(str);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return xmlStr.toString();
	}
	
	/**
	 * 将流转换为字节数组
	 * @param inputStream
	 * @return
	 */
	public static byte[] streamToByte(InputStream inputStream)
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte data[] = new byte[1024];
		int count;
		try
		{
			while (((count = inputStream.read(data)) != -1))
			{
				baos.write(data, 0, count);
			}
			baos.flush();
		}
		catch (IOException e)
		{
		}
		return baos.toByteArray();
	}
	
	/**
	 * 将流转换为64位编码字节数组
	 * @param inputStream
	 * @return
	 */
	public static byte[] streamTo64Byte(InputStream inputStream)
	{
		return Base64.encodeBase64(streamToByte(inputStream));
	}
	
	/**
	 * 将流转换为64位编码字节数组字符串
	 * @param inputStream
	 * @return
	 */
	public static String streamTo64ByteString(InputStream inputStream)
	{
		return new String(streamTo64Byte(inputStream));
	}
	
	/**
	 * 将文件转换为64位编码字节数组字符串
	 * @param file
	 * @return
	 */
	public static String fileTo64ByteString(File file)
	{
		try
		{
			return streamTo64ByteString(new FileInputStream(file));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 写信息到指定的文件中
	 * @param info 要写入的信息字符串
	 * @param path 要写入的目标文件的路径
	 */
	public static boolean writeStringToFile(String info, String path)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(info.getBytes());
			fos.flush();
			fos.close();
			
			return true;
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
}
