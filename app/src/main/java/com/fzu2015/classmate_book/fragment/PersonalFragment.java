package com.fzu2015.classmate_book.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dou361.dialogui.listener.DialogUIListener;
import com.fzu2015.classmate_book.R;
import com.fzu2015.classmate_book.bean.MemberBean;
import com.fzu2015.classmate_book.bean.UserEntity;
import com.dou361.dialogui.*;
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

public class PersonalFragment extends Fragment {

    public static final String MAINURL = "https://yibao.fty-web.com/";
    public static final String LOGINURL = "auth/login";
    public static final String SIGNUPURL = "auth/register";
    public static final String MEMBERURL = "curd/selectAll";
    public static final String UPDATEURL = "curd/update";
    public static final String DELETEURL = "curd/delete";
    private UpdateTask task;
    private View view;
    private Button destroy;
    private TextView t_name;
    private TextView t_personality;
    private TextView t_address;
    private TextView t_phone;
    private TextView t_email;
    private TextView t_wechat;
    private TextView t_QQ;
    private String name;
    private String personality;
    private String address;
    private String phone;
    private String email;
    private String wechat;
    private String QQ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_personal , null);
        init(view);
        setListener();
        return view;
    }

    public void init(View view){
        task = new UpdateTask();
        destroy = (Button) view.findViewById(R.id.destroy);
        t_name = (TextView) view.findViewById(R.id.name);
        t_personality = (TextView) view.findViewById(R.id.personality);
        t_address = (TextView) view.findViewById(R.id.address);
        t_phone = (TextView) view.findViewById(R.id.phone);
        t_email = (TextView) view.findViewById(R.id.email);
        t_wechat = (TextView) view.findViewById(R.id.wechat);
        t_QQ = (TextView) view.findViewById(R.id.qq);
        name = UserEntity.getName();
        personality = UserEntity.getPersonality();
        address = UserEntity.getAddress();
        phone = UserEntity.getPhone();
        email = UserEntity.getEmail();
        wechat = UserEntity.getWechat();
        QQ = UserEntity.getQQ();
        t_name.setText(name);
        t_personality.setText(personality);
        t_address.setText(address);
        t_phone.setText(phone);
        t_email.setText(email);
        t_wechat.setText(wechat);
        t_QQ.setText(QQ);
    }

    public void setListener(){
        final View view1 = view;
        destroy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        NetworkUtil.Delete();
                    }
                }).start();
            }
        });
        t_personality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUIUtils.showAlertInput(getActivity(), "更改个性签名", "请输入新信息", "确认新信息", "确定", "取消", new DialogUIListener() {
                    @Override
                    public void onPositive() {

                    }

                    @Override
                    public void onNegative() {

                    }

                    @Override
                    public void onGetInput(CharSequence input1, CharSequence input2) {
                        final String str = input1.toString();
                        task.execute(view1, "personality", str);
                    }
                }).show();
            }
        });
        t_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUIUtils.showAlertInput(getActivity(), "更改电话", "请输入新电话", "确认新电话", "确定", "取消", new DialogUIListener() {
                    @Override
                    public void onPositive() {

                    }

                    @Override
                    public void onNegative() {

                    }

                    @Override
                    public void onGetInput(CharSequence input1, CharSequence input2) {
                        final String str = input1.toString();
                        task.execute(view1,"phone", str);
                    }
                }).show();
            }
        });
        t_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUIUtils.showAlertInput(getActivity(), "更改地址", "请输入新地址", "确认新地址", "确定", "取消", new DialogUIListener() {
                    @Override
                    public void onPositive() {

                    }

                    @Override
                    public void onNegative() {

                    }

                    @Override
                    public void onGetInput(CharSequence input1, CharSequence input2) {
                        final String str = input1.toString();
                        task.execute(view1,"address", str);
                    }
                }).show();
            }
        });
        t_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUIUtils.showAlertInput(getActivity(), "更改邮箱", "请输入新邮箱", "确认新邮箱", "确定", "取消", new DialogUIListener() {
                    @Override
                    public void onPositive() {

                    }

                    @Override
                    public void onNegative() {

                    }

                    @Override
                    public void onGetInput(CharSequence input1, CharSequence input2) {
                        final String str = input1.toString();
                        task.execute(view1,"email", str);
                    }
                }).show();
            }
        });
        t_wechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUIUtils.showAlertInput(getActivity(), "更改微信", "请输入新微信", "确认新微信", "确定", "取消", new DialogUIListener() {
                    @Override
                    public void onPositive() {

                    }

                    @Override
                    public void onNegative() {

                    }

                    @Override
                    public void onGetInput(CharSequence input1, CharSequence input2) {
                        final String str = input1.toString();
                        task.execute(view1,"weichat", str);

                    }
                }).show();
            }
        });
        t_QQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUIUtils.showAlertInput(getActivity(), "更改QQ", "请输入新QQ", "确认新QQ", "确定", "取消", new DialogUIListener() {
                    @Override
                    public void onPositive() {

                    }

                    @Override
                    public void onNegative() {

                    }

                    @Override
                    public void onGetInput(CharSequence input1, CharSequence input2) {
                        final String str = input1.toString();
                        task.execute(view1,"qq", str);
                    }
                }).show();
            }
        });
    }

    private class UpdateTask extends AsyncTask<Object , Object , String> {

        private View view;
        private String category;
        private String data;

        @Override
        protected String doInBackground(Object... objects) {
            view = (View) objects[0];
            category = (String) objects[1];
            data = (String) objects[2];
            String result;
            OkHttpClient okHttpClient = new OkHttpClient();
            Response response;
            RequestBody requestBody = null;
            requestBody = new FormBody.Builder()
                    .add("id", UserEntity.getId())
                    .add("token", UserEntity.getToken())
                    .add("name", UserEntity.getName())
                    .add("phone", UserEntity.getPhone())
                    .add("address", UserEntity.getAddress())
                    .add("email", UserEntity.getEmail())
                    .add("weichat", UserEntity.getWechat())
                    .add("qq", UserEntity.getQQ())
                    .add(category, data)
                    .build();
            Request request = new Request.Builder()
                    .url(MAINURL+UPDATEURL)
                    .post(requestBody)
                    .build();
            try {
                response = okHttpClient.newCall(request).execute();
                result = new String(response.body().bytes());
                Log.d("update", result);
                return result;
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            switch (category){
                case "personality":UserEntity.setPersonality(data);break;
                case "address":UserEntity.setAddress(data);break;
                case "phone":UserEntity.setPhone(data);break;
                case "email":UserEntity.setEmail(data);break;
                case "weichat":UserEntity.setWechat(data);break;
                case "qq":UserEntity.setQQ(data);
            }
            Toast.makeText(view.getContext(), "更新成功", Toast.LENGTH_SHORT).show();
            init(view);
        }
    }




}
