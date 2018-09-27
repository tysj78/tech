package com.wd.tech.mvp.user.presenter;

import com.wd.tech.base.BasePresenter;
import com.wd.tech.bean.GetUserInfoByUserIdBean;
import com.wd.tech.bean.RegisterUserBean;
import com.wd.tech.mvp.user.model.GetUserInfoByUserIdModel;
import com.wd.tech.mvp.user.model.IGetUserInfoByUserIdModel;
import com.wd.tech.mvp.user.view.IGetUserInfoByUserIdView;
import com.wd.tech.mvp.user.view.IRegisterView;
import com.wd.tech.util.RsaCoder;

import java.lang.ref.WeakReference;

/*
 * 注册的presenter
 * */
public class GetUserInfoByUserIdPresenter extends BasePresenter<GetUserInfoByUserIdModel,IGetUserInfoByUserIdView> {
     GetUserInfoByUserIdModel getUserInfoByUserIdModel;
    private String s;

    public GetUserInfoByUserIdPresenter(IGetUserInfoByUserIdView view) {
        super(view);
        getUserInfoByUserIdModel=new GetUserInfoByUserIdModel();

    }

    @Override
    protected WeakReference<IGetUserInfoByUserIdView> getWeak() {
        return null ;
    }

    @Override
    protected GetUserInfoByUserIdModel initModel() {
        getUserInfoByUserIdModel=new GetUserInfoByUserIdModel();
        return getUserInfoByUserIdModel;
    }

    public void getUserInfoByUserId(int userId, String sessionId){

        getUserInfoByUserIdModel.getUserInfoByUserId(userId, sessionId, new IGetUserInfoByUserIdModel() {
            @Override
            public void ongetUserInfoByUserId(GetUserInfoByUserIdBean bean) {
                view.getData(bean);
            }

            @Override
            public void onError() {

            }
        });
    }

}
