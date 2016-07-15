package com.net.xml.bean;

public class XmlRequestData2
{
	public Envelope Envelope;
	
	public static class Envelope
	{
		public String Header;
		public Body Body;
		
		public static class Body
		{
			public REPLY REPLY;
			public REQUEST REQUEST;
			
			public static class REPLY
			{
				
			}
			
			public static class REQUEST
			{
				public AUTHENTICATION AUTHENTICATION;
				public String COMMAND;
				public DATA DATA;
				
				public static class AUTHENTICATION
				{
					public SERVERDEF SERVERDEF;
					public LOGONDATA LOGONDATA;
					
					public static class SERVERDEF
					{
						public String SERVERNAME;
					}
					
					public static class LOGONDATA
					{
						public String USERNAME;
						public String PASSWORD;
					}
				}
				
				public static class DATA
				{
					public String CONTENTID;
					public String CONTENTTYPENAME;
					public String FOLDER;
				}
			}
		}
	}
}
