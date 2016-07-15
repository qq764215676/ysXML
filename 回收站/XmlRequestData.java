package com.net.xml.bean;

import java.io.Serializable;
import java.util.ArrayList;

import com.net.xml.bean.XmlData.YOUNGCONTENT.YOUNGDOCUMENTS;
import com.net.xml.bean.XmlData.YOUNGCONTENT.YOUNGPROPERTIES;
import com.net.xml.bean.XmlData.YOUNGCONTENT.YOUNGDOCUMENTS.YOUNGDOCUMENT;
import com.net.xml.bean.XmlData.YOUNGCONTENT.YOUNGPROPERTIES.YOUNGPROPERTY;

@SuppressWarnings("serial")
public class XmlRequestData
{
	public Envelope Envelope;
	
	public static class Envelope
	{
		public String Header;
		public Body Body;
	}
	
	public static class Body
	{
		public REPLY REPLY;
		public REQUEST REQUEST;
	}
	
	public static class REPLY
	{
		
	}
	
	public static class REQUEST
	{
		public AUTHENTICATION AUTHENTICATION;
		public String COMMAND;
		public DATA DATA;
	}
	
	public static class AUTHENTICATION
	{
		public SERVERDEF SERVERDEF;
		public LOGONDATA LOGONDATA;
	}
	
	public static class SERVERDEF
	{
		public String SERVERNAME;
	}
	
	public static class LOGONDATA
	{
		public String USERNAME;
		public String PASSWORD;
	}
	
	public static class DATA
	{
		public String CONTENTID;
		public String CONTENTTYPENAME;
		public String FOLDER;
	}
	
	public static class YOUNGCONTENT implements Serializable
	{
		public String ROOT = "";
		public String FOLDER = "";
		public String NODECLASS = "";
		public String NODETYPENAME = "";
		public String CONTENTTYPENAME = "";
		public String CONTENTTYPEID = "";
		public String NODETYPEID = "";
		public String CONTENTID = "";
		public String NODEID = "";
		public String PARENTNODEID = "";
		public String VERSIONID = "";
		public String PROPERTYLISTSIZE = "";
		public String CRUDSTATUS = "";
		public String CONTENTCLASS = "";
		public String CONTENTSTATUS = "";
		public String RETENTIONCONTENT = "";
		public String CHECKEDOUTUSER = "";
		public String CHECKEDOUT = "";
		public String CREATEDATE = "";
		public String CREATEUSER = "";
		public String LASTCHANGEDDATE = "";
		public String LASTCHANGEDUSER = "";
		public String SERVERID = "";
		/** YOUNGPROPERTIES标签 */
		public YOUNGPROPERTIES YOUNGPROPERTIES = new YOUNGPROPERTIES();
		/** YOUNGDOCUMENTS标签 */
		public YOUNGDOCUMENTS YOUNGDOCUMENTS = new YOUNGDOCUMENTS();
	}
	
	/** YOUNGPROPERTIES标签中包含的带内容属性的双标签子节点 */
	public static class YOUNGPROPERTIES implements Serializable
	{
		public ArrayList<YOUNGPROPERTY> YOUNGPROPERTY = new ArrayList<>();
	}
	
	/** YOUNGPROPERTY标签中包含的带内容属性的双标签子节点 */
	public static class YOUNGPROPERTY implements Serializable
	{
		public String NAME = "";
		public String DESCRIPTION = "";
		public String ID = "";
		public String CONTROLFLAG = "";
		public String TYPE = "";
		public String LENGTH = "";
		public String PRECISION = "";
		public String SCALE = "";
		public String GROUPID = "";
		public String MAXINTVALUE = "";
		public String MININTVALUE = "";
		public String STRINGCONSTRAINT = "";
		public String MINVALUESET = "";
		public String MAXVALUESET = "";
		public String VALID = "";
		public String SEARCHABLE = "";
		public String MANDATORY = "";
		public String PROTECTED = "";
		public String UNIQUE = "";
		public String PRIMARY = "";
		public String TEXTSEARCHABLE = "";
		public String DISPLAYORDER = "";
		public String CONTENTTYPEID = "";
		public String NODETYPEID = "";
		public String CRUDSTATUS = "";
		public String PARENTKEY = "";
		public String FOREIGNKEY = "";
		public String LINKED = "";
		public String VALUE = "";
		public String USERINPUTED = "";
	}
	
	/** YOUNGDOCUMENTS标签中包含的带内容属性的双标签子节点 */
	public static class YOUNGDOCUMENTS implements Serializable
	{
		public ArrayList<YOUNGDOCUMENT> YOUNGDOCUMENT = new ArrayList<>();
	}
	
	/** YOUNGDOCUMENT标签中包含的带内容属性的双标签子节点 */
	public static class YOUNGDOCUMENT implements Serializable
	{
		public String DOCUMENTID = "";
		public String VERSIONID = "";
		public String STORAGEID = "";
		public String CONTAINERID = "";
		public String DOCFILENAME = "";
		public String DOCUMENTTYPEID = "";
		public String NODETYPEID = "";
		public String DOCUMENTTYPENAME = "";
		public String SIZE = "";
		public String MIMETYPEID = "";
		public String MIMETYPE = "";
		public String STATUS = "";
		public String DATALOCATION = "";
		public String EMPTYINCACHE = "";
		public String CRUDSTATUS = "";
		public String CONTENTTYPENAME = "";
		public String ENCRYPTIONREQUIRED = "";
		public String DOCUMENTFLAG = "";
	}
}
