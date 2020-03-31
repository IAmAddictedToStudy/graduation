package com.example.graduation.service;

import com.example.graduation.bean.BusinessmenRecommendBean;
import com.example.graduation.bean.QueryBusinessmenRecommendBean;
import com.example.graduation.repository.BusinessmenRecommendRepository;
import com.example.graduation.repository.entity.BusinessmenRecommendEntity;
import com.example.graduation.repository.entity.BusinessmenRecommendListEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LiaoFuQin
 * @Classname BusinessmenRecommendService
 * @Description TODO
 * @Date 2020/3/27 21:24
 * @Created by LiaoFuQin
 */
@Service
public class BusinessmenRecommendService {
    @Autowired
    BusinessmenRecommendRepository businessmenRecommendRepository;

    public void updateBusinessmenRecommend(BusinessmenRecommendBean businessmenRecommendBean) throws Exception {
        BusinessmenRecommendEntity businessmenRecommendEntity = new BusinessmenRecommendEntity();
        BeanUtils.copyProperties(businessmenRecommendBean, businessmenRecommendEntity);
        int update = businessmenRecommendRepository.update(businessmenRecommendEntity);
        if (update <= 0) {
            throw new Exception("更新商家活动失败");
        }
    }

    public void insertBusinessmenRecommend(BusinessmenRecommendBean businessmenRecommendBean) throws Exception {
        BusinessmenRecommendEntity businessmenRecommendEntity = new BusinessmenRecommendEntity();
        BeanUtils.copyProperties(businessmenRecommendBean, businessmenRecommendEntity);
        businessmenRecommendEntity.setCreateTime(new Date());
        int update = businessmenRecommendRepository.insert(businessmenRecommendEntity);
        if (update <= 0) {
            throw new Exception("插入商家活动失败");
        }
    }

    public void deleteBusinessmenRecommend(BusinessmenRecommendBean businessmenRecommendBean) throws Exception {
        BusinessmenRecommendEntity businessmenRecommendEntity = new BusinessmenRecommendEntity();
        BeanUtils.copyProperties(businessmenRecommendBean, businessmenRecommendEntity);
        int update = businessmenRecommendRepository.delete(businessmenRecommendEntity);
        if (update <= 0) {
            throw new Exception("商家活动删除失败");
        }
    }

    public QueryBusinessmenRecommendBean queryBusinessmenRecommend() throws Exception {
        QueryBusinessmenRecommendBean queryBusinessmenRecommendBean = new QueryBusinessmenRecommendBean();
        List<QueryBusinessmenRecommendBean.BusinessmenRecommendBean> businessmenRecommendBeans = new ArrayList<>();
        List<BusinessmenRecommendListEntity> select = businessmenRecommendRepository.select();
        if (select.size() > 0) {
            select.forEach(businessmenRecommendListEntity -> {
                QueryBusinessmenRecommendBean.BusinessmenRecommendBean businessmenRecommendBean = new QueryBusinessmenRecommendBean.BusinessmenRecommendBean();
                BeanUtils.copyProperties(businessmenRecommendListEntity, businessmenRecommendBean);
                businessmenRecommendBeans.add(businessmenRecommendBean);
            });
        }
        queryBusinessmenRecommendBean.setBusinessmenRecommendBeans(businessmenRecommendBeans);
        return queryBusinessmenRecommendBean;
    }

    public QueryBusinessmenRecommendBean queryAllBusinessmenRecommend() throws Exception {
        QueryBusinessmenRecommendBean queryBusinessmenRecommendBean = new QueryBusinessmenRecommendBean();
        List<QueryBusinessmenRecommendBean.BusinessmenRecommendBean> businessmenRecommendBeans = new ArrayList<>();
        List<BusinessmenRecommendListEntity> select = businessmenRecommendRepository.selectAll();
        if (select.size() > 0) {
            select.forEach(businessmenRecommendListEntity -> {
                QueryBusinessmenRecommendBean.BusinessmenRecommendBean businessmenRecommendBean = new QueryBusinessmenRecommendBean.BusinessmenRecommendBean();
                BeanUtils.copyProperties(businessmenRecommendListEntity, businessmenRecommendBean);
                businessmenRecommendBeans.add(businessmenRecommendBean);
            });
        }
        queryBusinessmenRecommendBean.setBusinessmenRecommendBeans(businessmenRecommendBeans);
        return queryBusinessmenRecommendBean;
    }


}
