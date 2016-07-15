package com.net.xml.dto;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.net.xml.bean.XmlConstants;
import com.net.xml.bean.XmlData;
import com.net.xml.bean.XmlData.YOUNGCONTENT;
import com.net.xml.bean.XmlData.YOUNGCONTENT.YOUNGDOCUMENTS.YOUNGDOCUMENT;
import com.net.xml.bean.XmlData.YOUNGCONTENT.YOUNGPROPERTIES.YOUNGPROPERTY;

/**
 * 
 * 云平台xml文件SAX解析类
 * 16.07
 * @author lmc
 *
 */
public class XmlParserHandler extends DefaultHandler
{
	private XmlData xmlData;
	private YOUNGCONTENT YOUNGCONTENT;
	private YOUNGPROPERTY YOUNGPROPERTY;
	private YOUNGDOCUMENT YOUNGDOCUMENT;
	private String currentOuterTag = ""; //当前标签的外层标签
	private String value; //双标签夹带的属性值
	
	public XmlData getXmlData()
	{
		return xmlData;
	}
	
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
			case XmlConstants.TAG_YOUNGCONTENT:
			{
				currentOuterTag = XmlConstants.TAG_YOUNGCONTENT;
				YOUNGCONTENT = new YOUNGCONTENT();
			}break;
			
			case XmlConstants.TAG_YOUNGPROPERTIES:
			{
				currentOuterTag = XmlConstants.TAG_YOUNGPROPERTIES;
			}break;
			
			case XmlConstants.TAG_YOUNGDOCUMENTS:
			{
				currentOuterTag = XmlConstants.TAG_YOUNGDOCUMENTS;
			}break;
			
			case XmlConstants.TAG_YOUNGPROPERTY:
			{
				currentOuterTag = XmlConstants.TAG_YOUNGPROPERTY;
				YOUNGPROPERTY = new YOUNGPROPERTY();
			}break;
			
			case XmlConstants.TAG_YOUNGDOCUMENT:
			{
				currentOuterTag = XmlConstants.TAG_YOUNGDOCUMENT;
				YOUNGDOCUMENT = new YOUNGDOCUMENT();
			}break;
			
