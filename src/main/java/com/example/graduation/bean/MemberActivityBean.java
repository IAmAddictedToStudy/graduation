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
public class MemberActivityBean {
    private Long id;
    @NotEmpty(message = "活动名不能为空")
    private String activityName;
    @NotEmpty(message = "活动规则不能为空")
    private String activityRole;
    @NotEmpty(message = "活动时间不能为空")
    private String activityTime;
    private String activityEndTime;
    @NotEmpty(message = "活动地区不能为空")
    private String activityArea;
    @NotEmpty(message = "活动地点不能为空")
    private String activitySite;
    private String activityCreator;
    @NotEmpty(message = "活动内容不能为空")
    private String activityContent;
}
