package com.example.graduation.controller;

import com.example.graduation.bean.CommonResultBean;
import com.example.graduation.bean.MemberCustBean;
import com.example.graduation.bean.MemberCustLoginRequestBean;
import com.example.graduation.bean.QueryMemberCustResponseBean;
import com.example.graduation.repository.MemberCustRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiaoFuQin
 * @Classname MemberController
 * @Description TODO
 * @Date 2020/3/21 19:34
 * @Created by LiaoFuQin
 */
@RestController
public class MemberController {
    @Autowired
    MemberCustRepository memberCustRepository;

    @RequestMapping("/")
    public CommonResultBean<QueryMemberCustResponseBean> queryAllMemberController() {
        CommonResultBean<QueryMemberCustResponseBean> resultBean = new CommonResultBean<>();
        resultBean.setData(memberCustRepository.queryMemberCustMapper());
        return resultBean;
    }

    @PostMapping("/login")
    public CommonResultBean<MemberCustBean> login(MemberCustLoginRequestBean requestBean) throws Exception {
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
            MemberCustBean login = memberCustRepository.login(requestBean);
            resultBean.setData(login);
        } catch (Exception e) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("账号或密码错误");
            return resultBean;
        }

        return resultBean;
    }
}
