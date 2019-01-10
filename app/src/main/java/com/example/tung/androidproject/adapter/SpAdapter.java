package com.example.tung.androidproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tung.androidproject.R;
import com.example.tung.androidproject.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SpAdapter extends RecyclerView.Adapter<SpAdapter.SanphamHoder>{
    Context context;
    ArrayList<Sanpham> listsp;

    public SpAdapter(Context context, ArrayList<Sanpham> listsp) {
        this.context = context;
        this.listsp = listsp;
    }

    @NonNull
    @Override
    public SanphamHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsanpham,null);
        SanphamHoder sanphamHoder =new SanphamHoder(v);
        return sanphamHoder;
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SanphamHoder sanphamHoder, int i) {
        Sanpham sanpham = listsp.get(i);
        sanphamHoder.txttensanpham.setText(sanpham.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        sanphamHoder.txtgiasanpham.setText("Giá: " + decimalFormat.format(sanpham.getGiasp()) + " đ");
        Picasso.with(context).load(sanpham.getHinhanhsp())
                .placeholder(R.drawable.ic_not_available)
                .error(R.drawable.ic_error)
                .into(sanphamHoder.imghinhsanpham);
    }

    @Override
    public int getItemCount() {
        return listsp.size();
    }

    public class SanphamHoder extends RecyclerView.ViewHolder{
        public ImageView imghinhsanpham;
        public TextView txttensanpham, txtgiasanpham;

        public SanphamHoder(@NonNull View itemView) {
            super(itemView);
            imghinhsanpham = itemView.findViewById(R.id.iv_sp);
            txtgiasanpham = itemView.findViewById(R.id.tv_gia_sp);
            txttensanpham = itemView.findViewById(R.id.tv_ten_sp);
        }
    }
}