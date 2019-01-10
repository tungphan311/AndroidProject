package com.example.tung.androidproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.util.SortedList;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tung.androidproject.R;
import com.example.tung.androidproject.activity.MainScreen;
import com.example.tung.androidproject.adapter.SanphamAdapter;
import com.example.tung.androidproject.adapter.SpAdapter;
import com.example.tung.androidproject.model.Sanpham;
import com.example.tung.androidproject.util.ApiClient;
import com.example.tung.androidproject.util.ApiInterface;
import com.example.tung.androidproject.util.Constran;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Sanpham> listSanpham;
    SpAdapter spAdapter;
    ApiInterface apiInterface;
    EditText editText;
    ImageView imageView;
    String key ="";

    public MeFragment() {
        // Required empty public constructor
    }

    public static MeFragment newInstance(String parma1, String param2) {
        MeFragment fragment = new MeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle saveInsanceState) {
        super.onCreate(saveInsanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_me, container, false);
        Anhxa(view);
        getSanPham();
        getEvent();
        return view;
    }

    private void getEvent() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                timsanpham(editText.getText().toString());
            }
        });
    }

    private void getSanPham() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Constran.timkiem_URL, new com.android.volley.Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response !=null){
                    int Masanpham = 0;
                    String Tensanpham = "";
                    Integer Giasanpham = 0;
                    String Hinhanhsanpham="";
                    String Motasanpham ="";
                    int Maloaisanpham = 0;
                    for (int i=0;i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);

                            Masanpham = jsonObject.getInt("masanpham");
                            Tensanpham = jsonObject.getString("tensanpham");
                            Giasanpham = jsonObject.getInt("giasanpham");
                            Hinhanhsanpham =jsonObject.getString("hinhanhsanpham");
                            Motasanpham = jsonObject.getString("motasanpham");
                            Maloaisanpham =jsonObject.getInt("maloaisanpham");

                            listSanpham.add(new Sanpham(Masanpham,Tensanpham,Giasanpham,Hinhanhsanpham,Motasanpham,Maloaisanpham));
                            spAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }


    private void Anhxa(View view) {
        recyclerView = view.findViewById(R.id.rvtimkiemsp);
        listSanpham = new ArrayList<>();
        spAdapter = new SpAdapter(getActivity().getApplicationContext(), listSanpham);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2));
        recyclerView.setAdapter(spAdapter);
        editText = view.findViewById(R.id.edt_timkiem);
        imageView = view.findViewById(R.id.imv_timkiem);
    }
    private void timsanpham(String Key){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String duongdan = Constran.timkiem_URL+String.valueOf(Key);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongdan, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                int masanpham=0;
                String tensanpham="";
                int giasanpham=0;
                String hinhanhsanpham="";
                String motasanpham="";
                int maloaisanpham=0;
                if (response !=null){
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i=0;i<response.length();i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            masanpham = jsonObject.getInt("masanpham");
                            tensanpham = jsonObject.getString("tensanpham");
                            giasanpham = jsonObject.getInt("giasanpham");
                            hinhanhsanpham = jsonObject.getString("hinhanhsanpham");
                            motasanpham = jsonObject.getString("motasanpham");
                            maloaisanpham = jsonObject.getInt("maloaisanpham");
                            listSanpham.add(new Sanpham(masanpham,tensanpham,giasanpham,hinhanhsanpham,motasanpham,maloaisanpham));
                            spAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<String, String>();
                param.put("key",String.valueOf(""));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

}
