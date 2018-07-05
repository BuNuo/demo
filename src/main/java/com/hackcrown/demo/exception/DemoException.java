package com.hackcrown.demo.exception;

import com.hackcrown.demo.enums.ResultEnum;

/**
 * @Auther: bunuo
 * @Date: 2018/7/5 21:47
 * @Description:
 */
public class DemoException extends RuntimeException {

    private Integer code;

    public DemoException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
