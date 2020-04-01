package com.example.graduation.controller;

import com.example.graduation.bean.*;
import com.example.graduation.service.BusinessmenRecommendService;
import com.example.graduation.service.MerchantLikeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author DaiDaQi
 * @Classname BusinessmenRecommendController
 * @Description TODO
 * @Date 2020/3/27 21:34
 * @Created by DaiDaQi
 */
@RestController
public class BusinessmenRecommendController {
    @Autowired
    BusinessmenRecommendService businessmenRecommendService;
    @Autowired
    MerchantLikeService service;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");

    @PostMapping("/updateBusinessmenRecommend")
    public CommonResultBean updateBusinessmenRecommend(BusinessmenRecommendBean businessmenRecommendBean) throws Exception {
        if (businessmenRecommendBean.getId() == null) {
            throw new Exception("id不能为空");
        }
        businessmenRecommendService.updateBusinessmenRecommend(businessmenRecommendBean);
        return new CommonResultBean();
    }


    @PostMapping("/insertBusinessmenRecommend")
    public CommonResultBean insertBusinessmenRecommend(BusinessmenRecommendBean businessmenRecommendBean, HttpSession session) throws Exception {
        CommonResultBean resultBean = new CommonResultBean();
        try {
            MemberAdminBean memberAdminBean = (MemberAdminBean) session.getAttribute("memberAdminBean");
            if (memberAdminBean == null) {
                resultBean.setResultCode("-1");
                resultBean.setResultMsg("未登录");
                return resultBean;
            }
        } catch (Exception e) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("未登录");
            return resultBean;
        }
        if (StringUtils.isBlank(businessmenRecommendBean.getBriefIntroduction())) {
            throw new Exception("商家简介不能为空");
        }
        if (StringUtils.isBlank(businessmenRecommendBean.getActivitySite())) {
            throw new Exception("商家地点不能为空");
        }
        if (StringUtils.isBlank(businessmenRecommendBean.getActivityTime())) {
            throw new Exception("商家活动时间不能为空");
        } else {
            String startTimeStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS").format(new Date());
            Date startTime = df.parse(startTimeStr);
            Date endTime = df.parse(businessmenRecommendBean.getActivityTime());
            if (startTime.getTime() > endTime.getTime()) {
                resultBean.setResultCode("-1");
                resultBean.setResultMsg("商家活动时间不能小于现在");
                return resultBean;
            }
        }
        if (StringUtils.isBlank(businessmenRecommendBean.getBusinessName())) {
            throw new Exception("商家名简介不能为空");
        }
        if (StringUtils.isBlank(businessmenRecommendBean.getPropagandaTime())) {
            throw new Exception("商家活动宣传截至时间不能为空");
        } else {
            String startTimeStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS").format(new Date());
            Date startTime = df.parse(startTimeStr);
            Date endTime = df.parse(businessmenRecommendBean.getPropagandaTime());
            if (startTime.getTime() > endTime.getTime()) {
                resultBean.setResultCode("-1");
                resultBean.setResultMsg("商家活动宣传时间不能小于现在");
                return resultBean;
            }
        }
        if (StringUtils.isBlank(businessmenRecommendBean.getTagline())) {
            throw new Exception("商家活动详情不能为空");
        }
        businessmenRecommendService.insertBusinessmenRecommend(businessmenRecommendBean);
        QueryBusinessmenRecommendBean queryBusinessmenRecommendBean = businessmenRecommendService.queryAllBusinessmenRecommend();
        if (queryBusinessmenRecommendBean.getBusinessmenRecommendBeans().size() > 0) {
            MerchantLikeEntityBean merchantLikeEntityBean = MerchantLikeEntityBean.builder().merchantId(queryBusinessmenRecommendBean.getBusinessmenRecommendBeans().get(0).getId()).studentNumber(1L).build();
            service.insertMerchantLike(merchantLikeEntityBean);
        }
        return resultBean;
    }

    @PostMapping("/deleteBusinessmenRecommend")
    public CommonResultBean deleteBusinessmenRecommend(BusinessmenRecommendBean businessmenRecommendBean) throws Exception {
        if (businessmenRecommendBean.getId() == null) {
            throw new Exception("id不能为空");
        }
        businessmenRecommendService.deleteBusinessmenRecommend(businessmenRecommendBean);
        return new CommonResultBean();
    }

    @GetMapping("/queryBusinessmenRecommend")
    public CommonResultBean<QueryBusinessmenRecommendBean> queryBusinessmenRecommend() throws Exception {
        CommonResultBean<QueryBusinessmenRecommendBean> commonResultBean = new CommonResultBean<>();
        QueryBusinessmenRecommendBean queryBusinessmenRecommendBean = businessmenRecommendService.queryBusinessmenRecommend();
        commonResultBean.setData(queryBusinessmenRecommendBean);
        return commonResultBean;
    }
}
