package com.penny.service;

import com.penny.dataobject.ProductInfo;
import com.penny.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Administrator on 2018/6/11.
 */
public interface ProductInfoService {

    ProductInfo findOne(String productId);
    /**
     * 查询所有在架的商品
     * @return
     * */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存；
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存；
    void decreaseStock(List<CartDTO> cartDTOList);

}
