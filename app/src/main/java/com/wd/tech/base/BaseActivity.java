package com.wd.tech.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/7/11 0011.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    protected P presenter;
    private Unbinder unbinder;
    protected Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
        presenter = providePresenter();
        initView();
        initDate();
    }

    protected abstract void initView();

    public abstract P providePresenter();

    public abstract int getLayout();

    public abstract void initDate();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        presenter = null;
        unbinder.unbind();
    }
}
