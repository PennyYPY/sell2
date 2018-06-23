package com.penny.dataobject;/**
 * Created by Administrator on 2018/6/6.
 */

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
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
@DynamicUpdate//动态更新；
@Data
@ToString(exclude = {"categoryId","categoryName","categoryType"})
public class ProductCategory {
    @Id
    @GeneratedValue
    /*类目Id*/
    private Integer categoryId;
    /*类目名字*/
    private String categoryName;
    /*类目类型*/
    private Integer categoryType;

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }



    public ProductCategory() {
    }

//    @Override
//    public String toString() {
//        return "ProductCategory{"+
//                "categoryId=" + categoryId+
//                ",categoryName '"+categoryName + '\''+
//                ",categoryType="+categoryType + '}';
//    }
}
