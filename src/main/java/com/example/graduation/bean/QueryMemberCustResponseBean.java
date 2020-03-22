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
public class QueryMemberCustResponseBean {
    List<MemberCustBean> memberCustBeans;

    @Data
    public static class MemberCustBean {
        private Long id;
        private String custStudentNumber;
        private String custPassword;
        private String custName;
        private String custAcademy;
        private String custGrade;
        private String custProfession;
        private String custPhone;
        private String custCharacter;
    }

}
