package com.penny.cotroller;/**
 * Created by Administrator on 2018/6/11.
 */

import com.penny.dataobject.ProductCategory;
import com.penny.dataobject.ProductInfo;
import com.penny.service.CategoryService;
import com.penny.service.ProductInfoService;
import com.penny.utils.ResultVOUtil;
import com.penny.vo.ProductInfoVO;
import com.penny.vo.ProductVO;
import com.penny.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: sell2
 * @description:
 * @author: Mr.Wang
 * @create: 2018-06-11 16:56
 **/
@RestController
@RequestMapping(value = "/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //1、查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        
        //2、查询类目（一次性查询）
        List<Integer> categoryTypeList;
        //传统方法
//        for (ProductInfo productInfo : productList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简的做法(java8,lambda)
        categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        
        List<ProductCategory> productCategoriesList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3、数据拼装

        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoriesList){

            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){

                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);

                }

            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(Arrays.asList(productVOList));
    }

}
