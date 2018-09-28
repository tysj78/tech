package com.wd.tech.mvp.group;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wd.tech.R;
import com.wd.tech.mvp.group.activity.AddActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * author:Created by YangYong on 2018/9/24 0024.
 */
public class ContactsFragment extends Fragment {
//    @BindView(R.id.contacts_group)
//    TextView contactsGroup;
//    @BindView(R.id.contacts_elv)
//    ExpandableListView contactsElv;
    Unbinder unbinder;
    @BindView(R.id.contacts_add)
    TextView contactsAdd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contacts_fg, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.contacts_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.contacts_add:
                startActivity(new Intent(getActivity(), AddActivity.class));
                break;
//            case R.id.contacts_group:
//                break;
        }
    }
}
