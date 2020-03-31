package com.example.graduation.bean;

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
public class MyActivityJoinRequestBean {
    private String activityId;
}
