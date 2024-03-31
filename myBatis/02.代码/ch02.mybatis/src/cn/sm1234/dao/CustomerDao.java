package cn.sm1234.dao;

import java.util.List;

import cn.sm1234.domain.Customer;
import cn.sm1234.domain.CustomerRM;
import cn.sm1234.domain.CustomerVo;

public interface CustomerDao {

	public void saveCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Integer id);
	
	public List<Customer> queryAllCustomer();
	
	public Customer queryCustomerById(Integer id);
	
	public List<Customer> queryCustomerByName(String name);
	
	//输入映射
	//public void testParameterType(String name);
	//public void testParameterType(Customer c);
	public void testParameterType(CustomerVo c);
	
	public Long queryTotalCount();
	
	public Customer queryCustomer(Integer id);
	
	public CustomerRM queryCustomerResultMap(Integer id);
	
	public List<Customer> queryByNameAndTelephone(Customer customer);
	
	public void deleteCustomerByIn(Customer customer);
	
}
