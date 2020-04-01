package com.example.graduation.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author DaiDaQi
 * @Classname MerchantLike
 * @Description TODO
 * @Date 2020/3/27 21:13
 * @Created by DaiDaQi
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "merchant_like")
public class MerchantLikeEntity {
    @Id
    private Long id;
    private Long merchantId;
    private Long studentNumber;

    int number;
}
