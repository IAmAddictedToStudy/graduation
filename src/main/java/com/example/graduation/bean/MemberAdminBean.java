package com.example.graduation.bean;

import lombok.Data;

/**
 * @author DaiDaQi
 * @Classname MemberAdmin
 * @Description TODO
 * @Date 2020/3/27 20:31
 * @Created by DaiDaQi
 */

@Data
public class MemberAdminBean {
    private Long id;
    private String adminAccount;
    private String adminPassword;
    private String adminCreateTime;
}
