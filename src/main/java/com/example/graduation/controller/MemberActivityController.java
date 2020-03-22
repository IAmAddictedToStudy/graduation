package com.example.graduation.controller;

import com.example.graduation.bean.CommonResultBean;
import com.example.graduation.bean.QueryMemberActivityRequestBean;
import com.example.graduation.bean.QueryMemberActivityResponseBean;
import com.example.graduation.service.MemberActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiaoFuQin
 * @Classname MemberActivityService
 * @Description TODO
 * @Date 2020/3/22 16:27
 * @Created by LiaoFuQin
 */
@RestController
public class MemberActivityController {
    @Autowired
    MemberActivityService service;

    @PostMapping("/queryMemberActivityByCondition")
    public CommonResultBean<QueryMemberActivityResponseBean> queryMemberActivityByCondition(QueryMemberActivityRequestBean requestBean) {
        CommonResultBean<QueryMemberActivityResponseBean> resultBean = new CommonResultBean<>();
        resultBean.setData(service.queryMemberActivityByCondition(requestBean));
        return resultBean;
    }
}
