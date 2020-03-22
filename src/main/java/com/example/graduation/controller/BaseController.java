package com.example.graduation.controller;

import com.example.graduation.bean.CommonResultBean;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author LiaoFuQin
 * @Classname BaseController
 * @Description TODO
 * @Date 2020/3/10 13:33
 * @Created by LiaoFuQin
 */
public class BaseController {
    //拦截错误信息并返回
    @ExceptionHandler(Exception.class)
    public CommonResultBean handleException(Exception e) {
        CommonResultBean commonResultBean = new CommonResultBean();
        commonResultBean.setResultCode("-1");
        commonResultBean.setResultMsg(e.getMessage());
        return commonResultBean;
    }
}
