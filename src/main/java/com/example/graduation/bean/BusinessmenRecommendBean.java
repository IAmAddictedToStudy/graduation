package com.example.graduation.bean;

import lombok.Data;

/**
 * @author DaiDaQi
 * @Classname BusinessmenRecommend
 * @Description TODO
 * @Date 2020/3/27 20:53
 * @Created by DaiDaQi
 */

@Data
public class BusinessmenRecommendBean {
    private Long id;
    private String businessName;
    private String briefIntroduction;
    private String activityTime;
    private String activitySite;
    private String propagandaTime;
    private String tagline;
    private int likeCount;
}
