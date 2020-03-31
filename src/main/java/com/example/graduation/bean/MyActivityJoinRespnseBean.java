package com.example.graduation.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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
public class MyActivityJoinRespnseBean {
    private List<MyActivityJoinEntity> myActivityJoinEntities;

    @Data
    public static class MyActivityJoinEntity {
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
}
