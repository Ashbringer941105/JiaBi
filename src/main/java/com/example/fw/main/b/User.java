package com.example.fw.main.b;

import com.example.fw.base.BaseEN;

public class User extends BaseEN {
    private Long id;
    private String uname;
    private String pwd;
    private String ex;//用户等级，钱袋等级
    private String nickname;
    private String jiabi_suname;//上级账号，假币差错上级
    private String qiandai_suname;//上级账号，钱袋上级

    public String getJiabi_suname() {
        return jiabi_suname;
    }

    public void setJiabi_suname(String jiabi_suname) {
        this.jiabi_suname = jiabi_suname;
    }

    public String getQiandai_suname() {
        return qiandai_suname;
    }

    public void setQiandai_suname(String qiandai_suname) {
        this.qiandai_suname = qiandai_suname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
