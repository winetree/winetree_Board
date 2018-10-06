package wine.tree.comm;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;

public class SQLSupport {
	
	public static SqlMapClient SQLMapClient;
	
	static {
		
		String SQLMapConfig = "wine/tree/comm/SQLMapConfig.xml";
		try {
			Reader reader = Resources.getResourceAsReader(SQLMapConfig);
			SQLMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			System.out.println("iBatis : 객체 생성");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
