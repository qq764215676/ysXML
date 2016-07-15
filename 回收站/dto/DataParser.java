package com.net.database.dto;

import java.util.ArrayList;
import java.util.List;

import ys.net.post.DataSetList;

import com.example.Constants;
import com.net.database.bean.AlbumTable;
import com.net.database.bean.AppVersionTable;
import com.net.database.bean.Table;
import com.net.database.bean.CategoriesTable;
import com.net.database.bean.ContentTable;
import com.net.database.bean.CourseTable;
import com.net.database.bean.EnquiryTable;
import com.net.database.bean.ExpertTable;
import com.net.database.bean.NewsTable;
import com.net.database.bean.OpinionTable;
import com.net.database.bean.ReplyTable;
import com.net.database.bean.StudyInfoTable;
import com.net.database.bean.StudyScoreTable;
import com.net.database.bean.ThumbsTable;
import com.net.database.bean.UserInfoTable;
import com.net.database.bean.UserTable;

public final class DataParser
{
	private DataParser(){}
	
	public static ArrayList<Table> getTable(DataSetList dataList, String tableName)
	{
		ArrayList<Table> tableDataList = new ArrayList<>();
		String type = dataList.type; //表名
		ArrayList<String> contentIdList = (ArrayList<String>) dataList.CONTENTID; //contentId
		List<List<String>> documentIdList = (List<List<String>>) dataList.DOCUMENTIDLIST; //附件目录
		ArrayList<String> nameList = (ArrayList<String>) dataList.nameList; //字段名
		ArrayList<String> valueList = (ArrayList<String>) dataList.valueList; //字段值
		
		if(contentIdList.size()==0) return tableDataList; //若相匹配的结果数为0，则直接返回
		
		//将数据库表记录数据从DataSetList中解析出来
		Table tableData = null;
		int recordNum = nameList.size()/contentIdList.size(); //记录的总数
		int recordIndex = 0; //当前解析到第几条记录
		for (int i = 0; i < nameList.size(); i++) //循环解析所有的记录
		{
			if(i%recordNum==0)
			{
				tableData = newTableInstance(tableName);
				tableData.setTableName(type);
				tableData.setContentId(contentIdList.get(recordIndex));
				
				for (String documentId : documentIdList.get(recordIndex))
				{
					String fileUrl = "http://" + Constants.CONNIP + Constants.FILE_PATH + documentId + "/" + "file";
					tableData.getAccessaryFileUrlList().add(fileUrl);
				}
			}
			else
			{
				tableData.putField(nameList.get(i), valueList.get(i));
				
				if(i%recordNum == recordNum-1)
				{
					tableDataList.add(tableData);
					recordIndex++;
				}
			}
		}
		
		return tableDataList;
	}
	
	/**
	 * 根据给定的表类型返回对应的表实例，实例以BaseTable类型保存
	 * @param tableName
	 * @return
	 */
	public static Table newTableInstance(String tableName)
	{
		Table tableData = null;
		
		switch(tableName)
		{
			case AlbumTable.TABLE_NAME: tableData = new AlbumTable(); break;
			case AppVersionTable.TABLE_NAME: tableData = new AppVersionTable(); break;
			case ContentTable.TABLE_NAME: tableData = new ContentTable(); break;
			case CourseTable.TABLE_NAME: tableData = new CourseTable(); break;
			case EnquiryTable.TABLE_NAME: tableData = new EnquiryTable(); break;
			case ExpertTable.TABLE_NAME: tableData = new ExpertTable(); break;
			case NewsTable.TABLE_NAME: tableData = new NewsTable(); break;
			case OpinionTable.TABLE_NAME: tableData = new OpinionTable(); break;
			case ReplyTable.TABLE_NAME: tableData = new ReplyTable(); break;
			case StudyInfoTable.TABLE_NAME: tableData = new StudyInfoTable(); break;
			case StudyScoreTable.TABLE_NAME: tableData = new StudyScoreTable(); break;
			case ThumbsTable.TABLE_NAME: tableData = new ThumbsTable(); break;
			case UserInfoTable.TABLE_NAME: tableData = new UserInfoTable(); break;
			case UserTable.TABLE_NAME: tableData = new UserTable(); break;
			case CategoriesTable.TABLE_NAME: tableData = new CategoriesTable(); break;
			
			default: tableData = new Table(); break;
		}
		
		return tableData;
	}
}
