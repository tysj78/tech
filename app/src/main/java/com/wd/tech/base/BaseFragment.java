package com.wd.tech.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author:Created by YangYong on 2018/8/31 0031.
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    protected P presenter;
    private Unbinder unbinder;
    protected Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context=container.getContext();
        View view = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(view);
        presenter = getPresenter();
        return view;
    }

    protected abstract P getPresenter();

    protected abstract int getLayout();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }


    protected abstract void initView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroy();
        presenter = null;
//        unbinder.unbind();
    }
}
