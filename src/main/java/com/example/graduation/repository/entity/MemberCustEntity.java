package com.example.graduation.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;


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
@Table(name = "member_cust")
public class MemberCustEntity {
    @Id
    private Long id;
    private String custStudentNumber;
    private String custPassword;
    private String custName;
    private String custAcademy;
    private String custGrade;
    private String custProfession;
    private String custPhone;
}
