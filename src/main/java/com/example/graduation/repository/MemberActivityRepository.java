package com.example.graduation.repository;

import com.example.graduation.repository.entity.MemberActivityUniteEntity;
import com.example.graduation.repository.mysql.MemberActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    public List<MemberActivityUniteEntity> queryMemberActivityByCondition(MemberActivityUniteEntity requestBean) {
        return memberActivityMapper.queryMemberActivityByCondition(requestBean);
    }

}
