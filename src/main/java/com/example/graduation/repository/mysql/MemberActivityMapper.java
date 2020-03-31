package com.example.graduation.repository.mysql;


import com.example.graduation.repository.entity.MemberActivityEntity;
import com.example.graduation.repository.entity.MemberActivityUniteEntity;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
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
public interface MemberActivityMapper extends InsertListMapper<MemberActivityEntity>, tk.mybatis.mapper.common.Mapper<MemberActivityEntity> {

    @SelectProvider(type = MemberActivityProvider.class, method = "queryMemberActivityByCondition")
    List<MemberActivityUniteEntity> queryMemberActivityByCondition(MemberActivityUniteEntity adminRoleEntity);

    @InsertProvider(type = MemberActivityProvider.class, method = "insertMemberActivity")
    int insertMemberActivity(MemberActivityEntity entity);

    @UpdateProvider(type = MemberActivityProvider.class, method = "updateMemberActivity")
    int updateMemberActivity(MemberActivityEntity entity);
}
