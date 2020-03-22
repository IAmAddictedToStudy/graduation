package com.example.graduation.repository.mysql;


import com.example.graduation.repository.entity.MemberActivityEntity;
import com.example.graduation.repository.entity.MemberCustEntity;
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
public interface MemberActivityMapper extends InsertListMapper<MemberActivityEntity>, tk.mybatis.mapper.common.Mapper<MemberActivityEntity> {

}
