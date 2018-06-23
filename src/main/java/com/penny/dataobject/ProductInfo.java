package com.penny.dataobject;/**
 * Created by Administrator on 2018/6/11.
 */


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: sell2
 * @description:
 * @author: Mr.Wang
 * @create: 2018-06-11 10:47
 **/
@Entity
@Data
public class ProductInfo {

    @Id
    /** 商品ID */
    private String productId;
    /** 商品名称 */
    private String productName;
    /** 商品价格（单价） */
    private BigDecimal productPrice;
    /** 商品库存 */
    private Integer productStock;
    /** 商品描述 */
    private String productDescription;
    /** 商品图标 */
    private String productIcon;
    /** 商品状态 */
    private Integer productStatus;
    /** 类目编号 */
    private Integer categoryType;
    /** 创建时间. */
    private Date createTime;
    /** 更新时间. */
    private Date updateTime;

    public ProductInfo(String productId,
                       String productName,
                       BigDecimal productPrice,
                       Integer productStock,
                       String productDescription,
                       String productIcon,
                       Integer productStatus,
                       Integer categoryType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.productStatus = productStatus;
        this.categoryType = categoryType;
    }

    public ProductInfo() {
    }
}
