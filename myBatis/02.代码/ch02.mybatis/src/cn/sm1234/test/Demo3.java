package cn.sm1234.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.sm1234.dao.CustomerDao;
import cn.sm1234.domain.Customer;
import cn.sm1234.domain.CustomerRM;
import cn.sm1234.domain.CustomerVo;
import cn.sm1234.utils.SessionUtils;

public class Demo3 {

	/**
	 * 输入映射-基本类型
	 */
	@Test
	public void test1(){
		SqlSession sqlSession = SessionUtils.getSession();
		//getMapper(): 返回指定接口的动态代理的实现类对象
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		//dao.testParameterType("张三");
		/*
		
		Customer c = new Customer();
		c.setName("张三2222");
		c.setGender("男");
		c.setTelephone("13211112222");
		dao.testParameterType(c);*/

		CustomerVo vo = new CustomerVo();
		Customer c = new Customer();
		c.setName("张三333");
		c.setGender("男");
		c.setTelephone("13211112222");
		vo.setCustomer(c);
		
		dao.testParameterType(vo);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	/**
	 * 输出映射
	 */
	@Test
	public void test2(){
		SqlSession sqlSession = SessionUtils.getSession();
		//getMapper(): 返回指定接口的动态代理的实现类对象
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);

		/*Long count = dao.queryTotalCount();
		System.out.println(count);*/
		
	/*	Customer c = dao.queryCustomer(1);
		System.out.println(c);*/
		
		CustomerRM c = dao.queryCustomerResultMap(1);
		System.out.println(c);
		
		sqlSession.commit();
		sqlSession.close();
	}	

}
