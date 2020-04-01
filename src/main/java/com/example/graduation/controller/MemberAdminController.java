package com.example.graduation.controller;

import com.example.graduation.bean.CommonResultBean;
import com.example.graduation.bean.MemberAdminBean;
import com.example.graduation.service.MemberAdminService;
import com.example.graduation.service.MerchantLikeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author DaiDaQi
 * @Classname MemberAdminController
 * @Description TODO
 * @Date 2020/3/27 20:44
 * @Created by DaiDaQi
 */
@RestController
public class MemberAdminController extends BaseController {
    @Autowired
    MemberAdminService memberAdminService;
    @Autowired
    MerchantLikeService service;

    @PostMapping("/adminLogin")
    public CommonResultBean<MemberAdminBean> adminLogin(MemberAdminBean memberAdminBean, HttpSession session) throws Exception {
        if (StringUtils.isBlank(memberAdminBean.getAdminAccount())) {
            throw new Exception("账号不能为空");
        }
        if (StringUtils.isBlank(memberAdminBean.getAdminPassword())) {
            throw new Exception("密码不能为空");
        }
        CommonResultBean<MemberAdminBean> commonResultBean = new CommonResultBean<>();
        MemberAdminBean memberAdminBean1 = memberAdminService.adminLogin(memberAdminBean);
        session.setAttribute("memberAdminBean", memberAdminBean1);
        commonResultBean.setData(memberAdminBean1);
        return commonResultBean;
    }

    @RequestMapping("/queryMyAdminMessage")
    public CommonResultBean<MemberAdminBean> queryMyMemberMessage(HttpSession session) {
        CommonResultBean<MemberAdminBean> resultBean = new CommonResultBean<>();
        try {
            MemberAdminBean memberCustBean = (MemberAdminBean) session.getAttribute("memberAdminBean");
            if (memberCustBean == null) {
                resultBean.setResultCode("-1");
                resultBean.setResultMsg("未登录");
                return resultBean;
            }
            resultBean.setData(memberCustBean);
            return resultBean;
        } catch (Exception e) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("未登录");
            return resultBean;
        }
    }
}
