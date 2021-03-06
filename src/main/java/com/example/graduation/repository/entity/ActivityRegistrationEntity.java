package com.example.graduation.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Table(name = "activity_registration")
public class ActivityRegistrationEntity {
    private Long id;
    private String activityId;
    private String studentNumber;
    private String createTime;
}
