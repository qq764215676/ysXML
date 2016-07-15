package com.net.xml.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.constants.ServerInfo;
import com.net.xml.bean.Document;
import com.net.xml.dto.XmlWrapper.XmlData.DATA.YOUNGDOCUMENTS.YOUNGDOCUMENT;
import com.net.xml.dto.XmlWrapper.XmlData.DATA.YOUNGPROPERTIES.YOUNGPROPERTY;
import com.utils.IOUtils;

/**
 * 
 * 云平台xml请求 包装类
 * 
 */
public class XmlWrapper
{
	private XmlWrapper(){}
	
	/**
	 * 包装查询数据请求；可以查询当前平台数据库中的表记录的相关信息；默认从数据库的匹配结果中获取全部的所有数据
	 * @param query sql查询语句
	 * @param contentTypeName 查询的目标表名
	 * @return
	 */
	public static String wrapXmlForSelect(String query, String contentTypeName)
	{
		return wrapXmlForSelect(query, contentTypeName, "", "");
	}
	
	/**
	 * 包装查询数据请求；可以查询当前平台数据库中的表记录的相关信息
	 * @param query sql查询语句
	 * @param contentTypeName 查询的目标表名
	 * @param offset 获取结果的起始位置
	 * @param size 获取结果的数量
	 * @return
	 */
	public static String wrapXmlForSelect(String query, String contentTypeName, String offset, String size)
	{
		XmlData dataList = new XmlData();

		dataList.COMMAND = ServerInfo.REQUEST_COMMAND_SEARCHYOUNGCONTENT;
		dataList.AUTHENTICATION.LOGONDATA.USERNAME = ServerInfo.LOGIN_USERNAME;
		dataList.AUTHENTICATION.LOGONDATA.PASSWORD = ServerInfo.LOGIN_PASSWORD;
		dataList.DATA.SIMPLESEARCH = "false";
		dataList.DATA.CONTENTTYPENAME = contentTypeName;
		dataList.DATA.QUERY = query;
		dataList.DATA.OFFSET = offset;
		dataList.DATA.SIZE = size;
		dataList.DATA.RETENTIONDOC = "true";
		dataList.DATA.CHECKDOCONLY = "true";
		dataList.DATA.NOTINCLUDEDOCINFO = "false";
		
		return wrapXml(dataList);
	}
	
	/**
	 * 包装修改数据请求；可以修改当前平台数据库中的一条表记录的相关信息
	 * @param fieldList 要修改的字段列表
	 * @param contentId 要修改的表记录的contentId
	 * @param file 以该file替换修改后的表记录的附件列表
	 * @return
	 */
	public static String wrapXmlForUpdate(HashMap<String, String> fieldList, String contentId, Document file)
	{
		ArrayList<Document> fileList = new ArrayList<>();
		fileList.add(file);
		return wrapXmlForUpdate(fieldList, contentId, fileList);
	}
	
	/**
	 * 包装修改数据请求；可以修改当前平台数据库中的一条表记录的相关信息
	 * @param fieldList 要修改的字段列表
	 * @param contentId 要修改的表记录的contentId
	 * @param fileList 以该fileList替换修改后的表记录的附件列表
	 * @return
	 */
	public static String wrapXmlForUpdate(HashMap<String, String> fieldList, String contentId, Document[] fileArray)
	{
		ArrayList<Document> fileList = new ArrayList<>();
		for (Document document : fileArray)
		{
			fileList.add(document);
		}
		return wrapXmlForUpdate(fieldList, contentId, fileList);
	}
	
