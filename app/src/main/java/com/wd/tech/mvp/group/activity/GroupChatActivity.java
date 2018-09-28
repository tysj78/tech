package com.wd.tech.mvp.group.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wd.tech.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GroupChatActivity extends AppCompatActivity {

    @BindView(R.id.groupchat_creategroup)
    TextView groupchatCreategroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.groupchat_creategroup)
    public void onViewClicked() {
        //跳转到创建群聊页面

        Intent intent=new Intent(this,New_GroupActivity.class);
        startActivity(intent);
    }
}
