package com.example.graduation.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

/**
 * @author LiaoFuQin
 * @Classname MemberActivityEntity
 * @Description TODO
 * @Date 2020/3/21 20:04
 * @Created by LiaoFuQin
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member_activity")
public class MemberActivityEntity {
    private Long id;
    private String activityName;
    private String activityRole;
    private String activityTime;
    private String activityEndTime;
    private String activityArea;
    private String activitySite;
    private String activityCreator;
}
