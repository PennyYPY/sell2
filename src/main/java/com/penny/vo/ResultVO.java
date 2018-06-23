package com.penny.vo;/**
 * Created by Administrator on 2018/6/11.
 */

/**
 * @program: sell2
 * @description:
 * @author: Mr.Wang
 * @create: 2018-06-11 16:58
 **/
public class ResultVO<T> {

    /***/
    private Integer code;
    /***/
    private String message;
    private T data;



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
