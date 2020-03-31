package com.example.graduation.repository.mysql;

import com.example.graduation.repository.entity.MemberAdminEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.additional.insert.InsertListMapper;

/**
 * @author DaiDaQi
 * @Classname MemberAdminMapper
 * @Description TODO
 * @Date 2020/3/27 20:32
 * @Created by DaiDaQi
 */
@Mapper
@Component
public interface MemberAdminMapper extends InsertListMapper<MemberAdminEntity>, tk.mybatis.mapper.common.Mapper<MemberAdminEntity> {
}
