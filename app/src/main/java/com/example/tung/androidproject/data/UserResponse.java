package com.example.tung.androidproject.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {

    @SerializedName("user")
    @Expose
    public List<User> users = null;

    @SerializedName("success")
    @Expose
    public Integer success;

    @SerializedName("message")
    @Expose
    public String message;

    public List<User> getUsers() {
        return users;
    }

    public Integer getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
