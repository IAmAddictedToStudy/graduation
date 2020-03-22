package com.example.graduation.repository;

import com.example.graduation.bean.QueryMemberActivityRequestBean;
import com.example.graduation.bean.QueryMemberActivityResponseBean;
import com.example.graduation.repository.entity.MemberActivityUniteEntity;
import com.example.graduation.repository.mysql.MemberActivityMapper;
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
public class MemberActivityRepository {
    @Autowired
    MemberActivityMapper memberActivityMapper;

    public QueryMemberActivityResponseBean queryMemberActivityByCondition(QueryMemberActivityRequestBean requestBean) {
        QueryMemberActivityResponseBean queryMemberActivityResponseBean = new QueryMemberActivityResponseBean();
        List<QueryMemberActivityResponseBean.MemberActivityUniteEntity> memberActivityUniteEntities1 = new ArrayList<>();
        MemberActivityUniteEntity memberActivityUniteEntity = new MemberActivityUniteEntity();
        BeanUtils.copyProperties(requestBean, memberActivityUniteEntity);
        List<MemberActivityUniteEntity> memberActivityUniteEntities = memberActivityMapper.queryMemberActivityByCondition(memberActivityUniteEntity);
        memberActivityUniteEntities.forEach(memberActivityUniteEntity1 -> {
            QueryMemberActivityResponseBean.MemberActivityUniteEntity memberActivityUniteEntity2 = new QueryMemberActivityResponseBean.MemberActivityUniteEntity();
            BeanUtils.copyProperties(memberActivityUniteEntity1, memberActivityUniteEntity2);
            memberActivityUniteEntities1.add(memberActivityUniteEntity2);
        });
        queryMemberActivityResponseBean.setMemberActivityUniteEntities(memberActivityUniteEntities1);
        return queryMemberActivityResponseBean;

    }

}
