package com.example.graduation.controller;

import com.example.graduation.bean.BusinessmenRecommendBean;
import com.example.graduation.bean.CommonResultBean;
import com.example.graduation.bean.QueryBusinessmenRecommendBean;
import com.example.graduation.service.BusinessmenRecommendService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiaoFuQin
 * @Classname BusinessmenRecommendController
 * @Description TODO
 * @Date 2020/3/27 21:34
 * @Created by LiaoFuQin
 */
@RestController
public class BusinessmenRecommendController {
    @Autowired
    BusinessmenRecommendService businessmenRecommendService;

    @PostMapping("/updateBusinessmenRecommend")
    public CommonResultBean updateBusinessmenRecommend(BusinessmenRecommendBean businessmenRecommendBean) throws Exception {
        if (businessmenRecommendBean.getId() == null) {
            throw new Exception("id不能为空");
        }
        businessmenRecommendService.updateBusinessmenRecommend(businessmenRecommendBean);
        return new CommonResultBean();
    }


    @PostMapping("/insertBusinessmenRecommend")
    public CommonResultBean insertBusinessmenRecommend(BusinessmenRecommendBean businessmenRecommendBean) throws Exception {
        if (StringUtils.isBlank(businessmenRecommendBean.getBriefIntroduction())) {
            throw new Exception("商家简介不能为空");
        }
        if (StringUtils.isBlank(businessmenRecommendBean.getActivitySite())) {
            throw new Exception("商家地点不能为空");
        }
        if (StringUtils.isBlank(businessmenRecommendBean.getActivityTime())) {
            throw new Exception("商家活动时间不能为空");
        }
        if (StringUtils.isBlank(businessmenRecommendBean.getBusinessName())) {
            throw new Exception("商家名简介不能为空");
        }
        if (StringUtils.isBlank(businessmenRecommendBean.getPropagandaTime())) {
            throw new Exception("商家活动宣传截至时间不能为空");
        }
        if (StringUtils.isBlank(businessmenRecommendBean.getTagline())) {
            throw new Exception("商家活动详情不能为空");
        }
        businessmenRecommendService.insertBusinessmenRecommend(businessmenRecommendBean);
        return new CommonResultBean();
    }

    @PostMapping("/deleteBusinessmenRecommend")
    public CommonResultBean deleteBusinessmenRecommend(BusinessmenRecommendBean businessmenRecommendBean) throws Exception {
        if (businessmenRecommendBean.getId() == null) {
            throw new Exception("id不能为空");
        }
        businessmenRecommendService.deleteBusinessmenRecommend(businessmenRecommendBean);
        return new CommonResultBean();
    }

    @PostMapping("/queryBusinessmenRecommend")
    public CommonResultBean<QueryBusinessmenRecommendBean> queryBusinessmenRecommend() throws Exception {
        CommonResultBean<QueryBusinessmenRecommendBean> commonResultBean = new CommonResultBean<>();
        QueryBusinessmenRecommendBean queryBusinessmenRecommendBean = businessmenRecommendService.queryBusinessmenRecommend();
        commonResultBean.setData(queryBusinessmenRecommendBean);
        return commonResultBean;
    }
}
