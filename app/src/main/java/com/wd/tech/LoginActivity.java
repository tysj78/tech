package com.wd.tech;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.tech.base.BaseActivity;
import com.wd.tech.bean.GetUserInfoByUserIdBean;
import com.wd.tech.bean.LoginBean;
import com.wd.tech.mvp.user.presenter.GetUserInfoByUserIdPresenter;
import com.wd.tech.mvp.user.presenter.LoginPresenter;
import com.wd.tech.mvp.user.view.IGetUserInfoByUserIdView;
import com.wd.tech.mvp.user.view.LoginView;
import com.wd.tech.util.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView,IGetUserInfoByUserIdView {


    @BindView(R.id.title)
    RelativeLayout title;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.login_qq)
    ImageView loginQq;
    @BindView(R.id.login_wx)
    ImageView loginWx;
    @BindView(R.id.login_sina)
    ImageView loginSina;
    @BindView(R.id.login_linear)
    LinearLayout loginLinear;
    private LoginPresenter loginPresenter;

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public LoginPresenter providePresenter() {
        loginPresenter = new LoginPresenter(this);
        return loginPresenter;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initDate() {

    }

    @OnClick({R.id.login, R.id.register, R.id.login_qq, R.id.login_wx, R.id.login_sina})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login:
                if (username.getText().toString()!=""&&password.getText().toString()!=""){
                        loginPresenter.initNetWork(username.getText().toString(),password.getText().toString());
                }
                break;
            case R.id.register:
                Intent intent=new Intent(this,RegisterAvtivity.class);
                startActivity(intent);
                break;
            case R.id.login_qq:
                break;
            case R.id.login_wx:
                break;
            case R.id.login_sina:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (username.getText().toString()==""&&password.getText().toString()==""){
            login.setEnabled(false);
        }else {
            login.setEnabled(true);
        }
    }

    @Override
    public void getData(LoginBean loginBean) {
        LoginBean.ResultBean result = loginBean.getResult();
        String sessionId = result.getSessionId();
        int userId = result.getUserId();
        String nickName = result.getNickName();
        String pwd = result.getPwd();
        SharedPreferencesUtils.setParam(this,"userId",userId);
        SharedPreferencesUtils.setParam(this,"sessionId",sessionId);
        SharedPreferencesUtils.setParam(this,"nickName",nickName);

        Toast.makeText(this,loginBean.getMessage(),Toast.LENGTH_SHORT).show();
        if (loginBean.getMessage().equals("登录成功")) {
            GetUserInfoByUserIdPresenter presenter=new GetUserInfoByUserIdPresenter(this);
            presenter.getUserInfoByUserId(userId,sessionId);
        }else {
            Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getData(GetUserInfoByUserIdBean Bean) {
        GetUserInfoByUserIdBean.ResultBean result = Bean.getResult();
        if (result.getSex()==0){
            Intent intent=new Intent(this,RegisterThreeActivity.class);
            startActivity(intent);
        }else {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}
