package com.example.tung.androidproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.util.SortedList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tung.androidproject.R;
import com.example.tung.androidproject.adapter.SanphamAdapter;
import com.example.tung.androidproject.model.Sanpham;
import com.example.tung.androidproject.util.ApiInterface;
import com.example.tung.androidproject.util.Constran;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Sanpham> sanphams;
    private SanphamAdapter sanphamAdapter;
    private ApiInterface apiInterface;
    ProgressBar progressBar;



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

        return view;
    }

    private void Anhxa(View view) {
        progressBar = view.findViewById(R.id.progress);
        recyclerView = view.findViewById(R.id.rvtimkiemsp);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

    }
    public void fetchSanpham(String key){
        apiInterface = Constran.getApiClient().create(ApiInterface.class);
        Call<List<Sanpham>> call = apiInterface.timkiemsp(key);

        ((retrofit2.Call) call).enqueue(new Callback() {
            @Override
            public void onResponse(retrofit2.Call call, Response response) {

                sanphams = (List<Sanpham>) response.body();
                sanphamAdapter = new SanphamAdapter(sanphams,getView());
                recyclerView.setAdapter(sanphamAdapter);
                sanphamAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(retrofit2.Call call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getView(),"ERROR",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
