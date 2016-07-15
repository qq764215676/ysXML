package com.net.xml.bean;

import java.io.Serializable;
import java.util.ArrayList;

import com.net.xml.bean.XmlData.YOUNGCONTENT.YOUNGDOCUMENTS.YOUNGDOCUMENT;
import com.net.xml.bean.XmlData.YOUNGCONTENT.YOUNGPROPERTIES.YOUNGPROPERTY;

/**
 * 
 * 对应云平台xml文件的数据结构类；
 * 包含云平台xml文件中的标签携带的属性；
 * 用于存放解析云平台xml文件后得到的数据；
 */
public class XmlData implements Serializable
{
	/** xml请求是否正常返回 */
	public boolean SUCCESS = false;
	/** xml请求未正常返回时的异常信息 */
	public String ERROR = "";
	/** YOUNGCONTENT标签 */
	public ArrayList<YOUNGCONTENT> YOUNGCONTENT = new ArrayList<>();
	
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
		
		/** YOUNGPROPERTIES标签中包含的带内容属性的双标签子节点 */
		public static class YOUNGPROPERTIES implements Serializable
		{
			public ArrayList<YOUNGPROPERTY> YOUNGPROPERTY = new ArrayList<>();
			
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
		}
		
		/** YOUNGDOCUMENTS标签中包含的带内容属性的双标签子节点 */
		public static class YOUNGDOCUMENTS implements Serializable
		{
			public ArrayList<YOUNGDOCUMENT> YOUNGDOCUMENT = new ArrayList<>();
			
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
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("SUCCESS="+SUCCESS+"\n");
		sb.append("ERROR="+ERROR+"\n");
		sb.append("YOUNGCONTENTS:");
		sb.append("[");
		for (int i = 0; i < YOUNGCONTENT.size(); i++)
		{
			YOUNGCONTENT youngcontent = YOUNGCONTENT.get(i);
			sb.append("[");
			sb.append("ROOT="+youngcontent.ROOT+",");
			sb.append("FOLDER="+youngcontent.FOLDER+",");
			sb.append("NODECLASS="+youngcontent.NODECLASS+",");
			sb.append("NODETYPENAME="+youngcontent.NODETYPENAME+",");
			sb.append("CONTENTTYPENAME="+youngcontent.CONTENTTYPENAME+",");
			sb.append("CONTENTTYPEID="+youngcontent.CONTENTTYPEID+",");
			sb.append("NODETYPEID="+youngcontent.NODETYPEID+",");
			sb.append("PARENTNODEID="+youngcontent.PARENTNODEID+",");
			sb.append("CONTENTID="+youngcontent.CONTENTID+",");
			sb.append("NODEID="+youngcontent.NODEID+",");
			sb.append("VERSIONID="+youngcontent.VERSIONID+",");
			sb.append("PROPERTYLISTSIZE="+youngcontent.PROPERTYLISTSIZE+",");
			sb.append("CRUDSTATUS="+youngcontent.CRUDSTATUS+",");
			sb.append("CONTENTCLASS="+youngcontent.CONTENTCLASS+",");
			sb.append("CONTENTSTATUS"+youngcontent.CONTENTSTATUS+",");
			sb.append("RETENTIONCONTENT="+youngcontent.RETENTIONCONTENT+",");
			sb.append("CHECKEDOUTUSER="+youngcontent.CHECKEDOUTUSER+",");
			sb.append("CHECKEDOUT="+youngcontent.CHECKEDOUT+",");
			sb.append("CREATEDATE="+youngcontent.CREATEDATE+",");
			sb.append("CREATEUSER="+youngcontent.CREATEUSER+",");
			sb.append("LASTCHANGEDDATE="+youngcontent.LASTCHANGEDDATE+",");
			sb.append("LASTCHANGEDUSER="+youngcontent.LASTCHANGEDUSER+",");
			sb.append("SERVERID="+youngcontent.SERVERID+",");
			
			sb.append("\n");
			sb.append("YOUNGPROPERTIES:");
			sb.append("[");
			for (int j = 0; j < youngcontent.YOUNGPROPERTIES.YOUNGPROPERTY.size(); j++)
			{
				YOUNGPROPERTY youngproperty = youngcontent.YOUNGPROPERTIES.YOUNGPROPERTY.get(j);
				sb.append("[");
				sb.append("NAME="+youngproperty.NAME+",");
				sb.append("DESCRIPTION="+youngproperty.DESCRIPTION+",");
				sb.append("ID="+youngproperty.ID+",");
				sb.append("CONTROLFLAG="+youngproperty.CONTROLFLAG+",");
				sb.append("TYPE="+youngproperty.TYPE+",");
				sb.append("LENGTH="+youngproperty.LENGTH+",");
				sb.append("PRECISION="+youngproperty.PRECISION+",");
				sb.append("SCALE="+youngproperty.SCALE+",");
				sb.append("GROUPID="+youngproperty.GROUPID+",");
				sb.append("MAXINTVALUE="+youngproperty.MAXINTVALUE+",");
				sb.append("MININTVALUE="+youngproperty.MININTVALUE+",");
				sb.append("STRINGCONSTRAINT="+youngproperty.STRINGCONSTRAINT+",");
				sb.append("MINVALUESET="+youngproperty.MINVALUESET+",");
				sb.append("MAXVALUESET="+youngproperty.MAXVALUESET+",");
				sb.append("VALID="+youngproperty.VALID+",");
				sb.append("SEARCHABLE="+youngproperty.SEARCHABLE+",");
				sb.append("MANDATORY="+youngproperty.MANDATORY+",");
				sb.append("PROTECTED="+youngproperty.PROTECTED+",");
				sb.append("UNIQUE="+youngproperty.UNIQUE+",");
				sb.append("PRIMARY="+youngproperty.PRIMARY+",");
				sb.append("TEXTSEARCHABLE="+youngproperty.TEXTSEARCHABLE+",");
				sb.append("DISPLAYORDER="+youngproperty.DISPLAYORDER+",");
				sb.append("CONTENTTYPEID="+youngproperty.CONTENTTYPEID+",");
				sb.append("NODETYPEID="+youngproperty.NODETYPEID+",");
				sb.append("CRUDSTATUS="+youngproperty.CRUDSTATUS+",");
				sb.append("PARENTKEY="+youngproperty.PARENTKEY+",");
				sb.append("FOREIGNKEY="+youngproperty.FOREIGNKEY+",");
				sb.append("LINKED="+youngproperty.LINKED+",");
				sb.append("VALUE="+youngproperty.VALUE+",");
				sb.append("USERINPUTED="+youngproperty.USERINPUTED+",");
				sb.append("]");
				sb.append(",");
				sb.append("\n");
			}
			sb.append("]");
			
			sb.append("\n");
			sb.append("YOUNGDOCUMENTS:");
			sb.append("[");
			for (int j = 0; j < youngcontent.YOUNGDOCUMENTS.YOUNGDOCUMENT.size(); j++)
			{
				YOUNGDOCUMENT youngdocument = youngcontent.YOUNGDOCUMENTS.YOUNGDOCUMENT.get(j);
				sb.append("[");
				sb.append("DOCUMENTID="+youngdocument.DOCUMENTID+",");
				sb.append("VERSIONID="+youngdocument.VERSIONID+",");
				sb.append("STORAGEID="+youngdocument.STORAGEID+",");
				sb.append("CONTAINERID="+youngdocument.CONTAINERID+",");
				sb.append("DOCFILENAME="+youngdocument.DOCFILENAME+",");
				sb.append("DOCUMENTTYPEID="+youngdocument.DOCUMENTTYPEID+",");
				sb.append("NODETYPEID="+youngdocument.NODETYPEID+",");
				sb.append("DOCUMENTTYPENAME="+youngdocument.DOCUMENTTYPENAME+",");
				sb.append("SIZE="+youngdocument.SIZE+",");
				sb.append("MIMETYPEID="+youngdocument.MIMETYPEID+",");
				sb.append("MIMETYPE="+youngdocument.MIMETYPE+",");
				sb.append("STATUS="+youngdocument.STATUS+",");
				sb.append("DATALOCATION="+youngdocument.DATALOCATION+",");
				sb.append("EMPTYINCACHE="+youngdocument.EMPTYINCACHE+",");
				sb.append("CRUDSTATUS="+youngdocument.CRUDSTATUS+",");
				sb.append("CONTENTTYPENAME="+youngdocument.CONTENTTYPENAME+",");
				sb.append("ENCRYPTIONREQUIRED="+youngdocument.ENCRYPTIONREQUIRED+",");
				sb.append("DOCUMENTFLAG="+youngdocument.DOCUMENTFLAG+",");
				sb.append("]");
				sb.append(",");
				sb.append("\n");
			}
			sb.append("]");
			
			sb.append("]");
			if(i!=YOUNGCONTENT.size()-1)
			{
				sb.append(",");
				sb.append("\n\n");
			}
		}
		sb.append("]");
		
		return sb.toString();
	}
}
