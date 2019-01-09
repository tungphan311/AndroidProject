package com.example.tung.androidproject.util;

public class Constran {

    public static final int REQUEST_CODE_DANGNHAP = 100;
    public static final int RESULT_CODE_DANGNHAP = 99;

    public static final int REQUEST_CODE_ME_DANGNHAP = 151;
    public static final int RESULT_CODE_ME_DANGNHAP = 152;
    public static final String KEY_ME_DANGNHAP = "me_dangnhap";

    public static String connectionErrorMessage = "Vui lòng kiểm tra kết nối Internet";

    public static String localhost = "10.0.133.201:8080";
    public static String API_URL = "http://" + localhost + "/server/";
    public static String getLoaiSP_URL = "http://" + localhost + "/server/getloaisanpham.php";
    public static String getSPMoiNhat_URL = "http://" + localhost + "/server/getsanphammoinhat.php";
    public static String getPhone_URL = "http://" + localhost + "/server/getsanpham.php?page=";
}
