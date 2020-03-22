package com.example.graduation.bean;

import lombok.Data;

/**
 * @author LiaoFuQin
 * @Classname MemberCustLoginRequestBean
 * @Description TODO
 * @Date 2020/3/21 20:19
 * @Created by LiaoFuQin
 */
@Data
public class MemberCustLoginRequestBean {
    private String custStudentNumber;
    private String custPassword;
}
