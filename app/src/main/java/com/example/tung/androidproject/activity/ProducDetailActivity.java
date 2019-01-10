package com.example.tung.androidproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.tung.androidproject.R;
import com.example.tung.androidproject.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class ProducDetailActivity extends AppCompatActivity {

    Toolbar toolbarDetail;
    ImageView imgDetail;
    TextView tvTen, tvGia, tvMota;
    Spinner spinner;
    Button btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produc_detail);
        
        Anhxa();
        ActionToolBar();
        GetDetail();
        CatchEventSpinner();

    }

    private void CatchEventSpinner() {
        Integer[] soluong = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, soluong);
        spinner.setAdapter(arrayAdapter);
    }

    private void GetDetail() {

        // khởi tạo các biến để nhận giá trị được gửi tới
        int masp = 0;
        String tensp = "";
        int giasp = 0;
        String hinhanhsp = "";
        String motasp = "";
        int maloaisp =0;

        // tiến hành gán các giá trị được gửi tới
        Sanpham sanpham = (Sanpham) getIntent().getSerializableExtra("thongtinsanpham");
        masp = sanpham.getMasp();
        tensp = sanpham.getTensp();
        giasp = sanpham.getGiasp();
        hinhanhsp = sanpham.getHinhanhsp();
        motasp = sanpham.getMotasp();
        maloaisp = sanpham.getMaloaisp();

        // show giá trị lên màn hình
        tvTen.setText(tensp);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tvGia.setText("Giá : " + decimalFormat.format(giasp) + " đ");
        tvMota.setText(motasp);
        Picasso.with(getApplicationContext()).load(hinhanhsp)
                .placeholder(R.drawable.ic_not_available)
                .error(R.drawable.ic_error)
                .into(imgDetail);
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarDetail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarDetail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        toolbarDetail = findViewById(R.id.toolbar_detail);
        imgDetail = findViewById(R.id.iv_detail);
        tvTen = findViewById(R.id.tv_detail_tensp);
        tvGia = findViewById(R.id.tv_detail_giasp);
        tvMota = findViewById(R.id.tv_motasp);
        spinner = findViewById(R.id.spinner);
        btnAddToCart = findViewById(R.id.btn_addToCart);
    }
}
