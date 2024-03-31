package cn.sm1234.test;

import java.util.List;

import org.junit.Test;

import cn.sm1234.dao.CustomerDao;
import cn.sm1234.dao.impl.CustomerDaoImpl;
import cn.sm1234.domain.Customer;

public class Demo1 {

	@Test
	public void test1(){
		Customer c = new Customer();
		c.setName("陈六222");
		c.setGender("男");
		c.setTelephone("13244445555");
		
		CustomerDao dao = new CustomerDaoImpl();
		dao.saveCustomer(c);
	}
	
	@Test
	public void test2(){
		Customer c = new Customer();
		c.setId(1);
		c.setName("李四");
		
		CustomerDao dao = new CustomerDaoImpl();
		dao.updateCustomer(c);
	}
	
	@Test
	public void test3(){
		CustomerDao dao = new CustomerDaoImpl();
		dao.deleteCustomer(8);
	}
	
	@Test
	public void test4(){
		CustomerDao dao = new CustomerDaoImpl();
		List<Customer> list = dao.queryAllCustomer();
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
	
	@Test
	public void test5(){
		CustomerDao dao = new CustomerDaoImpl();
		Customer customer = dao.queryCustomerById(1);
		System.out.println(customer);
	}
	
	@Test
	public void test6(){
		CustomerDao dao = new CustomerDaoImpl();
		List<Customer> list = dao.queryCustomerByName("%陈%");
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
}
