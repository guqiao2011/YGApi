package com.guqiao.api.gank;

import com.google.gson.JsonObject;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GankService {


    String GANK_BASE_URL = "http://gank.io/";

    /**
     * 获取最新一天的消息
     */
    @GET("api/today")
    Observable<JsonObject> getNewestGankList();


    /**
     * 获取闲读的主分类
     */
    @GET("api/xiandu/categories")
    Observable<JsonObject> getXiaoduCategories();

    /**
     * 获取闲读的子分类
     *
     * @param sub XdSubCate
     */
    @GET("api/xiandu/category/{sub}")
    Observable<JsonObject> getXianduSubCategories(@Path("sub") String sub);


    /**
     * 获取闲读数据
     *
     * @param count 每页的数量
     * @param page  页数
     * @param subId 子分类返回的id
     */
    @GET("/api/xiandu/data/id/{subId}/count/{count}/page/{page}")
    Observable<JsonObject> getXianduData(@Path("subId") String subId, @Path("count") int count, @Path("page") int page);


    /**
     * 搜索api
     *
     * @param category Category
     * @param count
     * @param page
     */
    @GET("api/search/query/listview/category/{category}/count/{count}/page/{page}")
    Observable<JsonObject> searchGankInfo(@Path("category") String category, @Path("count") int count, @Path("page") int page);


    /**
     * 获取某几日干货网站数据
     */
    @GET("api/history/content/{count}/{page}")
    Observable<JsonObject> getSomeDayGankInfo(@Path("count") int count, @Path("page") int page);


    /**
     * 获取特定日期网站数据
     */
    @GET("api/history/content/day/{year}/{month}/{day}")
    Observable<JsonObject> getSomeDateGankInfo(@Path("year") int year, @Path("month") int month, @Path("day") int day);


    /**
     * 获取发过干货日期接口
     */
    @GET("api/day/history")
    Observable<JsonObject> getHistoryGankInfo();


    /**
     * 获取分类数据
     *
     * @param category 分类 Category
     * @param page     页数
     * @param count    个数
     */
    @GET("api/data/{category}/{count}/{page}")
    Observable<JsonObject> getCateDateGankInfo(@Path("category") String category, @Path("count") int count, @Path("page") int page);

    /**
     * 获取每日数据
     *
     * @param year
     * @param month
     * @param day
     */
    @GET("api/day/{year}/{month}/{day}")
    Observable<JsonObject> getDailyGankInfo(@Path("year") int year, @Path("month") int month, @Path("day") int day);

    /**
     * 获取随机数据
     */
    @GET("api/random/data/{category}/{count}")
    Observable<JsonObject> getRandomGankInfo(@Path("category") String category, @Path("count") int count);
}