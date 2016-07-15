package com.net.database.bean;

/**
 * 
 * 需求意见表
 * 
 */
public class OpinionTable extends Table
{
	private static final long serialVersionUID = -1457340830882406359L;

	/** 表名 */
	public static final String TABLE_NAME = "OPINION";
	/** 用户的contentId */
	public static final String FIELD_USERID = "USERID";
	/** 投稿时间 */
	public static final String FIELD_POSTTIME = "POSTTIME";
	/** 审核时间 */
	public static final String FIELD_PASSTIME = "PASSTIME";
	/** 是否通过审核 */
	public static final String FIELD_ISPASSED = "ISPASSED";
	/** 审核人 */
	public static final String FIELD_AUDITOR = "AUDITOR";
	
	public OpinionTable()
	{
		initTable();
	}
	
	private void initTable()
	{
		setTableName(TABLE_NAME);
	}
}
