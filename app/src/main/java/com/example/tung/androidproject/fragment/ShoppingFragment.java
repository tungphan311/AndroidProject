package com.example.tung.androidproject.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.tung.androidproject.R;
import com.example.tung.androidproject.adapter.LoaisanphamAdapter;
import com.example.tung.androidproject.adapter.SanphamAdapter;
import com.example.tung.androidproject.model.Loaisanpham;
import com.example.tung.androidproject.model.Sanpham;
import com.example.tung.androidproject.util.Constran;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment {
    DrawerLayout drawerLayout;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    NavigationView navigationView;
    ListView listView;
    Toolbar toolbar;

    ArrayList<Loaisanpham> listLoaiSP;
    LoaisanphamAdapter loaisanphamAdapter;

    ArrayList<Sanpham> listSanpham;
    SanphamAdapter sanphamAdapter;

    int maloaisp = 0;
    String tenloaisp = "";
    String hinhanhloaisp = "";

    public ShoppingFragment() {
        // Required empty public constructor
    }

    public static ShoppingFragment newInstance(String param1, String param2) {
        ShoppingFragment fragment = new ShoppingFragment();
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
        View view =  inflater.inflate(R.layout.fragment_shopping, container, false);

        Anhxa(view);

        createMenuBar();

        setViewFlipper();

        getDataLoaiSP();

        getDataSPMoiNhat();

        return view;
    }

    private void Anhxa(View view) {
        viewFlipper = view.findViewById(R.id.viewflipper);
        recyclerView = view.findViewById(R.id.recycleview);
        navigationView = view.findViewById(R.id.navigationview);
        listView = view.findViewById(R.id.lv_mainscreen);
        drawerLayout = view.findViewById(R.id.drawlayout);
        toolbar = view.findViewById(R.id.toolbar);

        listLoaiSP = new ArrayList<>();
        loaisanphamAdapter = new LoaisanphamAdapter(listLoaiSP, getActivity().getApplicationContext());
        listView.setAdapter(loaisanphamAdapter);

        listSanpham = new ArrayList<>();
        sanphamAdapter = new SanphamAdapter(getActivity().getApplicationContext(), listSanpham);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2));
        recyclerView.setAdapter(sanphamAdapter);
    }

    @SuppressLint("RestrictedApi")
    private void createMenuBar() {
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void setViewFlipper() {
        ArrayList<String> listViewFlipper = new ArrayList<>();
        listViewFlipper.add("https://cdn.fptshop.com.vn/Uploads/Originals/2019/1/8/636825660756940502_H1.png");
        listViewFlipper.add("https://cdn.fptshop.com.vn/Uploads/Originals/2019/1/7/636824679816698276_H1.png");
        listViewFlipper.add("https://cdn.fptshop.com.vn/Uploads/Originals/2019/1/3/636820917936458718_F-H1_800x300.jpg");
        listViewFlipper.add("https://cdn.fptshop.com.vn/Uploads/Originals/2019/1/3/636821117669639978_H1.png");

        for (int i =0; i<listViewFlipper.size(); i++) {
            ImageView imageView = new ImageView(getActivity().getApplicationContext());
            Picasso.with(getActivity().getApplicationContext()).load(listViewFlipper.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }

        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation left_in = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.left_in);
        Animation right_out = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.right_out);

        viewFlipper.setInAnimation(left_in);
        viewFlipper.setOutAnimation(right_out);
    }

    private void getDataLoaiSP() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Constran.getLoaiSP_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    for (int i=0; i<response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            maloaisp = jsonObject.getInt("maloaisanpham");
                            tenloaisp = jsonObject.getString("tenloaisanpham");
                            hinhanhloaisp = jsonObject.getString("hinhanhloaisanpham");
                            listLoaiSP.add(new Loaisanpham(maloaisp, tenloaisp, hinhanhloaisp));
                            loaisanphamAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext(), "get loaisanpham error", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }

    private void getDataSPMoiNhat() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Constran.getSPMoiNhat_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int masp = 0;
                    String tensp = "";
                    Integer giasp = 0;
                    String hinhanhsp = "";
                    String motasp = "";
                    int maloaisp = 0;

                    for (int i= 0; i<response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);

                            masp = jsonObject.getInt("masanpham");
                            tensp = jsonObject.getString("tensanpham");
                            giasp = jsonObject.getInt("giasanpham");
                            hinhanhsp = jsonObject.getString("hinhanhsanpham");
                            motasp = jsonObject.getString("motasanpham");
                            maloaisp = jsonObject.getInt("maloaisanpham");

                            listSanpham.add(new Sanpham(masp, tensp, giasp, hinhanhsp, motasp, maloaisp));
                            sanphamAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext(), "get sanphammoinhat error", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
