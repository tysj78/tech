package com.wd.tech.mvp.group.activity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.wd.tech.R;
import com.wd.tech.adapter.PhoneContactsAdapter;
import com.wd.tech.bean.Contacts;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhoneContactsActivity extends AppCompatActivity {

    @BindView(R.id.phonecontacts_rv)
    RecyclerView phonecontactsRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_contacts);
        ButterKnife.bind(this);
        initPhoneContacts();
    }

    private void initPhoneContacts() {
        List<Contacts> list = new ArrayList<>();
        //得到内容解析器
        ContentResolver contentResolver = getContentResolver();
        Uri raw_uri = Uri.parse("content://com.android.contacts/raw_contacts");
        Uri data_uri = Uri.parse("content://com.android.contacts/data");
        //查询组的数据
        Cursor query = contentResolver.query(raw_uri, null, null, null, null);
        while (query.moveToNext()) {
            //创建对象
            Contacts contacts = new Contacts();
            //得到组里的ID
            String _id = query.getString(query.getColumnIndex("_id"));
            //根据组查询该组的信息
            Cursor query2 = contentResolver.query(data_uri, null, "raw_contact_id = ?", new String[]{_id}, null);
            while (query2.moveToNext()) {

                String data = query2.getString(query2.getColumnIndex("data1"));
                String mimetype = query2.getString(query2.getColumnIndex("mimetype"));
                //通过mimetype筛选取出来的信息
                if (mimetype.equals("vnd.android.cursor.item/phone_v2")) {
                    Log.i("TAG", "电话：" + data);
                    contacts.setPhone(data);
                } else if (mimetype.equals("vnd.android.cursor.item/email_v2")) {
                    Log.i("TAG", "邮箱：" + data);
                    contacts.setEmail(data);
                } else if (mimetype.equals("vnd.android.cursor.item/name")) {
                    Log.i("TAG", "姓名：" + data);
                    contacts.setName(data);
                }
            }
            //一次内层循环结束，将赋值好的对象，添加到集合
            list.add(contacts);
        }
        //初始化联系人列表
        initContactsList(list);
    }

    private void initContactsList(List<Contacts> list) {
        phonecontactsRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        PhoneContactsAdapter adapter = new PhoneContactsAdapter(list);
        phonecontactsRv.setAdapter(adapter);
    }
}
