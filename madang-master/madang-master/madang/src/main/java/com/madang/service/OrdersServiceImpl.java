//package com.madang.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.madang.mapper.OrdersMapper;
//import com.madang.vo.Member;
//import com.madang.vo.Orders;
//
//@Service("ordersService")
//public class OrdersServiceImpl implements OrdersService {
//	
//	@Autowired
//	OrdersMapper ordersMapper;
//
//	@Override
//	public Orders findOrderBymemberid(Member member) {
//		Orders orders = ordersMapper.findOrderBymemberid(member);
//		return orders;
//	}
//	
//}
