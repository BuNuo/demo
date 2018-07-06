package com.hackcrown.demo.utils;

import com.hackcrown.demo.domain.Result;

/**
 * @Auther: bunuo
 * @Date: 2018/7/5 21:51
 * @Description:
 */
public class ResultUtil {

    public static Result success(Object object) {
    	Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
