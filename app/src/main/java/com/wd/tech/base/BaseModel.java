package com.wd.tech.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * author:Created by YangYong on 2018/8/31 0031.
 */
public abstract class BaseModel {
    protected CompositeDisposable compositeDisposable=new CompositeDisposable();

    public void onDestroy(){
        if (compositeDisposable!=null){
            compositeDisposable.clear();
        }
    }
}
