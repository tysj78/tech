package com.wd.tech.mvp.group.mvp.model;

import com.wd.tech.bean.JoinedGroup;
import com.wd.tech.mvp.group.mvp.model.bean.NewGroupBean;

/**
 * author:Created by YangYong on 2018/9/28 0028.
 */
public interface GroupChatCallBack {
    void getJoinedGroup(JoinedGroup joinedGroup);


    void getnewGroup(NewGroupBean newGroupBean);

}
