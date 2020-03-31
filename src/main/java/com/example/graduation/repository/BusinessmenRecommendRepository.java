package com.example.graduation.repository;

import com.example.graduation.repository.entity.BusinessmenRecommendEntity;
import com.example.graduation.repository.entity.BusinessmenRecommendListEntity;
import com.example.graduation.repository.mysql.BusinessmenRecommendMapper;
import com.example.graduation.repository.mysql.MerchantLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LiaoFuQin
 * @Classname BusinessmenRecommendMapper
 * @Description TODO
 * @Date 2020/3/27 20:55
 * @Created by LiaoFuQin
 */
@Repository
public class BusinessmenRecommendRepository {
    @Autowired
    BusinessmenRecommendMapper businessmenRecommendMapper;
    @Autowired
    MerchantLikeMapper merchantLikeMapper;

    public int insert(BusinessmenRecommendEntity recommendEntity) {
        return businessmenRecommendMapper.insert(recommendEntity);
    }

    public int delete(BusinessmenRecommendEntity recommendEntity) {
        return businessmenRecommendMapper.delete(recommendEntity);
    }

    public List<BusinessmenRecommendListEntity> select() {
        return merchantLikeMapper.queryRecommendList();
    }

    public List<BusinessmenRecommendListEntity> selectAll() {
        return merchantLikeMapper.queryAllRecommendList();
    }


    public int update(BusinessmenRecommendEntity recommendEntity) {
        return businessmenRecommendMapper.updateBusinessmenRecommend(recommendEntity);
    }

}
