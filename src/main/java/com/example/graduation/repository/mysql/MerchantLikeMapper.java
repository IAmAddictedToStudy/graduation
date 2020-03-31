package com.example.graduation.repository.mysql;

import com.example.graduation.repository.entity.BusinessmenRecommendListEntity;
import com.example.graduation.repository.entity.MerchantLikeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author LiaoFuQin
 * @Classname MerchantLikeMapper
 * @Description TODO
 * @Date 2020/3/27 21:15
 * @Created by LiaoFuQin
 */
@Mapper
@Component
public interface MerchantLikeMapper extends tk.mybatis.mapper.common.Mapper<MerchantLikeEntity> {
    @SelectProvider(type = MerchantLikeProvider.class, method = "queryRecommendList")
    List<BusinessmenRecommendListEntity> queryRecommendList();

    @SelectProvider(type = MerchantLikeProvider.class, method = "queryAllRecommendList")
    List<BusinessmenRecommendListEntity> queryAllRecommendList();

}
