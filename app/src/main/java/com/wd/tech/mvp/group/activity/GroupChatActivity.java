package com.wd.tech.mvp.group.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.wd.tech.R;
import com.wd.tech.adapter.GroupListAdapter;
import com.wd.tech.base.BaseActivity;
import com.wd.tech.bean.JoinedGroup;
import com.wd.tech.mvp.group.mvp.model.bean.NewGroupBean;
import com.wd.tech.mvp.group.mvp.presenter.GroupChatPresenter;
import com.wd.tech.mvp.group.mvp.view.GroupChatView;
import com.wd.tech.util.SharedPreferencesUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GroupChatActivity extends BaseActivity<GroupChatPresenter> implements GroupChatView {

    @BindView(R.id.groupchat_creategroup)
    TextView groupchatCreategroup;
    @BindView(R.id.groupchat_grouplist)
    RecyclerView groupchatGrouplist;
    private int userId;
    private String sessionId;
    private GroupListAdapter listAdapter;


    @OnClick(R.id.groupchat_creategroup)
    public void onViewClicked() {
        //跳转到创建群聊页面

        Intent intent=new Intent(this,NewgroupActivity.class);
        startActivity(intent);
    }

    @Override
    protected void initView() {
        //sp取出双id
        userId = (int) SharedPreferencesUtils.getParam(this, "userId", 0);
        sessionId = (String) SharedPreferencesUtils.getParam(this, "sessionId", "");

        //初始化群列表
        initGroupList();
    }

    //可交互时调用
    @Override
    protected void onResume() {
        super.onResume();
        presenter.getJoinedGroup(userId, sessionId,null,null);
    }

    private void initGroupList() {
        groupchatGrouplist.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public GroupChatPresenter providePresenter() {
        return new GroupChatPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_group_chat;
    }

    @Override
    public void initDate() {

    }

    @Override
    public void getJoinedGroup(JoinedGroup joinedGroup) {
        String status = joinedGroup.getStatus();
        if (status.equals("0000")) {
            List<JoinedGroup.ResultBean> result = joinedGroup.getResult();
            if (listAdapter == null) {
                listAdapter = new GroupListAdapter(result);
                groupchatGrouplist.setAdapter(listAdapter);
            } else {
                listAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void getnewGroup(NewGroupBean newGroupBean) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
