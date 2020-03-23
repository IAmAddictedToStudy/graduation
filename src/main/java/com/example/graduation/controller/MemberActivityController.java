package com.example.graduation.controller;

import com.example.graduation.bean.*;
import com.example.graduation.service.MemberActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

    @PostMapping("/insertMemberActivity")
    public CommonResultBean insertMemberActivity(@Valid MemberActivityBean memberActivityBean, HttpSession session) {
        CommonResultBean resultBean = new CommonResultBean();
        try {
            MemberCustBean memberCustBean = (MemberCustBean) session.getAttribute("memberCustBean");
            memberActivityBean.setActivityCreator(memberCustBean.getCustStudentNumber());
        } catch (Exception e) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("未登录，请重新登录");
            return resultBean;
        }
        try {
            service.insertMemberActivity(memberActivityBean);
        } catch (Exception e) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg(e.getMessage());
        }
        return resultBean;
    }
}
