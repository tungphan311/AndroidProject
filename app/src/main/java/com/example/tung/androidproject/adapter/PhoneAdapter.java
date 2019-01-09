package com.example.tung.androidproject.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tung.androidproject.R;
import com.example.tung.androidproject.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PhoneAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> listPhone;

    public PhoneAdapter(Context context, ArrayList<Sanpham> listPhone) {
        this.context = context;
        this.listPhone = listPhone;
    }


    @Override
    public int getCount() {
        return listPhone.size();
    }

    @Override
    public Object getItem(int position) {
        return listPhone.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        public TextView txtPhoneName, txtPhonePrice, txtPhoneDescription;
        public ImageView imgPhone;
        public LinearLayout llPhone;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.listview_phone, null);

            viewHolder.txtPhoneName = view.findViewById(R.id.textViewNamePhone);
            viewHolder.txtPhonePrice = view.findViewById(R.id.textViewPricePhone);
            viewHolder.txtPhoneDescription = view.findViewById(R.id.textViewDescriptionPhone);
            viewHolder.imgPhone = view.findViewById(R.id.imageViewPhone);
            viewHolder.llPhone = view.findViewById(R.id.linearLayoutPhone);

            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();

            final Sanpham sanpham = (Sanpham) getItem(position);
            viewHolder.txtPhoneName.setText(sanpham.getTensp());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            viewHolder.txtPhonePrice.setText("Giá: " + decimalFormat.format(sanpham.getGiasp()) + " đ");

            viewHolder.txtPhoneDescription.setMaxLines(2);
            viewHolder.txtPhoneDescription.setEllipsize(TextUtils.TruncateAt.END);
            viewHolder.txtPhoneDescription.setText(sanpham.getMotasp());

            Picasso.with(context).load(sanpham.getHinhanhsp())
                    .placeholder(R.drawable.ic_not_available)
                    .error(R.drawable.ic_error)
                    .into(viewHolder.imgPhone);
        }

        return view;
    }
}
