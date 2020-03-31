package com.example.graduation.controller;

import com.example.graduation.bean.CommonResultBean;
import com.example.graduation.bean.MemberAdminBean;
import com.example.graduation.service.MemberAdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiaoFuQin
 * @Classname MemberAdminController
 * @Description TODO
 * @Date 2020/3/27 20:44
 * @Created by LiaoFuQin
 */
@RestController
public class MemberAdminController extends BaseController {
    @Autowired
    MemberAdminService memberAdminService;

    @PostMapping("/adminLogin")
    public CommonResultBean<MemberAdminBean> adminLogin(MemberAdminBean memberAdminBean) throws Exception {
        if (StringUtils.isBlank(memberAdminBean.getAdminAccount())) {
            throw new Exception("账号不能为空");
        }
        if (StringUtils.isBlank(memberAdminBean.getAdminPassword())) {
            throw new Exception("密码不能为空");
        }
        CommonResultBean<MemberAdminBean> commonResultBean = new CommonResultBean<>();
        MemberAdminBean memberAdminBean1 = memberAdminService.adminLogin(memberAdminBean);
        commonResultBean.setData(memberAdminBean1);
        return commonResultBean;
    }
}
