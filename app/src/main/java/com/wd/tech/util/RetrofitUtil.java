package com.wd.tech.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by YangYong on 2018/7/12 0012.
 */
public class RetrofitUtil {
    private final Retrofit retrofit;
    private HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private RetrofitUtil() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(buildOkhttpClinet())
                .build();
    }

    private OkHttpClient buildOkhttpClinet() {
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    //暴露外部的方法
    public static RetrofitUtil getDefault() {
        return SingleHolder._instant;
    }

    private static class SingleHolder {
        private static final RetrofitUtil _instant = new RetrofitUtil();
    }

    //动态代理创建接口实现类
    public <T> T create(Class<T> Clazz) {
        return retrofit.create(Clazz);
    }
}