			case XmlConstants.TAG_SUCCESS:
			{
				xmlData.SUCCESS = true;
			}break;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException
	{
		super.characters(ch, start, length);
		
		String value = new String(ch, start, length);
		if(!value.trim().equals(""))
		{
			this.value = value;
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException
	{
		super.endElement(uri, localName, qName);
		
		switch(currentOuterTag)
		{
			//YOUNGCONTENT下的直接子属性
			case XmlConstants.TAG_YOUNGCONTENT:
			{
				switch(qName)
				{
					case XmlConstants.TAG_ROOT: YOUNGCONTENT.ROOT = value; break;
					case XmlConstants.TAG_FOLDER: YOUNGCONTENT.FOLDER = value; break;
					case XmlConstants.TAG_NODECLASS: YOUNGCONTENT.NODECLASS = value; break;
					case XmlConstants.TAG_NODETYPENAME: YOUNGCONTENT.NODETYPENAME = value; break;
					case XmlConstants.TAG_CONTENTTYPENAME: YOUNGCONTENT.CONTENTTYPENAME = value; break;
					case XmlConstants.TAG_CONTENTTYPEID: YOUNGCONTENT.CONTENTTYPEID = value; break;
					case XmlConstants.TAG_NODETYPEID: YOUNGCONTENT.NODETYPEID = value; break;
					case XmlConstants.TAG_PARENTNODEID: YOUNGCONTENT.PARENTNODEID = value; break;
					case XmlConstants.TAG_CONTENTID: YOUNGCONTENT.CONTENTID = value; break;
					case XmlConstants.TAG_NODEID: YOUNGCONTENT.NODEID = value; break;
					case XmlConstants.TAG_VERSIONID: YOUNGCONTENT.VERSIONID = value; break;
					case XmlConstants.TAG_PROPERTYLISTSIZE: YOUNGCONTENT.PROPERTYLISTSIZE = value; break;
					case XmlConstants.TAG_CRUDSTATUS: YOUNGCONTENT.CRUDSTATUS = value; break;
					case XmlConstants.TAG_CONTENTCLASS: YOUNGCONTENT.CONTENTCLASS = value; break;
					case XmlConstants.TAG_CONTENTSTATUS: YOUNGCONTENT.CONTENTSTATUS = value; break;
					case XmlConstants.TAG_RETENTIONCONTENT: YOUNGCONTENT.RETENTIONCONTENT = value; break;
					case XmlConstants.TAG_CHECKEDOUTUSER: YOUNGCONTENT.CHECKEDOUTUSER = value; break;
					case XmlConstants.TAG_CHECKEDOUT: YOUNGCONTENT.CHECKEDOUT = value; break;
					case XmlConstants.TAG_CREATEDATE: YOUNGCONTENT.CREATEDATE = value; break;
					case XmlConstants.TAG_CREATEUSER: YOUNGCONTENT.CREATEUSER = value; break;
					case XmlConstants.TAG_LASTCHANGEDDATE: YOUNGCONTENT.LASTCHANGEDDATE = value; break;
					case XmlConstants.TAG_LASTCHANGEDUSER: YOUNGCONTENT.LASTCHANGEDUSER = value; break;
					case XmlConstants.TAG_SERVERID: YOUNGCONTENT.SERVERID = value; break;
				}
			}break;
			
			//YOUNGPROPERTY下的直接子属性
			case XmlConstants.TAG_YOUNGPROPERTY:
			{
				switch(qName)
				{
					case XmlConstants.TAG_NAME: YOUNGPROPERTY.NAME = value; break;
					case XmlConstants.TAG_DESCRIPTION: YOUNGPROPERTY.DESCRIPTION = value; break;
					case XmlConstants.TAG_ID: YOUNGPROPERTY.ID = value; break;
					case XmlConstants.TAG_CONTROLFLAG: YOUNGPROPERTY.CONTROLFLAG = value; break;
					case XmlConstants.TAG_TYPE: YOUNGPROPERTY.TYPE = value; break;
					case XmlConstants.TAG_LENGTH: YOUNGPROPERTY.LENGTH = value; break;
					case XmlConstants.TAG_PRECISION: YOUNGPROPERTY.PRECISION = value; break;
					case XmlConstants.TAG_SCALE: YOUNGPROPERTY.SCALE = value; break;
					case XmlConstants.TAG_GROUPID: YOUNGPROPERTY.GROUPID = value; break;
					case XmlConstants.TAG_MAXINTVALUE: YOUNGPROPERTY.MAXINTVALUE = value; break;
					case XmlConstants.TAG_MININTVALUE: YOUNGPROPERTY.MININTVALUE = value; break;
					case XmlConstants.TAG_STRINGCONSTRAINT: YOUNGPROPERTY.STRINGCONSTRAINT = value; break;
					case XmlConstants.TAG_MINVALUESET: YOUNGPROPERTY.MINVALUESET = value; break;
					case XmlConstants.TAG_MAXVALUESET: YOUNGPROPERTY.MAXVALUESET = value; break;
					case XmlConstants.TAG_VALID: YOUNGPROPERTY.VALID = value; break;
					case XmlConstants.TAG_SEARCHABLE: YOUNGPROPERTY.SEARCHABLE = value; break;
					case XmlConstants.TAG_MANDATORY: YOUNGPROPERTY.MANDATORY = value; break;
					case XmlConstants.TAG_PROTECTED: YOUNGPROPERTY.PROTECTED = value; break;
					case XmlConstants.TAG_UNIQUE: YOUNGPROPERTY.UNIQUE = value; break;
					case XmlConstants.TAG_PRIMARY: YOUNGPROPERTY.PRIMARY = value; break;
					case XmlConstants.TAG_TEXTSEARCHABLE: YOUNGPROPERTY.TEXTSEARCHABLE = value; break;
					case XmlConstants.TAG_DISPLAYORDER: YOUNGPROPERTY.DISPLAYORDER = value; break;
					case XmlConstants.TAG_CONTENTTYPEID: YOUNGPROPERTY.CONTENTTYPEID = value; break;
					case XmlConstants.TAG_NODETYPEID: YOUNGPROPERTY.NODETYPEID = value; break;
					case XmlConstants.TAG_CRUDSTATUS: YOUNGPROPERTY.CRUDSTATUS = value; break;
					case XmlConstants.TAG_PARENTKEY: YOUNGPROPERTY.PARENTKEY = value; break;
					case XmlConstants.TAG_FOREIGNKEY: YOUNGPROPERTY.FOREIGNKEY = value; break;
					case XmlConstants.TAG_LINKED: YOUNGPROPERTY.LINKED = value; break;
					case XmlConstants.TAG_VALUE: YOUNGPROPERTY.VALUE = value; break;
					case XmlConstants.TAG_USERINPUTED: YOUNGPROPERTY.USERINPUTED = value; break;
				}
			}break;
			
			//YOUNGDOCUMENT下的直接子属性
			case XmlConstants.TAG_YOUNGDOCUMENT:
			{
				switch(qName)
				{
					case XmlConstants.TAG_DOCUMENTID: YOUNGDOCUMENT.DOCUMENTID = value; break;
					case XmlConstants.TAG_VERSIONID: YOUNGDOCUMENT.VERSIONID = value; break;
					case XmlConstants.TAG_STORAGEID: YOUNGDOCUMENT.STORAGEID = value; break;
					case XmlConstants.TAG_CONTAINERID: YOUNGDOCUMENT.CONTAINERID = value; break;
					case XmlConstants.TAG_DOCFILENAME: YOUNGDOCUMENT.DOCFILENAME = value; break;
					case XmlConstants.TAG_DOCUMENTTYPEID: YOUNGDOCUMENT.DOCUMENTTYPEID = value; break;
					case XmlConstants.TAG_NODETYPEID: YOUNGDOCUMENT.NODETYPEID = value; break;
					case XmlConstants.TAG_DOCUMENTTYPENAME: YOUNGDOCUMENT.DOCUMENTTYPENAME = value; break;
					case XmlConstants.TAG_SIZE: YOUNGDOCUMENT.SIZE = value; break;
					case XmlConstants.TAG_MIMETYPEID: YOUNGDOCUMENT.MIMETYPEID = value; break;
					case XmlConstants.TAG_MIMETYPE: YOUNGDOCUMENT.MIMETYPE = value; break;
					case XmlConstants.TAG_STATUS: YOUNGDOCUMENT.STATUS = value; break;
					case XmlConstants.TAG_DATALOCATION: YOUNGDOCUMENT.DATALOCATION = value; break;
					case XmlConstants.TAG_EMPTYINCACHE: YOUNGDOCUMENT.EMPTYINCACHE = value; break;
					case XmlConstants.TAG_CRUDSTATUS: YOUNGDOCUMENT.CRUDSTATUS = value; break;
					case XmlConstants.TAG_CONTENTTYPENAME: YOUNGDOCUMENT.CONTENTTYPENAME = value; break;
					case XmlConstants.TAG_ENCRYPTIONREQUIRED: YOUNGDOCUMENT.ENCRYPTIONREQUIRED = value; break;
					case XmlConstants.TAG_DOCUMENTFLAG: YOUNGDOCUMENT.DOCUMENTFLAG = value; break;
				}
			}break;
		}
		
		switch(qName)
		{
			case XmlConstants.TAG_YOUNGCONTENT:
			{
				xmlData.YOUNGCONTENT.add(YOUNGCONTENT);
			}break;
			
			case XmlConstants.TAG_YOUNGPROPERTY:
			{
				YOUNGCONTENT.YOUNGPROPERTIES.YOUNGPROPERTY.add(YOUNGPROPERTY);
			}break;
			
			case XmlConstants.TAG_YOUNGDOCUMENT:
			{
				YOUNGCONTENT.YOUNGDOCUMENTS.YOUNGDOCUMENT.add(YOUNGDOCUMENT);
			}break;
		}
	}
	
}
