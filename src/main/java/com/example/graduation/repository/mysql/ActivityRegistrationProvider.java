package com.example.graduation.repository.mysql;


import com.example.graduation.repository.entity.ActivityRegistrationEntity;
import com.example.graduation.repository.entity.MyActivityJoinEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author DaiDaQi
 * @Classname MemberCustMapper
 * @Description TODO
 * @Date 2020/2/7 15:15
 * @Created by DaiDaQi
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

    public String queryMyJoinMemberActivity(ActivityRegistrationEntity entity) {
        return new SQL() {{
            SELECT(" ma.*");
            FROM("activity_registration ar\n" +
                    "         left join member_activity ma on ar.activity_id = ma.id");

            WHERE(" ar.student_number = #{studentNumber} ");
            ORDER_BY("ma.activity_time desc ");
        }}.toString();
    }

    public String queryMyJoinMemberMessageActivity(MyActivityJoinEntity entity) {
        return new SQL() {{
            SELECT(" mc.*, ar.create_time join_time, ma.activity_name");
            FROM("activity_registration ar\n" +
                    "         left join member_activity ma on ar.activity_id = ma.id\n" +
                    "         left join member_cust mc on ar.student_number = mc.cust_student_number");
            WHERE(" ar.activity_id = #{activityId} ");
            ORDER_BY("ar.create_time");
        }}.toString();
    }

}
