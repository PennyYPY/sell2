package com.penny.dataobject;/**
 * Created by Administrator on 2018/6/6.
 */

import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: sell2
 * @description:
 * @author: Mr.Wang
 * @create: 2018-06-06 10:17
 **/
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    /*类目Id*/
    private Integer categoryId;
    /*类目名字*/
    private String categoryName;
    /*类目类型*/
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
