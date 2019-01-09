package com.example.tung.androidproject.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Constran {

    public static final int REQUEST_CODE_DANGNHAP = 100;
    public static final int RESULT_CODE_DANGNHAP = 99;

    public static final int REQUEST_CODE_ME_DANGNHAP = 151;
    public static final int RESULT_CODE_ME_DANGNHAP = 152;
    public static final String KEY_ME_DANGNHAP = "me_dangnhap";

    public static String localhost = "10.0.133.201:8080";
    public static String API_URL = "http://" + localhost + "/server/";
    public static String getLoaiSP_URL = "http://" + localhost + "/server/getloaisanpham.php";
    public static String getSPMoiNhat_URL = "http://" + localhost + "/server/getsanphammoinhat.php";
    public static String timkiem_URL = "http://"+ localhost "/server/timkiemsp.php";
    public static Retrofit retrofit;
    public static Retrofit getApiClient(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(timkiem_URL)
                    .addCallAdapterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
