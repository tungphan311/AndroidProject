package com.example.tung.androidproject.data;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;

public class User {
    @SerializedName("mauser")
    @Expose
    public String mauser;

    @SerializedName("hovaten")
    @Expose
    public String hovaten;

    @SerializedName("diachi")
    @Expose
    public String diachi;

    @SerializedName("email")
    @Expose
    public String email;


    @SerializedName("sodienthoai")
    @Expose
    public String sodienthoai;

    @SerializedName("matkhau")
    @Expose
    public String matkhau;

    public String getMauser() {
        return mauser;
    }
    public String getHovaten() {return hovaten;}

    public String getDiachi() {
        return diachi;
    }

    public String getEmail() {return email;}
    public String getSodienthoai() {return  sodienthoai;}

    public String getMatkhau() {
        return matkhau;
    }
}
