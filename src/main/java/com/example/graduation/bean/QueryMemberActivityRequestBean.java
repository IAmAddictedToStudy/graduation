package com.example.graduation.bean;

import lombok.Data;

/**
 * @author DaiDaQi
 * @Classname QueryMemberCustRequestBean
 * @Description TODO
 * @Date 2020/3/21 19:42
 * @Created by DaiDaQi
 */
@Data
public class QueryMemberActivityRequestBean {
    private Long id;
    private String activityName;
    private String activityRole;
    private String activityTime;
    private String activityEndTime;
    private String activityArea;
    private String activitySite;
    private String activityCreator;
    private String custCharacter;
}
