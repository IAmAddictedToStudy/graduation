package com.example.graduation.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LiaoFuQin
 * @Classname BusinessmenRecommend
 * @Description TODO
 * @Date 2020/3/27 20:53
 * @Created by LiaoFuQin
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "businessmen_recommend")
public class BusinessmenRecommendListEntity {
    @Id
    private Long id;
    private String businessName;
    private String briefIntroduction;
    private String activityTime;
    private String activitySite;
    private String propagandaTime;
    private String tagline;
    private int likeCount;
}