	/**
	 * 包装修改数据请求；可以修改当前平台数据库中的一条表记录的相关信息
	 * @param fieldList 要修改的字段列表
	 * @param contentId 要修改的表记录的contentId
	 * @param fileList 以该fileList替换修改后的表记录的附件列表
	 * @return
	 */
	public static String wrapXmlForUpdate(HashMap<String, String> fieldList, String contentId, ArrayList<Document> fileList)
	{
		XmlData dataList = new XmlData();
		
		dataList.COMMAND = ServerInfo.REQUEST_COMMAND_IMPORTYOUNGCONTENT;
		dataList.AUTHENTICATION.LOGONDATA.USERNAME = ServerInfo.LOGIN_USERNAME;
		dataList.AUTHENTICATION.LOGONDATA.PASSWORD = ServerInfo.LOGIN_PASSWORD;
		dataList.DATA.CONTENTID = contentId;
		if(fieldList != null)
		{
			Iterator<String> fieldIterator = fieldList.keySet().iterator();
			while(fieldIterator.hasNext())
			{
				String fieldName = fieldIterator.next();
				String fieldValue = fieldList.get(fieldName);
				
				YOUNGPROPERTY YOUNGPROPERTY = new YOUNGPROPERTY();
				YOUNGPROPERTY.NAME = fieldName;
				YOUNGPROPERTY.VALUE = fieldValue;
				
				dataList.DATA.YOUNGPROPERTIES.YOUNGPROPERTY.add(YOUNGPROPERTY);
			}
		}
		if(fileList != null)
		{
			for (Document document : fileList)
			{
				String fileName = document.getName();
				String fileType = document.getFileType();
				String inputStream64 = IOUtils.fileTo64ByteString(document);
				
				YOUNGDOCUMENT YOUNGDOCUMENT = new YOUNGDOCUMENT();
				YOUNGDOCUMENT.SOURCEFILENAME = fileName;
				YOUNGDOCUMENT.MIMETYPE = fileType+"&#xD;";
				YOUNGDOCUMENT.INPUTSTREAM = inputStream64;
				YOUNGDOCUMENT.SIZE = String.valueOf(document.length());
				YOUNGDOCUMENT.DOCUMENTTYPENAME = "FILE";
				
				dataList.DATA.YOUNGDOCUMENTS.YOUNGDOCUMENT.add(YOUNGDOCUMENT);
			}
		}
		
		return wrapXml(dataList);
	}
	/**
	 * 包装导入请求；可以向平台数据库中增加一条表记录
	 * @param fieldList 该表记录的字段列表
	 * @param contentTypeName 该表记录所属的表名
	 * @param file 该表记录的附件
	 * @return
	 */
	public static String wrapXmlForInsert(HashMap<String, String> fieldList, String contentTypeName, Document file)
	{
		ArrayList<Document> fileList = new ArrayList<>();
		fileList.add(file);
		return wrapXmlForInsert(fieldList, contentTypeName, fileList);
	}
	
	/**
	 * 包装导入请求；可以向平台数据库中增加一条表记录
	 * @param fieldList 该表记录的字段列表
	 * @param contentTypeName 该表记录所属的表名
	 * @param fileList 该表记录的附件列表
	 * @return
	 */
	public static String wrapXmlForInsert(HashMap<String, String> fieldList, String contentTypeName, Document[] fileArray)
	{
		ArrayList<Document> fileList = new ArrayList<>();
		for (Document document : fileArray)
		{
			fileList.add(document);
		}
		return wrapXmlForInsert(fieldList, contentTypeName, fileList);
	}
	
