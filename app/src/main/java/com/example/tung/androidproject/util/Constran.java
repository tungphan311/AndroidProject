package com.example.tung.androidproject.util;

import com.android.volley.toolbox.StringRequest;

import com.example.tung.androidproject.R;
import com.example.tung.androidproject.model.ItemTK;

import java.util.ArrayList;
import java.util.List;

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
    public static String insertUser_URL = "http://" + localhost + "/server/insert_user.php";

    //Chức năng trong tài khoản
    public static ArrayList<ItemTK> getListChucnang() {
        ArrayList<ItemTK> list = new ArrayList<>();
        list.add(new ItemTK(R.drawable.ic_tk_donhangcuatoi, "Đơn hàng của tôi"));
        list.add(new ItemTK(R.drawable.ic_tk_caidat, "Cài đặt"));
        return list;
    }
    //Chức năng trong ứng dụng
    public static ArrayList<ItemTK> getListCaidat() {
        ArrayList<ItemTK> list = new ArrayList<>();
        list.add(new ItemTK(R.drawable.ic_tk_chinhsach, "Chính sách"));
        list.add(new ItemTK(R.drawable.ic_tk_trogiup, "Trợ giúp"));
        list.add(new ItemTK(R.drawable.icons8_about_50, "Giới thiệu"));
        return list;
    }

    public static String donhang_URL = "http://" + localhost + "/server/thongtinkh.php";
    public static String chitietdonhang_URL = "http://" + localhost + "/server/chitietdonhang.php";
}
