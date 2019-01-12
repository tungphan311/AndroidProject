package com.example.tung.androidproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tung.androidproject.R;
import com.example.tung.androidproject.activity.MuahangActivity;
import com.example.tung.androidproject.adapter.XacnhanAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class XacnhanFragment extends Fragment {
    TextView tvTongtien, tvTen, tvSodt, tvDiachi;
    ListView listView;
    XacnhanAdapter adapter;

    public XacnhanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_xacnhan, container, false);

        initView(view);

        initData();


        return view;
    }

    private void initView(View view) {
        tvTongtien = view.findViewById(R.id.tv_tongtien);
        listView = view.findViewById(R.id.listitem);
        adapter = new XacnhanAdapter(getActivity().getApplicationContext(), ShoppingFragment.carts);
        listView.setAdapter(adapter);
        tvTen = view.findViewById(R.id.textview_ten);
        tvSodt = view.findViewById(R.id.textview_sodt);
        tvDiachi = view.findViewById(R.id.textview_dchi);
    }

    private void initData() {
        String total =((MuahangActivity)getActivity()).getTongtien();
        total = tvTongtien.getText().toString() + total;
        tvTongtien.setText(total);

        String ten = ((MuahangActivity)getActivity()).getTennguoinhan();
        tvTen.setText(ten);
    }
}
