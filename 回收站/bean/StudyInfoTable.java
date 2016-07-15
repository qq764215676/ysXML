package com.net.database.bean;

/**
 * 
 * 课程学习情况表 
 * 
 */
public class StudyInfoTable extends Table
{
	private static final long serialVersionUID = -68575200641933694L;

	/** 表名 */
	public static final String TABLE_NAME = "STUDYINFO";
	/** 课程编号 */
	public static final String FIELD_COURSENO = "COURSENO";
	/** 用户编号 */
	public static final String FIELD_USERNO = "USERNO";
	/** 满意度评分 */
	public static final String FIELD_SATISFACTION = "SATISFACTION";
	/** 学习时间 */
	public static final String FIELD_STUDYTIME = "STUDYTIME";
	/** 是否收藏（1.是 0.否） */
	public static final String FIELD_ISCOLLECT = "ISCOLLECT";
	/** 是否取得积分（1.是 0.否） */
	public static final String FIELD_ISGETPOINT = "ISGETPOINT";
	
	public StudyInfoTable()
	{
		initTable();
	}
	
	private void initTable()
	{
		setTableName(TABLE_NAME);
	}
}
