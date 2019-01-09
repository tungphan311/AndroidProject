package com.example.tung.androidproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tung.androidproject.R;
import com.example.tung.androidproject.activity.MainScreen;
import com.example.tung.androidproject.util.Constran;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment implements View.OnClickListener {

    private TextView btnDangNhap, tvQuenMatKhau;
    private EditText etPhone, etPassword;

    public SignInFragment() {
        // Required empty public constructor
    }

//    public static SignInFragment newInstance(String param1, String param2) {
//        SignInFragment fragment = new SignInFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInsanceState) {
//        super.onCreate(savedInsanceState);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        initView(view);

        initData();

        initEvent();

        return view;
    }

    private void initEvent() {
        btnDangNhap.setOnClickListener(this);
        tvQuenMatKhau.setOnClickListener(this);
    }

    private void initView(View view) {
        btnDangNhap = view.findViewById(R.id.btn_dangnhap);
        tvQuenMatKhau = view.findViewById(R.id.tv_quenmatkhau);
        etPhone = view.findViewById(R.id.et_phone);
        etPassword = view.findViewById(R.id.et_password);
    }

    private void initData() {

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dangnhap:

                break;
        }
    }
}
