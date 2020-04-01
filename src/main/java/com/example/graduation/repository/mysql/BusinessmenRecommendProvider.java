package com.example.graduation.repository.mysql;

import com.example.graduation.repository.entity.BusinessmenRecommendEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author DaiDaQi
 * @Classname BusinessmenRecommendProvider
 * @Description TODO
 * @Date 2020/3/27 21:00
 * @Created by DaiDaQi
 */
public class BusinessmenRecommendProvider {

    public String updateBusinessmenRecommend(BusinessmenRecommendEntity entity) {
        return new SQL() {{
            UPDATE("businessmen_recommend");
            if (StringUtils.isNotBlank(entity.getActivitySite())) {
                SET("activity_site=#{activitySite}");
            }
            if (StringUtils.isNotBlank(entity.getActivityTime())) {
                SET("activity_time=#{activityTime}");
            }
            if (StringUtils.isNotBlank(entity.getBriefIntroduction())) {
                SET("brief_introduction=#{briefIntroduction}");
            }
            if (StringUtils.isNotBlank(entity.getBusinessName())) {
                SET("business_name=#{businessName}");
            }
            if (StringUtils.isNotBlank(entity.getPropagandaTime())) {
                SET("propaganda_time=#{propagandaTime}");
            }
            if (StringUtils.isNotBlank(entity.getTagline())) {
                SET("tagline=#{tagline}");
            }
            WHERE("id=#{id}");
        }}.toString();
    }
}
