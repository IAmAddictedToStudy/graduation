package com.example.graduation.service;

import com.example.graduation.bean.MemberCustBean;
import com.example.graduation.bean.MemberCustLoginRequestBean;
import com.example.graduation.bean.QueryMemberCustResponseBean;
import com.example.graduation.repository.MemberCustRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiaoFuQin
 * @Classname MemberController
 * @Description TODO
 * @Date 2020/3/21 19:34
 * @Created by LiaoFuQin
 */
@Service
public class MemberService {
    @Autowired
    MemberCustRepository memberCustRepository;


    public QueryMemberCustResponseBean queryAllMemberController() {
        return memberCustRepository.queryMemberCustMapper();
    }


    public MemberCustBean login(MemberCustLoginRequestBean resultBean) throws Exception {
        return memberCustRepository.login(resultBean);
    }
}
