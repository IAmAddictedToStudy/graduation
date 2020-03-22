package com.example.graduation.repository;

import com.example.graduation.bean.QueryMemberCustResponseBean;
import com.example.graduation.repository.entity.MemberCustEntity;
import com.example.graduation.repository.mysql.MemberCustMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiaoFuQin
 * @Classname MemberCustRepository
 * @Description TODO
 * @Date 2020/3/21 19:36
 * @Created by LiaoFuQin
 */
@Repository
public class MemberCustRepository {
    @Autowired
    MemberCustMapper memberCustMapper;

    public QueryMemberCustResponseBean queryMemberCustMapper() {
        QueryMemberCustResponseBean queryMemberCustResponseBean = new QueryMemberCustResponseBean();
        List<QueryMemberCustResponseBean.MemberCustBean> memberCustBeans = new ArrayList<>();
        List<MemberCustEntity> memberCustEntities = memberCustMapper.selectAll();
        memberCustEntities.forEach(memberCustEntity -> {
            QueryMemberCustResponseBean.MemberCustBean memberCustBean = new QueryMemberCustResponseBean.MemberCustBean();
            BeanUtils.copyProperties(memberCustEntity, memberCustBean);
            memberCustBeans.add(memberCustBean);
        });
        queryMemberCustResponseBean.setMemberCustBeans(memberCustBeans);
        return queryMemberCustResponseBean;
    }

    public List<MemberCustEntity> login(MemberCustEntity memberCustEntity) throws Exception {
        return memberCustMapper.select(memberCustEntity);
    }

    public int register(MemberCustEntity entity) throws Exception {
        return memberCustMapper.insert(entity);
    }

    public List<MemberCustEntity> select(MemberCustEntity entity) throws Exception {
        return memberCustMapper.select(entity);
    }

    public List<MemberCustEntity> queryMemberCust(MemberCustEntity memberCustEntity) {
        return memberCustMapper.select(memberCustEntity);
    }

}
