package com.fzu2015.classmate_book.bean;

/**
 * Created by Maple27 on 2017/11/4.
 */

public class UserEntity {

    private static String id;
    private static String token;
    private static String name;
    private static String address;
    private static String phone;
    private static String email;
    private static String wechat;
    private static String QQ;
    private static String personality;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        UserEntity.id = id;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        UserEntity.token = token;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        UserEntity.name = name;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        UserEntity.address = address;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        UserEntity.phone = phone;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserEntity.email = email;
    }

    public static String getWechat() {
        return wechat;
    }

    public static void setWechat(String wechat) {
        UserEntity.wechat = wechat;
    }

    public static String getQQ() {
        return QQ;
    }

    public static void setQQ(String QQ) {
        UserEntity.QQ = QQ;
    }

    public static String getPersonality() {
        return personality;
    }

    public static void setPersonality(String personality) {
        UserEntity.personality = personality;
    }
}
