package com.wd.tech;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.wd.tech.base.BaseActivity;
import com.wd.tech.bean.RegisterUserBean;
import com.wd.tech.mvp.user.presenter.RegisterPresenter;
import com.wd.tech.mvp.user.view.IRegisterView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterAvtivity extends BaseActivity<RegisterPresenter> implements IRegisterView {


    @BindView(R.id.return1)
    ImageView return1;
    @BindView(R.id.nickname)
    EditText nickname;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.register)
    Button register;
    private RegisterPresenter registerPresenter;

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    public RegisterPresenter providePresenter() {
        registerPresenter = new RegisterPresenter(this);
        return registerPresenter;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_register_avtivity;
    }

    @Override
    public void initDate() {

    }


    @OnClick({R.id.return1, R.id.register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.return1:
                finish();
                break;
            case R.id.register:
                registerPresenter = new RegisterPresenter(this);
                if (phone.getText().toString()!=""&&nickname.getText().toString()!=""&&password.getText().toString()!="") {
                    if (password.getText().length()<6){
                        Toast.makeText(this,"密码长度不够",Toast.LENGTH_SHORT).show();
                    }else {
                        registerPresenter.findRegisterModelList(phone.getText().toString(), nickname.getText().toString(), password.getText().toString());
                    }
                }else {
                    if (phone.getText().toString()==""){
                        Toast.makeText(this,"手机号不能为空",Toast.LENGTH_SHORT).show();
                    }else if (nickname.getText().toString()==""){
                        Toast.makeText(this,"昵称不能为空",Toast.LENGTH_SHORT).show();
                    }else if (password.getText().toString()==""){
                        Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    @Override
    public void getData(RegisterUserBean registerUserBean) {
        String message = registerUserBean.getMessage();
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        if (message.equals("注册成功")){
            finish();
        }
    }
}
