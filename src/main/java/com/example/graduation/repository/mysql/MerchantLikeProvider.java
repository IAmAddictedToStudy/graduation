package com.example.graduation.repository.mysql;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author LiaoFuQin
 * @Classname MerchantLikeProvider
 * @Description TODO
 * @Date 2020/3/27 21:17
 * @Created by LiaoFuQin
 */
public class MerchantLikeProvider {

    public String queryRecommendList() {
        return new SQL() {{
            SELECT(" count(*) likeCount,ml.merchant_id, br.* ");
            FROM("merchant_like ml\n" +
                    "         left join businessmen_recommend br on ml.merchant_id = br.id");
            WHERE("br.propaganda_time >now() ");
            GROUP_BY("merchant_id");
            ORDER_BY("br.create_time desc");
        }}.toString();
    }

    public String queryAllRecommendList() {
        return new SQL() {{
            SELECT("* ");
            FROM("businessmen_recommend br");
            ORDER_BY("br.create_time desc");
        }}.toString();
    }
}
