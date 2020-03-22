package com.example.graduation.controller;

import com.example.graduation.bean.ActivityRegistrationBean;
import com.example.graduation.bean.CommonResultBean;
import com.example.graduation.bean.MemberCustBean;
import com.example.graduation.service.ActivityRegisteationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author LiaoFuQin
 * @Classname ActivityRegisteationController
 * @Description TODO
 * @Date 2020/3/22 17:19
 * @Created by LiaoFuQin
 */
@RestController
public class ActivityRegisteationController extends BaseController {
    @Autowired
    ActivityRegisteationService activityRegisteationService;

    @PostMapping("/insertActivityRegistration")
    public CommonResultBean insertActivityRegistration(@Valid ActivityRegistrationBean activityRegistrationBean, HttpSession session) {
        CommonResultBean commonResultBean = new CommonResultBean();

        try {
            MemberCustBean memberCustBean = (MemberCustBean) session.getAttribute("memberCustBean");
            activityRegistrationBean.setStudentNumber(memberCustBean.getCustStudentNumber());
        } catch (Exception e) {
            commonResultBean.setResultCode("-1");
            commonResultBean.setResultMsg("未登录，请重新登录");
            return commonResultBean;
        }
        try {
            activityRegisteationService.insertActivityRegistration(activityRegistrationBean);
        } catch (Exception e) {
            commonResultBean.setResultCode("-1");
            commonResultBean.setResultMsg(e.getMessage());
        }
        return commonResultBean;
    }

}
