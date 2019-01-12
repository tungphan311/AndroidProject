package com.example.tung.androidproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tung.androidproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThanhtoanFragment extends Fragment {
    Button btnTieptuc, btnQuaylai;
    Fragment fragment;

    public ThanhtoanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thanhtoan, container, false);

        initView(view);

        initEvent();

        return view;
    }

    private void initEvent() {
        btnTieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, fragment);
                getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btnQuaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.popBackStack();
            }
        });
    }

    private void initView(View view) {
        btnQuaylai = view.findViewById(R.id.btn_quaylai);
        btnTieptuc = view.findViewById(R.id.btn_tieptuc);

        fragment = new XacnhanFragment();
    }

}
