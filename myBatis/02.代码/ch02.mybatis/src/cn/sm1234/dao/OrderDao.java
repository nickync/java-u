package cn.sm1234.dao;

import java.util.List;

import cn.sm1234.domain.Order;
import cn.sm1234.domain.OrderUser;

public interface OrderDao {

	/**
	 * 查询订单，查询用户查询
	 */
	public List<OrderUser> queryOrderUser();
	
	/**
	 * 查询订单，查询用户(ResultMap)
	 * @return
	 */
	public List<Order> queryOrderUserResultMap();
}
