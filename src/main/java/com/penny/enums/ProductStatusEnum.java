package com.penny.enums;

import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Administrator on 2018/6/11.
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架上"),
    DOWN(1,"下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
