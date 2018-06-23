package com.penny.vo;/**
 * Created by Administrator on 2018/6/11.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.penny.dataobject.ProductInfo;

import java.util.List;


/**
 * @program: sell2
 * @description:
 * @author: Mr.Wang
 * @create: 2018-06-11 17:10
 **/
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

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

    public List<ProductInfoVO> getProductInfoVOList() {
        return productInfoVOList;
    }

    public void setProductInfoVOList(List<ProductInfoVO> productInfoVOList) {
        this.productInfoVOList = productInfoVOList;
    }
}
