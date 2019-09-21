package com.guqiao.api.gank;

import com.google.gson.JsonObject;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface GankService {


    String GANK_BASE_URL = "http://gank.io/";

    /**
     * 获取最新一天的消息
     *
     * @return
     */
    @GET("api/today")
    Observable<JsonObject> getNewestGankList();


}

