package com.net.database.bean;

/**
 * 
 * WXZJ-点赞表 
 * 
 */
public class ThumbsTable extends Table
{
	private static final long serialVersionUID = -3525873683419756440L;

	/** 表名 */
	public static final String TABLE_NAME = "THUMBS";
	/** 回复编号 */
	public static final String FIELD_HFID = "HFID";
	/** 用户编号 */
	public static final String FIELD_USERNO = "USERNO";
	/** 时间（教育训练） */
	public static final String FIELD_T_TIME = "T_TIME";
	
	public ThumbsTable()
	{
		initTable();
	}
	
	private void initTable()
	{
		setTableName(TABLE_NAME);
	}
}
