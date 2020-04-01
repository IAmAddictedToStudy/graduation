package com.example.graduation.bean;

import lombok.Data;

import java.util.List;

/**
 * @author DaiDaQi
 * @Classname QueryBusinessmenRecommendBean
 * @Description TODO
 * @Date 2020/3/27 21:29
 * @Created by DaiDaQi
 */
@Data
public class QueryBusinessmenRecommendBean {
    private List<BusinessmenRecommendBean> businessmenRecommendBeans;

    @Data
    public static class BusinessmenRecommendBean {
        private Long id;
        private String businessName;
        private String briefIntroduction;
        private String activityTime;
        private String activitySite;
        private String propagandaTime;
        private String tagline;
        private int likeCount;
    }
}
