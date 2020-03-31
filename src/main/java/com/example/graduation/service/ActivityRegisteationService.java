package com.example.graduation.service;

import com.example.graduation.bean.ActivityRegistrationBean;
import com.example.graduation.bean.MyActivityJoinRequestBean;
import com.example.graduation.bean.MyActivityJoinRespnseBean;
import com.example.graduation.bean.QueryMemberActivityResponseBean;
import com.example.graduation.repository.ActivityRegistrationRepository;
import com.example.graduation.repository.entity.ActivityRegistrationEntity;
import com.example.graduation.repository.entity.MemberActivityUniteEntity;
import com.example.graduation.repository.entity.MyActivityJoinEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DaiDaQi
 * @Classname ActivityRegisteation
 * @Description TODO
 * @Date 2020/3/22 17:07
 * @Created by DaiDaQi
 */
@Service
public class ActivityRegisteationService {
    @Autowired
    ActivityRegistrationRepository repository;

    public void insertActivityRegistration(ActivityRegistrationBean activityRegistrationBean) throws Exception {
        ActivityRegistrationEntity activityRegistrationEntity = new ActivityRegistrationEntity();
        BeanUtils.copyProperties(activityRegistrationBean, activityRegistrationEntity);
        List<ActivityRegistrationEntity> select = repository.select(activityRegistrationEntity);
        if (select.size() > 0) {
            throw new Exception("已报名参加活动");
        }
        if (repository.insertActivityRegistration(activityRegistrationEntity) <= 0) {
            throw new Exception("报名活动失败，请重试");
        }
    }

    public QueryMemberActivityResponseBean queryMyJoinMemberActivity(String studentNumber) {
        QueryMemberActivityResponseBean queryMemberActivityResponseBean = new QueryMemberActivityResponseBean();
        List<QueryMemberActivityResponseBean.MemberActivityUniteEntity> memberActivityUniteEntities = new ArrayList<>();
        ActivityRegistrationEntity activityRegistrationEntity = new ActivityRegistrationEntity();
        activityRegistrationEntity.setStudentNumber(studentNumber);
        List<MemberActivityUniteEntity> memberActivityUniteEntities1 = repository.queryMyJoinMemberActivity(activityRegistrationEntity);
        memberActivityUniteEntities1.forEach(memberActivityUniteEntitie -> {
            QueryMemberActivityResponseBean.MemberActivityUniteEntity entity = new QueryMemberActivityResponseBean.MemberActivityUniteEntity();
            BeanUtils.copyProperties(memberActivityUniteEntitie, entity);
            memberActivityUniteEntities.add(entity);
        });
        queryMemberActivityResponseBean.setMemberActivityUniteEntities(memberActivityUniteEntities);
        return queryMemberActivityResponseBean;
    }

    public MyActivityJoinRespnseBean queryMyJoinMemberMessageActivity(MyActivityJoinRequestBean myActivityJoinRequestBean) {
        MyActivityJoinRespnseBean myActivityJoinRespnseBean = new MyActivityJoinRespnseBean();
        List<MyActivityJoinRespnseBean.MyActivityJoinEntity> myActivityJoinEntities = new ArrayList<>();
        MyActivityJoinEntity myActivityJoinEntity = new MyActivityJoinEntity();
        BeanUtils.copyProperties(myActivityJoinRequestBean, myActivityJoinEntity);
        List<MyActivityJoinEntity> myActivityJoinEntities1 = repository.queryMyJoinMemberMessageActivity(myActivityJoinEntity);
        myActivityJoinEntities1.forEach(myActivityJoinEntity1 -> {
            MyActivityJoinRespnseBean.MyActivityJoinEntity myActivityJoinEntity2 = new MyActivityJoinRespnseBean.MyActivityJoinEntity();
            BeanUtils.copyProperties(myActivityJoinEntity1, myActivityJoinEntity2);
            myActivityJoinEntities.add(myActivityJoinEntity2);
        });
        myActivityJoinRespnseBean.setMyActivityJoinEntities(myActivityJoinEntities);
        return myActivityJoinRespnseBean;
    }


}
