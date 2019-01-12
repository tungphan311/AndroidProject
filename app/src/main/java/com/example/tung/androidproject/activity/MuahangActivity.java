package com.example.tung.androidproject.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.tung.androidproject.R;
import com.example.tung.androidproject.fragment.DiachiFragment;

public class MuahangActivity extends AppCompatActivity {
    ImageView btnBack;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    public Fragment fragment;
    public FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muahang);

        initView();

        initData();
    }

    private void initData() {

    }

    private void initView() {
        btnBack = findViewById(R.id.btn_back);

        fragment = new DiachiFragment();
        loadFragment(fragment);
    }

    private void loadFragment(Fragment fragment)
    {
        // load fragment
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
