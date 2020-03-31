package com.example.graduation.controller;

import com.example.graduation.bean.*;
import com.example.graduation.service.ActivityRegisteationService;
import com.example.graduation.service.MemberActivityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @Autowired
    ActivityRegisteationService activityRegisteationService;

    @PostMapping("/queryMemberActivityByCondition")
    public CommonResultBean<QueryMemberActivityResponseBean> queryMemberActivityByCondition(QueryMemberActivityRequestBean requestBean) {
        CommonResultBean<QueryMemberActivityResponseBean> resultBean = new CommonResultBean<>();
        resultBean.setData(service.queryMemberActivityByCondition(requestBean));
        return resultBean;
    }

    @GetMapping("/queryMyJoinMemberActivity")
    public CommonResultBean<QueryMemberActivityResponseBean> queryMyJoinMemberActivity(HttpSession session) {
        CommonResultBean<QueryMemberActivityResponseBean> resultBean = new CommonResultBean<>();
        String studentNumber;
        try {
            MemberCustBean memberCustBean = (MemberCustBean) session.getAttribute("memberCustBean");
            if (memberCustBean == null) {
                resultBean.setResultCode("-1");
                resultBean.setResultMsg("未登录，请重新登录");
                return resultBean;
            }
            studentNumber = memberCustBean.getCustStudentNumber();
        } catch (Exception e) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("未登录，请重新登录");
            return resultBean;
        }
        resultBean.setData(activityRegisteationService.queryMyJoinMemberActivity(studentNumber));
        return resultBean;
    }


    @PostMapping("/insertMemberActivity")
    public CommonResultBean insertMemberActivity(MemberActivityBean memberActivityBean, HttpSession session) throws ParseException {
        CommonResultBean resultBean = new CommonResultBean();
        try {
            MemberCustBean memberCustBean = (MemberCustBean) session.getAttribute("memberCustBean");
            memberActivityBean.setActivityCreator(memberCustBean.getCustStudentNumber());
        } catch (Exception e) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("未登录，请重新登录");
            return resultBean;
        }
        if (StringUtils.isBlank(memberActivityBean.getActivityName())) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("活动名不能为空");
            return resultBean;
        }
        if (StringUtils.isBlank(memberActivityBean.getActivityName())) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("活动名不能为空");
            return resultBean;
        }
        if (StringUtils.isBlank(memberActivityBean.getActivityRole())) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("活动规则不能为空");
            return resultBean;
        }
        if (StringUtils.isBlank(memberActivityBean.getActivityTime())) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("活动时间不能为空");
            return resultBean;
        } else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            String startTimeStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS").format(new Date());
            Date startTime = df.parse(startTimeStr);
            Date endTime = df.parse(memberActivityBean.getActivityTime());
            if (startTime.getTime() > endTime.getTime()) {
                resultBean.setResultCode("-1");
                resultBean.setResultMsg("活动时间不能小于现在");
                return resultBean;
            }

        }
        if (StringUtils.isBlank(memberActivityBean.getActivityContent())) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("活动内容不能为空");
            return resultBean;
        }
        if (StringUtils.isBlank(memberActivityBean.getActivityArea())) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("活动区域不能为空");
            return resultBean;
        }
        if (StringUtils.isBlank(memberActivityBean.getActivitySite())) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("具体地点不能为空");
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
