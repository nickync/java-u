package cn.sm1234.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.sm1234.dao.CustomerDao;
import cn.sm1234.domain.Customer;
import cn.sm1234.domain.CustomerRM;
import cn.sm1234.domain.CustomerVo;
import cn.sm1234.utils.SessionUtils;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void saveCustomer(Customer customer) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			sqlSession.insert("insertCustomer", customer);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally{
			sqlSession.close();
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			sqlSession.update("updateCustomer", customer);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally{
			sqlSession.close();
		}
	}

	@Override
	public void deleteCustomer(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			sqlSession.delete("deleteCustomer",id);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally{
			sqlSession.close();
		}
	}

	@Override
	public List<Customer> queryAllCustomer() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			return sqlSession.selectList("queryAllCustomer");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sqlSession.close();
		}
		return null;
	}

	@Override
	public Customer queryCustomerById(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			return sqlSession.selectOne("queryCustomerById",id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sqlSession.close();
		}
		return null;
	}

	@Override
	public List<Customer> queryCustomerByName(String name) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			return sqlSession.selectList("queryCustomerByName",name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sqlSession.close();
		}
		return null;
	}

	@Override
	public void testParameterType(CustomerVo c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long queryTotalCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer queryCustomer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerRM queryCustomerResultMap(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> queryByNameAndTelephone(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomerByIn(Customer customer) {
		// TODO Auto-generated method stub
		
	}

}
