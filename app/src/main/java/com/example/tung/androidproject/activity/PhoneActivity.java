package com.example.tung.androidproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tung.androidproject.R;
import com.example.tung.androidproject.adapter.PhoneAdapter;
import com.example.tung.androidproject.model.Sanpham;
import com.example.tung.androidproject.util.CheckConnection;
import com.example.tung.androidproject.util.Constran;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneActivity extends AppCompatActivity {

    Toolbar toolbarPhone;
    ListView listViewPhone;
    PhoneAdapter phoneAdapter;
    ArrayList<Sanpham> arrayListPhone;
    int idPhone =0;
    int page =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        Anhxa();

        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
            GetMaLoaiSP();
            ActionToolbbar();
            GetDataPhone(page);
        }
        else {
            CheckConnection.ShowToast_Short(getApplicationContext(), Constran.connectionErrorMessage);
            finish();
        }

    }

    private void GetDataPhone(int Page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String pathPhone = Constran.getPhone_URL + String.valueOf(Page);
        StringRequest stringRequest = new StringRequest(pathPhone, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int idPhone = 0;
                String namePhone = "";
                int pricePhone = 0;
                String imagePhone = "";
                String descriptionPhone = "";
                int idProductPhone =0;
                if (response !=null){
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++){
                            JSONObject jsonObject= jsonArray.getJSONObject(i);
                            idPhone = jsonObject.getInt("masanpham");
                            namePhone = jsonObject.getString("tensanpham");
                            pricePhone = jsonObject.getInt("giasanpham");
                            imagePhone=jsonObject.getString("hinhanhsanpham");
                            descriptionPhone = jsonObject.getString("motasanpham");
                            idProductPhone = jsonObject.getInt("maloaisanpham");

                            arrayListPhone.add(new Sanpham(idPhone,namePhone,pricePhone,imagePhone,descriptionPhone,idProductPhone));
                            phoneAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_Short(getApplicationContext(), Constran.connectionErrorMessage);
            }
        }); //{
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String,String> param = new HashMap<String,String>();
//                param.put("maloaisanpham", String.valueOf(idPhone));
//                return super.getParams();
//            }
        //};
        requestQueue.add(stringRequest);
    }

    private void ActionToolbbar() {
        setSupportActionBar(toolbarPhone);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarPhone.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void GetMaLoaiSP() {
        idPhone = getIntent().getIntExtra("maloaisanpham", -1);
        Log.d("gia tri maloaisanpham: ",idPhone +"");
    }

    private void Anhxa() {
        toolbarPhone = findViewById(R.id.toolBarPhone);
        listViewPhone = findViewById(R.id.listViewPhone);
        arrayListPhone = new ArrayList<>();
        phoneAdapter = new PhoneAdapter(getApplicationContext(), arrayListPhone);
        listViewPhone.setAdapter(phoneAdapter);
    }
}
