package cn.sm1234.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.sm1234.dao.OrderDao;
import cn.sm1234.dao.UserDao;
import cn.sm1234.domain.Order;
import cn.sm1234.domain.OrderUser;
import cn.sm1234.domain.User;
import cn.sm1234.utils.SessionUtils;

public class Demo5 {

	
	@Test
	public void test1(){
		SqlSession sqlSession = SessionUtils.getSession();
		OrderDao dao = sqlSession.getMapper(OrderDao.class);
		
		List<OrderUser> list = dao.queryOrderUser();
		for (OrderUser ou : list) {
			System.out.println(ou.getName()+"-"+ou.getProductname());
		}
	
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void test2(){
		SqlSession sqlSession = SessionUtils.getSession();
		OrderDao dao = sqlSession.getMapper(OrderDao.class);
		
		List<Order> list = dao.queryOrderUserResultMap();
		for (Order o: list) {
			System.out.println(o.getProductname()+"-"+o.getUser().getName());
		}
	
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void test3(){
		SqlSession sqlSession = SessionUtils.getSession();
		UserDao dao = sqlSession.getMapper(UserDao.class);
		
		List<User> userList = dao.queryUserOrder();
		for (User user : userList) {
			System.out.println("用户："+user.getId()+"-"+user.getName());
			for (Order o:user.getOrders()) {
				System.out.println("订单信息："+o.getOrderno()+"-"+o.getProductname());
			}
		}
	
		sqlSession.commit();
		sqlSession.close();
	}
	

	
}
