package com.wd.tech.mvp.group.mvp.model;

import com.wd.tech.base.BaseModel;
import com.wd.tech.bean.JoinedGroup;
import com.wd.tech.mvp.group.mvp.model.bean.NewGroupBean;
import com.wd.tech.util.MyRetrofit;
import com.wd.tech.util.RetrofitUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author:Created by YangYong on 2018/9/28 0028.
 */
public class GroupChatModel extends BaseModel {
    public void getJoinedGroup(int userId, String sessionId, final GroupChatCallBack callBack) {
        RetrofitUtil.getDefault().create(MyRetrofit.class).getJoinedGroup(userId, sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JoinedGroup>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(JoinedGroup joinedGroup) {
                        callBack.getJoinedGroup(joinedGroup);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void getNewGroupOk(int userId, String sessionId,String name,String description, final GroupChatCallBack callBack) {
        RetrofitUtil.getDefault().create(MyRetrofit.class).getJnewGroup(userId, sessionId,name,description)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewGroupBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(NewGroupBean newGroupBean) {
                        callBack.getnewGroup(newGroupBean);
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
