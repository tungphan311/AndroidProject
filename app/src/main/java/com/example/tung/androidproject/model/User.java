package com.example.tung.androidproject.model;

import java.io.Serializable;

public class User implements Serializable {

    public int mauser;
    public String sodienthoai;
    public String matkhau;

    public User(int mauser, String sodienthoai, String matkhau) {
        this.mauser = mauser;
        this.sodienthoai = sodienthoai;
        this.matkhau = matkhau;
    }

    public int getMauser() {
        return mauser;
    }

    public void setMauser(int mauser) {
        this.mauser = mauser;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
