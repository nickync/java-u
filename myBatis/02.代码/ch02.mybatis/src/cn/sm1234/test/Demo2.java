package cn.sm1234.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.sm1234.dao.CustomerDao;
import cn.sm1234.dao.impl.CustomerDaoImpl;
import cn.sm1234.domain.Customer;
import cn.sm1234.utils.SessionUtils;

public class Demo2 {

	@Test
	public void test1(){
		Customer c = new Customer();
		c.setName("陈六333");
		c.setGender("男");
		c.setTelephone("13244445555");
		
		SqlSession sqlSession = SessionUtils.getSession();
		//getMapper(): 返回指定接口的动态代理的实现类对象
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		dao.saveCustomer(c);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void test2(){
		Customer c = new Customer();
		c.setId(1);
		c.setName("李四222");
		
		SqlSession sqlSession = SessionUtils.getSession();
		//getMapper(): 返回指定接口的动态代理的实现类对象
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		dao.updateCustomer(c);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void test3(){
		SqlSession sqlSession = SessionUtils.getSession();
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		dao.deleteCustomer(15);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void test4(){
		SqlSession sqlSession = SessionUtils.getSession();
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		List<Customer> list = dao.queryAllCustomer();
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
	
	@Test
	public void test5(){
		SqlSession sqlSession = SessionUtils.getSession();
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		Customer customer = dao.queryCustomerById(1);
		System.out.println(customer);
	}
	
	@Test
	public void test6(){
		SqlSession sqlSession = SessionUtils.getSession();
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		List<Customer> list = dao.queryCustomerByName("%陈%");
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
}
