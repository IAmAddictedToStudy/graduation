package com.example.graduation.bean;

import lombok.Data;

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
    private String activityName;
    private String activityRole;
    private String activityTime;
    private String activityEndTime;
    private String activityArea;
    private String activitySite;
    private String activityCreator;
    private String activityContent;
}
