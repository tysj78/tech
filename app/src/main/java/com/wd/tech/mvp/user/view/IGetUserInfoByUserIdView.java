package com.wd.tech.mvp.user.view;

import com.wd.tech.base.BaseView;
import com.wd.tech.bean.GetUserInfoByUserIdBean;
import com.wd.tech.bean.RegisterUserBean;

public interface IGetUserInfoByUserIdView extends BaseView {
    void   getData(GetUserInfoByUserIdBean Bean);
}
