package com.wd.tech.bean;

public class LoginBean {

    /**
     * result : {"nickName":"徐云杰","phone":"18600151568","pwd":"R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=","sessionId":"15372410025241007","userId":1007,"userName":"4Vg15Z18600151568","whetherVip":2}
     * message : 登录成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * nickName : 徐云杰
         * phone : 18600151568
         * pwd : R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=
         * sessionId : 15372410025241007
         * userId : 1007
         * userName : 4Vg15Z18600151568
         * whetherVip : 2
         */

        private String nickName;
        private String phone;
        private String pwd;
        private String sessionId;
        private int userId;
        private String userName;
        private int whetherVip;

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getWhetherVip() {
            return whetherVip;
        }

        public void setWhetherVip(int whetherVip) {
            this.whetherVip = whetherVip;
        }
    }
}
