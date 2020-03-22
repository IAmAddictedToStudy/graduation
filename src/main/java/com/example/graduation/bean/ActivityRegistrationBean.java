package com.example.graduation.bean;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author LiaoFuQin
 * @Classname MemberActivityEntity
 * @Description TODO
 * @Date 2020/3/21 20:04
 * @Created by LiaoFuQin
 */

@Data
public class ActivityRegistrationBean {
    private Long id;
    @NotEmpty(message = "活动id不能为空")
    private String activityId;
    private String studentNumber;
    private String createTime;
}
