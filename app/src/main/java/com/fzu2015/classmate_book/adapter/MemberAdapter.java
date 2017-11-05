package com.fzu2015.classmate_book.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.fzu2015.classmate_book.R;
import com.fzu2015.classmate_book.bean.MemberBean;
import com.fzu2015.classmate_book.view.CircleImageView;

/**
 * Created by Maple27 on 2017/11/4.
 */

public class MemberAdapter extends BaseAdapter{

    private LayoutInflater inflater;
    private MemberBean memberBean;
    private ListView listView;

    public MemberAdapter(Context context, ListView listView, MemberBean memberBean) {
        super();
        inflater = LayoutInflater.from(context);
        this.memberBean = memberBean;
        this.listView = listView;
    }

    @Override
    public int getCount() {
        return memberBean.getPersons().size();
    }

    @Override
    public Object getItem(int i) {
        return listView.getItemAtPosition(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        View newView;
        if(view == null){
            viewHolder = new ViewHolder();
            newView = inflater.inflate(R.layout.listitem_info, null);
            viewHolder.name = (TextView) newView.findViewById(R.id.lv_name);
            viewHolder.phone = (TextView) newView.findViewById(R.id.lv_phone);
            viewHolder.wechat = (TextView) newView.findViewById(R.id.lv_wechat);
            newView.setTag(viewHolder);
        }else{
            newView = view;
            viewHolder = (ViewHolder) newView.getTag();
        }
        initViews(viewHolder , i);
        return newView;
    }

    public void initViews(ViewHolder viewHolder, int i){
        viewHolder.name.setText(memberBean.getPersons().get(i).getName());
        viewHolder.phone.setText(memberBean.getPersons().get(i).getPhone());
        viewHolder.wechat.setText(memberBean.getPersons().get(i).getWeichat());
    }

    static class ViewHolder{
        private TextView name;
        private TextView phone;
        private TextView wechat;
    }
}
