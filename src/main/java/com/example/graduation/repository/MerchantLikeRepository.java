package com.example.graduation.repository;

import com.example.graduation.repository.entity.MerchantLikeEntity;
import com.example.graduation.repository.mysql.MerchantLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LiaoFuQin
 * @Classname MerchantLikeMapper
 * @Description TODO
 * @Date 2020/3/27 21:15
 * @Created by LiaoFuQin
 */
@Repository
public class MerchantLikeRepository {
    @Autowired
    MerchantLikeMapper mapper;

    public int insert(MerchantLikeEntity entity) throws Exception {
        try {
            return mapper.insert(entity);
        } catch (Exception e) {
            throw new Exception("插入 MerchantLike失败");
        }
    }

    public List<MerchantLikeEntity> select(MerchantLikeEntity entity) throws Exception {
        try {
            return mapper.select(entity);
        } catch (Exception e) {
            throw new Exception("插入 MerchantLike失败");
        }
    }
}
