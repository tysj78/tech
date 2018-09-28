package com.wd.tech.util;

import com.wd.tech.bean.JoinedGroup;
import com.wd.tech.mvp.group.mvp.model.bean.NewGroupBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * author:Created by YangYong on 2018/7/17 0017.
 */
public interface MyRetrofit {
    //用户加入的群
    @GET("techApi/group/verify/v1/findUserJoinedGroup")
    Observable<JoinedGroup> getJoinedGroup(@Header("userId") int userId, @Header("sessionId") String sessionId);
//    用户加入的群
    @POST("techApi/group/verify/v1/createGroup")
    Observable<NewGroupBean> getJnewGroup(@Header("userId") int userId, @Header("sessionId") String sessionId,
                                          @Query("name") String name, @Query("description") String description);
}
