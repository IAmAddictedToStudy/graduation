package com.example.graduation.repository;

import com.example.graduation.repository.entity.MemberActivityEntity;
import com.example.graduation.repository.entity.MemberActivityUniteEntity;
import com.example.graduation.repository.mysql.MemberActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author DaiDaQi
 * @Classname MemberCustRepository
 * @Description TODO
 * @Date 2020/3/21 19:36
 * @Created by DaiDaQi
 */
@Repository
public class MemberActivityRepository {
    @Autowired
    MemberActivityMapper memberActivityMapper;


    public List<MemberActivityUniteEntity> queryMemberActivityByCondition(MemberActivityUniteEntity requestBean) {
        return memberActivityMapper.queryMemberActivityByCondition(requestBean);
    }

    public int insertMemberActivity(MemberActivityEntity entity) {
        return memberActivityMapper.insertMemberActivity(entity);
    }

    public List<MemberActivityEntity> select(MemberActivityEntity entity) {
        return memberActivityMapper.select(entity);
    }


    public int update(MemberActivityEntity entity) {
        return memberActivityMapper.updateMemberActivity(entity);
    }

    public int delete(MemberActivityEntity entity) {
        return memberActivityMapper.delete(entity);
    }

}
