package com.example.tung.androidproject.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SanphamAdapter extends RecyclerView.Adapter<> {


    public class ItemHolder extends RecyclerView.ViewHolder {
        public ImageView imgHinhSP;
        public TextView txtTenSP, texGiaSP;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
