package wine.tree.comm;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class SQLSupport {
	
	private static SqlSessionFactory sqlSessionFactory;
	Logger logger = Logger.getLogger(SQLSupport.class);
	
	static {
		String configPath = "wine/tree/comm/SQLMapConfig.xml";
		
		try {
			Reader reader = Resources.getResourceAsReader(configPath);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			System.out.println("SqlSessionFactory 객체 생성 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	
}
