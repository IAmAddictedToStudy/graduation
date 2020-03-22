package com.example.graduation.controller;

import com.example.graduation.bean.*;
import com.example.graduation.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author LiaoFuQin
 * @Classname MemberController
 * @Description TODO
 * @Date 2020/3/21 19:34
 * @Created by LiaoFuQin
 */
@RestController
public class MemberCustController extends BaseController {
    @Autowired
    MemberService memberService;

    @RequestMapping("/queryAllMemberController")
    public CommonResultBean<QueryMemberCustResponseBean> queryAllMemberController() {
        CommonResultBean<QueryMemberCustResponseBean> resultBean = new CommonResultBean<>();
        resultBean.setData(memberService.queryAllMemberService());
        return resultBean;
    }

    @RequestMapping("/queryMemberCust")
    public CommonResultBean<QueryMemberCustResponseBean> queryMemberCust(QueryMemberCustRequestBean queryMemberCustRequestBean) {
        CommonResultBean<QueryMemberCustResponseBean> resultBean = new CommonResultBean<>();
        QueryMemberCustResponseBean queryMemberCustResponseBean = memberService.queryMemberCust(queryMemberCustRequestBean);
        resultBean.setData(queryMemberCustResponseBean);
        return resultBean;
    }

    @PostMapping("/login")
    public CommonResultBean<MemberCustBean> login(MemberCustLoginRequestBean requestBean, HttpSession session) throws Exception {
        CommonResultBean<MemberCustBean> resultBean = new CommonResultBean<>();
        if (StringUtils.isEmpty(requestBean.getCustPassword())) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("密码不能为空");
            return resultBean;
        }
        if (StringUtils.isEmpty(requestBean.getCustStudentNumber())) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("账号不能为空");
            return resultBean;
        }
        try {
            MemberCustBean login = memberService.login(requestBean);
            session.setAttribute("memberCustBean", login);
            resultBean.setData(login);
        } catch (Exception e) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("账号或密码错误");
            return resultBean;
        }

        return resultBean;
    }


    @PostMapping("/register")
    public CommonResultBean register(@Valid MemberCustBean memberCustBean) {
        CommonResultBean commonResultBean = new CommonResultBean();
        try {
            memberService.register(memberCustBean);
        } catch (Exception e) {
            commonResultBean.setResultCode("-1");
            commonResultBean.setResultMsg(e.getMessage());
        }
        return commonResultBean;
    }
}
