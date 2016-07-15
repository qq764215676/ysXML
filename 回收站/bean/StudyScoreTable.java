package com.net.database.bean;

/**
 * 
 * 学分要求设置表 
 * 
 */
public class StudyScoreTable extends Table
{
	private static final long serialVersionUID = 857392987133804661L;

	/** 表名 */
	public static final String TABLE_NAME = "STUDYSCORE";
	/** 用户编号 */
	public static final String FIELD_USERNO = "USERNO";
	/** 需修学分 */
	public static final String FIELD_NEEDSCORE = "NEEDSCORE";
	/** 必修课程数量 */
	public static final String FIELD_REQUIREDNUM = "REQUIREDNUM";
	/** 选修课程数量 */
	public static final String FIELD_ELECTIVENUM = "ELECTIVENUM";
	/** 时间段 */
	public static final String FIELD_TIMEPERIOD = "TIMEPERIOD";
	
	public StudyScoreTable()
	{
		initTable();
	}
	
	private void initTable()
	{
		setTableName(TABLE_NAME);
	}
}
