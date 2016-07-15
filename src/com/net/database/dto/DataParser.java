package com.net.database.dto;

import java.util.ArrayList;

import com.constants.ServerInfo;
import com.net.database.bean.Table;
import com.net.xml.bean.XmlData;
import com.net.xml.bean.XmlData.YOUNGCONTENT;
import com.net.xml.bean.XmlData.YOUNGCONTENT.YOUNGDOCUMENTS.YOUNGDOCUMENT;
import com.net.xml.bean.XmlData.YOUNGCONTENT.YOUNGPROPERTIES.YOUNGPROPERTY;

public class DataParser
{
	/**
	 * 从XmlData对象中提取出表记录相关信息
	 * @param xmlData
	 * @return XmlData中包含的Table信息集合
	 */
	public static ArrayList<Table> getTable(XmlData xmlData)
	{
		ArrayList<Table> tableList = new ArrayList<>();
		
		//一个YOUNGCONTENT对象对应一条表记录
		for (int i = 0; i < xmlData.YOUNGCONTENT.size(); i++)
		{
			Table table = new Table();
			String tableName; //所属表名
			String contentId; //contentId
			
			YOUNGCONTENT youngcontent = xmlData.YOUNGCONTENT.get(i);
			tableName = youngcontent.NODETYPENAME;
			contentId = youngcontent.CONTENTID;
			for (int j = 0; j < youngcontent.YOUNGPROPERTIES.YOUNGPROPERTY.size(); j++)
			{
				String fieldName; //字段名
				String fieldValue; //字段值
				
				YOUNGPROPERTY youngproperty = youngcontent.YOUNGPROPERTIES.YOUNGPROPERTY.get(j);
				fieldName = youngproperty.NAME;
				fieldValue = youngproperty.VALUE;
				
				table.putField(fieldName, fieldValue);
			}
			
			for (int j = 0; j < youngcontent.YOUNGDOCUMENTS.YOUNGDOCUMENT.size(); j++)
			{
				YOUNGDOCUMENT youngdocument = youngcontent.YOUNGDOCUMENTS.YOUNGDOCUMENT.get(j);
				
				String accessaryFileUrl = ServerInfo.IP_ADDRESS_DOCUMENT_DIRECTORY+ youngdocument.DOCUMENTID + "/" + "file"; //附件URL
				
				table.getAccessaryFileUrlList().add(accessaryFileUrl);
			}

			table.setTableName(tableName);
			table.setContentId(contentId);
			tableList.add(table);
		}
		
		return tableList;
	}
}
