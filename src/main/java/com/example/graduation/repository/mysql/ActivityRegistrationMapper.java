package com.example.graduation.repository.mysql;


import com.example.graduation.repository.entity.ActivityRegistrationEntity;
import com.example.graduation.repository.entity.MemberActivityUniteEntity;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.additional.insert.InsertListMapper;

import java.util.List;


/**
 * @author DaiDaQi
 * @Classname MemberCustMapper
 * @Description TODO
 * @Date 2020/2/7 15:15
 * @Created by DaiDaQi
 */

@Mapper
@Component
public interface ActivityRegistrationMapper extends InsertListMapper<ActivityRegistrationEntity>, tk.mybatis.mapper.common.Mapper<ActivityRegistrationEntity> {
    @InsertProvider(type = ActivityRegistrationProvider.class, method = "insertActivityRegistration")
    int insertActivityRegistration(ActivityRegistrationEntity entity);

    @SelectProvider(type = ActivityRegistrationProvider.class, method = "queryMyJoinMemberActivity")
    List<MemberActivityUniteEntity> queryMyJoinMemberActivity(ActivityRegistrationEntity entity);

}
