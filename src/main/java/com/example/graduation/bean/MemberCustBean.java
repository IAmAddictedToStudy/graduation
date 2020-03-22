package com.example.graduation.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author LiaoFuQin
 * @Classname MemberAdmin
 * @Description TODO
 * @Date 2020/2/7 15:08
 * @Created by LiaoFuQin
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberCustBean {

    private Long id;
    private String custStudentNumber;
    private String custPassword;
    private String custName;
    private String custAcademy;
    private String custGrade;
    private String custProfession;
    private String custPhone;
}
