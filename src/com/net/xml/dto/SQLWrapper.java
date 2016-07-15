package com.net.xml.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * 云平台xml请求 sql语句包装类
 * 
 */
public class SQLWrapper
{
	private SQLWrapper(){}
	
	/**
	 * 包装sql查询语句，适用于无需查询条件的查询
	 * @param tableName 要查询的目标表名
	 * @return 
	 * @throws Exception
	 */
	public static String query(String tableName) throws Exception
	{
		return query(tableName, (HashMap<String, String>)null);
	}
	
	/**
	 * 包装sql查询语句，适用于以单个字段查询条件的查询
	 * @param tableName 要查询的目标表名
	 * @param fieldName 字段名
	 * @param fieldValue 字段值
	 * @return
	 */
	public static String query(String tableName, String fieldName, String fieldValue)
	{
		HashMap<String, String> fieldList = new HashMap<>();
		fieldList.put(fieldName, fieldValue);
		return query(tableName, fieldList);
	}
	
	/**
	 * 包装sql查询语句，适用于以多个字段查询条件的查询
	 * @param tableName 要查询的目标表名
	 * @param fieldList 作为查询条件的字段列表
	 * @return
	 */
	public static String query(String tableName, Map<String, String> fieldList)
	{
		StringBuilder sqlStr = new StringBuilder();
		
		sqlStr.append("from (select * from "+tableName);
		if(fieldList!=null && fieldList.keySet()!=null)
		{
			Iterator<String> iterator = fieldList.keySet().iterator();
			List<String> keyList = new ArrayList<>();
			while(iterator.hasNext())
			{
				keyList.add(iterator.next());
			}
			for (int i = 0; i < keyList.size(); i++)
			{
				if(i==0) sqlStr.append(" where ");
				String key = keyList.get(i);
				String value = fieldList.get(key);
				sqlStr.append(key+"='"+value+"'");
				if(keyList.size()>=2 && i != keyList.size()-1) sqlStr.append(" AND ");
			}
		}
		sqlStr.append(" ) "+tableName);
		
		return sqlStr.toString();
	}
}
