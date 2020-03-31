package com.example.graduation.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author DaiDaQi
 * @Classname MemberAdmin
 * @Description TODO
 * @Date 2020/2/7 15:08
 * @Created by DaiDaQi
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyActivityJoinEntity {
    private Long id;
    private String custStudentNumber;
    private String custPassword;
    private String custName;
    private String custAcademy;
    private String custGrade;
    private String custProfession;
    private String custPhone;
    private String custCharacter;
    private String joinTime;
    private String activityId;
    private String activityName;

}
