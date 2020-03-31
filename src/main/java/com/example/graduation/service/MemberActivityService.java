package com.example.graduation.service;

import com.example.graduation.bean.MemberActivityBean;
import com.example.graduation.bean.QueryMemberActivityRequestBean;
import com.example.graduation.bean.QueryMemberActivityResponseBean;
import com.example.graduation.repository.ActivityRegistrationRepository;
import com.example.graduation.repository.MemberActivityRepository;
import com.example.graduation.repository.MemberCustRepository;
import com.example.graduation.repository.entity.ActivityRegistrationEntity;
import com.example.graduation.repository.entity.MemberActivityEntity;
import com.example.graduation.repository.entity.MemberActivityUniteEntity;
import com.example.graduation.repository.entity.MemberCustEntity;
import com.example.graduation.utils.Apriori;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author DaiDaQi
 * @Classname MemberActivityService
 * @Description TODO
 * @Date 2020/3/22 16:27
 * @Created by DaiDaQi
 */
@Service
public class MemberActivityService {
    @Autowired
    MemberActivityRepository repository;
    @Autowired
    MemberCustRepository memberCustRepository;
    @Autowired
    ActivityRegistrationRepository activityRegistrationRepository;

    public QueryMemberActivityResponseBean queryMemberActivityByCondition(QueryMemberActivityRequestBean requestBean) {
        QueryMemberActivityResponseBean queryMemberActivityResponseBean = new QueryMemberActivityResponseBean();
        List<QueryMemberActivityResponseBean.MemberActivityUniteEntity> memberActivityUniteEntities1 = new ArrayList<>();
        MemberActivityUniteEntity memberActivityUniteEntity = new MemberActivityUniteEntity();
        BeanUtils.copyProperties(requestBean, memberActivityUniteEntity);
        List<MemberActivityUniteEntity> memberActivityUniteEntities = repository.queryMemberActivityByCondition(memberActivityUniteEntity);
        memberActivityUniteEntities.forEach(memberActivityUniteEntity1 -> {
            QueryMemberActivityResponseBean.MemberActivityUniteEntity memberActivityUniteEntity2 = new QueryMemberActivityResponseBean.MemberActivityUniteEntity();
            BeanUtils.copyProperties(memberActivityUniteEntity1, memberActivityUniteEntity2);
            memberActivityUniteEntities1.add(memberActivityUniteEntity2);
        });
        queryMemberActivityResponseBean.setMemberActivityUniteEntities(memberActivityUniteEntities1);
        return queryMemberActivityResponseBean;
    }

    public void insertMemberActivity(MemberActivityBean memberActivityBean) throws Exception {
        MemberActivityEntity memberActivityEntity = new MemberActivityEntity();
        BeanUtils.copyProperties(memberActivityBean, memberActivityEntity);
        int i = repository.insertMemberActivity(memberActivityEntity);
        if (i <= 0) {
            throw new Exception("添加活动失败，请稍后重试");
        }
    }

    public QueryMemberActivityResponseBean queryRecommendationList(String custCharacter) throws Exception {
        QueryMemberActivityResponseBean queryMemberActivityResponseBean = new QueryMemberActivityResponseBean();
        List<QueryMemberActivityResponseBean.MemberActivityUniteEntity> memberActivityUniteEntities = new ArrayList<>();
        MemberCustEntity memberCustEntity = new MemberCustEntity();
        memberCustEntity.setCustCharacter(custCharacter);
        List<MemberCustEntity> select = memberCustRepository.select(memberCustEntity);
        ArrayList<String> activityIds = new ArrayList<>();
        select.forEach(memberCustEntity1 -> {
            ActivityRegistrationEntity memberActivityEntity = new ActivityRegistrationEntity();
            memberActivityEntity.setStudentNumber(memberCustEntity1.getCustStudentNumber());
            List<ActivityRegistrationEntity> select1 = activityRegistrationRepository.select(memberActivityEntity);
            StringBuilder sb = new StringBuilder();
            select1.forEach(select2 -> {
                sb.append(select2.getActivityId()).append(";");
            });
            if (StringUtils.isNotBlank(sb.toString())) {
                activityIds.add(sb.toString());
            }
        });
        List<String> activityId = new ArrayList<>();
        Apriori apriori2 = new Apriori();
        //System.out.println("=频繁项集==========");
        Map<String, Integer> frequentSetMap = apriori2.apriori(activityIds);
        Set<String> keySet = frequentSetMap.keySet();
        for (String key : keySet) {
            if (key.length() == 2) {
                //如果报名人数大于 0.2
                if (frequentSetMap.get(key) > (select.size() * 0.2)) {
                    activityId.add(key.replace(";", ""));
                }
            }
        }
        activityId.forEach(id -> {
            MemberActivityUniteEntity memberActivityUniteEntity = new MemberActivityUniteEntity();
            memberActivityUniteEntity.setId(Long.valueOf(id));
            //按id查找数据
            List<MemberActivityUniteEntity> memberActivityUniteEntities2 = repository.queryMemberActivityByCondition(memberActivityUniteEntity);
            QueryMemberActivityResponseBean.MemberActivityUniteEntity memberActivityUniteEntity1 = new QueryMemberActivityResponseBean.MemberActivityUniteEntity();
            if (memberActivityUniteEntities2.size() > 0) {
                BeanUtils.copyProperties(memberActivityUniteEntities2.get(0), memberActivityUniteEntity1);
                memberActivityUniteEntities.add(memberActivityUniteEntity1);
            }
        });
        queryMemberActivityResponseBean.setMemberActivityUniteEntities(memberActivityUniteEntities);
        return queryMemberActivityResponseBean;
    }

    public QueryMemberActivityResponseBean queryMyActivityList(String studentNumber) throws Exception {
        QueryMemberActivityResponseBean queryMemberActivityResponseBean = new QueryMemberActivityResponseBean();
        List<QueryMemberActivityResponseBean.MemberActivityUniteEntity> memberActivityUniteEntities = new ArrayList<>();
        MemberActivityEntity memberActivityEntity = new MemberActivityEntity();
        memberActivityEntity.setActivityCreator(studentNumber);
        List<MemberActivityEntity> select = repository.select(memberActivityEntity);
        select.forEach(memberActivityEntity1 -> {
            QueryMemberActivityResponseBean.MemberActivityUniteEntity memberActivityUniteEntity = new QueryMemberActivityResponseBean.MemberActivityUniteEntity();
            BeanUtils.copyProperties(memberActivityEntity1, memberActivityUniteEntity);

            memberActivityUniteEntities.add(memberActivityUniteEntity);
        });
        queryMemberActivityResponseBean.setMemberActivityUniteEntities(memberActivityUniteEntities);
        return queryMemberActivityResponseBean;
    }

    public void updateActivity(MemberActivityBean memberActivityBean) throws Exception {
        MemberActivityEntity memberActivityEntity = new MemberActivityEntity();
        BeanUtils.copyProperties(memberActivityBean, memberActivityEntity);
        int update = repository.update(memberActivityEntity);
        if (update <= 0) {
            throw new Exception("修改活动失败");
        }
    }

    public void deleteActivity(MemberActivityBean memberActivityBean) throws Exception {
        MemberActivityEntity memberActivityEntity = new MemberActivityEntity();
        BeanUtils.copyProperties(memberActivityBean, memberActivityEntity);
        int update = repository.delete(memberActivityEntity);
        if (update <= 0) {
            throw new Exception("删除活动失败");
        }
    }
}
