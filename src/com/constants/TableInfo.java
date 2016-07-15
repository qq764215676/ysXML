package com.constants;

/**
 * 
 * 平台数据库表相关信息
 * 
 */
public class TableInfo
{
	private TableInfo(){}
	
	/** contentId */
	public static final String CONTENTID = "contentId";
	
	/** 相册表 */
	public static class AlbumTable
	{
		/** 表名 */
		public static final String TABLE_NAME = "ALBUM";
		/** 用户的contentId */
		public static final String FIELD_USERID = "USERID";
		/** 名称 */
		public static final String FIELD_NAME = "NAME";
		/** 描述 */
		public static final String FIELD_DESCRIPTION = "DESCRIPTION";
		/** 发布时间 */
		public static final String FIELD_DATETIME = "DATETIME";
		/** 序号 */
		public static final String FIELD_ORDERNUM = "ORDERNUM";
	}
	
	/** 应用版本表 */
	public static class AppVersionTable
	{
		/** 表名 */
		public static final String TABLE_NAME = "APP_VERSION";
		/** 版本码 */
		public static final String FIELD_VC = "APP_VC";
		/** 版本名 */
		public static final String FIELD_VN = "APP_VN";
		/** 版本详情 */
		public static final String FIELD_DETAIL = "CONTENT";
		/** 版本发布时间 */
		public static final String FIELD_TIME = "T_TIME";
	}
	
	/** 分类表 */
	public static class CategoriesTable
	{
		/** 表名 */
		public static final String TABLE_NAME = "CATEGORIES";
		/** 分类名称 */
		public static final String FIELD_NAME = "C_NAME";
		/** 父类ID */
		public static final String FIELD_PARENTID = "C_PARENTID";
		/** 信息通用表父类名称 */
		public static final String FIELD_PARENTNAME = "C_PARENTNAME";
		/** 等级 */
		public static final String FIELD_LEVEL = "C_LEVEL";
		/** 顺序 */
		public static final String FIELD_SORT = "C_SORT";
		/** 模块的分值 */
		public static final String FIELD_WEIGHT = "WEIGHT";
		/** 模块是否可以投稿 */
		public static final String FIELD_ISPOST = "ISPOST";
		/** 区分模块 */
		public static final String FIELD_MENU = "MENU";
		/** 项目标兵图片 */
		public static final String FIELD_PICURL = "PICURL";
	}
	
	/** 内容表 */
	public static class ContentTable
	{
		/** 表名 */
		public static final String TABLE_NAME = "CONTENTS";
		/** 信息的contentId */
		public static final String FIELD_NEWSID = "NEWSID";
		/** 内容 */
		public static final String FIELD_SUBSTANCE = "SUBSTANCE";
		/** 序号 */
		public static final String FIELD_ORDERNUM = "ORDERNUM";
		/** 内容表区分 */
		public static final String FIELD_DIVI = "DIVI";
	}
	
	/** 课程表 */
	public static class CourseTable
	{
		/** 表名 */
		public static final String TABLE_NAME = "COURSE";
		/** 课程名 */
		public static final String FIELD_COURSENAME = "COURSENAME";
		/** 课程类型(1.必修 2.选修) */
		public static final String FIELD_COURSETYPE = "COURSETYPE";
		/** 课程简介 */
		public static final String FIELD_COURSEINTRO = "COURSEINTRO";
		/** 详细文字 */
		public static final String FIELD_DETAILED = "DETAILED";
		/** 排序（越大越靠前） */
		public static final String FIELD_SORT = "SORT";
		/** 点击次数 */
		public static final String FIELD_CLICKNUM = "CLICKNUM";
		/** 积分 */
		public static final String FIELD_POINT = "POINT";
		/** 是否删除 0否 1是 */
		public static final String FIELD_ISDELETED = "ISDELETED";
		/** 用户编号 */
		public static final String FIELD_USERNO = "USERNO";
		/** 需要学习时长 */
		public static final String FIELD_NEEDTIME = "NEEDTIME";
	}
	
	/** 问询表 */
	public static class EnquiryTable
	{
		/** 表名 */
		public static final String TABLE_NAME = "ENQUIRY";
		/** 用户编号 */
		public static final String FIELD_USERNO = "USERNO";
		/** 考试选项内容 */
		public static final String FIELD_CONTENT = "CONTENT";
		/** 分类ID */
		public static final String FIELD_CATEGORYID = "CATEGORYID";
		/** 申请时间 */
		public static final String FIELD_APPLYTIME = "APPLYTIME";
	}
	
