package com.net.database.dto;

import java.util.ArrayList;
import java.util.HashMap;

import com.net.HttpRequester;
import com.net.database.bean.Table;
import com.net.xml.bean.Document;
import com.net.xml.bean.XmlData;
import com.net.xml.dto.XmlWrapper;

/**
 * 
 * 平台数据库数据操作类；
 * 
 */
public class DataOperation
{
	private DataOperation(){}
	
	/**
	 * 查询云平台中的数据库表，根据所给条件返回相匹配的Table列表
	 * @param sqlStr sql语句
	 * @param tableName 要查询的目标表名
	 * @return 匹配的Table列表
	 */
	public static ArrayList<Table> queryTable(String sqlStr, String tableName)
	{
		return queryTable(sqlStr, tableName, "", "");
	}
	
	/**
	 * 查询云平台中的数据库表，根据所给条件返回相匹配的Table列表
	 * @param sqlStr sql语句
	 * @param tableName 要查询的目标表名
	 * @param startIndex 查询到相匹配的结果列表后，从结果列表中获取数据的起始位置
	 * @param num 查询到相匹配的结果列表后，从结果列表中获取数据的数量
	 * @return 匹配的Table列表
	 */
	public static ArrayList<Table> queryTable(String sqlStr, String tableName, String startIndex, String num)
	{
		ArrayList<Table> tableList = null;
		
		String xmlStr = XmlWrapper.wrapXmlForSelect(sqlStr, tableName, startIndex, num);
		XmlData xmlData = HttpRequester.postRequest(xmlStr);
		tableList = DataParser.getTable(xmlData);
		
		return tableList;
	}
	
	/**
	 * 查询云平台中的数据库表，根据所给条件返回相匹配的Table；用于主观上确认结果只有一条的查询
	 * @param sqlStr sql语句
	 * @param tableName 要查询的目标表名
	 * @return 匹配的Table列表中的第一条记录
	 */
	public static Table queryTableForSingle(String sqlStr, String tableName)
	{
		ArrayList<Table> tableList = queryTable(sqlStr, tableName);
		
		if(tableList!=null && tableList.size()!=0) return tableList.get(0);
		else return null;
	}
	
	/**
	 * 查询云平台中的数据库表，根据所给条件返回相匹配的Table；用于主观上确认结果只有一条的查询
	 * @param sqlStr sql语句 
	 * @param tableName 要查询的目标表名
	 * @param startIndex 查询到相匹配的结果列表后，从结果列表中获取数据的起始位置
	 * @param num 查询到相匹配的结果列表后，从结果列表中获取数据的数量
	 * @return 匹配的Table列表中的第一条记录
	 */
	public static Table queryTableForSingle(String sqlStr, String tableName, String startIndex, String num)
	{
		ArrayList<Table> tableList = queryTable(sqlStr, tableName, startIndex, num);
		
		if(tableList!=null && tableList.size()!=0) return tableList.get(0);
		else return null;
	}
	
	/**
	 * 向平台数据库增加一条表记录
	 * @param table 要添加的表记录；添加成功后，平台会为新表记录生成一个contentId值，该值会设置到该table对象中
	 * @param file 要添加的表记录的单个附件
	 * @return false：添加失败；true：添加成功
	 */
	public static boolean insertTable(Table table, Document file)
	{
		ArrayList<Document> fileList = new ArrayList<>();
		fileList.add(file);
		return insertTable(table, fileList);
	}
	
	/**
	 * 向平台数据库增加一条表记录
	 * @param table 要添加的表记录；添加成功后，平台会为新表记录生成一个contentId值，该值会设置到该table对象中
	 * @param fileArray 要添加的表记录的附件列表
	 * @return false：添加失败；true：添加成功
	 */
	public static boolean insertTable(Table table, Document[] fileArray)
	{
		ArrayList<Document> fileList = new ArrayList<>();
		for (Document document : fileArray)
		{
			fileList.add(document);
		}
		return insertTable(table, fileList);
	}
	
	/**
	 * 向平台数据库增加一条表记录
	 * @param table 要添加的表记录；添加成功后，平台会为新表记录生成一个contentId值，该值会设置到该table对象中
	 * @param fileList 要添加的表记录的附件列表
	 * @return false：添加失败；true：添加成功
	 */
	public static boolean insertTable(Table table, ArrayList<Document> fileList)
	{
		String newTableContentId = insertTable(table.getFieldList(), table.getTableName(), fileList);
		table.setContentId(newTableContentId);
		
		return newTableContentId!=null;
	}
	
	/**
	 * 向平台数据库增加一条表记录
	 * @param fieldList 要添加的表记录的字段列表
	 * @param contentTypeName 添加的目的表名
	 * @param file 要添加的表记录的单个附件
	 * @return 添加表记录成功后，返回平台自动为该新table表记录生成的contentId值；添加失败时返回null
	 */
	public static String insertTable(HashMap<String, String> fieldList, String contentTypeName, Document file)
	{
		ArrayList<Document> fileList = new ArrayList<>();
		fileList.add(file);
		return insertTable(fieldList, contentTypeName, fileList);
	}
	
