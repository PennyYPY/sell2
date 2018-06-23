package com.penny.enums;/**
 * Created by Administrator on 2018/6/11.
 */

import lombok.Getter;

/**
 * @program: sell2
 * @description:
 * @author: Mr.Wang
 * @create: 2018-06-11 22:10
 **/
@Getter
public enum  OrderStatusEnum {

    NEW(0, "新订单"),
    FINISHED(1, "已完成"),
    CANCELED(2, "已取消");

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
