package com.wd.tech.mvp.group.mvp.presenter;

import com.wd.tech.base.BasePresenter;
import com.wd.tech.bean.JoinedGroup;
import com.wd.tech.mvp.group.mvp.model.GroupChatCallBack;
import com.wd.tech.mvp.group.mvp.model.GroupChatModel;
import com.wd.tech.mvp.group.mvp.view.GroupChatView;

import java.lang.ref.WeakReference;

/**
 * author:Created by YangYong on 2018/9/28 0028.
 */
public class GroupChatPresenter extends BasePresenter<GroupChatModel, GroupChatView> {
    public GroupChatPresenter(GroupChatView view) {
        super(view);
    }

    @Override
    protected WeakReference<GroupChatView> getWeak() {
        return new WeakReference(view);
    }

    @Override
    protected GroupChatModel initModel() {
        return new GroupChatModel();
    }

    public void getJoinedGroup(int userId, String sessionId) {
        model.getJoinedGroup(userId, sessionId, new GroupChatCallBack() {
            @Override
            public void getJoinedGroup(JoinedGroup joinedGroup) {
                view.getJoinedGroup(joinedGroup);
            }
        });
    }
}