	/**
	 * 包装导入请求；可以向平台数据库中增加一条表记录
	 * @param fieldList 该表记录的字段列表
	 * @param contentTypeName 该表记录所属的表名
	 * @param fileList 该表记录的附件列表
	 * @return
	 */
	public static String wrapXmlForInsert(HashMap<String, String> fieldList, String contentTypeName, ArrayList<Document> fileList)
	{
		XmlData dataList = new XmlData();
		
		dataList.COMMAND = ServerInfo.REQUEST_COMMAND_IMPORTYOUNGCONTENT;
		dataList.AUTHENTICATION.LOGONDATA.USERNAME = ServerInfo.LOGIN_USERNAME;
		dataList.AUTHENTICATION.LOGONDATA.PASSWORD = ServerInfo.LOGIN_PASSWORD;
		dataList.DATA.CONTENTTYPENAME = contentTypeName;
		if(fieldList != null)
		{
			Iterator<String> fieldIterator = fieldList.keySet().iterator();
			while(fieldIterator.hasNext())
			{
				String fieldName = fieldIterator.next();
				String fieldValue = fieldList.get(fieldName);
				
				YOUNGPROPERTY YOUNGPROPERTY = new YOUNGPROPERTY();
				YOUNGPROPERTY.NAME = fieldName;
				YOUNGPROPERTY.VALUE = fieldValue;
				
				dataList.DATA.YOUNGPROPERTIES.YOUNGPROPERTY.add(YOUNGPROPERTY);
			}
		}
		if(fileList != null)
		{
			for (Document document : fileList)
			{
				String fileName = document.getName();
				String fileType = document.getFileType();
				String inputStream64 = IOUtils.fileTo64ByteString(document);
				
				YOUNGDOCUMENT YOUNGDOCUMENT = new YOUNGDOCUMENT();
				YOUNGDOCUMENT.SOURCEFILENAME = fileName;
				YOUNGDOCUMENT.MIMETYPE = fileType+"&#xD;";
				YOUNGDOCUMENT.INPUTSTREAM = inputStream64;
				YOUNGDOCUMENT.SIZE = String.valueOf(document.length());
				YOUNGDOCUMENT.DOCUMENTTYPENAME = "FILE";
				
				dataList.DATA.YOUNGDOCUMENTS.YOUNGDOCUMENT.add(YOUNGDOCUMENT);
			}
		}
		
		return wrapXml(dataList);
	}
	
	/**
	 * 包装删除数据请求；可以删除平台数据库中的一条表记录
	 * @param contentId 要删除的表记录的contentId
	 * @return
	 */
	public static String wrapXmlForDelete(String contentId)
	{
		XmlData dataList = new XmlData();
		
		dataList.COMMAND = ServerInfo.REQUEST_COMMAND_DELETEYOUNGCONTENT;
		dataList.AUTHENTICATION.LOGONDATA.USERNAME = ServerInfo.LOGIN_USERNAME;
		dataList.AUTHENTICATION.LOGONDATA.PASSWORD = ServerInfo.LOGIN_PASSWORD;
		dataList.DATA.CONTENTID = contentId;
		
		return wrapXml(dataList);
	}
	
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 */
	public static String wrapXmlForLogon(String userName, String password)
	{
		XmlData dataList = new XmlData();

		dataList.COMMAND = ServerInfo.REQUEST_COMMAND_LOGON;
		dataList.AUTHENTICATION.LOGONDATA.USERNAME = userName;
		dataList.AUTHENTICATION.LOGONDATA.PASSWORD = password;
		
		return wrapXml(dataList);
	}
	
	/**
	 * 创建账户
	 * @param userName
	 * @param password
	 * @return
	 */
	public static String wrapXmlForAccount(String userName, String password)
	{
		XmlData dataList = new XmlData();
		
		dataList.COMMAND = ServerInfo.REQUEST_COMMAND_IMPORTYOUNGUSER;
		dataList.AUTHENTICATION.LOGONDATA.USERNAME = ServerInfo.LOGIN_USERNAME;
		dataList.AUTHENTICATION.LOGONDATA.PASSWORD = ServerInfo.LOGIN_PASSWORD;
		dataList.DATA.NAME = userName;
		dataList.DATA.PASSWORD = password;
		dataList.DATA.YOUNGSECURITYROLE.NAME = "Administrator";
		
		return wrapXml(dataList);
	}
	
