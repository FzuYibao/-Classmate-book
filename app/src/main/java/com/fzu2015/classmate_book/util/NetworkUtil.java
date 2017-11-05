package com.fzu2015.classmate_book.util;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fzu2015.classmate_book.activity.LoginActivity;
import com.fzu2015.classmate_book.activity.MainActivity;
import com.fzu2015.classmate_book.activity.SignUpActivity;
import com.fzu2015.classmate_book.bean.LoginBean;
import com.fzu2015.classmate_book.bean.UserEntity;
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

public class NetworkUtil {

    public static final String MAINURL = "https://yibao.fty-web.com/";
    public static final String LOGINURL = "auth/login";
    public static final String SIGNUPURL = "auth/register";
    public static final String MEMBERURL = "curd/selectAll";
    public static final String UPDATEURL = "curd/update";
    public static final String DELETEURL = "curd/delete";

    public static String Login(String username, String password){
        String result;
        OkHttpClient okHttpClient = new OkHttpClient();
        Response response;
        RequestBody requestBody = null;
        requestBody = new FormBody.Builder()
                .add("id" , username)
                .add("password" , password)
                .build();
        Request request = new Request.Builder()
                .url(MAINURL+LOGINURL)
                .post(requestBody)
                .build();
        try {
            response = okHttpClient.newCall(request).execute();
            result = new String(response.body().bytes());
            Log.d("login", result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

    public static String TokenLogin(String token){
        String result;
        OkHttpClient okHttpClient = new OkHttpClient();
        Response response;
        RequestBody requestBody = null;
        requestBody = new FormBody.Builder()
                .add("token" , token)
                .build();
        Request request = new Request.Builder()
                .url(MAINURL+LOGINURL)
                .post(requestBody)
                .build();
        try {
            response = okHttpClient.newCall(request).execute();
            result = new String(response.body().bytes());
            Log.d("login", result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

    public static String SignUp(String username, String password, String name, String address,
                                String phone, String email, String wechat, String QQ, String personality, AppCompatActivity activity){
        String result;
        OkHttpClient okHttpClient = new OkHttpClient();
        Response response;
        RequestBody requestBody = null;
        requestBody = new FormBody.Builder()
                .add("id", username)
                .add("name" , name)
                .add("password" , password)
                .add("address", address)
                .add("phone", phone)
                .add("weichat", wechat)
                .add("qq", QQ)
                .add("email", email)
                .add("personality", personality)
                .build();
        Request request = new Request.Builder()
                .url(MAINURL+SIGNUPURL)
                .post(requestBody)
                .build();
        try {
            response = okHttpClient.newCall(request).execute();
            result = new String(response.body().bytes());
            Log.d("signUp", result);
            Gson gson = new Gson();
            Type type = new TypeToken<LoginBean>(){}.getType();
            LoginBean bean = gson.fromJson(result , type);
            UserEntity.setToken(bean.getToken());
            Intent intent =new Intent(activity,LoginActivity.class);
            activity.startActivity(intent);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

    }


    public static String Delete(){
        String result;
        OkHttpClient okHttpClient = new OkHttpClient();
        Response response;
        RequestBody requestBody = null;
        requestBody = new FormBody.Builder()
                .add("id", UserEntity.getId())
                .build();
        Request request = new Request.Builder()
                .url(MAINURL+DELETEURL)
                .post(requestBody)
                .build();
        try {
            response = okHttpClient.newCall(request).execute();
            result = new String(response.body().bytes());
            Log.d("delete", result);
            android.os.Process.killProcess(android.os.Process.myPid());
            //Gson gson = new Gson();
            //Type type = new TypeToken<LoginBean>(){}.getType();
            //LoginBean bean = gson.fromJson(result , type);
            //UserEntity.setToken(bean.getToken());
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

    //https://yibao.fty-web.com/Excel_export
    public static void Export(){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://yibao.fty-web.com/Excel_export")
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
