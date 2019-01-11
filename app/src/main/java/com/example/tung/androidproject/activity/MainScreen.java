package com.example.tung.androidproject.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tung.androidproject.fragment.MeFragment;
import com.example.tung.androidproject.fragment.MoreFragment;
import com.example.tung.androidproject.fragment.NotificationFragment;
import com.example.tung.androidproject.R;
import com.example.tung.androidproject.fragment.ShoppingFragment;
import com.example.tung.androidproject.model.User;

public class MainScreen extends AppCompatActivity {

    private ActionBar toolbar;

    public static boolean isDangNhap;
    public static User user;

    BottomNavigationView navigation;
    Fragment fragment;

    public boolean close = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // load app default
        loadFragment(new ShoppingFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_shopping:
                    fragment = new ShoppingFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_user:
                    fragment = new MeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
                    Intent intent = new Intent(getApplicationContext(), CartActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_more:
                    fragment = new MoreFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment)
    {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (getSelectedMenu(navigation) == R.id.navigation_shopping) {
                if (close) {
                    finish();
                }
                else {
                    Toast.makeText(this, "Nhấn lần nữa để thoát", Toast.LENGTH_SHORT).show();
                    loadFragment(new ShoppingFragment());
                    close = true;
                }
            }
            else {
                close = false;
            }
        }


        return super.onKeyDown(keyCode, event);
    }

    private int getSelectedMenu(BottomNavigationView btmNavigation) {
        Menu menu = btmNavigation.getMenu();

        for (int i=0; i<btmNavigation.getMenu().size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            if (menuItem.isChecked()) {
                return menuItem.getItemId();
            }
        }
        return 0;
    }

}
