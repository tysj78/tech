package com.wd.tech;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.wd.tech.base.BaseActivity;
import com.wd.tech.base.BasePresenter;
import com.wd.tech.bean.PerfectUserInfoBean;
import com.wd.tech.mvp.user.presenter.PerfectUserInfoPresenter;
import com.wd.tech.mvp.user.view.IPerfectUserInfoView;
import com.wd.tech.util.SharedPreferencesUtils;
import com.wd.tech.util.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterThreeActivity extends BaseActivity implements IPerfectUserInfoView{


    @BindView(R.id.return1)
    ImageView return1;
    @BindView(R.id.sex)
    EditText sex;
    @BindView(R.id.birth)
    EditText birth;
    @BindView(R.id.qianmin)
    EditText qianmin;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.next)
    Button next;
    private PerfectUserInfoPresenter perfectUserInfoPresenter;
    private int sex1;
    private int userId;
    private String sessionId;
    private String nickName;

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        sex.setCursorVisible(false);
        sex.setFocusable(false);
        sex.setFocusableInTouchMode(false);
        birth.setCursorVisible(false);
        birth.setFocusable(false);
        birth.setFocusableInTouchMode(false);
    }

    @Override
    public BasePresenter providePresenter() {
        perfectUserInfoPresenter = new PerfectUserInfoPresenter(this);
        return perfectUserInfoPresenter;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_register_three;
    }

    @Override
    public void initDate() {
        userId = (int) SharedPreferencesUtils.getParam(this, "userId", 0);
        sessionId = (String) SharedPreferencesUtils.getParam(this, "sessionId", "");
        nickName = (String) SharedPreferencesUtils.getParam(this, "nickName", "");
    }


    @OnClick({R.id.return1, R.id.sex, R.id.birth, R.id.next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.return1:
                finish();
                break;
            case R.id.sex:
                AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this);
                final String[] arrayOfString1 = {  "男", "女"};

                localBuilder1.setSingleChoiceItems(arrayOfString1, 0, new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                    {
                        /**
                         * 操作
                         * */
                        sex.setText(arrayOfString1[paramAnonymousInt]);

                        paramAnonymousDialogInterface.dismiss();
                    }
                }).setCancelable(false).create().show();
                break;
            case R.id.birth:
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        System.out.println(String.format("%d/%d/%d",i,i1+1,i2));
                        birth.setText(String.format("%d/%d/%d",i,i1+1,i2));
                    }
                },2018,8,26).show();
                break;
            case R.id.next:
                if (sex.getText().toString().equals("男")){
                    sex1 = 1;
                }else {
                    sex1 = 2;
                }

                perfectUserInfoPresenter.perfectUserInfo(userId,sessionId,nickName,sex1,qianmin.getText().toString(),birth.getText().toString(),email.getText().toString());
                break;
        }
    }

    @Override
    public void getData(PerfectUserInfoBean bean) {
        Toast.makeText(this,bean.getMessage(),Toast.LENGTH_SHORT).show();
        if (bean.getMessage().equals("完善成功")){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}
