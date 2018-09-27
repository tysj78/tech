package com.wd.tech.mvp.user.presenter;

import android.widget.EditText;

import com.wd.tech.base.BasePresenter;
import com.wd.tech.bean.PerfectUserInfoBean;
import com.wd.tech.bean.RegisterUserBean;
import com.wd.tech.mvp.user.model.IPerfectUserInfoModel;
import com.wd.tech.mvp.user.model.IRegisterModel;
import com.wd.tech.mvp.user.model.PerfectUserInfoModel;
import com.wd.tech.mvp.user.model.RegisterModel;
import com.wd.tech.mvp.user.view.IPerfectUserInfoView;
import com.wd.tech.mvp.user.view.IRegisterView;
import com.wd.tech.util.RsaCoder;

import java.lang.ref.WeakReference;
import java.util.Date;

/*
 * 注册的presenter
 * */
public class PerfectUserInfoPresenter extends BasePresenter<PerfectUserInfoModel,IPerfectUserInfoView> {
    PerfectUserInfoModel  perfectUserInfoModel;
    private String s;

    public PerfectUserInfoPresenter(IPerfectUserInfoView view) {
        super(view);
        perfectUserInfoModel =new PerfectUserInfoModel();

    }

    @Override
    protected WeakReference<IPerfectUserInfoView> getWeak() {
        return null ;
    }

    @Override
    protected PerfectUserInfoModel initModel() {
        perfectUserInfoModel=new PerfectUserInfoModel();
        return  perfectUserInfoModel;
    }

    public void perfectUserInfo(int userid, String sessionId, String nickName, int sex, String signature, String birthday, String email){

        perfectUserInfoModel.perfectUserInfo(userid, sessionId, nickName, sex, signature, birthday, email, new IPerfectUserInfoModel() {
            @Override
            public void onPerfectUserInfo(PerfectUserInfoBean bean) {
                view.getData(bean);
            }

            @Override
            public void onError() {

            }
        });
    }

}
