package com.example.graduation.repository;

import com.example.graduation.repository.entity.ActivityRegistrationEntity;
import com.example.graduation.repository.entity.MemberActivityUniteEntity;
import com.example.graduation.repository.entity.MyActivityJoinEntity;
import com.example.graduation.repository.mysql.ActivityRegistrationMapper;
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
public class ActivityRegistrationRepository {
    @Autowired
    ActivityRegistrationMapper activityRegistrationMapper;

    public int insertActivityRegistration(ActivityRegistrationEntity entity) throws Exception {
        return activityRegistrationMapper.insertActivityRegistration(entity);
    }

    public List<ActivityRegistrationEntity> select(ActivityRegistrationEntity entity) {
        return activityRegistrationMapper.select(entity);
    }

    public List<MemberActivityUniteEntity> queryMyJoinMemberActivity(ActivityRegistrationEntity entity) {
        return activityRegistrationMapper.queryMyJoinMemberActivity(entity);
    }

    public List<MyActivityJoinEntity> queryMyJoinMemberMessageActivity(MyActivityJoinEntity entity) {
        return activityRegistrationMapper.queryMyJoinMemberMessageActivity(entity);
    }


}
