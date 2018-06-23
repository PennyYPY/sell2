package com.penny.dto;/**
 * Created by Administrator on 2018/6/14.
 */

import lombok.Data;

/**
 * @program: sell2
 * @description:购物车传输对象
 * @author: Mr.Wang
 * @create: 2018-06-14 09:35
 **/
@Data
public class CartDTO {

    /**商品Id*/
    private String productId;
    /**商品数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public CartDTO() {
    }
}
