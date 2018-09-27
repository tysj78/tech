package com.wd.tech.mvp.user.model;


import com.wd.tech.bean.GetUserInfoByUserIdBean;

public interface IGetUserInfoByUserIdModel {
    void ongetUserInfoByUserId(GetUserInfoByUserIdBean bean);

    void onError();
}
