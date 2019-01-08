package com.example.tung.androidproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tung.androidproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements View.OnClickListener {

    private EditText etHoTen, etDiaChi, etEmail, etSoDienThoai, etPassWord, etRePassWord;
    private TextView btnDangKy;
    private CheckBox cbDieuKhoan;

    public SignUpFragment() {
        // Required empty public constructor
    }

    public static SignUpFragment newInstance(String param1, String param2) {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInsanceState) {
        super.onCreate(savedInsanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sign_up, container, false);

        initView(view);

        initEvent();

        return view;
    }

    private void initView(View view) {
        etHoTen = view.findViewById(R.id.et_hoten);
        etDiaChi = view.findViewById(R.id.et_diachi);
        etEmail = view.findViewById(R.id.et_email);
        etSoDienThoai = view.findViewById(R.id.et_phone);
        etPassWord = view.findViewById(R.id.et_password);
        etRePassWord = view.findViewById(R.id.et_retype_password);

        cbDieuKhoan = view.findViewById(R.id.cb_dieukhoan);
        btnDangKy = view.findViewById(R.id.btn_dangky);
    }

    private void initEvent() {
        btnDangKy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_dangky)
        {
            xuLyDangKy();
        }
    }

    private void xuLyDangKy() {

    }
}
