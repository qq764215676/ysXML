package com.constants;

/**
 * 
 * 服务器相关信息
 * 
 */
public class ServerInfo
{
	private ServerInfo(){}
	
	/** 服务器WebService地址 */
	public static final String IP_ADDRESS_WEBSERVICE = "http://192.168.0.14:9080/IDOC/WebService";
	/** 服务器文档目录地址 */
	public static final String IP_ADDRESS_DOCUMENT_DIRECTORY = "http://192.168.0.14:9080/IDOC/service/file/";
	/** 服务器登录用户名 */
	public static final String LOGIN_USERNAME = "docadmin";
	/** 服务器登录密码 */
	public static final String LOGIN_PASSWORD = "passw0rd";
	/** 对服务器的请求命令_导入/修改数据 */
	public static final String REQUEST_COMMAND_IMPORTYOUNGCONTENT = "IMPORTYOUNGCONTENT";
	/** 对服务器的请求命令_删除数据 */
	public static final String REQUEST_COMMAND_DELETEYOUNGCONTENT = "DELETEYOUNGCONTENT";
	/** 对服务器的请求命令_查询数据 */
	public static final String REQUEST_COMMAND_SEARCHYOUNGCONTENT = "SEARCHYOUNGCONTENT";
	/** 对服务器的请求命令_登录 */
	public static final String REQUEST_COMMAND_LOGON = "LOGON";
	/** 对服务器的请求命令_创建账户 */
	public static final String REQUEST_COMMAND_IMPORTYOUNGUSER = "IMPORTYOUNGUSER";
}
