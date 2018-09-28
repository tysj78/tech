package com.wd.tech.mvp.group.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.tech.R;
import com.wd.tech.base.BaseActivity;
import com.wd.tech.bean.JoinedGroup;
import com.wd.tech.mvp.group.mvp.model.bean.NewGroupBean;
import com.wd.tech.mvp.group.mvp.presenter.GroupChatPresenter;
import com.wd.tech.mvp.group.mvp.view.GroupChatView;
import com.wd.tech.util.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewgroupActivity extends BaseActivity<GroupChatPresenter> implements GroupChatView {


    @BindView(R.id.new_fanhui)
    TextView mNewFanhui;
    @BindView(R.id.new_baocun)
    TextView mNewBaocun;
    @BindView(R.id.new_iclmt_title)
    EditText mNewIclmtTitle;
    @BindView(R.id.new_iclmt_jianjie)
    EditText mNewIclmtJianjie;
    @BindView(R.id.new_iclmt_che1)
    CheckBox mNewIclmtChe1;
    @BindView(R.id.new_iclmt_che2_title)
    TextView mNewIclmtChe2Title;
    @BindView(R.id.new_iclmt_che2)
    CheckBox mNewIclmtChe2;

    @OnClick({R.id.new_fanhui, R.id.new_baocun, R.id.new_iclmt_che1, R.id.new_iclmt_che2})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.new_fanhui:
                finish();//返回
                break;
            case R.id.new_baocun:
                String title = mNewIclmtTitle.getText().toString();
                String briefintroduction = mNewIclmtTitle.getText().toString();//簡介

                int userId = (int) SharedPreferencesUtils.getParam(NewgroupActivity.this, "userId", 0);
                String sessionId = (String) SharedPreferencesUtils.getParam(NewgroupActivity.this, "sessionId", "123123");



                if(title.equalsIgnoreCase("")){
                    Toast.makeText(this,"群名不能爲空",Toast.LENGTH_LONG).show();
                }else if(briefintroduction.equalsIgnoreCase("")){
                    Toast.makeText(this,"簡介不能爲空",Toast.LENGTH_LONG).show();
                }else{
                    presenter.getNew_Group( userId,  sessionId, title, briefintroduction);
                }
                break;
            case R.id.new_iclmt_che1:

                break;
            case R.id.new_iclmt_che2:
                break;
        }
    }

    @Override
    public void getJoinedGroup(JoinedGroup joinedGroup) {

    }

    @Override
    public void getnewGroup(NewGroupBean newGroupBean) {

        Toast.makeText(this,""+newGroupBean.getMessage(),Toast.LENGTH_LONG).show();
        if(newGroupBean.getStatus().equalsIgnoreCase("0000")){
            finish();
        }

    }

    @Override
    protected void initView() {

    }

    @Override
    public GroupChatPresenter providePresenter() {
        return new GroupChatPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_newgroup;
    }

    @Override
    public void initDate() {
        mNewIclmtChe1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(NewgroupActivity.this,"666666",Toast.LENGTH_LONG).show();
                    mNewIclmtChe2Title.setText("加入公開群需要群主同意");
                    mNewIclmtTitle.setText("加入公開群需要群主同意");
                    mNewIclmtChe2.setText("加入公開群需要群主同意");
                }else{
                    mNewIclmtChe2Title.setText("開放群成員邀請");
                    Toast.makeText(NewgroupActivity.this,"sdf",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO:OnCreate Method has been created, run ButterKnife again to generate code
        setContentView(R.layout.activity_newgroup);


        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
