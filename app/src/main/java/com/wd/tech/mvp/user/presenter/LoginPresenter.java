package com.wd.tech.mvp.user.presenter;

import com.wd.tech.base.BasePresenter;
import com.wd.tech.bean.LoginBean;
import com.wd.tech.mvp.user.model.ICallBack;
import com.wd.tech.mvp.user.model.LoginTask;
import com.wd.tech.mvp.user.view.LoginView;
import com.wd.tech.util.RsaCoder;

import java.lang.ref.WeakReference;

/*
 * 登陆的presenter
 * */
public class LoginPresenter extends BasePresenter<LoginTask,LoginView> implements ILoginPresenter {
     LoginTask loginTask;
     LoginView loginView;
    public LoginPresenter(LoginView view) {
        super(view);
        loginTask=new LoginTask();
        loginView=view;
    }

    @Override
    protected WeakReference getWeak() {
        return null;
    }

    @Override
    protected LoginTask initModel() {
        loginTask=new LoginTask();
        return loginTask;
    }


    @Override
    public void initNetWork(String name, String password) {
        String pass = null;
        try {
            pass = RsaCoder.encryptByPublicKey(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        loginTask.success(name, pass, new ICallBack() {
               @Override
               public void getSuccess(LoginBean loginBean) {
                   loginView.getData(loginBean);
               }
           });
    }
}
