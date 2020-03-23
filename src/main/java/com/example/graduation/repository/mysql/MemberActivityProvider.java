package com.example.graduation.repository.mysql;


import com.example.graduation.repository.entity.MemberActivityEntity;
import com.example.graduation.repository.entity.MemberActivityUniteEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;


/**
 * @author LiaoFuQin
 * @Classname MemberCustMapper
 * @Description TODO
 * @Date 2020/2/7 15:15
 * @Created by LiaoFuQin
 */


public class MemberActivityProvider {
    public String queryMemberActivityByCondition(MemberActivityUniteEntity requestEntity) {
        return new SQL() {{
            SELECT(" ma.*, mc.cust_character");
            FROM("member_activity ma\n" +
                    "         left join member_cust mc on ma.activity_creator = mc.cust_student_number");
            if (StringUtils.isNotBlank(requestEntity.getCustCharacter())) {
                WHERE(" mc.cust_character=#{custCharacter} ");
            }
        }}.toString();
    }


    public String insertMemberActivity(MemberActivityEntity entity) {
        return new SQL() {{
            INSERT_INTO("member_activity");
            if (StringUtils.isNotBlank(entity.getActivityName())) {
                VALUES("activity_name", "#{activityName}");
            }
            if (StringUtils.isNotBlank(entity.getActivityRole())) {
                VALUES("activity_role", "#{activityRole}");
            }
            if (StringUtils.isNotBlank(entity.getActivityArea())) {
                VALUES("activity_area", "#{activityArea}");
            }
            if (StringUtils.isNotBlank(entity.getActivityContent())) {
                VALUES("activity_content", "#{activityContent}");
            }
            if (StringUtils.isNotBlank(entity.getActivitySite())) {
                VALUES("activity_site", "#{activitySite}");
            }
            if (StringUtils.isNotBlank(entity.getActivityTime())) {
                VALUES("activity_time", "#{activityTime}");
            }
            if (StringUtils.isNotBlank(entity.getActivityCreator())) {
                VALUES("activity_creator", "#{activityCreator}");
            }
        }}.toString();
    }

}
