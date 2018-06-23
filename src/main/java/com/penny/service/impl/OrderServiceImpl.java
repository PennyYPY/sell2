package com.penny.service.impl;/**
 * Created by Administrator on 2018/6/13.
 */

import com.penny.dataobject.OrderDetail;
import com.penny.dataobject.OrderMaster;
import com.penny.dataobject.ProductInfo;
import com.penny.dto.CartDTO;
import com.penny.dto.OrderDTO;
import com.penny.enums.OrderStatusEnum;
import com.penny.enums.PayStatusEnum;
import com.penny.enums.ResultEnum;
import com.penny.exception.SellException;
import com.penny.repository.OrderDetailRepository;
import com.penny.repository.OrderMasterRepository;
import com.penny.service.OrderService;
import com.penny.service.ProductInfoService;
import com.penny.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: sell2
 * @description:
 * @author: Mr.Wang
 * @create: 2018-06-13 21:36
 **/
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    @Transactional
    public OrderDTO createOrder(OrderDTO orderDTO) {

        String orderId = KeyUtil.getUniqueKey();
//        List<CartDTO> cartDTOList = new ArrayList<>();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        //1、查询商品（数量，价格）
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {

            ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2、计算一件商品的订单总价
           orderAmount = productInfo
                   .getProductPrice()
                   .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                   .add(orderAmount);
            //订单详情入库
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);

            //spring提供的属性拷贝的工具
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);

//            CartDTO cartDTO = new CartDTO(orderDetail.getProductId(),orderDetail.getProductQuantity());
//            cartDTOList.add(cartDTO);

        }
        
        //3、订单写入数据库(orderMaster和orderDetail)
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderAmount(orderAmount);
        orderMasterRepository.save(orderMaster);

        //4、扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(),e.getProductQuantity()))
        .collect(Collectors.toList());
        productInfoService.decreaseStock(cartDTOList);
        
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paidOrder(OrderDTO orderDTO) {
        return null;
    }
}