	/**
	 * 向平台数据库增加一条表记录
	 * @param fieldList 要添加的表记录的字段列表
	 * @param contentTypeName 添加的目的表名
	 * @param fileArray 要添加的表记录的附件列表
	 * @return 添加表记录成功后，返回平台自动为该新table表记录生成的contentId值；添加失败时返回null
	 */
	public static String insertTable(HashMap<String, String> fieldList, String contentTypeName, Document[] fileArray)
	{
		ArrayList<Document> fileList = new ArrayList<>();
		for (Document document : fileArray)
		{
			fileList.add(document);
		}
		return insertTable(fieldList, contentTypeName, fileList);
	}
	
	/**
	 * 向平台数据库增加一条表记录
	 * @param fieldList 要添加的表记录的字段列表
	 * @param contentTypeName 添加的目的表名
	 * @param fileList 要添加的表记录的附件列表
	 * @return 添加表记录成功后，返回平台自动为该新table表记录生成的contentId值；添加失败时返回null
	 */
	public static String insertTable(HashMap<String, String> fieldList, String contentTypeName, ArrayList<Document> fileList)
	{
		String newTableContentId = null;
		
		String xmlStr = XmlWrapper.wrapXmlForInsert(fieldList, contentTypeName, fileList);
		XmlData xmlData = HttpRequester.postRequest(xmlStr);
		if(xmlData.SUCCESS)
		{
			newTableContentId = xmlData.YOUNGCONTENT.get(0).CONTENTID;
		}
		
		return newTableContentId;
	}
	
	/**
	 * 更新平台数据库上指定的表记录
	 * @param table 该table对象的contentId值应当对应平台上的一条表记录，然后方法会使用该table对象的字段列表去替换其对应的表记录的字段列表
	 * @param file 文件数不为0时，以该文档替换目的表记录的文档列表
	 * @return 更新操作是否出现异常
	 */
	public static boolean updateTable(Table table, Document file)
	{
		ArrayList<Document> fileList = new ArrayList<>();
		fileList.add(file);
		return updateTable(table, fileList);
	}
	
	/**
	 * 更新平台数据库上指定的表记录
	 * @param table 该table对象的contentId值应当对应平台上的一条表记录，然后方法会使用该table对象的字段列表去替换其对应的表记录的字段列表
	 * @param fileArray 文件数不为0时，以该文档列表替换目的表记录的文档列表
	 * @return 更新操作是否出现异常
	 */
	public static boolean updateTable(Table table, Document[] fileArray)
	{
		ArrayList<Document> fileList = new ArrayList<>();
		for (Document document : fileArray)
		{
			fileList.add(document);
		}
		return updateTable(table, fileList);
	}
	
	
	/**
	 * 更新平台数据库上指定的表记录
	 * @param table 该table对象的contentId值应当对应平台上的一条表记录，然后方法会使用该table对象的字段列表去替换其对应的表记录的字段列表
	 * @param fileList 文件数不为0时，以该文档列表替换目的表记录的文档列表
	 * @return 更新操作是否出现异常
	 */
	public static boolean updateTable(Table table, ArrayList<Document> fileList)
	{
		String xmlStr = XmlWrapper.wrapXmlForUpdate(table.getFieldList(), table.getContentId(), fileList);
		XmlData xmlData = HttpRequester.postRequest(xmlStr);
		
		return xmlData.SUCCESS;
	}
	
	/**
	 * 更新平台数据库上指定的表记录
	 * @param fieldList 要更新的字段列表
	 * @param contentId 要更新的表记录的contentId
	 * @param file 文件数不为0时，以该文档替换目的表记录的文档列表
	 * @return 更新操作是否出现异常
	 */
	public static boolean updateTable(HashMap<String, String> fieldList, String contentId, Document file)
	{
		ArrayList<Document> fileList = new ArrayList<>();
		fileList.add(file);
		return updateTable(fieldList, contentId, fileList);
	}
	
	/**
	 * 更新平台数据库上指定的表记录
	 * @param fieldList 要更新的字段列表
	 * @param contentId 要更新的表记录的contentId
	 * @param fileArray 文件数不为0时，以该文档列表替换目的表记录的文档列表
	 * @return 更新操作是否出现异常
	 */
	public static boolean updateTable(HashMap<String, String> fieldList, String contentId, Document[] fileArray)
	{
		ArrayList<Document> fileList = new ArrayList<>();
		for (Document document : fileArray)
		{
			fileList.add(document);
		}
		return updateTable(fieldList, contentId, fileList);
	}
	
	/**
	 * 更新平台数据库上指定的表记录
	 * @param fieldList 要更新的字段列表
	 * @param contentId 要更新的表记录的contentId
	 * @param fileList 文件数不为0时，以该文档列表替换目的表记录的文档列表
	 * @return 更新操作是否出现异常
	 */
	public static boolean updateTable(HashMap<String, String> fieldList, String contentId, ArrayList<Document> fileList)
	{
		String xmlStr = XmlWrapper.wrapXmlForUpdate(fieldList, contentId, fileList);
		XmlData xmlData = HttpRequester.postRequest(xmlStr);
		
		return xmlData.SUCCESS;
	}
	
	/**
	 * 删除平台数据库上指定的表记录
	 * @param contentId 要删除的表记录的contentId
	 * @return 删除操作是否出现异常
	 */
	public static boolean deleteTable(String contentId)
	{
		String xmlStr = XmlWrapper.wrapXmlForDelete(contentId);
		XmlData xmlData = HttpRequester.postRequest(xmlStr);
		
		return xmlData.SUCCESS;
	}
}
