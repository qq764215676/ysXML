package com.ys;

public class XmlAttr
{
	public static final String NOATTR_NODE_SUCCESS = "SUCCESS";
	public static final String NOATTR_NODE_PARENTNODEID = "PARENTNODEID";
	public static final String NOATTR_NODE_CONTROLFLAG = "CONTROLFLAG";
	public static final String NOATTR_NODE_CHECKEDOUTUSER = "CHECKEDOUTUSER";
	
	public static final String ATTR_NODE_ROOT = "ROOT";
	public static final String ATTR_NODE_FOLDER = "FOLDER";
	public static final String ATTR_NODE_NODECLASS = "NODECLASS";
	public static final String ATTR_NODE_NODETYPENAME = "NODETYPENAME";
	public static final String ATTR_NODE_CONTENTTYPENAME = "CONTENTTYPENAME";
	public static final String ATTR_NODE_CONTENTTYPEID = "CONTENTTYPEID";
	public static final String ATTR_NODE_NODETYPEID = "NODETYPEID";
	public static final String ATTR_NODE_CONTENTID = "CONTENTID";
	public static final String ATTR_NODE_NODEID = "NODEID";
	public static final String ATTR_NODE_VERSIONID = "VERSIONID";
	public static final String ATTR_NODE_PROPERTYLISTSIZE = "PROPERTYLISTSIZE";
	public static final String ATTR_NODE_CRUDSTATUS = "CRUDSTATUS";
	public static final String ATTR_NODE_CONTENTCLASS = "CONTENTCLASS";
	public static final String ATTR_NODE_CONTENTSTATUS = "CONTENTSTATUS";
	public static final String ATTR_NODE_RETENTIONCONTENT = "RETENTIONCONTENT";
	public static final String ATTR_NODE_CHECKEDOUT = "CHECKEDOUT";
	public static final String ATTR_NODE_CREATEDATE = "CREATEDATE";
	public static final String ATTR_NODE_CREATEUSER = "CREATEUSER";
	public static final String ATTR_NODE_LASTCHANGEDDATE = "LASTCHANGEDDATE";
	public static final String ATTR_NODE_LASTCHANGEDUSER = "LASTCHANGEDUSER";
	public static final String ATTR_NODE_SERVERID = "SERVERID";
	public static final String ATTR_NODE_NAME = "NAME";
	public static final String ATTR_NODE_DESCRIPTION = "DESCRIPTION";
	public static final String ATTR_NODE_ID = "ID";
	public static final String ATTR_NODE_TYPE = "TYPE";
	public static final String ATTR_NODE_LENGTH = "LENGTH";
	public static final String ATTR_NODE_PRECISION = "PRECISION";
	public static final String ATTR_NODE_SCALE = "SCALE";
	public static final String ATTR_NODE_GROUPID = "GROUPID";
	public static final String ATTR_NODE_MAXINTVALUE = "MAXINTVALUE";
	public static final String ATTR_NODE_MININTVALUE = "MININTVALUE";
	public static final String ATTR_NODE_STRINGCONSTRAINT = "STRINGCONSTRAINT";
	public static final String ATTR_NODE_MINVALUESET = "MINVALUESET";
	public static final String ATTR_NODE_MAXVALUESET = "MAXVALUESET";
	public static final String ATTR_NODE_VALID = "VALID";
	public static final String ATTR_NODE_SEARCHABLE = "SEARCHABLE";
	public static final String ATTR_NODE_MANDATORY = "MANDATORY";
	public static final String ATTR_NODE_PROTECTED = "PROTECTED";
	public static final String ATTR_NODE_UNIQUE = "UNIQUE";
	public static final String ATTR_NODE_PRIMARY = "PRIMARY";
	public static final String ATTR_NODE_TEXTSEARCHABLE = "TEXTSEARCHABLE";
	public static final String ATTR_NODE_DISPLAYORDER = "DISPLAYORDER";
	public static final String ATTR_NODE_PARENTKEY = "PARENTKEY";
	public static final String ATTR_NODE_FOREIGNKEY = "FOREIGNKEY";
	public static final String ATTR_NODE_LINKED = "LINKED";
	public static final String ATTR_NODE_VALUE = "VALUE";
	public static final String ATTR_NODE_USERINPUTED = "USERINPUTED";
	public static final String ATTR_NODE_DOCUMENTID = "DOCUMENTID";
	public static final String ATTR_NODE_STORAGEID = "STORAGEID";
	public static final String ATTR_NODE_CONTAINERID = "CONTAINERID";
	public static final String ATTR_NODE_DOCFILENAME = "DOCFILENAME";
	public static final String ATTR_NODE_DOCUMENTTYPEID = "DOCUMENTTYPEID";
	public static final String ATTR_NODE_DOCUMENTTYPENAME = "DOCUMENTTYPENAME";
	public static final String ATTR_NODE_SIZE = "SIZE";
	public static final String ATTR_NODE_MIMETYPEID = "MIMETYPEID";
	public static final String ATTR_NODE_MIMETYPE = "MIMETYPE";
	public static final String ATTR_NODE_STATUS = "STATUS";
	public static final String ATTR_NODE_DATALOCATION = "DATALOCATION";
	public static final String ATTR_NODE_EMPTYINCACHE = "EMPTYINCACHE";
	public static final String ATTR_NODE_ENCRYPTIONREQUIRED = "ENCRYPTIONREQUIRED";
	public static final String ATTR_NODE_DOCUMENTFLAG = "DOCUMENTFLAG";

