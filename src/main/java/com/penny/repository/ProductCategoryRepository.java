package com.penny.repository;/**
 * Created by Administrator on 2018/6/6.
 */

import com.penny.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: sell2
 * @description:
 * @author: Mr.Wang
 * @create: 2018-06-06 10:21
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
}
