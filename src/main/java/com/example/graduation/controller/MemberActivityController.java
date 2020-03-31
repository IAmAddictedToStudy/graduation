package com.example.graduation.controller;

import com.example.graduation.bean.*;
import com.example.graduation.service.MemberActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author DaiDaQi
 * @Classname MemberActivityService
 * @Description TODO
 * @Date 2020/3/22 16:27
 * @Created by DaiDaQi
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
    public CommonResultBean insertMemberActivity(MemberActivityBean memberActivityBean, HttpSession session) {
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

    @GetMapping("/queryMyActivityList")
    public CommonResultBean<QueryMemberActivityResponseBean> queryMyActivityList(HttpSession session) {
        CommonResultBean<QueryMemberActivityResponseBean> resultBean = new CommonResultBean<>();
        String studentNumber;
        try {
            MemberCustBean memberCustBean = (MemberCustBean) session.getAttribute("memberCustBean");
            studentNumber = memberCustBean.getCustStudentNumber();
        } catch (Exception e) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("未登录，进行登录");
            return resultBean;
        }
        try {
            resultBean.setData(service.queryMyActivityList(studentNumber));
            return resultBean;
        } catch (Exception e) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg(e.getMessage());
            return resultBean;
        }

    }

    @PostMapping("/updateActivity")
    public CommonResultBean<Object> queryMyActivityList(MemberActivityBean memberActivityBean) {
        CommonResultBean<Object> resultBean = new CommonResultBean<>();
        if (memberActivityBean.getId() == null) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("id不能为空");
            return resultBean;
        }
        try {
            service.updateActivity(memberActivityBean);
            return new CommonResultBean<>();
        } catch (Exception e) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg(e.getMessage());
            return resultBean;
        }
    }

    @PostMapping("/deleteActivity")
    public CommonResultBean deleteActivity(MemberActivityBean memberActivityBean) {
        CommonResultBean resultBean = new CommonResultBean<>();
        if (memberActivityBean.getId() == null) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("id不能为空");
            return resultBean;
        }
        try {
            service.deleteActivity(memberActivityBean);
            return new CommonResultBean();
        } catch (Exception e) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg(e.getMessage());
            return resultBean;
        }

    }

    @GetMapping("/queryRecommendationList")
    public CommonResultBean<QueryMemberActivityResponseBean> queryRecommendationList(HttpSession session) throws Exception {
        CommonResultBean<QueryMemberActivityResponseBean> commonResultBean = new CommonResultBean<>();
        String custCharacter;
        try {
            MemberCustBean memberCustBean = (MemberCustBean) session.getAttribute("memberCustBean");
            custCharacter = memberCustBean.getCustCharacter();
        } catch (Exception e) {
            commonResultBean.setResultCode("-1");
            commonResultBean.setResultMsg("未登录，进行登录");
            return commonResultBean;
        }
        QueryMemberActivityResponseBean queryMemberActivityResponseBean = service.queryRecommendationList(custCharacter);
        commonResultBean.setData(queryMemberActivityResponseBean);
        return commonResultBean;
    }
}
