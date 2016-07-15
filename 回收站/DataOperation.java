package com.net.database.dto;

import java.util.ArrayList;
import java.util.HashMap;

import ys.net.post.DataSetList;
import ys.net.post.DocInfor;
import ys.net.post.PostHttp;
import ys.net.post.XmlPackage;

import com.example.Constants;
import com.net.HttpRequester;
import com.net.database.bean.Document;
import com.net.database.bean.Table;
import com.net.xml.bean.XmlData;

public final class DataOperation
{
	private DataOperation(){}
	
	public static ArrayList<?> queryTable(String tableName, String sqlStr, int firstIndex, int num) throws Exception
	{
		return queryTable(
				sqlStr, 
				num==-1?"":String.valueOf(num), 
				"", 
				"", 
				"SEARCHYOUNGCONTENT", 
				new DocInfor("", tableName), 
				true, 
				false, 
				firstIndex==-1?"":String.valueOf(firstIndex));
	}
	
	/**
	 * 查询指定的表，取offset(默认从第1个开始取)到num(默认取结果总数)之间的结果
	 * 
	 * @param sqlStr sql语句
	 * @param num 取结果数量
	 * @param orderBy 排序
	 * @param fieldNameList 字段名列表
	 * @param command 指令
	 * @param docInfor 表名和表记录contentId
	 * @param isSimpleSearch
	 * @param noTincludedocInfo
	 * @param offset 取结果起始位置
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<?> queryTable(String sqlStr, String num, String orderBy, String fieldNameList, String command, DocInfor docInfor, boolean isSimpleSearch, boolean noTincludedocInfo, String offset) throws Exception
	{
		XmlData resultData = null;
		ArrayList<Table> tableDataList = new ArrayList<Table>();
		
		String xmlStr = XmlPackage.packageSelect(sqlStr, num, orderBy, fieldNameList, command, docInfor, isSimpleSearch, noTincludedocInfo, offset);
		resultData = HttpRequester.postRequest(xmlStr);
		tableDataList = DataParser.getTable(resultData);

		return tableDataList;
	}
	
	public static boolean insertOrUpdateTable(Table tableData) throws Exception
	{
		boolean result = false;
		
		String xmlStr = "";
		
		xmlStr = XmlPackage.packageForSaveOrUpdate(
				(HashMap<?, ?>) tableData.getFieldList(), 
				new DocInfor(tableData.getContentId(), tableData.getTableName()),  //当该表记录的contentId对应数据库中的一条已有的表记录时，更新该条记录；不对应已有记录时，添加新记录
				false);
		
		DataSetList resultData = PostHttp.PostXML(xmlStr);
		if(Constants.REQUEST_RESULT_SUCCESS.equals(resultData.SUCCESS))
		{
			if(resultData.CONTENTID!=null && resultData.CONTENTID.size()!=0)
			{
				tableData.setContentId(resultData.CONTENTID.get(0));
			}
			result = true;
		}
		
		return result;
	}
	
	/**
	 * 向服务器端 插入一条表记录/更新现有的一条记录
	 * @param tableData 要 插入/更新 的表记录
	 * @param file 附件
	 * @return 插入成功的表记录的contentId
	 * @throws Exception 
	 */
	public static boolean insertOrUpdateTable(Table tableData, Document file) throws Exception
	{
		return insertOrUpdateTable(tableData, new Document[]{file});
	}
	
	public static boolean insertOrUpdateTable(Table tableData, Document[] file) throws Exception
	{
		boolean result = false;
		
		String xmlStr = "";
		
		String[] filePath = new String[file.length];
		String[] fileType = new String[file.length];
		for (int i = 0; i < file.length; i++)
		{
			filePath[i] = file[i]==null?"":file[i].getPath();
			fileType[i] = file[i]==null?"":file[i].getFileType();
		}
		
		xmlStr = XmlPackage.packageForInsertFileData(
				(HashMap<?, ?>) tableData.getFieldList(), 
				new DocInfor(tableData.getContentId(), tableData.getTableName()),
				true, 
				filePath, 
				fileType);
		
		DataSetList resultData = PostHttp.PostXML(xmlStr);
		if(Constants.REQUEST_RESULT_SUCCESS.equals(resultData.SUCCESS))
		{
			if(resultData.CONTENTID!=null && resultData.CONTENTID.size()!=0)
			{
				tableData.setContentId(resultData.CONTENTID.get(0));
			}
			result = true;
		}
		
		return result;
	}
	
	/**
	 * 删除服务器上的一条表记录
	 * @param tableData
	 * @return 删除成功或失败
	 * @throws Exception 
	 */
	public static boolean deleteTable(Table tableData) throws Exception
	{
		boolean result = false;
		
		String xmlStr = XmlPackage.packageDelete(tableData.getContentId());
		
		DataSetList resultData = PostHttp.PostXML(xmlStr);
		if(Constants.REQUEST_RESULT_SUCCESS.equals(resultData.SUCCESS)) result = true;
		
		return result;
	}
}
