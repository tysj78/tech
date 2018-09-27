package com.wd.tech.mvp.user.model;

import com.wd.tech.api.ApiService;
import com.wd.tech.base.BaseModel;
import com.wd.tech.bean.LoginBean;
import com.wd.tech.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 * 登录功能的model
 * */
public class LoginTask extends BaseModel implements ILoginTask {

    @Override
    public void success(String name, String pass, final ICallBack callBack) {
        RetrofitUtil instance = RetrofitUtil.getDefault();
        ApiService myServer = instance.create(ApiService.class);
        Observable<LoginBean> login = myServer.login(name, pass);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
callBack.getSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
