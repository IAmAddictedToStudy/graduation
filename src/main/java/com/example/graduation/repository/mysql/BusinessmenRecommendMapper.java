package com.example.graduation.repository.mysql;

import com.example.graduation.repository.entity.BusinessmenRecommendEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Component;

/**
 * @author LiaoFuQin
 * @Classname BusinessmenRecommendMapper
 * @Description TODO
 * @Date 2020/3/27 20:55
 * @Created by LiaoFuQin
 */
@Mapper
@Component
public interface BusinessmenRecommendMapper extends tk.mybatis.mapper.common.Mapper<BusinessmenRecommendEntity> {
    @UpdateProvider(type = BusinessmenRecommendProvider.class, method = "updateBusinessmenRecommend")
    int updateBusinessmenRecommend(BusinessmenRecommendEntity entity);
}
