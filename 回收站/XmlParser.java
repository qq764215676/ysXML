package com.database.net;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ys.XmlAttr;
import com.ys.XmlData;
import com.ys.XmlData.YOUNGCONTENT;
import com.ys.XmlData.YOUNGCONTENT.YOUNGDOCUMENTS.YOUNGDOCUMENT;
import com.ys.XmlData.YOUNGCONTENT.YOUNGPROPERTIES.YOUNGPROPERTY;

public class XmlParser
{
	public static XmlData parseXml(InputStream xmlStream)
	{
		XmlData resultData = new XmlData();
		
		try
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			db = dbf.newDocumentBuilder();
			Document document = db.parse(xmlStream);
			
			XmlParser xmlParse = new XmlParser();
			xmlParse.parseNodeList(document.getElementsByTagName(XmlAttr.ATTRLIST_NODE_REPLY), XmlAttr.ATTRLIST_NODE_REPLY);
			resultData = xmlParse.xmlData;
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		
		return resultData;
	}
	
	private XmlData xmlData = new XmlData();
	private int YOUNCONTENT_listIndex;
	private YOUNGCONTENT YOUNGCONTENT;
	private YOUNGPROPERTY YOUNGPROPERTY;
	private void parseNodeList(NodeList attrNodeList, String listName) throws IllegalAccessException
	{
		System.out.printf("长度=%d 名称:%s \n", attrNodeList.getLength(), listName);
		YOUNGCONTENT = new YOUNGCONTENT();
		YOUNGPROPERTY = new YOUNGPROPERTY();
		for (int i = 0; i < attrNodeList.getLength(); i++)
		{
			Node attr = attrNodeList.item(i);
			
			System.out.printf("%s, %s, %d\n", attr.getNodeName(), attr.getNodeValue(), attr.getNodeType());
			if(attr.getNodeType() == Node.ELEMENT_NODE)
			switch(XmlAttr.getNodeType(attr.getNodeName()))
			{
				case XmlAttr.NODE_TYPE_NOATTR:
				{
					switch(listName)
					{
						case XmlAttr.ATTRLIST_NODE_REPLY:
						{
							switch(attr.getNodeName())
							{
								case XmlAttr.NOATTR_NODE_SUCCESS: xmlData.SUCCESS = true; break;
							}
						}
					}
				}break;
				
				case XmlAttr.NODE_TYPE_ATTR:
				{
					switch(listName)
					{
						case XmlAttr.ATTRLIST_NODE_YOUNGCONTENT:
						{
							YOUNCONTENT_listIndex = i;
							switch(attr.getNodeName())
							{
								case XmlAttr.ATTR_NODE_ROOT: YOUNGCONTENT.ROOT = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_FOLDER: YOUNGCONTENT.FOLDER = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_NODECLASS: YOUNGCONTENT.NODECLASS = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_NODETYPENAME: YOUNGCONTENT.NODETYPENAME = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_CONTENTTYPENAME: YOUNGCONTENT.CONTENTTYPENAME = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_CONTENTTYPEID: YOUNGCONTENT.CONTENTTYPEID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_NODETYPEID: YOUNGCONTENT.NODETYPEID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_CONTENTID: YOUNGCONTENT.CONTENTID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_NODEID: YOUNGCONTENT.NODEID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_VERSIONID: YOUNGCONTENT.VERSIONID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_PROPERTYLISTSIZE: YOUNGCONTENT.PROPERTYLISTSIZE = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_CRUDSTATUS: YOUNGCONTENT.CRUDSTATUS = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_CONTENTCLASS: YOUNGCONTENT.CONTENTCLASS = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_CONTENTSTATUS: YOUNGCONTENT.CONTENTSTATUS = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_RETENTIONCONTENT: YOUNGCONTENT.RETENTIONCONTENT = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_CHECKEDOUT: YOUNGCONTENT.CHECKEDOUT = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_CREATEDATE: YOUNGCONTENT.CREATEDATE = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_CREATEUSER: YOUNGCONTENT.CREATEUSER = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_LASTCHANGEDDATE: YOUNGCONTENT.LASTCHANGEDDATE = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_LASTCHANGEDUSER: YOUNGCONTENT.LASTCHANGEDUSER = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_SERVERID: YOUNGCONTENT.SERVERID = attr.getNodeValue(); break;
							}
							xmlData.YOUNGCONTENT.add(YOUNGCONTENT);
						}break;
						
						case XmlAttr.ATTRLIST_NODE_YOUNGPROPERTY:
						{
							switch(attr.getNodeName())
							{
								case XmlAttr.ATTR_NODE_NAME: YOUNGPROPERTY.NAME = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_DESCRIPTION: YOUNGPROPERTY.DESCRIPTION = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_ID: YOUNGPROPERTY.ID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_TYPE: YOUNGPROPERTY.TYPE = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_LENGTH: YOUNGPROPERTY.LENGTH = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_PRECISION: YOUNGPROPERTY.PRECISION = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_SCALE: YOUNGPROPERTY.SCALE = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_GROUPID: YOUNGPROPERTY.GROUPID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_MAXINTVALUE: YOUNGPROPERTY.MAXINTVALUE = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_MININTVALUE: YOUNGPROPERTY.MININTVALUE = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_STRINGCONSTRAINT: YOUNGPROPERTY.STRINGCONSTRAINT = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_MINVALUESET: YOUNGPROPERTY.MINVALUESET = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_MAXVALUESET: YOUNGPROPERTY.MAXVALUESET = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_VALID: YOUNGPROPERTY.VALID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_SEARCHABLE: YOUNGPROPERTY.SEARCHABLE = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_MANDATORY: YOUNGPROPERTY.MANDATORY = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_PROTECTED: YOUNGPROPERTY.PROTECTED = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_UNIQUE: YOUNGPROPERTY.UNIQUE = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_PRIMARY: YOUNGPROPERTY.PRIMARY = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_TEXTSEARCHABLE: YOUNGPROPERTY.TEXTSEARCHABLE = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_DISPLAYORDER: YOUNGPROPERTY.DISPLAYORDER = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_CONTENTTYPEID: YOUNGPROPERTY.CONTENTTYPEID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_NODETYPEID: YOUNGPROPERTY.NODETYPEID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_CRUDSTATUS: YOUNGPROPERTY.CRUDSTATUS = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_PARENTKEY: YOUNGPROPERTY.PARENTKEY = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_FOREIGNKEY: YOUNGPROPERTY.FOREIGNKEY = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_LINKED: YOUNGPROPERTY.LINKED = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_VALUE: YOUNGPROPERTY.VALUE = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_USERINPUTED: YOUNGPROPERTY.USERINPUTED = attr.getNodeValue(); break;
							}
							//xmlData.YOUNGCONTENT.get(YOUNCONTENT_listIndex).YOUNGPROPERTIES.YOUNGPROPERTY.add(YOUNGPROPERTY);
						}break;
						
						case XmlAttr.ATTRLIST_NODE_YOUNGDOCUMENT:
						{
							YOUNGDOCUMENT YOUNGDOCUMENT = new YOUNGDOCUMENT();
							switch(attr.getNodeName())
							{
								case XmlAttr.ATTR_NODE_DOCUMENTID: YOUNGDOCUMENT.DOCUMENTID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_VERSIONID: YOUNGDOCUMENT.VERSIONID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_STORAGEID: YOUNGDOCUMENT.STORAGEID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_CONTAINERID: YOUNGDOCUMENT.CONTAINERID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_DOCFILENAME: YOUNGDOCUMENT.DOCFILENAME = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_DOCUMENTTYPEID: YOUNGDOCUMENT.DOCUMENTTYPEID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_NODETYPEID: YOUNGDOCUMENT.NODETYPEID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_DOCUMENTTYPENAME: YOUNGDOCUMENT.DOCUMENTTYPENAME = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_SIZE: YOUNGDOCUMENT.SIZE = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_MIMETYPEID: YOUNGDOCUMENT.MIMETYPEID = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_MIMETYPE: YOUNGDOCUMENT.MIMETYPE = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_STATUS: YOUNGDOCUMENT.STATUS = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_DATALOCATION: YOUNGDOCUMENT.DATALOCATION = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_EMPTYINCACHE: YOUNGDOCUMENT.EMPTYINCACHE = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_CRUDSTATUS: YOUNGDOCUMENT.CRUDSTATUS = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_CONTENTTYPENAME: YOUNGDOCUMENT.CONTENTTYPENAME = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_ENCRYPTIONREQUIRED: YOUNGDOCUMENT.ENCRYPTIONREQUIRED = attr.getNodeValue(); break;
								case XmlAttr.ATTR_NODE_DOCUMENTFLAG: YOUNGDOCUMENT.DOCUMENTFLAG = attr.getNodeValue(); break;
							}
							//xmlData.YOUNGCONTENT.get(YOUNCONTENT_listIndex).YOUNGDOCUMENTS.YOUNGDOCUMENT.add(YOUNGDOCUMENT);
						}break;
					}
				}break;
				
				case XmlAttr.NODE_TYPE_ATTRLIST:
				{
					parseNodeList(attr.getChildNodes(), attr.getNodeName());
				}break;
			}
		}
	}
	
}