	public static final String ATTRLIST_NODE_REPLY = "REPLY";
	public static final String ATTRLIST_NODE_YOUNGCONTENT = "YOUNGCONTENT";
	public static final String ATTRLIST_NODE_YOUNGPROPERTY = "YOUNGPROPERTY";
	public static final String ATTRLIST_NODE_YOUNGPROPERTIES = "YOUNGPROPERTIES";
	public static final String ATTRLIST_NODE_YOUNGDOCUMENTS = "YOUNGDOCUMENTS";
	public static final String ATTRLIST_NODE_YOUNGDOCUMENT = "YOUNGDOCUMENT";
	
	//标签类型
	/** 不带任何属性的单标签 */
	public static final int NODE_TYPE_NOATTR = 0;
	/** 带单个节点属性值的双标签 */
	public static final int NODE_TYPE_ATTR = 1;
	/** 带节点属性列表的双标签 */
	public static final int NODE_TYPE_ATTRLIST = 2;
	
	/**
	 * 根据所给标签名返回该标签对应的类型
	 * @param nodeName
	 * @return
	 * @throws IllegalAccessException 判断的标签必须是定义于当前类中的常量，如果未在当前类中定义
	 */
	public static int getNodeType(String nodeName) throws IllegalAccessException
	{
		switch(nodeName)
		{
			case NOATTR_NODE_SUCCESS: return NODE_TYPE_NOATTR;
			case NOATTR_NODE_CONTROLFLAG: return NODE_TYPE_NOATTR;
			case NOATTR_NODE_PARENTNODEID: return NODE_TYPE_NOATTR;
			case NOATTR_NODE_CHECKEDOUTUSER: return NODE_TYPE_NOATTR;
			
			case ATTR_NODE_ROOT: return NODE_TYPE_ATTR;
			case ATTR_NODE_FOLDER: return NODE_TYPE_ATTR;
			case ATTR_NODE_NODECLASS: return NODE_TYPE_ATTR;
			case ATTR_NODE_NODETYPENAME: return NODE_TYPE_ATTR;
			case ATTR_NODE_CONTENTTYPENAME: return NODE_TYPE_ATTR;
			case ATTR_NODE_CONTENTTYPEID: return NODE_TYPE_ATTR;
			case ATTR_NODE_NODETYPEID: return NODE_TYPE_ATTR;
			case ATTR_NODE_CONTENTID: return NODE_TYPE_ATTR;
			case ATTR_NODE_NODEID: return NODE_TYPE_ATTR;
			case ATTR_NODE_VERSIONID: return NODE_TYPE_ATTR;
			case ATTR_NODE_PROPERTYLISTSIZE: return NODE_TYPE_ATTR;
			case ATTR_NODE_CRUDSTATUS: return NODE_TYPE_ATTR;
			case ATTR_NODE_CONTENTCLASS: return NODE_TYPE_ATTR;
			case ATTR_NODE_CONTENTSTATUS: return NODE_TYPE_ATTR;
			case ATTR_NODE_RETENTIONCONTENT: return NODE_TYPE_ATTR;
			case ATTR_NODE_CHECKEDOUT: return NODE_TYPE_ATTR;
			case ATTR_NODE_CREATEDATE: return NODE_TYPE_ATTR;
			case ATTR_NODE_CREATEUSER: return NODE_TYPE_ATTR;
			case ATTR_NODE_LASTCHANGEDUSER: return NODE_TYPE_ATTR;
			case ATTR_NODE_LASTCHANGEDDATE: return NODE_TYPE_ATTR;
			case ATTR_NODE_SERVERID: return NODE_TYPE_ATTR;
			case ATTR_NODE_NAME: return NODE_TYPE_ATTR;
			case ATTR_NODE_DESCRIPTION: return NODE_TYPE_ATTR;
			case ATTR_NODE_ID: return NODE_TYPE_ATTR;
			case ATTR_NODE_TYPE: return NODE_TYPE_ATTR;
			case ATTR_NODE_LENGTH: return NODE_TYPE_ATTR;
			case ATTR_NODE_PRECISION: return NODE_TYPE_ATTR;
			case ATTR_NODE_SCALE: return NODE_TYPE_ATTR;
			case ATTR_NODE_GROUPID: return NODE_TYPE_ATTR;
			case ATTR_NODE_MAXINTVALUE: return NODE_TYPE_ATTR;
			case ATTR_NODE_MININTVALUE: return NODE_TYPE_ATTR;
			case ATTR_NODE_STRINGCONSTRAINT: return NODE_TYPE_ATTR;
			case ATTR_NODE_MINVALUESET: return NODE_TYPE_ATTR;
			case ATTR_NODE_MAXVALUESET: return NODE_TYPE_ATTR;
			case ATTR_NODE_VALID: return NODE_TYPE_ATTR;
			case ATTR_NODE_SEARCHABLE: return NODE_TYPE_ATTR;
			case ATTR_NODE_MANDATORY: return NODE_TYPE_ATTR;
			case ATTR_NODE_PROTECTED: return NODE_TYPE_ATTR;
			case ATTR_NODE_UNIQUE: return NODE_TYPE_ATTR;
			case ATTR_NODE_PRIMARY: return NODE_TYPE_ATTR;
			case ATTR_NODE_TEXTSEARCHABLE: return NODE_TYPE_ATTR;
			case ATTR_NODE_DISPLAYORDER: return NODE_TYPE_ATTR;
			case ATTR_NODE_PARENTKEY: return NODE_TYPE_ATTR;
			case ATTR_NODE_FOREIGNKEY: return NODE_TYPE_ATTR;
			case ATTR_NODE_LINKED: return NODE_TYPE_ATTR;
			case ATTR_NODE_VALUE: return NODE_TYPE_ATTR;
			case ATTR_NODE_USERINPUTED: return NODE_TYPE_ATTR;
			case ATTR_NODE_DOCUMENTID: return NODE_TYPE_ATTR;
			case ATTR_NODE_STORAGEID: return NODE_TYPE_ATTR;
			case ATTR_NODE_CONTAINERID: return NODE_TYPE_ATTR;
			case ATTR_NODE_DOCFILENAME: return NODE_TYPE_ATTR;
			case ATTR_NODE_DOCUMENTTYPEID: return NODE_TYPE_ATTR;
			case ATTR_NODE_DOCUMENTTYPENAME: return NODE_TYPE_ATTR;
			case ATTR_NODE_SIZE: return NODE_TYPE_ATTR;
			case ATTR_NODE_MIMETYPEID: return NODE_TYPE_ATTR;
			case ATTR_NODE_MIMETYPE: return NODE_TYPE_ATTR;
			case ATTR_NODE_STATUS: return NODE_TYPE_ATTR;
			case ATTR_NODE_DATALOCATION: return NODE_TYPE_ATTR;
			case ATTR_NODE_EMPTYINCACHE: return NODE_TYPE_ATTR;
			case ATTR_NODE_ENCRYPTIONREQUIRED: return NODE_TYPE_ATTR;
			case ATTR_NODE_DOCUMENTFLAG: return NODE_TYPE_ATTR;
			
			case ATTRLIST_NODE_REPLY: return NODE_TYPE_ATTRLIST;
			case ATTRLIST_NODE_YOUNGCONTENT: return NODE_TYPE_ATTRLIST;
			case ATTRLIST_NODE_YOUNGPROPERTIES: return NODE_TYPE_ATTRLIST;
			case ATTRLIST_NODE_YOUNGPROPERTY: return NODE_TYPE_ATTRLIST;
			case ATTRLIST_NODE_YOUNGDOCUMENTS: return NODE_TYPE_ATTRLIST;
			case ATTRLIST_NODE_YOUNGDOCUMENT: return NODE_TYPE_ATTRLIST;
			
			default: throw new IllegalAccessException(String.format("未在[%s]类中预定义的标签：%s，请到该类中定义此标签", XmlAttr.class, nodeName));
		}
	}
}
