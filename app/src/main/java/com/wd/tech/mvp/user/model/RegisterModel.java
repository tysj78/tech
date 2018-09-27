package com.wd.tech.mvp.user.model;

import com.wd.tech.api.ApiService;
import com.wd.tech.base.BaseModel;
import com.wd.tech.bean.RegisterUserBean;
import com.wd.tech.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 * 注册功能的model
 * */
public class RegisterModel extends BaseModel {
    public void findRegisterModelList(String phone, String nickName,  String pwd, final IRegisterModel listener){

        Observable<RegisterUserBean> observable = RetrofitUtil.getDefault().create(ApiService.class).registerUser(phone, nickName, pwd);

        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterUserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterUserBean registerUserBean) {
                        listener.onRegister(registerUserBean);
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
