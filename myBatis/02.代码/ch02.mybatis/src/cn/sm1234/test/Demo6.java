package cn.sm1234.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.sm1234.ssm.mapper.TOrderMapper;
import cn.sm1234.ssm.po.TOrder;
import cn.sm1234.ssm.po.TOrderExample;
import cn.sm1234.ssm.po.TOrderExample.Criteria;
import cn.sm1234.utils.SessionUtils;

public class Demo6 {

	
	@Test
	public void test1(){
		SqlSession sqlSession = SessionUtils.getSession();
		TOrderMapper dao = sqlSession.getMapper(TOrderMapper.class);
		
	/*	TOrder o = new TOrder();
		o.setOrderno("0005");
		o.setProductname("Hibernate入门教程");
		o.setUserId(1);
		
		dao.insert(o);*/
		
		
		TOrder o = new TOrder();
		o.setOrderno("0006");
		o.setProductname("Struts2入门教程");
		//o.setUserId(1);
		
		//dao.insertSelective(o);
		dao.insert(o);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void test2(){
		SqlSession sqlSession = SessionUtils.getSession();
		TOrderMapper dao = sqlSession.getMapper(TOrderMapper.class);
		
		TOrder o = dao.selectByPrimaryKey(5);
		System.out.println(o.getOrderno()+"-"+o.getProductname());
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void test3(){
		SqlSession sqlSession = SessionUtils.getSession();
		TOrderMapper dao = sqlSession.getMapper(TOrderMapper.class);
		
		TOrderExample example = new TOrderExample();
		//Criteria: 封装条件
		Criteria criteria = example.createCriteria();
		//criteria.andIdGreaterThan(3);
		criteria.andProductnameLike("%a%");
		
		List<TOrder> list = dao.selectByExample(example);
		for (TOrder o : list) {
			System.out.println(o.getOrderno()+"-"+o.getProductname());
		}
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	
}
