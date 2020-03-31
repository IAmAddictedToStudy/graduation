package com.example.graduation.controller;

import com.example.graduation.bean.CommonResultBean;
import com.example.graduation.bean.MemberCustBean;
import com.example.graduation.bean.MerchantLikeEntityBean;
import com.example.graduation.service.MerchantLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author LiaoFuQin
 * @Classname MerchantLikeMapper
 * @Description TODO
 * @Date 2020/3/27 21:15
 * @Created by LiaoFuQin
 */
@RestController
public class MerchantLikeController extends BaseController {
    @Autowired
    MerchantLikeService service;

    @PostMapping("/insertMerchantLike")
    public CommonResultBean insertMerchantLike(MerchantLikeEntityBean entity, HttpSession session) throws Exception {
        CommonResultBean resultBean = new CommonResultBean();
        if (entity.getMerchantId() == null) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("商家id不能为空");
            return resultBean;
        }
        try {
            MemberCustBean memberCustBean = (MemberCustBean) session.getAttribute("memberCustBean");
            if (memberCustBean == null) {
                resultBean.setResultCode("-1");
                resultBean.setResultMsg("未登录，请重新登录");
                return resultBean;
            }
            entity.setStudentNumber(Long.parseLong(memberCustBean.getCustStudentNumber()));
        } catch (Exception e) {
            resultBean.setResultCode("-1");
            resultBean.setResultMsg("未登录，请重新登录");
            return resultBean;
        }

        service.insertMerchantLike(entity);
        return resultBean;
    }
}
