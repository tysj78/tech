package com.wd.tech.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.tech.R;
import com.wd.tech.bean.Contacts;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author:Created by YangYong on 2018/9/27 0027.
 */
public class PhoneContactsAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Contacts> list;
    private String path = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1538040897734&di=67dbd135b37ece589dd837bf9ef8f0d6&imgtype=0&src=http%3A%2F%2Fgss1.bdstatic.com%2F9vo3dSag_xI4khGkpoWK1HF6hhy%2Fbaike%2Fs%3D220%2Fsign%3D08822efe5bee3d6d26c680c973176d41%2Fc75c10385343fbf2ebae9b7ab27eca8064388fec.jpg";

    public PhoneContactsAdapter(List<Contacts> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.phone_contacts_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Contacts contacts = list.get(position);
        viewHolder.phoneContactsItemImg.setImageURI(Uri.parse(path));
        viewHolder.phoneContactsItemName.setText(contacts.getName());
        viewHolder.phoneContactsItemPhone.setText(contacts.getPhone());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.phone_contacts_item_img)
        SimpleDraweeView phoneContactsItemImg;
        @BindView(R.id.phone_contacts_item_name)
        TextView phoneContactsItemName;
        @BindView(R.id.phone_contacts_item_phone)
        TextView phoneContactsItemPhone;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
