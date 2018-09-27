package com.wd.tech.api;

import com.wd.tech.bean.GetUserInfoByUserIdBean;
import com.wd.tech.bean.LoginBean;
import com.wd.tech.bean.ModifyHeadPicBean;
import com.wd.tech.bean.ModifyNickNameBean;
import com.wd.tech.bean.ModifySignatureBean;
import com.wd.tech.bean.PerfectUserInfoBean;
import com.wd.tech.bean.RegisterUserBean;

import java.util.Date;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

public interface ApiService {
    //3.1注册
    @FormUrlEncoded
    @POST("techApi/user/v1/register")
    Observable<RegisterUserBean> registerUser(@Field("phone") String phone,
                                              @Field("nickName") String nickName,
                                              @Field("pwd") String pwd);
    //3.3.完善用户信息
    @FormUrlEncoded
    @POST("techApi/user/verify/v1/perfectUserInfo")
    Observable<PerfectUserInfoBean> perfectUserInfo(@Header("userId") int userId,
                                                    @Header("sessionId") String sessionId,
                                                    @Field("nickName") String nickName,
                                                    @Field("sex") int sex,
                                                    @Field("signature") String signature,
                                                    @Field("birthday") String birthday,
                                                    @Field("email") String email);
    //3.2登陆
    @FormUrlEncoded
    @POST("techApi/user/v1/login")
    Observable<LoginBean> login(@Field("phone") String phone,
                                @Field("pwd") String pwd);

    //3.4.根据用户ID查询用户信息
    @GET("techApi/user/verify/v1/getUserInfoByUserId")
    Observable<GetUserInfoByUserIdBean> getUserInfoByUserId(@Header("userId") int userId,
                                                            @Header("sessionId") String sessionId);
    //3.5.修改用户昵称
    @PUT("techApi/user/verify/v1/modifyNickName")
    Observable<ModifyNickNameBean> modifyNickName(@Header("userId") int userId,
                                                  @Header("sessionId") String sessionId,
                                                  @Field("nickName") String nickName
    );
    //3.6.修改用户签名
    @PUT("techApi/user/verify/v1/modifySignature")
    Observable<ModifySignatureBean> modifySignature(@Header("userId") int userId,
                                                    @Header("sessionId") String sessionId,
                                                    @Field("signature") String signature
    );
    //3.7上传用户头像
    @POST("https://172.17.8.100/techApi/user/verify/v1/modifyHeadPic")
    @Multipart
    Observable<ModifyHeadPicBean> uploadHeadPic(@Header("userId") int userId,
                                                @Header("sessionId") String sessionId,
                                                @Part MultipartBody.Part image
    );

}
