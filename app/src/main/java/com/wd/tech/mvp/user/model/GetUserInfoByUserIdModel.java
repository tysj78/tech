package com.wd.tech.mvp.user.model;

import com.wd.tech.api.ApiService;
import com.wd.tech.base.BaseModel;
import com.wd.tech.bean.GetUserInfoByUserIdBean;
import com.wd.tech.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 * 注册功能的model
 * */
public class GetUserInfoByUserIdModel extends BaseModel {
    public void GetUserInfoByUserId(int userId, String sessionId,  final IGetUserInfoByUserIdModel listener){

        Observable<GetUserInfoByUserIdBean> observable = RetrofitUtil.getDefault().create(ApiService.class).getUserInfoByUserId(userId,sessionId);

        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetUserInfoByUserIdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetUserInfoByUserIdBean Bean) {
                        listener.ongetUserInfoByUserId(Bean);
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
