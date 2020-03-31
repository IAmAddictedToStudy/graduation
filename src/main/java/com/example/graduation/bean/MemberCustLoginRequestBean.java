package com.example.graduation.bean;

import lombok.Data;

/**
 * @author DaiDaQi
 * @Classname MemberCustLoginRequestBean
 * @Description TODO
 * @Date 2020/3/21 20:19
 * @Created by DaiDaQi
 */
@Data
public class MemberCustLoginRequestBean {
    private String custStudentNumber;
    private String custPassword;
}
