package com.fzu2015.classmate_book.bean;

import java.util.List;

/**
 * Created by Maple27 on 2017/11/4.
 */

public class MemberBean {


    private List<PersonsBean> persons;

    public List<PersonsBean> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonsBean> persons) {
        this.persons = persons;
    }

    public static class PersonsBean {
        /**
         * id :
         * name : 1111
         * address : null
         * phone : null
         * weichat : null
         * email : null
         * qq : null
         * personality : null
         * password : d41d8cd98f00b204e9800998ecf8427e
         */

        private String id;
        private String name;
        private String address;
        private String phone;
        private String weichat;
        private String email;
        private String qq;
        private String personality;
        private String password;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getWeichat() {
            return weichat;
        }

        public void setWeichat(String weichat) {
            this.weichat = weichat;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getPersonality() {
            return personality;
        }

        public void setPersonality(String personality) {
            this.personality = personality;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
