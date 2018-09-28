package com.wd.tech.bean;

import java.util.List;

/**
 * author:Created by YangYong on 2018/9/28 0028.
 */
public class JoinedGroup {

    /**
     * result : [{"blackFlag":0,"groupId":10011,"groupName":"农夫山泉","hxGroupId":"61550527315969","role":3}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * blackFlag : 0
         * groupId : 10011
         * groupName : 农夫山泉
         * hxGroupId : 61550527315969
         * role : 3
         */

        private int blackFlag;
        private int groupId;
        private String groupName;
        private String hxGroupId;
        private int role;

        public int getBlackFlag() {
            return blackFlag;
        }

        public void setBlackFlag(int blackFlag) {
            this.blackFlag = blackFlag;
        }

        public int getGroupId() {
            return groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public String getHxGroupId() {
            return hxGroupId;
        }

        public void setHxGroupId(String hxGroupId) {
            this.hxGroupId = hxGroupId;
        }

        public int getRole() {
            return role;
        }

        public void setRole(int role) {
            this.role = role;
        }
    }
}
