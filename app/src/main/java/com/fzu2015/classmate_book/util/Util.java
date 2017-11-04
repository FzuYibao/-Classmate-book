package com.fzu2015.classmate_book.util;

import com.fzu2015.classmate_book.bean.LoginBean;
import com.fzu2015.classmate_book.bean.MemberBean;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class Util {

    static String BASE_URL = "";

    //定义get
    public static String doGet(String u){
        HttpURLConnection con=null;
        InputStream is=null;
        StringBuilder sbd=new StringBuilder();
        try {
            URL url=new URL(u);
            con= (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5*1000);  //设置超时时间
            con.setReadTimeout(5*1000);     //设置读取时间
//	            con.setRequestMethod("GET");
            if(con.getResponseCode()==200){ //判断是否连接成功
                is=con.getInputStream();    //获取输入
                int next=0;
                byte[] bt=new byte[1024];
                while((next=is.read(bt))!=-1){
                    sbd.append(new String(bt),0,next);  //读入到sbd中
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(con!=null){
                con.disconnect();
            }
        }
        return sbd.toString();
    }

    //定义post
    public static String doPost(String uri,String args){
        HttpURLConnection httpURLConnection=null;
        InputStream is=null;
        StringBuilder sbd=new StringBuilder();
        try {
            URL url=new URL(uri);
            httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5*1000);
            httpURLConnection.setReadTimeout(5*1000);
            httpURLConnection.setRequestMethod("POST");
            //设置httpURLConnection可以请求的内容
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            //设置一些请求头的信息 field：http请求的请求头   newValue：请求头的值
            httpURLConnection.setRequestProperty("Charset","UTF-8");
            httpURLConnection.setRequestProperty("Content-type","application/x-www-form-urlencoded");
            //option=getUser&uName=jerehedu
            String params=args;
            //获取一个outputstream，并将内容写入该流
            OutputStream os=httpURLConnection.getOutputStream();
            os.write(params.getBytes());
            os.flush();
            os.close();

            if(httpURLConnection.getResponseCode()==200){
                is=httpURLConnection.getInputStream();
                int next=0;
                byte[] b=new byte[1024*10];
                while((next=is.read(b))>0){
                    sbd.append(new String(b,0,next));
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(is!=null){
                    is.close();
                }
                if(httpURLConnection!=null){
                    httpURLConnection.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sbd.toString();
    }

    //实现登陆
    public static LoginBean login(String account, String password){
        //初始化
        LoginBean loginbean = new LoginBean();

        //获得数据
        String url = BASE_URL + "/login";
        String args = account + "&" + password;
        String json_result = doPost(url, args);

        //解析
        try {
            JSONObject json_all = new JSONObject(json_result);
            loginbean.setState(json_all.getString("state"));
            loginbean.setReason(json_all.getString("reason"));
            loginbean.setOwer_name(json_all.getString("ower_name"));
            loginbean.setOwer_address(json_all.getString("ower_address"));
            loginbean.setOwer_phone(json_all.getString("ower_phone"));
            loginbean.setOwer_weichat(json_all.getString("ower_weichat"));
            loginbean.setOwer_email(json_all.getString("ower_email"));
            loginbean.setOwer_qq(json_all.getString("ower_qq"));
            loginbean.setOwer_personality(json_all.getString("ower_personality"));


        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return loginbean;
    }

    //实现获得所有member
    public static MemberBean getMembers(){
        //初始化
        MemberBean member_bean = new MemberBean();
        List<MemberBean.PersonsBean> persons_bean = new ArrayList<MemberBean.PersonsBean>();

        //获得数据
        String url = BASE_URL + "/getMembers";
        String json_string_result = doGet(url);

        //解析
        try {
            JSONObject json_all = new JSONObject(json_string_result);
            JSONArray members_list = json_all.getJSONArray("persons");
            for(int i=0;i<members_list.length();i++){
                JSONObject json_person = members_list.getJSONObject(i);

                MemberBean.PersonsBean person = new MemberBean.PersonsBean();
                person.setName(json_person.getString("name"));
                person.setAddress("address");
                person.setPhone("phone");
                person.setWeichat("weichat");
                person.setEmail("email");
                person.setQq("qq");
                person.setPersonality("personality");
                persons_bean.add(person);
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        member_bean.setPersons(persons_bean);
        return member_bean;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
