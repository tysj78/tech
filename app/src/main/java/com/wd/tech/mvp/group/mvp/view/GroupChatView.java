package com.wd.tech.mvp.group.mvp.view;

import com.wd.tech.base.BaseView;
import com.wd.tech.bean.JoinedGroup;
import com.wd.tech.mvp.group.mvp.model.bean.NewGroupBean;

/**
 * author:Created by YangYong on 2018/9/28 0028.
 */
public interface GroupChatView extends BaseView {
    void getJoinedGroup(JoinedGroup joinedGroup);

    void getnewGroup(NewGroupBean newGroupBean);

}
