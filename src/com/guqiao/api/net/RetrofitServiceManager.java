package com.guqiao.api.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author jiangyao
 * @date 2019/9/21 4:17 下午
 * @des 通用网络请求类
 */
public class RetrofitServiceManager {
    private final int DEFAULT_TIME_OUT = 20;
    private final int DEFAULT_READ_TIME_OUT = 20;
    private Retrofit.Builder mRetrofitBuilder;
    private OkHttpClient.Builder mOkhttpBuilder;
    private final String DEFAULT_BASE_URL = "http://www.test.com/";

    private RetrofitServiceManager() {

    }

    /**
     * 创建okhttpBuilder
     */
    private void createOkHttpBuilder() {
        mOkhttpBuilder = new OkHttpClient.Builder();
        mOkhttpBuilder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);
        mOkhttpBuilder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);
    }

    /**
     * 创建RetrofitBuilder
     */

    private void createRetrofitBuilder() {
        if (mOkhttpBuilder == null) {
            createOkHttpBuilder();
        }
        mRetrofitBuilder = new Retrofit.Builder().client(mOkhttpBuilder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
    }

    public static RetrofitServiceManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final RetrofitServiceManager INSTANCE = new RetrofitServiceManager();
    }


    /**
     * @param baseUrl
     * @param service
     * @param <T>
     * @return
     */
    public <T> T create(String baseUrl, Class<T> service) {
        if (mRetrofitBuilder == null) {
            createRetrofitBuilder();
        }
        return mRetrofitBuilder.baseUrl(baseUrl).build().create(service);
    }

    /**
     * 此处有坑
     * (1) 如果先调用create(String baseUrl,Class<T> service),然后调用create(Class<T> service)可正常运行
     * (2) 如果直接调用create(Class<T> service)会报错baseUrl null，因为（1）中已经设置了baseUrl，（2）中就不用设置。
     *
     * @param service
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service) {
        return create(DEFAULT_BASE_URL, service);
    }
}
