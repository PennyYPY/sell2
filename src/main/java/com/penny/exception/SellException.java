package com.penny.exception;/**
 * Created by Administrator on 2018/6/13.
 */

import com.penny.enums.ResultEnum;


/**
 * @program: sell2
 * @description:
 * @author: Mr.Wang
 * @create: 2018-06-13 21:57
 **/
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {

        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();

    }
}
