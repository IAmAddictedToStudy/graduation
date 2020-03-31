package com.example.graduation.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author DaiDaQi
 * @Classname MemberAdmin
 * @Description TODO
 * @Date 2020/3/27 20:31
 * @Created by DaiDaQi
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member_admin")
public class MemberAdminEntity {
    @Id
    private Long id;
    private String adminAccount;
    private String adminPassword;
    private String adminCreateTime;
}
