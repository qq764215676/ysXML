package Test;

import java.util.ArrayList;

import com.constants.TableInfo.ReplyTable;
import com.net.HttpRequester;
import com.net.database.bean.Table;
import com.net.database.dto.DataOperation;
import com.net.xml.bean.Document;
import com.net.xml.bean.XmlData;
import com.net.xml.dto.SQLWrapper;
import com.net.xml.dto.XmlWrapper;

/**
 * 
 * getElementsByTagName：直接获取文件中的某个节点(然后可以通过后续方法获取其中的子节点)
 * 
 */
public class Test
{
	public static void main(String[] args) throws Exception
	{
		//ArrayList<Table> replyTableList = DataOperation.queryTable(SQLWrapper.query(ReplyTable.TABLE_NAME), ReplyTable.TABLE_NAME);
		//System.out.println(replyTableList.get(0).getField(ReplyTable.FIELD_CONTENT));
		//System.out.println(DataOperation.queryTable(SQLWrapper.wrapSqlForQuery(UserTable.TABLE_NAME), UserTable.TABLE_NAME));
		//System.out.println(replyTableList);
		
		String s;
		s= XmlWrapper.wrapXmlForUpdate(null, "A0100320167121733089706254", (Document)null);
		//s = XmlWrapper.wrapXmlForSelect("from USERS where REALNAME = '邓大平'", "USERS", "", "");
		XmlData xd = HttpRequester.postRequest(s);
		
	}
}
