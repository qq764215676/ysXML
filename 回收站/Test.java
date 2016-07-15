package com.ys;

import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.database.dto.DataOperation;
import com.database.net.XmlParser;
import com.database.net.XmlParser2;
import com.database.pojo.AlbumTable;
import com.database.pojo.UserTable;

/**
 * 
 * getElementsByTagName：直接获取文件中的某个节点(然后可以通过后续方法获取其中的子节点)
 * 
 */
public class Test
{
	public static void main(String[] args) throws Exception
	{
		//System.out.println(DataOperation.queryTable(UserTable.TABLE_NAME));
		//System.out.println(DataOperation.queryTable(UserTable.TABLE_NAME, UserTable.FIELD_USERNAME, "lb"));
		
		/*DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		db = dbf.newDocumentBuilder();
		Document document = db.parse("reply.xml");
		
		System.out.println("服务器返回结果是否正常："+isSuccess(document));
		
		if(isSuccess(document)) parseNodeList(document.getElementsByTagName(XmlAttr.ATTRLIST_NODE_YOUNGCONTENT));*/
		
		FileInputStream fis = new FileInputStream("reply.xml");
		
		//System.out.println(XmlParser.parseXml(fis));
		
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();
		parser.parse("reply.xml", new XmlParser2());
	}
	
	public static boolean isSuccess(Document document)
	{
		//判断xml里是否有 SUCCESS元素存在，若存在，则说明服务器返回结果正常，否则说明服务器返回结果失败
		//SUCCESS元素的数量不为0就说明正常返回了
		return document.getElementsByTagName(XmlAttr.NOATTR_NODE_SUCCESS).getLength()!=0;
	}
	
	public static void parseNodeList(NodeList attrNodes) throws IllegalAccessException
	{
		System.out.println("属性节点的数量="+attrNodes.getLength());
		for (int j = 0; j < attrNodes.getLength(); j++)
		{
			Node attr = attrNodes.item(j);
			
			switch(XmlAttr.getNodeType(attr.getNodeName()))
			{
				case XmlAttr.NODE_TYPE_ATTR:
				{
					System.out.printf("%s：%s\n",attr.getNodeName(), attr.getChildNodes().item(0).getNodeValue());
				}break;
				
				case XmlAttr.NODE_TYPE_NOATTR:
				{
					System.out.println(attr.getNodeName());
				}break;
				
				case XmlAttr.NODE_TYPE_ATTRLIST:
				{
					System.out.println("子节点列表"+attr.getNodeName());
					parseNodeList(attr.getChildNodes());
				}break;
			}
		}
	}
}
