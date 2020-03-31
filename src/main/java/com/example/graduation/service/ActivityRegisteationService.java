package com.example.graduation.service;

import com.example.graduation.bean.ActivityRegistrationBean;
import com.example.graduation.repository.ActivityRegistrationRepository;
import com.example.graduation.repository.entity.ActivityRegistrationEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DaiDaQi
 * @Classname ActivityRegisteation
 * @Description TODO
 * @Date 2020/3/22 17:07
 * @Created by DaiDaQi
 */
@Service
public class ActivityRegisteationService {
    @Autowired
    ActivityRegistrationRepository repository;

    public void insertActivityRegistration(ActivityRegistrationBean activityRegistrationBean) throws Exception {
        ActivityRegistrationEntity activityRegistrationEntity = new ActivityRegistrationEntity();
        BeanUtils.copyProperties(activityRegistrationBean, activityRegistrationEntity);
        List<ActivityRegistrationEntity> select = repository.select(activityRegistrationEntity);
        if (select.size() > 0) {
            throw new Exception("已报名参加活动");
        }
        if (repository.insertActivityRegistration(activityRegistrationEntity) <= 0) {
            throw new Exception("报名活动失败，请重试");
        }
    }
}
