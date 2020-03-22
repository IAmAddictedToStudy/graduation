package com.example.graduation.bean;

import lombok.Data;

import java.util.List;

/**
 * @author LiaoFuQin
 * @Classname QueryMemberCustRequestBean
 * @Description TODO
 * @Date 2020/3/21 19:42
 * @Created by LiaoFuQin
 */
@Data
public class QueryMemberActivityResponseBean {
    List<MemberActivityUniteEntity> memberActivityUniteEntities;

    @Data
    public static class MemberActivityUniteEntity {
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

}
