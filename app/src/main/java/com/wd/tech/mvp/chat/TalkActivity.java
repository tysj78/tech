package com.wd.tech.mvp.chat;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.hyphenate.EMCallBack;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMTextMessageBody;
import com.wd.tech.R;
import com.wd.tech.mvp.chat.apdate.MsgAdapter;
import com.wd.tech.mvp.chat.bean.Msg;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TalkActivity extends Activity implements EMMessageListener  {

    @BindView(R.id.add_fanhui)
    ImageView addFanhui;
    @BindView(R.id.msg)
    RecyclerView msg;
    @BindView(R.id.input)
    EditText input;
    @BindView(R.id.send)
    Button send;
    private List<Msg> msgList = new ArrayList<>();
    private EMMessageListener msgListener;
    private MsgAdapter adapter;
 Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msgg) {
            super.handleMessage(msgg);
            EMMessage message = (EMMessage) msgg.obj;
            // 这里只是简单的demo，也只是测试文字消息的收发，所以直接将body转为EMTextMessageBody去获取内容
            EMTextMessageBody body = (EMTextMessageBody) message.getBody();
            // 将新的消息内容和时间加入到下边

            String name=   body.getMessage();
            Log.i("TAG",name+"sad");
            msgList.add(new Msg(name,Msg.TYPE.RECEIVED));
            int newSize = msgList.size() - 1;
            adapter.notifyItemInserted(newSize);
            msg.scrollToPosition(newSize);

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);
        ButterKnife.bind(this);
        init();
        msgListener=this;
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        msg.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msg.setAdapter(adapter);
       new Thread(new Runnable() {
            @Override
            public void run() {
                EMClient.getInstance().login("18732093731", "123123", new EMCallBack() {//回调
                    @Override
                    public void onSuccess() {
                        EMClient.getInstance().groupManager().loadAllGroups();
                        EMClient.getInstance().chatManager().loadAllConversations();
                        Log.i("TAG", "登录聊天服务器成功！");
                    }

                    @Override
                    public void onProgress(int progress, String status) {

                    }

                    @Override
                    public void onError(int code, String message) {
                        Log.i("TAG", "登录聊天服务器失败！"+message);
                    }
                });
            }
        }).start();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=input.getText().toString();
                msgList.add(new Msg(content,Msg.TYPE.SENT));
                int newSize = msgList.size() - 1;
                adapter.notifyItemInserted(newSize);
                msg.scrollToPosition(newSize);

                //清空输入框中的内容
                input.setText("");

            }
        });
    }

    private void init() {
        msgList.add(new Msg("你好111111111111111112131231231231211111111111111111", Msg.TYPE.RECEIVED));
        msgList.add(new Msg("你好，请问你好？", Msg.TYPE.SENT));
        msgList.add(new Msg("我是 deniro，很高兴认识你^_^", Msg.TYPE.RECEIVED));
        msgList.add(new Msg("我是 石争鑫，很高兴认识你^_^", Msg.TYPE.RECEIVED));
        msgList.add(new Msg("我是 石培鑫，很高兴认识你^_^", Msg.TYPE.RECEIVED));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EMClient.getInstance().chatManager().removeMessageListener(msgListener);
    }
    @Override
    protected void onResume() {
        super.onResume();
        EMClient.getInstance().chatManager().addMessageListener(msgListener);
    }
    @Override
    public void onMessageReceived(List<EMMessage> list) {
        for (EMMessage message : list) {
            Log.i("TAG", "收到新消息:" + message);

            // 设置消息为已读

            // 因为消息监听回调这里是非ui线程，所以要用handler去更新ui
            Message msg = handler.obtainMessage();
            msg.what = 0;
            msg.obj = message;
            handler.sendMessage(msg);

        }
    }

    @Override
    public void onCmdMessageReceived(List<EMMessage> messages) {

    }

    @Override
    public void onMessageRead(List<EMMessage> messages) {

    }

    @Override
    public void onMessageDelivered(List<EMMessage> messages) {

    }

    @Override
    public void onMessageChanged(EMMessage message, Object change) {

    }
}
