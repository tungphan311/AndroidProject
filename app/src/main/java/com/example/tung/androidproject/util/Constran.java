package com.example.tung.androidproject.util;

public class Constran {
    public static String connectionErrorMessage = "Vui lòng kiểm tra kết nối Internet";
    public static final int REQUEST_CODE_DANGNHAP = 100;
    public static final int RESULT_CODE_DANGNHAP = 99;

    public static final int REQUEST_CODE_ME_DANGNHAP = 151;
    public static final int RESULT_CODE_ME_DANGNHAP = 152;
    public static final String KEY_ME_DANGNHAP = "me_dangnhap";

    public static String localhost = "10.0.133.201:8080";
    public static String API_URL = "http://" + localhost + "/server";
    public static String getLoaiSP_URL = "http://" + localhost + "/server/getloaisanpham.php";
    public static String getSPMoiNhat_URL = "http://" + localhost + "/server/getsanphammoinhat.php";
    public static String timkiem_URL = "http://"+ localhost + "/server/timkiemsp.php?key=";

    public static String search_URL = "http://"+ localhost + "/server/search.php?key=";

    public static String getPhone_URL = "http://" + localhost + "/server/getphone.php?page=";
    public static String getLaptop_URL = "http://" + localhost + "/server/getlaptop.php?page=";
    public static String getTablet_URL = "http://" + localhost + "/server/gettablet.php?page=";
    public static String getPhukien_URL = "http://" + localhost + "/server/getphukien.php?page=";

    public static String getUser_URL = "http://" + localhost + "/server/getuser.php";
}
