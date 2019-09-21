package com.guqiao.api.test;

import com.google.gson.JsonObject;
import com.guqiao.api.common.CommonService;
import com.guqiao.api.gank.GankService;
import com.guqiao.api.gank.model.type.Category;
import com.guqiao.api.gank.model.type.XdSubCate;
import com.guqiao.api.net.RetrofitServiceManager;
import io.reactivex.functions.Consumer;

/**
 * @author jiangyao
 * @date 2019/9/21 4:20 下午
 * @des
 */
public class GankTest {
    public static void main(String[] args) {
        RetrofitServiceManager.getInstance().create(CommonService.class)
                .queryKuaidi("shentong", "12121212").subscribe(new Consumer<JsonObject>() {
            @Override
            public void accept(JsonObject jsonObject) throws Exception {
                System.out.println("accept--->" + jsonObject);
            }
        }, throwable -> {
            System.out.println("error--->" + throwable.getMessage());
        });
    }

//    "blogspot"
}
