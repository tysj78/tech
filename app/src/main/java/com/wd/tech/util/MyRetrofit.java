package com.wd.tech.util;

import com.wd.tech.bean.JoinedGroup;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * author:Created by YangYong on 2018/7/17 0017.
 */
public interface MyRetrofit {
    //用户加入的群
    @GET("techApi/group/verify/v1/findUserJoinedGroup")
    Observable<JoinedGroup> getJoinedGroup(@Header("userId") int userId, @Header("sessionId") String sessionId);
}
