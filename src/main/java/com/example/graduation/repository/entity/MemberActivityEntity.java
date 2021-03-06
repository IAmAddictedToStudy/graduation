package com.example.graduation.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author DaiDaQi
 * @Classname MemberActivityEntity
 * @Description TODO
 * @Date 2020/3/21 20:04
 * @Created by DaiDaQi
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member_activity")
public class MemberActivityEntity {
    @Id
    private Long id;
    private String activityName;
    private String activityRole;
    private String activityTime;
    private String activityEndTime;
    private String activityArea;
    private String activitySite;
    private String activityCreator;
    private String activityContent;
}
