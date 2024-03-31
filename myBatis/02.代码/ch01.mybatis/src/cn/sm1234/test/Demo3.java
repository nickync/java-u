package cn.sm1234.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.sm1234.domain.Customer;
import cn.sm1234.utils.SessionUtils;

/**
 * 演示MyBatis的CRUD操作
 * 
 * @author lenovo
 * 
 */
public class Demo3 {
	// 添加操作
	@Test
	public void test1() {
		SqlSession sqlSession = SessionUtils.getSession();
		Customer c = new Customer();
		c.setName("李四");
		c.setGender("女");
		c.setTelephone("14355557777");
		sqlSession.insert("insertCustomer", c);
		// 必须添加事务
		sqlSession.commit();
		sqlSession.close();
	}

	// 修改操作
	@Test
	public void test2() {
		SqlSession sqlSession = SessionUtils.getSession();
		Customer c = new Customer();
		c.setId(11);
		c.setName("老王");
		sqlSession.update("updateCustomer", c);
		// 必须添加事务
		sqlSession.commit();
		sqlSession.close();
	}
	
	// 查询所有操作
	@Test
	public void test3() {
		SqlSession sqlSession = SessionUtils.getSession();
		List<Customer> list = sqlSession.selectList("queryAllCustomer");
		for (Customer customer : list) {
			System.out.println(customer);
		}
		sqlSession.close();
	}
	
	// 根据id查询操作
	@Test
	public void test4() {
		SqlSession sqlSession = SessionUtils.getSession();
		Customer c = sqlSession.selectOne("queryCustomerById", 3);
		System.out.println(c);
		sqlSession.close();
	}
	
	// 根据name模糊查询操作
	@Test
	public void test5() {
		SqlSession sqlSession = SessionUtils.getSession();
		List<Customer> list = sqlSession.selectList("queryCustomerByName", "%张%");
		for (Customer customer : list) {
			System.out.println(customer);
		}
		sqlSession.close();
	}
	
	// 删除操作
	@Test
	public void test6() {
		SqlSession sqlSession = SessionUtils.getSession();
		sqlSession.delete("deleteCustomer", 9);
		sqlSession.commit();
		sqlSession.close();
	}
}
