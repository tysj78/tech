package com.wd.tech;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.hjm.bottomtabbar.BottomTabBar;
import com.wd.tech.mvp.CommunityFragment;
import com.wd.tech.mvp.GroupFragment;
import com.wd.tech.mvp.MyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_bt)
    BottomTabBar mainBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStatusBar();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initBt();
    }

    private void initBt() {
        mainBt.init(getSupportFragmentManager())
                .setImgSize(70, 70)
                .setChangeColor(Color.parseColor("#DA2C15"), Color.parseColor("#8A8A8A"))
                .addTabItem("社区", R.drawable.sehqu, CommunityFragment.class)
                .addTabItem("群组", R.drawable.group, GroupFragment.class)
                .addTabItem("我的", R.drawable.my, MyFragment.class)
                .isShowDivider(false);
    }

    //沉浸式，颜色可以根据需要修改
    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //注意要清除 FLAG_TRANSLUCENT_STATUS flag
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.lan));
        }
    }
}
