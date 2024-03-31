package cn.sm1234.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.sm1234.domain.Customer;
import cn.sm1234.utils.SessionUtils;

/**
 * 演示MyBatis的工具类的使用
 * @author lenovo
 *
 */
public class Demo2 {

	public static void main(String[] args) throws Exception {
		SqlSession sqlSession = SessionUtils.getSession();

		//4.执行操作
		Customer customer = new Customer();
		customer.setName("张三33");
		customer.setGender("男");
		customer.setTelephone("13455556666");
		
		sqlSession.insert("insertCustomer",customer);
		
		//5.如果是更新操作，则需要提交事务
		sqlSession.commit();
		
		//6.关闭连接
		sqlSession.close();
	}
}
