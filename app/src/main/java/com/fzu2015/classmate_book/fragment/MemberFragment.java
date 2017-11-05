package com.fzu2015.classmate_book.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.fzu2015.classmate_book.R;
import com.fzu2015.classmate_book.adapter.MemberAdapter;
import com.fzu2015.classmate_book.bean.MemberBean;
import com.fzu2015.classmate_book.bean.UserEntity;
import com.fzu2015.classmate_book.util.NetworkUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Maple27 on 2017/11/4.
 */

public class MemberFragment extends Fragment {

    public static final String MAINURL = "https://yibao.fty-web.com/";
    public static final String LOGINURL = "auth/login";
    public static final String SIGNUPURL = "auth/register";
    public static final String MEMBERURL = "curd/selectAll";
    public static final String UPDATEURL = "curd/update";
    private Context context;
    private Button export;
    private MemberAdapter adapter;
    private MemberBean memberBean;
    private ListView lv;
    private GetInitDataTask task;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_member , container , false);
        task = new GetInitDataTask();
        task.execute(view);
        return view;
    }

    public void init(View view){
        context = this.getContext();
        export = (Button) view.findViewById(R.id.export);
        lv = (ListView) view.findViewById(R.id.lv);
        View headView = getLayoutInflater(new Bundle()).inflate(R.layout.listview_header, null);
        lv.addHeaderView(headView);
        adapter = new MemberAdapter(context, lv, memberBean);
        lv.setAdapter(adapter);
        setListViewHeightBasedOnChildren(lv);
        export.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("https://yibao.fty-web.com/Excel_export");
                intent.setData(content_url);
                startActivity(intent);
            }
        });
    }

    //异步加载数据
    private class GetInitDataTask extends AsyncTask<Object , Object , String> {

        private View view;

        @Override
        protected String doInBackground(Object... objects) {
            view = (View) objects[0];
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormBody.Builder()
                    .build();
            Request request = new Request.Builder()
                    .url(MAINURL+MEMBERURL)
                    .post(requestBody)
                    .build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                String result = new String(response.body().bytes());
                Log.d("member" , result);
                return result;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            Gson gson = new Gson();
            Type type = new TypeToken<MemberBean>(){}.getType();
            memberBean = gson.fromJson(s , type);
            init(view);
        }
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {

        // 获取ListView对应的Adapter

        ListAdapter listAdapter = listView.getAdapter();

        if (listAdapter == null) {

            return;

        }

        int totalHeight = 0;

        for (int i = 0; i < listAdapter.getCount(); i++) { // listAdapter.getCount()返回数据项的数目

            View listItem = listAdapter.getView(i, null, listView);

            listItem.measure(0, 0); // 计算子项View 的宽高

            totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度

        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));

        // listView.getDividerHeight()获取子项间分隔符占用的高度

        // params.height最后得到整个ListView完整显示需要的高度

        listView.setLayoutParams(params);

    }
}
