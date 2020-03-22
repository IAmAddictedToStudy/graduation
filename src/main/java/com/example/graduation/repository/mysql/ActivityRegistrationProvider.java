package com.example.graduation.repository.mysql;


import com.example.graduation.repository.entity.ActivityRegistrationEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author LiaoFuQin
 * @Classname MemberCustMapper
 * @Description TODO
 * @Date 2020/2/7 15:15
 * @Created by LiaoFuQin
 */


public class ActivityRegistrationProvider {

    public String insertActivityRegistration(ActivityRegistrationEntity entity) {
        return new SQL() {{
            INSERT_INTO("activity_registration");
            if (StringUtils.isNotBlank(entity.getActivityId())) {
                VALUES("activity_id", "#{activityId}");
            }
            if (StringUtils.isNotBlank(entity.getStudentNumber())) {
                VALUES("student_number", "#{studentNumber}");
            }
            VALUES("create_time", "now()");
        }}.toString();
    }

}
