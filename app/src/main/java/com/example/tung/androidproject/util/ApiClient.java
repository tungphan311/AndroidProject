package com.example.tung.androidproject.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static String localhost = "10.0.135.91:8080";
    public static String API_URL = "http://" + localhost + "/server";
    public static String getLoaiSP_URL = "http://" + localhost + "/server/getloaisp.php";
    public static String getSPMoiNhat_URL = "http://" + localhost + "/server/getspmoinhat.php";
    public static String timkiem_URL = "http://"+ localhost + "/server/timkiemsp.php";
    public static Retrofit retrofit;
    public static Retrofit getApiClient(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(timkiem_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
