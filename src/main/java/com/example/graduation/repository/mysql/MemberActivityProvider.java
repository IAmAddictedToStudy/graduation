package com.example.graduation.repository.mysql;


import com.example.graduation.repository.entity.MemberActivityUniteEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;


/**
 * @author LiaoFuQin
 * @Classname MemberCustMapper
 * @Description TODO
 * @Date 2020/2/7 15:15
 * @Created by LiaoFuQin
 */

@Mapper
@Component
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
}
