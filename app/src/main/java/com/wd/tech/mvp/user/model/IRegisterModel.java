package com.wd.tech.mvp.user.model;


import com.wd.tech.bean.RegisterUserBean;

public interface IRegisterModel {
    void onRegister(RegisterUserBean bean);

    void onError();
}
