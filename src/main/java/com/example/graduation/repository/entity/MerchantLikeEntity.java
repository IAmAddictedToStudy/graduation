package com.example.graduation.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

/**
 * @author LiaoFuQin
 * @Classname MerchantLike
 * @Description TODO
 * @Date 2020/3/27 21:13
 * @Created by LiaoFuQin
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "merchant_like")
public class MerchantLikeEntity {
    private Long id;
    private Long merchantId;
    private Long studentNumber;
}