	/**
	 * 将对应云平台xml请求的数据结构中的数据提取出来；转换为字符串形式的xml请求；
	 * @param xmlData 包含请求数据
	 * @return
	 */
	public static String wrapXml(XmlData xmlData)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		sb.append("<Body>");
		sb.append("<REQUEST>");
		sb.append("<AUTHENTICATION>");
		sb.append("<SERVERDEF>");
		sb.append("<SERVERNAME>"+xmlData.AUTHENTICATION.SERVERDEF.SERVERNAME+"</SERVERNAME>");
		sb.append("</SERVERDEF>");
		sb.append("<LOGONDATA>");
		sb.append("<USERNAME>"+xmlData.AUTHENTICATION.LOGONDATA.USERNAME+"</USERNAME>");
		sb.append("<PASSWORD>"+xmlData.AUTHENTICATION.LOGONDATA.PASSWORD+"</PASSWORD>");
		sb.append("</LOGONDATA>");
		sb.append("</AUTHENTICATION>");
		sb.append("<COMMAND>"+xmlData.COMMAND+"</COMMAND>");
		sb.append("<DATA>");
		sb.append("<CONTENTID>"+xmlData.DATA.CONTENTID+"</CONTENTID>");
		sb.append("<CONTENTTYPENAME>"+xmlData.DATA.CONTENTTYPENAME+"</CONTENTTYPENAME>");
		sb.append("<FOLDER>"+xmlData.DATA.FOLDER+"</FOLDER>");
		sb.append("<SIMPLESEARCH>"+xmlData.DATA.SIMPLESEARCH+"</SIMPLESEARCH>");
		sb.append("<QUERY>"+xmlData.DATA.QUERY+"</QUERY>");
		sb.append("<OFFSET>"+xmlData.DATA.OFFSET+"</OFFSET>");
		sb.append("<SIZE>"+xmlData.DATA.SIZE+"</SIZE>");
		sb.append("<ORDERBY>"+xmlData.DATA.ORDERBY+"</ORDERBY>");
		sb.append("<COLUMNLIST>"+xmlData.DATA.COLUMNLIST+"</COLUMNLIST>");
		sb.append("<RETENTIONDOC>"+xmlData.DATA.RETENTIONDOC+"</RETENTIONDOC>");
		sb.append("<CHECKDOCONLY>"+xmlData.DATA.CHECKDOCONLY+"</CHECKDOCONLY>");
		sb.append("<NOTINCLUDEDOCINFO>"+xmlData.DATA.NOTINCLUDEDOCINFO+"</NOTINCLUDEDOCINFO>");
		sb.append("<PASSWORD>"+xmlData.DATA.PASSWORD+"</PASSWORD>");
		sb.append("<STATUS>"+xmlData.DATA.STATUS+"</STATUS>");
		sb.append("<EXTATTR1>"+xmlData.DATA.EXTATTR1+"</EXTATTR1>");
		sb.append("<EXTATTR2>"+xmlData.DATA.EXTATTR2+"</EXTATTR2>");
		sb.append("<YOUNGUSERGROUPS>");
		sb.append("<NAME>"+xmlData.DATA.YOUNGSECURITYROLE.NAME+"</NAME>");
		sb.append("</YOUNGUSERGROUPS>");
		sb.append("<YOUNGPROPERTIES>");
		for (int i = 0; i < xmlData.DATA.YOUNGPROPERTIES.YOUNGPROPERTY.size(); i++)
		{
			sb.append("<YOUNGPROPERTY>");
			sb.append("<NAME>"+xmlData.DATA.YOUNGPROPERTIES.YOUNGPROPERTY.get(i).NAME+"</NAME>");
			sb.append("<TYPE>"+xmlData.DATA.YOUNGPROPERTIES.YOUNGPROPERTY.get(i).TYPE+"</TYPE>");
			sb.append("<VALUE>"+xmlData.DATA.YOUNGPROPERTIES.YOUNGPROPERTY.get(i).VALUE+"</VALUE>");
			sb.append("</YOUNGPROPERTY>");
		}
		sb.append("</YOUNGPROPERTIES>");
		sb.append("<YOUNGDOCUMENTS>");
		for (int i = 0; i < xmlData.DATA.YOUNGDOCUMENTS.YOUNGDOCUMENT.size(); i++)
		{
			sb.append("<YOUNGDOCUMENT>");
			sb.append("<SOURCEFILENAME>"+xmlData.DATA.YOUNGDOCUMENTS.YOUNGDOCUMENT.get(i).SOURCEFILENAME+"</SOURCEFILENAME>");
			sb.append("<DOCUMENTTYPENAME>"+xmlData.DATA.YOUNGDOCUMENTS.YOUNGDOCUMENT.get(i).DOCUMENTTYPENAME+"</DOCUMENTTYPENAME>");
			sb.append("<INPUTSTREAM>"+xmlData.DATA.YOUNGDOCUMENTS.YOUNGDOCUMENT.get(i).INPUTSTREAM+"</INPUTSTREAM>");
			sb.append("<SIZE>"+xmlData.DATA.YOUNGDOCUMENTS.YOUNGDOCUMENT.get(i).SIZE+"</SIZE>");
			sb.append("<MIMETYPE>"+xmlData.DATA.YOUNGDOCUMENTS.YOUNGDOCUMENT.get(i).MIMETYPE+"</MIMETYPE>");
			sb.append("</YOUNGDOCUMENT>");
		}
		sb.append("</YOUNGDOCUMENTS>");
		sb.append("</DATA>");
		sb.append("</REQUEST>");
		sb.append("</Body>");
		sb.append("</Envelope>");
		
