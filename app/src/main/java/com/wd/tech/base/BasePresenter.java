package com.wd.tech.base;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2018/7/11 0011.
 */

public abstract class BasePresenter<M extends BaseModel, V extends BaseView> {
    protected M model;
    protected V view;
    protected WeakReference<V> weakReference;

    public BasePresenter(V view) {
        this.view = view;
        model = initModel();
        weakReference=getWeak();
    }

    protected abstract WeakReference<V> getWeak();

    protected abstract M initModel();


    //内存优化
    public void onDestroy() {
        model.onDestroy();
        if (weakReference!=null&&weakReference.get()!=null){
            weakReference.clear();
            weakReference=null;
            view=null;
        }
    }

}
