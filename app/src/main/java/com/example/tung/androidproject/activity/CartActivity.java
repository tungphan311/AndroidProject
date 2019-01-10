package com.example.tung.androidproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.tung.androidproject.R;
import com.example.tung.androidproject.adapter.CartAdapter;
import com.example.tung.androidproject.fragment.ShoppingFragment;

public class CartActivity extends AppCompatActivity {

    ListView listViewCart;
    TextView tvThongbao;
    TextView tvTongtien;
    Button btnThanhtoan, btnMuatiep;
    android.support.v7.widget.Toolbar toolbarCart;
    CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Anhxa();
        ActionToolbar();
        CheckData();
    }

    private void CheckData() {
        if (ShoppingFragment.carts.size() <= 0) {
            cartAdapter.notifyDataSetChanged();
            tvTongtien.setVisibility(View.VISIBLE);
            listViewCart.setVisibility(View.INVISIBLE);
        }
        else {
            cartAdapter.notifyDataSetChanged();
            tvTongtien.setVisibility(View.INVISIBLE);
            listViewCart.setVisibility(View.VISIBLE);
        }
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbarCart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarCart.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        listViewCart = findViewById(R.id.lv_cart);
        tvThongbao = findViewById(R.id.tv_cart_noitem);
        tvTongtien = findViewById(R.id.tv_totalcost);
        btnThanhtoan = findViewById(R.id.btn_thanhtoan);
        btnMuatiep = findViewById(R.id.btn_tieptucmuahang);
        toolbarCart = findViewById(R.id.toolbar_cart);
        cartAdapter = new CartAdapter(CartActivity.this, ShoppingFragment.carts);
        listViewCart.setAdapter(cartAdapter);
    }
}
