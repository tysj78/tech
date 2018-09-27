package com.wd.tech.mvp.user.model;

import com.wd.tech.api.ApiService;
import com.wd.tech.base.BaseModel;
import com.wd.tech.bean.PerfectUserInfoBean;
import com.wd.tech.bean.RegisterUserBean;
import com.wd.tech.util.RetrofitUtil;

import java.util.Date;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 * 注册功能的model
 * */
public class PerfectUserInfoModel extends BaseModel {
    public void perfectUserInfo(int userid, String sessionId, String nickName, int sex, String signature, String birthday, String email, final IPerfectUserInfoModel listener){

        Observable<PerfectUserInfoBean> observable = RetrofitUtil.getDefault().create(ApiService.class).perfectUserInfo(userid,sessionId,nickName,sex,signature,birthday,email);

        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PerfectUserInfoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PerfectUserInfoBean bean) {
                        listener.onPerfectUserInfo(bean);
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
