package com.example.tung.androidproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.tung.androidproject.R;
import com.example.tung.androidproject.model.Diachi;

import java.util.ArrayList;

public class DiachiAdapter extends BaseAdapter {
    Context context;
    ArrayList<Diachi> listDiachi;

    public DiachiAdapter(Context context, ArrayList<Diachi> listDiachi) {
        this.context = context;
        this.listDiachi = listDiachi;
    }

    @Override
    public int getCount() {
        return listDiachi.size();
    }

    @Override
    public Object getItem(int position) {
        return listDiachi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        LinearLayout llDiachi;
        RadioButton rbChondchi;
        TextView tvTen, tvSodt, tvDiachi;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        DiachiAdapter.ViewHolder viewHolder = null;

        if (view == null) {
            viewHolder = new DiachiAdapter.ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_diachi, null);

            viewHolder.llDiachi = view.findViewById(R.id.ll_diachicuthe);
            viewHolder.rbChondchi = view.findViewById(R.id.rd_chondchi);
            viewHolder.tvTen = view.findViewById(R.id.tv_tennguoinhan);
            viewHolder.tvSodt = view.findViewById(R.id.tv_sodtnguoinhan);
            viewHolder.tvDiachi = view.findViewById(R.id.tv_dchingnhan);

            view.setTag(viewHolder);
        }
        else {
            viewHolder = (DiachiAdapter.ViewHolder) view.getTag();
        }

        Diachi dchi = (Diachi) getItem(position);

        viewHolder.tvTen.setText(dchi.getHoten());
        viewHolder.tvSodt.setText(dchi.getSodt());
        viewHolder.tvDiachi.setText(dchi.getDiachicuthe());

        return view;
    }
}
