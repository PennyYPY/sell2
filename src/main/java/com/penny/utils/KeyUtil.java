package com.penny.utils;/**
 * Created by Administrator on 2018/6/13.
 */

import java.util.Random;

/**
 * @program: sell2
 * @description:生成唯一主键
 * @author: Mr.Wang
 * @create: 2018-06-13 22:13
 **/
public class KeyUtil {
    public static synchronized String getUniqueKey() {

        Random random = new Random();
        Integer num = random.nextInt(900000)+ 100000;

        return System.currentTimeMillis() + String.valueOf(num);


    }
}
