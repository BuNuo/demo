package com.hackcrown.demo.exception;

import com.hackcrown.demo.domain.Result;
import com.hackcrown.demo.utils.ResultUtil;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @Auther: bunuo
 * @Date: 2018/7/5 21:48
 * @Description:
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    
    /*public static final String DEFAULT_ERROR_VIEW = "error";
    
    @ExceptionHandler(value = DemoException.class)
    @ResponseBody
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }*/

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof DemoException) {
            DemoException demoException = (DemoException) e;
            return ResultUtil.error(demoException.getCode(), demoException.getMessage());
        }if(e instanceof NoHandlerFoundException) {
        	return ResultUtil.error(404, "NOT FOUND");
        } else if(e instanceof HttpRequestMethodNotSupportedException) {
        	return ResultUtil.error(404, "NOT FOUND");
        } else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
    
    
}
