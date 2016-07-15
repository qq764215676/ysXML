package com.net.xml.dto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.constants.XmlInfo;
import com.net.xml.bean.XmlData;
import com.net.xml.bean.XmlData.YOUNGCONTENT;
import com.net.xml.bean.XmlData.YOUNGCONTENT.YOUNGDOCUMENTS.YOUNGDOCUMENT;
import com.net.xml.bean.XmlData.YOUNGCONTENT.YOUNGPROPERTIES.YOUNGPROPERTY;

/**
 * 
 * 云平台xml文件解析类
 *
 */
public class XmlParser
{
	private XmlParser(){}
	
	/**
	 * 解析xml，返回包含xml信息的XmlData对象
	 * @param xmlStr xml信息对应的字符串
	 * @return  XmlData 保存xml数据的类
	 */
	public static XmlData parseXml(String xmlStr)
	{
		return parseXml(new InputSource(new StringReader(xmlStr)));
	}
	
	/**
	 * 解析xml，返回包含xml信息的XmlData对象
	 * @param file xml信息对应的文件
	 * @return XmlData 保存xml数据的类
	 */
	public static XmlData parseXml(File file)
	{
		try
		{
			return parseXml(new FileInputStream(file));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 解析xml，返回包含xml信息的XmlData对象
	 * @param inputStream xml信息对应的输入流
	 * @return
	 */
	public static XmlData parseXml(InputStream inputStream)
	{
		return parseXml(new InputSource(inputStream));
	}
	
	/**
	 * 解析xml，返回包含xml信息的XmlData对象
	 * @param inputSource xml信息对应的inputSource
	 * @return XmlData 保存xml数据的类
	 */
	public static XmlData parseXml(InputSource inputSource)
	{
		XmlData xmlData = null;
		
		try
		{
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			XmlParseHandler xmlParserHandler = new XmlParseHandler();
			saxParser.parse(inputSource, xmlParserHandler); //开始解析
			xmlData = xmlParserHandler.getXmlData(); //解析完成后，获取XmlData对象
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		
		return xmlData;
	}
	
	/**
	 * 
	 * 云平台xml文件SAX解析Handler
	 *
	 */
	private static class XmlParseHandler extends DefaultHandler
	{
		private XmlData xmlData;
		
		public XmlData getXmlData()
		{
			return xmlData;
		}
		
		//解析中用到的临时变量
		private YOUNGCONTENT YOUNGCONTENT;
		private YOUNGPROPERTY YOUNGPROPERTY;
		private YOUNGDOCUMENT YOUNGDOCUMENT;
		private String currentOuterTag = ""; //当前标签的外层标签
		private String value; //双标签节点中夹带的属性值
		@Override
		public void startDocument() throws SAXException
		{
			super.startDocument();
			
			xmlData = new XmlData();
		}
		
		@Override
		public void endDocument() throws SAXException
		{
			super.endDocument();
		}
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
		{
			super.startElement(uri, localName, qName, attributes);
			
			switch(qName)
			{
				case XmlInfo.TAG_YOUNGCONTENT:
				{
					currentOuterTag = XmlInfo.TAG_YOUNGCONTENT;
					YOUNGCONTENT = new YOUNGCONTENT();
				}break;
				
				case XmlInfo.TAG_YOUNGPROPERTIES:
				{
					currentOuterTag = XmlInfo.TAG_YOUNGPROPERTIES;
				}break;
				
				case XmlInfo.TAG_YOUNGDOCUMENTS:
				{
					currentOuterTag = XmlInfo.TAG_YOUNGDOCUMENTS;
				}break;
				
				case XmlInfo.TAG_YOUNGPROPERTY:
				{
					currentOuterTag = XmlInfo.TAG_YOUNGPROPERTY;
					YOUNGPROPERTY = new YOUNGPROPERTY();
				}break;
				
				case XmlInfo.TAG_YOUNGDOCUMENT:
				{
					currentOuterTag = XmlInfo.TAG_YOUNGDOCUMENT;
					YOUNGDOCUMENT = new YOUNGDOCUMENT();
				}break;
				
				case XmlInfo.TAG_SUCCESS:
				{
					//若xml文件中存在TAG_SUCCESS标签，则说明服务器正常返回了结果
					xmlData.SUCCESS = true;
				}break;
			}
		}
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException
		{
			super.characters(ch, start, length);
			
			String value = new String(ch, start, length);
			if(!value.trim().equals("")) //剔除为空白字符串的节点
			{
				this.value = value;
			}
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException
		{
			super.endElement(uri, localName, qName);
			
			//这里的解析标签的操作，需要根据包裹它们的外围标签来对应执行
			switch(currentOuterTag)
			{
				//YOUNGCONTENT下的直接子属性
				case XmlInfo.TAG_YOUNGCONTENT:
				{
					switch(qName)
					{
						case XmlInfo.TAG_ROOT: YOUNGCONTENT.ROOT = value; break;
						case XmlInfo.TAG_FOLDER: YOUNGCONTENT.FOLDER = value; break;
						case XmlInfo.TAG_NODECLASS: YOUNGCONTENT.NODECLASS = value; break;
						case XmlInfo.TAG_NODETYPENAME: YOUNGCONTENT.NODETYPENAME = value; break;
						case XmlInfo.TAG_CONTENTTYPENAME: YOUNGCONTENT.CONTENTTYPENAME = value; break;
						case XmlInfo.TAG_CONTENTTYPEID: YOUNGCONTENT.CONTENTTYPEID = value; break;
						case XmlInfo.TAG_NODETYPEID: YOUNGCONTENT.NODETYPEID = value; break;
						case XmlInfo.TAG_PARENTNODEID: YOUNGCONTENT.PARENTNODEID = value; break;
						case XmlInfo.TAG_CONTENTID: YOUNGCONTENT.CONTENTID = value; break;
						case XmlInfo.TAG_NODEID: YOUNGCONTENT.NODEID = value; break;
						case XmlInfo.TAG_VERSIONID: YOUNGCONTENT.VERSIONID = value; break;
						case XmlInfo.TAG_PROPERTYLISTSIZE: YOUNGCONTENT.PROPERTYLISTSIZE = value; break;
						case XmlInfo.TAG_CRUDSTATUS: YOUNGCONTENT.CRUDSTATUS = value; break;
						case XmlInfo.TAG_CONTENTCLASS: YOUNGCONTENT.CONTENTCLASS = value; break;
						case XmlInfo.TAG_CONTENTSTATUS: YOUNGCONTENT.CONTENTSTATUS = value; break;
						case XmlInfo.TAG_RETENTIONCONTENT: YOUNGCONTENT.RETENTIONCONTENT = value; break;
						case XmlInfo.TAG_CHECKEDOUTUSER: YOUNGCONTENT.CHECKEDOUTUSER = value; break;
						case XmlInfo.TAG_CHECKEDOUT: YOUNGCONTENT.CHECKEDOUT = value; break;
						case XmlInfo.TAG_CREATEDATE: YOUNGCONTENT.CREATEDATE = value; break;
						case XmlInfo.TAG_CREATEUSER: YOUNGCONTENT.CREATEUSER = value; break;
						case XmlInfo.TAG_LASTCHANGEDDATE: YOUNGCONTENT.LASTCHANGEDDATE = value; break;
						case XmlInfo.TAG_LASTCHANGEDUSER: YOUNGCONTENT.LASTCHANGEDUSER = value; break;
						case XmlInfo.TAG_SERVERID: YOUNGCONTENT.SERVERID = value; break;
					}
				}break;
				
				//YOUNGPROPERTY下的直接子属性
				case XmlInfo.TAG_YOUNGPROPERTY:
				{
					switch(qName)
					{
						case XmlInfo.TAG_NAME: YOUNGPROPERTY.NAME = value; break;
						case XmlInfo.TAG_DESCRIPTION: YOUNGPROPERTY.DESCRIPTION = value; break;
						case XmlInfo.TAG_ID: YOUNGPROPERTY.ID = value; break;
						case XmlInfo.TAG_CONTROLFLAG: YOUNGPROPERTY.CONTROLFLAG = value; break;
						case XmlInfo.TAG_TYPE: YOUNGPROPERTY.TYPE = value; break;
						case XmlInfo.TAG_LENGTH: YOUNGPROPERTY.LENGTH = value; break;
						case XmlInfo.TAG_PRECISION: YOUNGPROPERTY.PRECISION = value; break;
						case XmlInfo.TAG_SCALE: YOUNGPROPERTY.SCALE = value; break;
						case XmlInfo.TAG_GROUPID: YOUNGPROPERTY.GROUPID = value; break;
						case XmlInfo.TAG_MAXINTVALUE: YOUNGPROPERTY.MAXINTVALUE = value; break;
						case XmlInfo.TAG_MININTVALUE: YOUNGPROPERTY.MININTVALUE = value; break;
						case XmlInfo.TAG_STRINGCONSTRAINT: YOUNGPROPERTY.STRINGCONSTRAINT = value; break;
						case XmlInfo.TAG_MINVALUESET: YOUNGPROPERTY.MINVALUESET = value; break;
						case XmlInfo.TAG_MAXVALUESET: YOUNGPROPERTY.MAXVALUESET = value; break;
						case XmlInfo.TAG_VALID: YOUNGPROPERTY.VALID = value; break;
						case XmlInfo.TAG_SEARCHABLE: YOUNGPROPERTY.SEARCHABLE = value; break;
						case XmlInfo.TAG_MANDATORY: YOUNGPROPERTY.MANDATORY = value; break;
						case XmlInfo.TAG_PROTECTED: YOUNGPROPERTY.PROTECTED = value; break;
						case XmlInfo.TAG_UNIQUE: YOUNGPROPERTY.UNIQUE = value; break;
						case XmlInfo.TAG_PRIMARY: YOUNGPROPERTY.PRIMARY = value; break;
						case XmlInfo.TAG_TEXTSEARCHABLE: YOUNGPROPERTY.TEXTSEARCHABLE = value; break;
						case XmlInfo.TAG_DISPLAYORDER: YOUNGPROPERTY.DISPLAYORDER = value; break;
						case XmlInfo.TAG_CONTENTTYPEID: YOUNGPROPERTY.CONTENTTYPEID = value; break;
						case XmlInfo.TAG_NODETYPEID: YOUNGPROPERTY.NODETYPEID = value; break;
						case XmlInfo.TAG_CRUDSTATUS: YOUNGPROPERTY.CRUDSTATUS = value; break;
						case XmlInfo.TAG_PARENTKEY: YOUNGPROPERTY.PARENTKEY = value; break;
						case XmlInfo.TAG_FOREIGNKEY: YOUNGPROPERTY.FOREIGNKEY = value; break;
						case XmlInfo.TAG_LINKED: YOUNGPROPERTY.LINKED = value; break;
						case XmlInfo.TAG_VALUE: YOUNGPROPERTY.VALUE = value; break;
						case XmlInfo.TAG_USERINPUTED: YOUNGPROPERTY.USERINPUTED = value; break;
					}
				}break;
				
				//YOUNGDOCUMENT下的直接子属性
				case XmlInfo.TAG_YOUNGDOCUMENT:
				{
					switch(qName)
					{
						case XmlInfo.TAG_DOCUMENTID: YOUNGDOCUMENT.DOCUMENTID = value; break;
						case XmlInfo.TAG_VERSIONID: YOUNGDOCUMENT.VERSIONID = value; break;
						case XmlInfo.TAG_STORAGEID: YOUNGDOCUMENT.STORAGEID = value; break;
						case XmlInfo.TAG_CONTAINERID: YOUNGDOCUMENT.CONTAINERID = value; break;
						case XmlInfo.TAG_DOCFILENAME: YOUNGDOCUMENT.DOCFILENAME = value; break;
						case XmlInfo.TAG_DOCUMENTTYPEID: YOUNGDOCUMENT.DOCUMENTTYPEID = value; break;
						case XmlInfo.TAG_NODETYPEID: YOUNGDOCUMENT.NODETYPEID = value; break;
						case XmlInfo.TAG_DOCUMENTTYPENAME: YOUNGDOCUMENT.DOCUMENTTYPENAME = value; break;
						case XmlInfo.TAG_SIZE: YOUNGDOCUMENT.SIZE = value; break;
						case XmlInfo.TAG_MIMETYPEID: YOUNGDOCUMENT.MIMETYPEID = value; break;
						case XmlInfo.TAG_MIMETYPE: YOUNGDOCUMENT.MIMETYPE = value; break;
						case XmlInfo.TAG_STATUS: YOUNGDOCUMENT.STATUS = value; break;
						case XmlInfo.TAG_DATALOCATION: YOUNGDOCUMENT.DATALOCATION = value; break;
						case XmlInfo.TAG_EMPTYINCACHE: YOUNGDOCUMENT.EMPTYINCACHE = value; break;
						case XmlInfo.TAG_CRUDSTATUS: YOUNGDOCUMENT.CRUDSTATUS = value; break;
						case XmlInfo.TAG_CONTENTTYPENAME: YOUNGDOCUMENT.CONTENTTYPENAME = value; break;
						case XmlInfo.TAG_ENCRYPTIONREQUIRED: YOUNGDOCUMENT.ENCRYPTIONREQUIRED = value; break;
						case XmlInfo.TAG_DOCUMENTFLAG: YOUNGDOCUMENT.DOCUMENTFLAG = value; break;
					}
				}break;
			}
			
			//这里的解析标签的操作，不需要判断其外围标签
			switch(qName)
			{
				case XmlInfo.TAG_YOUNGCONTENT:
				{
					xmlData.YOUNGCONTENT.add(YOUNGCONTENT);
				}break;
				
				case XmlInfo.TAG_YOUNGPROPERTY:
				{
					YOUNGCONTENT.YOUNGPROPERTIES.YOUNGPROPERTY.add(YOUNGPROPERTY);
				}break;
				
				case XmlInfo.TAG_YOUNGDOCUMENT:
				{
					YOUNGCONTENT.YOUNGDOCUMENTS.YOUNGDOCUMENT.add(YOUNGDOCUMENT);
				}break;
				
				case XmlInfo.TAG_ERROR:
				{
					xmlData.ERROR = value;
				}break;
			}
		}
	}
}
