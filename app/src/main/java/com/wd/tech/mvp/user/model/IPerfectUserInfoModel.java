package com.wd.tech.mvp.user.model;


import com.wd.tech.bean.PerfectUserInfoBean;

public interface IPerfectUserInfoModel {
    void onPerfectUserInfo(PerfectUserInfoBean bean);

    void onError();
}
