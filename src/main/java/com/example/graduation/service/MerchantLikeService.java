package com.example.graduation.service;

import com.example.graduation.bean.MerchantLikeEntityBean;
import com.example.graduation.repository.MerchantLikeRepository;
import com.example.graduation.repository.entity.MerchantLikeEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DaiDaQi
 * @Classname MerchantLikeMapper
 * @Description TODO
 * @Date 2020/3/27 21:15
 * @Created by DaiDaQi
 */
@Service
public class MerchantLikeService {
    @Autowired
    MerchantLikeRepository repository;

    public void insertMerchantLike(MerchantLikeEntityBean entity) throws Exception {
        MerchantLikeEntity merchantLikeEntity = new MerchantLikeEntity();
        BeanUtils.copyProperties(entity, merchantLikeEntity);
        List<MerchantLikeEntity> select = repository.select(merchantLikeEntity);
        if (select.size() > 0) {
            throw new Exception("你已经点过赞了");
        }
        int insert = repository.insert(merchantLikeEntity);
        if (insert <= 0) {
            throw new Exception("点赞失败");
        }
    }
}