		return sb.toString();
	}
	
	/** 对应云平台xml请求的数据结构；包含数据列表；要发送的请求数据应往该对象中填充 */
	public static class XmlData
	{
		public AUTHENTICATION AUTHENTICATION = new AUTHENTICATION();
		public String COMMAND = "";
		public DATA DATA = new DATA();
		
		public static class AUTHENTICATION
		{
			public SERVERDEF SERVERDEF = new SERVERDEF();
			public LOGONDATA LOGONDATA = new LOGONDATA();
			
			public static class SERVERDEF
			{
				public String SERVERNAME = "";
			}
			
			public static class LOGONDATA
			{
				public String USERNAME = "";
				public String PASSWORD = "";
			}
		}
		
		public static class DATA
		{
			public String CONTENTID = "";
			public String CONTENTTYPENAME = "";
			public String FOLDER = "";
			public String SIMPLESEARCH = "";
			public String QUERY = "";
			public String OFFSET = "";
			public String SIZE = "";
			public String ORDERBY = "";
			public String COLUMNLIST = "";
			public String RETENTIONDOC = "";
			public String CHECKDOCONLY = "";
			public String NOTINCLUDEDOCINFO = "";
			public String NAME = "";
			public String PASSWORD = "";
			public String STATUS = "";
			public String EXTATTR1 = "";
			public String EXTATTR2 = "";
			public String YOUNGUSERGROUPS = "";
			public YOUNGSECURITYROLE YOUNGSECURITYROLE = new YOUNGSECURITYROLE();
			public YOUNGPROPERTIES YOUNGPROPERTIES = new YOUNGPROPERTIES();
			public YOUNGDOCUMENTS YOUNGDOCUMENTS = new YOUNGDOCUMENTS();
			
			public static class YOUNGSECURITYROLE
			{
				public String NAME = "";
			}
			
			public static class YOUNGPROPERTIES
			{
				public ArrayList<YOUNGPROPERTY> YOUNGPROPERTY = new ArrayList<>();
				
				public static class YOUNGPROPERTY
				{
					public String NAME = "";
					public String TYPE = "";
					public String VALUE = "";
				}
			}
			
			public static class YOUNGDOCUMENTS
			{
				public ArrayList<YOUNGDOCUMENT> YOUNGDOCUMENT = new ArrayList<>();
				
				public static class YOUNGDOCUMENT
				{
					public String SOURCEFILENAME = "";
					public String DOCUMENTTYPENAME = "";
					public String INPUTSTREAM = "";
					public String SIZE = "";
					public String MIMETYPE = "";
				}
			}
		}
	}
	
}
