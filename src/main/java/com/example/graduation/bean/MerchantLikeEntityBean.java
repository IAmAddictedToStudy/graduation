package com.example.graduation.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class MerchantLikeEntityBean {
    private Long id;
    private Long merchantId;
    private Long studentNumber;
}
