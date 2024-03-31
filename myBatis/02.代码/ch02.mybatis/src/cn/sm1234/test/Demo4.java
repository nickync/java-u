package cn.sm1234.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.sm1234.dao.CustomerDao;
import cn.sm1234.domain.Customer;
import cn.sm1234.domain.CustomerRM;
import cn.sm1234.domain.CustomerVo;
import cn.sm1234.utils.SessionUtils;

public class Demo4 {

	/**
	 * if标签
	 */
	@Test
	public void test1(){
		SqlSession sqlSession = SessionUtils.getSession();
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		
		Customer c = new Customer();
		c.setName("%张%");
		//c.setTelephone("%33%");
		
		List<Customer> list = dao.queryByNameAndTelephone(c);
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	/**
	 * foreach标签
	 */
	@Test
	public void test2(){
		SqlSession sqlSession = SessionUtils.getSession();
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		
		Customer c = new Customer();
		Integer[] ids = {12,13,16};
		c.setIds(ids);
		
		dao.deleteCustomerByIn(c);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
}
