package mybatisconfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.syl.model.User;
import com.syl.utils.JsonUtil;

import junit.framework.TestCase;

/**
 * @description 
 * @author 史彦磊
 * @version 1.0
 *  2015年10月30日
 */
public class MyBatisConfigTest {
	
	
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void initConfig() throws IOException{
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	
	
	@Test
	public void selectAllUser(){
		SqlSession openSession = this.sqlSessionFactory.openSession();
		List<User> user = openSession.selectList("User.selectAllUser");
		System.out.println(JsonUtil.toJson(user));
	}

}
