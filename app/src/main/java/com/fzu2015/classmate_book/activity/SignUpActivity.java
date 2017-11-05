package com.fzu2015.classmate_book.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fzu2015.classmate_book.R;
import com.fzu2015.classmate_book.util.NetworkUtil;

import okhttp3.OkHttpClient;

/**
 * Created by Maple27 on 2017/11/4.
 */

public class SignUpActivity extends AppCompatActivity {

    private EditText user;
    private EditText password;
    private EditText password_confirm;
    private EditText name;
    private EditText address;
    private EditText phone;
    private EditText email;
    private EditText wechat;
    private EditText QQ;
    private EditText personality;
    private Button signUp;
    private String user2;
    private String password2;
    private String password_confirm2;
    private String name2;
    private String address2;
    private String phone2;
    private String email2;
    private String wechat2;
    private String QQ2;
    private String personality2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();
    }

    public void init(){
        signUp = (Button) findViewById(R.id.signUp2);
        user = (EditText) findViewById(R.id.user_signUp);
        password = (EditText) findViewById(R.id.password_signUp);
        password_confirm = (EditText) findViewById(R.id.password_confirm_signUp);
        name = (EditText) findViewById(R.id.name_signUp);
        address = (EditText) findViewById(R.id.address_signUp);
        phone = (EditText) findViewById(R.id.phone_signUp);
        email = (EditText) findViewById(R.id.email_signUp);
        wechat = (EditText) findViewById(R.id.wechat_signUp);
        QQ = (EditText) findViewById(R.id.qq_signUp);
        personality = (EditText) findViewById(R.id.personality_signUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sendSignUpRequest();
                    }
                }).start();
            }
        });
    }

    public void sendSignUpRequest(){
        user2 = user.getText().toString();
        password2 = password.getText().toString();
        password_confirm2 = password_confirm.getText().toString();
        name2 = name.getText().toString();
        address2 = address.getText().toString();
        phone2 = phone.getText().toString();
        email2 = email.getText().toString();
        wechat2 = wechat.getText().toString();
        QQ2 = QQ.getText().toString();
        personality2 = personality.getText().toString();
        Log.d("ididid", user2);
        if(user2.equals("")||password2.equals("")||name2.equals("")){
            Looper.prepare();
            Toast.makeText(this, "用户名、密码、姓名不能为空", Toast.LENGTH_SHORT).show();
            Looper.loop();
        }else {
            NetworkUtil.SignUp(user2,password2,name2,address2,phone2,email2,wechat2,QQ2,personality2,this);
        }

    }

}
