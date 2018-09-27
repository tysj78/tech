package com.wd.tech.mvp.user.presenter;

import com.wd.tech.base.BasePresenter;
import com.wd.tech.bean.RegisterUserBean;
import com.wd.tech.mvp.user.model.IRegisterModel;
import com.wd.tech.mvp.user.model.RegisterModel;
import com.wd.tech.mvp.user.view.IRegisterView;
import com.wd.tech.util.RsaCoder;

import java.lang.ref.WeakReference;

/*
 * 注册的presenter
 * */
public class RegisterPresenter extends BasePresenter<RegisterModel,IRegisterView> {
     RegisterModel registerModel;
    private String s;

    public RegisterPresenter(IRegisterView view) {
        super(view);
        registerModel=new RegisterModel();

    }

    @Override
    protected WeakReference<IRegisterView> getWeak() {
        return null ;
    }

    @Override
    protected RegisterModel initModel() {
        registerModel=new RegisterModel();
        return registerModel;
    }

    public void findRegisterModelList(String phone, String nickName,  String pwd){
        try {
            s = RsaCoder.encryptByPublicKey(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        registerModel.findRegisterModelList(phone,nickName,s, new IRegisterModel() {
                @Override
                public void onRegister(RegisterUserBean bean) {
                    view.getData(bean);
                }

                @Override
                public void onError() {

                }
            });
    }

}
