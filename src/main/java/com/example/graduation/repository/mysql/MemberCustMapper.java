package com.example.graduation.repository.mysql;


import com.example.graduation.repository.entity.MemberCustEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.additional.insert.InsertListMapper;


/**
 * @author DaiDaQi
 * @Classname MemberCustMapper
 * @Description TODO
 * @Date 2020/2/7 15:15
 * @Created by DaiDaQi
 */

@Mapper
@Component
public interface MemberCustMapper extends InsertListMapper<MemberCustEntity>, tk.mybatis.mapper.common.Mapper<MemberCustEntity> {
    /**
     * 插入
     *
     * @param memberCustEntity 管理员信息实体类
     * @return 插入条数
     */
}
