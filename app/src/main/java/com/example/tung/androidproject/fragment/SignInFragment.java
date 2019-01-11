package com.example.tung.androidproject.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.tung.androidproject.R;
import com.example.tung.androidproject.activity.LoginActivity;
import com.example.tung.androidproject.activity.MainScreen;
import com.example.tung.androidproject.model.User;
import com.example.tung.androidproject.util.Constran;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment  {

    private TextView btnDangNhap, tvQuenMatKhau;
    private EditText etPhone, etPassword;

    ArrayList<User> listUsers;

    public SignInFragment() {
        // Required empty public constructor
    }

    public static SignInFragment newInstance(String param1, String param2) {
        SignInFragment fragment = new SignInFragment();
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
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        initView(view);

        getListUser();

        catchEvent();

        return view;
    }

    private void catchEvent() {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = etPhone.getText().toString().trim();     // remove space
                String pass = etPassword.getText().toString().trim();

                Toast.makeText(getActivity(), String.valueOf(listUsers.size()), Toast.LENGTH_SHORT).show();

                if (phone.length() == 0) {
                    Toast.makeText(getActivity(), "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                    etPhone.requestFocus();
                }
                else if (pass.length() == 0) {
                    Toast.makeText(getActivity(), "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
                    etPassword.requestFocus();
                }
                else {
                    for (int i=0; i<listUsers.size(); i++) {
                        if (listUsers.get(i).getSodienthoai().equals(phone) && listUsers.get(i).getMatkhau().equals(pass)) {
                             MainScreen.isDangNhap = true;
                             MainScreen.user = listUsers.get(i);
                             continue;
                        }
                    }

                    if (MainScreen.isDangNhap) {
                        Toast.makeText(getActivity(), "Login successed", Toast.LENGTH_SHORT).show();
                        getActivity().finish();
                        getActivity().overridePendingTransition(R.anim.leftin, R.anim.rightout);
                    }
                    else {
                        Toast.makeText(getActivity(), "Login failed. Wrong phone or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void getListUser() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Constran.getUser_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int mauser = 0;
                    String sodt = "";
                    String pass = "";

                    for (int i= 0; i<response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);

                            mauser = jsonObject.getInt("mauser");
                            sodt = jsonObject.getString("sodienthoai");
                            pass = jsonObject.getString("matkhau");

                            listUsers.add(new User(mauser, sodt, pass));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }


    private void initView(View view) {
        btnDangNhap = view.findViewById(R.id.btn_dangnhap);
        tvQuenMatKhau = view.findViewById(R.id.tv_quenmatkhau);
        etPhone = view.findViewById(R.id.et_phone);
        etPassword = view.findViewById(R.id.et_password);
        listUsers = new ArrayList<>();
    }


}
