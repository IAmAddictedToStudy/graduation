package com.example.graduation.service;

import com.example.graduation.bean.MemberCustBean;
import com.example.graduation.bean.MemberCustLoginRequestBean;
import com.example.graduation.bean.QueryMemberCustRequestBean;
import com.example.graduation.bean.QueryMemberCustResponseBean;
import com.example.graduation.repository.MemberCustRepository;
import com.example.graduation.repository.entity.MemberCustEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        MemberCustBean memberCustBean = new MemberCustBean();
        MemberCustEntity memberCustEntity = new MemberCustEntity();
        memberCustEntity.setCustStudentNumber(resultBean.getCustStudentNumber());
        memberCustEntity.setCustPassword(resultBean.getCustPassword());
        List<MemberCustEntity> select = memberCustRepository.login(memberCustEntity);
        if (select.size() <= 0) {
            throw new Exception();
        }
        BeanUtils.copyProperties(select.get(0), memberCustBean);
        return memberCustBean;
    }

    public void register(MemberCustBean resultBean) throws Exception {
        MemberCustEntity memberCustEntity = new MemberCustEntity();
        memberCustEntity.setCustStudentNumber(resultBean.getCustStudentNumber());
        List<MemberCustEntity> select = memberCustRepository.select(memberCustEntity);
        if (select.size() > 0) {
            throw new Exception("学号已存在");
        }
        BeanUtils.copyProperties(resultBean, memberCustEntity);
        int register = memberCustRepository.register(memberCustEntity);
        if (register <= 0) {
            throw new Exception("注册失败，请重试");
        }
    }

    public QueryMemberCustResponseBean queryMemberCust(QueryMemberCustRequestBean queryMemberCustRequestBean) {
        QueryMemberCustResponseBean queryMemberCustResponseBean = new QueryMemberCustResponseBean();
        List<QueryMemberCustResponseBean.MemberCustBean> memberCustBeans = new ArrayList<>();
        MemberCustEntity memberCustEntity = new MemberCustEntity();
        BeanUtils.copyProperties(queryMemberCustRequestBean, memberCustEntity);
        List<MemberCustEntity> select = memberCustRepository.queryMemberCust(memberCustEntity);
        //拷贝数据
        select.forEach(memberCustEntity1 -> {
            QueryMemberCustResponseBean.MemberCustBean memberCustBean = new QueryMemberCustResponseBean.MemberCustBean();
            BeanUtils.copyProperties(memberCustEntity1, memberCustBean);
            memberCustBeans.add(memberCustBean);
        });
        queryMemberCustResponseBean.setMemberCustBeans(memberCustBeans);
        return queryMemberCustResponseBean;
    }
}
