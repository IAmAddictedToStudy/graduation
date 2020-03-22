package com.example.graduation.service;

import com.example.graduation.bean.QueryMemberActivityRequestBean;
import com.example.graduation.bean.QueryMemberActivityResponseBean;
import com.example.graduation.repository.MemberActivityRepository;
import com.example.graduation.repository.entity.MemberActivityUniteEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiaoFuQin
 * @Classname MemberActivityService
 * @Description TODO
 * @Date 2020/3/22 16:27
 * @Created by LiaoFuQin
 */
@Service
public class MemberActivityService {
    @Autowired
    MemberActivityRepository repository;

    public QueryMemberActivityResponseBean queryMemberActivityByCondition(QueryMemberActivityRequestBean requestBean) {
        QueryMemberActivityResponseBean queryMemberActivityResponseBean = new QueryMemberActivityResponseBean();
        List<QueryMemberActivityResponseBean.MemberActivityUniteEntity> memberActivityUniteEntities1 = new ArrayList<>();
        MemberActivityUniteEntity memberActivityUniteEntity = new MemberActivityUniteEntity();
        BeanUtils.copyProperties(requestBean, memberActivityUniteEntity);
        List<MemberActivityUniteEntity> memberActivityUniteEntities = repository.queryMemberActivityByCondition(memberActivityUniteEntity);
        memberActivityUniteEntities.forEach(memberActivityUniteEntity1 -> {
            QueryMemberActivityResponseBean.MemberActivityUniteEntity memberActivityUniteEntity2 = new QueryMemberActivityResponseBean.MemberActivityUniteEntity();
            BeanUtils.copyProperties(memberActivityUniteEntity1, memberActivityUniteEntity2);
            memberActivityUniteEntities1.add(memberActivityUniteEntity2);
        });
        queryMemberActivityResponseBean.setMemberActivityUniteEntities(memberActivityUniteEntities1);
        return queryMemberActivityResponseBean;
    }
}
