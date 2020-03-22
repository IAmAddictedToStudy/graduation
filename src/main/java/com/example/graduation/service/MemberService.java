package com.example.graduation.service;

import com.example.graduation.bean.MemberCustBean;
import com.example.graduation.bean.MemberCustLoginRequestBean;
import com.example.graduation.bean.QueryMemberCustRequestBean;
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


    public QueryMemberCustResponseBean queryAllMemberService() {
        return memberCustRepository.queryMemberCustMapper();
    }

    public MemberCustBean login(MemberCustLoginRequestBean resultBean) throws Exception {
        return memberCustRepository.login(resultBean);
    }

    public void register(MemberCustBean resultBean) throws Exception {
        int register = memberCustRepository.register(resultBean);
        if (register <= 0) {
            throw new Exception("注册失败，请重试");
        }
    }

    public QueryMemberCustResponseBean queryMemberCust(QueryMemberCustRequestBean queryMemberCustRequestBean) {
        return memberCustRepository.queryMemberCust(queryMemberCustRequestBean);
    }
}
