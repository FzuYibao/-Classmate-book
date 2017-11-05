package com.fzu2015.classmate_book.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fzu2015.classmate_book.R;
import com.fzu2015.classmate_book.bean.LoginBean;
import com.fzu2015.classmate_book.bean.UserEntity;
import com.fzu2015.classmate_book.util.NetworkUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Maple27 on 2017/11/4.
 */

public class LoginActivity extends AppCompatActivity {

    private String token;
    private Button login;
    private TextView signUp;
    private EditText username;
    private EditText password;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    public void initViews(){
        login = (Button) findViewById(R.id.login);
        signUp = (TextView) findViewById(R.id.signUp1);
        username = (EditText) findViewById(R.id.userName_login);
        password = (EditText) findViewById(R.id.password_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username2 = username.getText().toString();
                final String password2 = password.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String result = NetworkUtil.Login(username2, password2);
                        Gson gson = new Gson();
                        Type type = new TypeToken<LoginBean>(){}.getType();
                        LoginBean loginBean = gson.fromJson(result , type);
                        handler.obtainMessage(0 , loginBean).sendToTarget();
                    }
                }).start();

                /*Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);*/
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    final Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 0){
                final LoginBean loginBean = (LoginBean) msg.obj;
                if(loginBean.getState().equals("1")){
                    pref = getSharedPreferences("userData" , MODE_PRIVATE);
                    editor = pref.edit();
                    editor.putString("token" , loginBean.getToken());
                    editor.commit();
                    UserEntity.setId(loginBean.getId());
                    UserEntity.setToken(loginBean.getToken());
                    UserEntity.setName(loginBean.getOwer_name());
                    UserEntity.setAddress(loginBean.getOwer_address());
                    UserEntity.setPhone(loginBean.getOwer_phone());
                    UserEntity.setEmail(loginBean.getOwer_email());
                    UserEntity.setWechat(loginBean.getOwer_weichat());
                    UserEntity.setQQ(loginBean.getOwer_qq());
                    UserEntity.setPersonality(loginBean.getOwer_personality());
                    Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    setContentView(R.layout.activity_login);
                    initViews();
                }
            }
        }
    };

}