	/** 专家表 */
	public static class ExpertTable
	{
		/** 表名 */
		public static final String TABLE_NAME = "A_EXPERT";
		/** 用户编号 */
		public static final String FIELD_USERNO = "USERNO";
		/** 真实姓名 */
		public static final String FIELD_REALNAME = "REALNAME";
		/** 分类ID */
		public static final String FIELD_CATEGORYID = "CATEGORYID";
		/** 个人介绍 */
		public static final String FIELD_INTRODUCTION = "INTRODUCTION";
		/** 用户的contentId */
		public static final String FIELD_USERID = "USERID";
		/** 时间（教育训练） */
		public static final String FIELD_T_TIME = "T_TIME";
	}
	
	/** 信息类通用表 */
	public static class NContentTable
	{
		/** 表名 */
		public static final String TABLE_NAME = "N_CONTENT";
		/** 标题 */
		public static final String FIELD_TITLE = "TITLE";
		/** 发布时间 */
		public static final String FIELD_DATETIME = "DATETIME";
		/** 是否置顶 */
		public static final String FIELD_ISTOP = "ISTOP";
		/** 是否滚动 */
		public static final String FIELD_ISROLLING = "ISROLLING";
		/** 是否发布 */
		public static final String FIELD_ISPUBLISH = "ISPUBLISH";
		/** 分类ID */
		public static final String FIELD_CATEGORYID = "CATEGORYID";
		/** 序号 */
		public static final String FIELD_ORDERNUM = "ORDERNUM";
		/** 作者的id */
		public static final String FIELD_WRITERID = "WRITERID";
		/** 政工简报报头 */
		public static final String FIELD_HEADER = "HEADER";
		/** 是否通过审核 */
		public static final String FIELD_ISPASSED = "ISPASSED";
		/** 投稿时间 */
		public static final String FIELD_POSTTIME = "POSTTIME";
		/** 审核时间 */
		public static final String FIELD_PASSTIME = "PASSTIME";
		/** 审核人 */
		public static final String FIELD_AUDITOR = "AUDITOR";
		/** 模块的分值 */
		public static final String FIELD_WEIGHT = "WEIGHT";
		/** 项目标兵图片 */
		public static final String FIELD_PICURL = "PICURL";
		/** 未通过原因 */
		public static final String FIELD_REASON = "REASON";
	}
	
	/** 需求意见表 */
	public static class OpinionTable
	{
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
	}
	
	/** WXZJ-回答表  */
	public static class ReplyTable
	{
		/** 表名 */
		public static final String TABLE_NAME = "REPLY";
		/** 回复评论编号 */
		public static final String FIELD_REPLYTONO = "REPLYTONO";
		/** 考试选项内容 */
		public static final String FIELD_CONTENT = "CONTENT";
		/** 时间（教育训练） */
		public static final String FIELD_T_TIME = "T_TIME";
		/** 用户编号 */
		public static final String FIELD_USERNO = "USERNO";
	}
	
	/** 课程学习情况表 */
	public static class StudyInfoTable
	{
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
	}
	
	/** 学分要求设置表 */
	public static class StudyScoreTable
	{
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
	}
	
	/** WXZJ-点赞表  */
	public static class ThumbsTable
	{
		/** 表名 */
		public static final String TABLE_NAME = "THUMBS";
		/** 回复编号 */
		public static final String FIELD_HFID = "HFID";
		/** 用户编号 */
		public static final String FIELD_USERNO = "USERNO";
		/** 时间（教育训练） */
		public static final String FIELD_T_TIME = "T_TIME";
	}
	
	/** 用户信息表 */
	public static class UserInfoTable
	{
		/** 表名 */
		public static final String TABLE_NAME = "USERINFO";
		/** 性别 */
		public static final String FIELD_SEX = "SEX";
		/** 地址 */
		public static final String FIELD_ADDRESS = "ADDRESS";
		/** 出生日期 */
		public static final String FIELD_BIRTHDAY = "BIRTHDAY";
		/** 用户编号 */
		public static final String FIELD_USERID = "USERID";
		/** 身份证号 */
		public static final String FIELD_IDCARDNO = "IDCARDNO";
	}
	
	/** 用户表 */
	public static class UserTable
	{
		/** 表名 */
		public static final String TABLE_NAME = "USERS";
		/** 用户名 */ 
		public static final String FIELD_USERNAME = "USERNAME";
		/** 真实姓名 */ 
		public static final String FIELD_REALNAME = "REALNAME";
		/** 电话 */ 
		public static final String FIELD_TELEPHONE = "TELEPHONE";
		/** 邮箱 */ 
		public static final String FIELD_EMAIL = "EMAIL";
		/** 密码 */ 
		public static final String FIELD_PASSWORD = "PASSWORD";
		/** 部门编号 */ 
		public static final String FIELD_DEPARTMENTNO = "DEPARTMENTNO";
		/** 角色编号 */ 
		public static final String FIELD_ROLENO = "ROLENO";
		/** 组编号 */ 
		public static final String FIELD_GROUPNO = "GROUPNO";
		/** 用户编号 */ 
		public static final String FIELD_USERNUM = "USERNUM";
	}
}
