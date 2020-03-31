package com.example.graduation.service;

import com.example.graduation.bean.MemberAdminBean;
import com.example.graduation.repository.MemberAdminRepository;
import com.example.graduation.repository.entity.MemberAdminEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class MemberAdminService {
    @Autowired
    MemberAdminRepository memberAdminRepository;

    public MemberAdminBean adminLogin(MemberAdminBean memberAdminBean) throws Exception {
        MemberAdminBean memberAdminBean1 = new MemberAdminBean();
        MemberAdminEntity memberAdminEntity = new MemberAdminEntity();
        memberAdminEntity.setAdminAccount(memberAdminBean.getAdminAccount());
        memberAdminEntity.setAdminPassword(memberAdminBean.getAdminPassword());
        List<MemberAdminEntity> memberAdminEntities = memberAdminRepository.adminLogin(memberAdminEntity);
        if (memberAdminEntities.size() <= 0) {
            throw new Exception("账号或密码错误");
        }
        BeanUtils.copyProperties(memberAdminEntities.get(0), memberAdminBean1);
        return memberAdminBean1;
    }

}
