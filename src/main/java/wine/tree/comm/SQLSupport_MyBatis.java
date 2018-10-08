package wine.tree.comm;

import java.io.IOException;
import java.io.Reader;
import java.util.logging.Logger;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SQLSupport_MyBatis {

	private static SqlSessionFactory sqlSessionFactory;
	Logger logger = Logger.getLogger("SQLSupport_MyBatis.class");

	static {
		String path = "wine/tree/comm/SQLMapConfig_MyBatis.xml";
		try {
			Reader reader = Resources.getResourceAsReader(path);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			System.out.println("MyBatis 객체 생성 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
