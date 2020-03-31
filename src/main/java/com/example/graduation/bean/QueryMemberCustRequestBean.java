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
public class QueryMemberCustRequestBean {
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
