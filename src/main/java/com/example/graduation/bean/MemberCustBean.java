package com.example.graduation.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


/**
 * @author DaiDaQi
 * @Classname MemberAdmin
 * @Description TODO
 * @Date 2020/2/7 15:08
 * @Created by DaiDaQi
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberCustBean {

    private Long id;
    @NotEmpty(message = "账号不能为空")
    private String custStudentNumber;
    @NotEmpty(message = "密码不能为空")
    private String custPassword;
    @NotEmpty(message = "姓名不能为空")
    private String custName;
    @NotEmpty(message = "学院不能为空")
    private String custAcademy;
    @NotEmpty(message = "年级不能为空")
    private String custGrade;
    @NotEmpty(message = "专业不能为空")
    private String custProfession;
    //    @NotEmpty(message = "手机不能为空")
//    private String custPhone;
    @NotEmpty(message = "性格类型不能为空")
    private String custCharacter;

}
