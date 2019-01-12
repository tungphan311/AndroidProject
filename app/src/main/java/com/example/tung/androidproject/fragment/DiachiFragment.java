package com.example.tung.androidproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tung.androidproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiachiFragment extends Fragment {
    Button btnContinue;
    Fragment fragment;

    public DiachiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diachi, container, false);

        initView(view);

        initEvent();

        return view;
    }

    private void initEvent() {
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, fragment);
                getActivity().overridePendingTransition(R.anim.leftin, R.anim.rightout);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    private void initView(View view) {
        btnContinue = view.findViewById(R.id.btn_diachi);
        fragment = new ThanhtoanFragment();
    }

}
