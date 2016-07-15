package com.ys;

import java.util.ArrayList;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.database.pojo.BaseTable;

public class DataParse
{
	/*public static ArrayList<BaseTable> getTable()
	{
	}*/
	
	public static void parseNodeList(NodeList attrNodes) throws IllegalAccessException
	{
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
					parseNodeList(attr.getChildNodes());
				}break;
			}
		}
	}
}
