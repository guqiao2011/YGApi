package com.guqiao.api.common;

import com.google.gson.JsonObject;
import com.guqiao.api.conf.Constant;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * @author jiangyao
 * @date 2019/9/21 6:37 下午
 * @des
 */
public interface CommonService {

    /**
     * 快递查询
     */
    @Headers({"Domain-Name: " + Constant.KUAI_KEY})
    @GET("http://kuaidi100.com/query")
    Observable<JsonObject> queryKuaidi(@Query("type") String type, @Query("postid") String postid);
}
