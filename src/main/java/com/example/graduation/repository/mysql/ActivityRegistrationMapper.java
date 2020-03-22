package com.example.graduation.repository.mysql;


import com.example.graduation.repository.entity.ActivityRegistrationEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.additional.insert.InsertListMapper;


/**
 * @author LiaoFuQin
 * @Classname MemberCustMapper
 * @Description TODO
 * @Date 2020/2/7 15:15
 * @Created by LiaoFuQin
 */

@Mapper
@Component
public interface ActivityRegistrationMapper extends InsertListMapper<ActivityRegistrationEntity>, tk.mybatis.mapper.common.Mapper<ActivityRegistrationEntity> {

}
