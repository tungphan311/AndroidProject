package com.example.tung.androidproject.util;

import com.example.tung.androidproject.model.Sanpham;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("timkiemsp.php")
    Call<ArrayList<Sanpham>> timkiemsp (@Query("key") String keyword);
}
