package com.net.xml.bean;

import java.io.File;

/**
 * 
 * 云平台Document类，对应云平台的文件
 * 
 */
public class Document extends File
{
	private static final long serialVersionUID = 7347074876298874326L;
	
	/** 该文件后缀名对应的平台文件类型 */
	private String fileType;
	
	/**
	 * 
	 * @param path
	 * @param fileType 该文件后缀名对应的平台文件类型
	 */
	public Document(String path, String fileType)
	{
		super(path);
		
		this.fileType = fileType;
	}
	
	/**
	 * 获取该文档在平台上对应的文件类型
	 * @return
	 */
	public String getFileType()
	{
		return this.fileType;
	}
	
}
