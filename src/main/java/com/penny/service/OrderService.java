package com.penny.service;

import com.penny.dataobject.OrderDetail;
import com.penny.dataobject.OrderMaster;
import com.penny.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Administrator on 2018/6/13.
 */
public interface OrderService {

    /**创建订单*/
    //如果一次性返回整个实体类，可能造成数据库表结构的泄漏，比如用户名密码一般不需要返回，用DTO解决这个问题;
    OrderDTO createOrder(OrderDTO orderDTO);

    /**查询单个订单*/
    OrderDTO findOne(String orderId);

    /**查询订单列表*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);

    /**完结订单*/
    OrderDTO finish(OrderDTO orderDTO);

    /**支付订单*/
    OrderDTO paidOrder(OrderDTO orderDTO);

}
