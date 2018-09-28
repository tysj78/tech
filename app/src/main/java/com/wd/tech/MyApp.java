package com.wd.tech;

import android.app.Application;


import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * author:Created by YangYong on 2018/9/22 0022.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
//        EMOptions options = new EMOptions();
//
//        EMClient.getInstance().init(getApplicationContext(), options);
////在做打包混淆时，关闭debug模式，避免消耗不必要的资源
//        EMClient.getInstance().setDebugMode(true);

        Fresco.initialize(this);

    }
}
