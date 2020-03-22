package com.example.graduation.service;

import com.example.graduation.bean.QueryMemberActivityRequestBean;
import com.example.graduation.bean.QueryMemberActivityResponseBean;
import com.example.graduation.repository.MemberActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiaoFuQin
 * @Classname MemberActivityService
 * @Description TODO
 * @Date 2020/3/22 16:27
 * @Created by LiaoFuQin
 */
@Service
public class MemberActivityService {
    @Autowired
    MemberActivityRepository repository;

    public QueryMemberActivityResponseBean queryMemberActivityByCondition(QueryMemberActivityRequestBean requestBean) {
       return repository.queryMemberActivityByCondition(requestBean);
    }
}
