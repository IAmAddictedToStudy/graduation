package com.example.graduation.repository;

import com.example.graduation.repository.entity.MemberAdminEntity;
import com.example.graduation.repository.mysql.MemberAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author DaiDaQi
 * @Classname MemberAdminMapper
 * @Description TODO
 * @Date 2020/3/27 20:32
 * @Created by DaiDaQi
 */
@Repository
public class MemberAdminRepository {
    @Autowired
    MemberAdminMapper memberAdminMapper;

    public List<MemberAdminEntity> adminLogin(MemberAdminEntity memberAdminEntity) {
        return memberAdminMapper.select(memberAdminEntity);
    }
}
