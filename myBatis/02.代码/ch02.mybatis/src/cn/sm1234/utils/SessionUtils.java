package cn.sm1234.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtils {

	private static SqlSessionFactoryBuilder builder;
	private static SqlSessionFactory factory;

	/**
	 * 初始化SqlSessionFactory
	 */
	static {
		try {
			builder = new SqlSessionFactoryBuilder();
			InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
			factory = builder.build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取sqlSession
	 */
	public static SqlSession getSession(){
		return factory.openSession();
	}
}
