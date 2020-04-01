package com.example.graduation.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author DaiDaQi
 * @Classname BusinessmenRecommend
 * @Description TODO
 * @Date 2020/3/27 20:53
 * @Created by DaiDaQi
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "businessmen_recommend")
public class BusinessmenRecommendEntity {
    @Id
    private Long id;
    private String businessName;
    private String briefIntroduction;
    private String activityTime;
    private String activitySite;
    private String propagandaTime;
    private Date createTime;
    private String tagline;
}
