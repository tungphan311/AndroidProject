package com.example.tung.androidproject.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Constran {

    public static final int REQUEST_CODE_DANGNHAP = 100;
    public static final int RESULT_CODE_DANGNHAP = 99;

    public static final int REQUEST_CODE_ME_DANGNHAP = 151;
    public static final int RESULT_CODE_ME_DANGNHAP = 152;
    public static final String KEY_ME_DANGNHAP = "me_dangnhap";

    public static String localhost = "10.0.135.91:8080";
    public static String API_URL = "http://" + localhost + "/server";
    public static String getLoaiSP_URL = "http://" + localhost + "/server/getloaisp.php";
    public static String getSPMoiNhat_URL = "http://" + localhost + "/server/getspmoinhat.php";
    public static String timkiem_URL = "http://"+ localhost + "/server/timkiemsp.php?key=";

}
