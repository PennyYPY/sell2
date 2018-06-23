package com.penny.utils;/**
 * Created by Administrator on 2018/6/11.
 */

import com.penny.vo.ResultVO;

/**
 * @program: sell2
 * @description:
 * @author: Mr.Wang
 * @create: 2018-06-11 21:47
 **/
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMessage("成功");

        return resultVO;
    }

    public static ResultVO success(){

        return success(null);

    }

    public static ResultVO error(Integer code,String msg){

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(msg);
        return resultVO;
    }

}
