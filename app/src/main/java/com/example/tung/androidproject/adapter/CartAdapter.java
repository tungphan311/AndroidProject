package com.example.tung.androidproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tung.androidproject.R;
import com.example.tung.androidproject.model.Cart;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartAdapter extends BaseAdapter {
    Context context;
    ArrayList<Cart> carts;

    public CartAdapter(Context context, ArrayList<Cart> carts) {
        this.context = context;
        this.carts = carts;
    }

    @Override
    public int getCount() {
        return carts.size();
    }

    @Override
    public Object getItem(int position) {
        return carts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        public TextView tvTensp, tvGiasp;
        public ImageView imgSp;
        public Button btnThemsp, btnBotsp;
        public EditText etSoluongsp;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        CartAdapter.ViewHolder viewHolder = null;

        if (view == null) {
            viewHolder = new CartAdapter.ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_cart, null);

            viewHolder.tvTensp = view.findViewById(R.id.tv_cart_tensp);
            viewHolder.tvGiasp = view.findViewById(R.id.tv_cart_giasp);
            viewHolder.imgSp = view.findViewById(R.id.im_cart);
            viewHolder.btnBotsp = view.findViewById(R.id.btn_botsp);
            viewHolder.btnThemsp = view.findViewById(R.id.btn_themsp);
            viewHolder.etSoluongsp = view.findViewById(R.id.et_soluongsp);

            view.setTag(viewHolder);
        }
        else {
            viewHolder = (CartAdapter.ViewHolder) view.getTag();
        }

        Cart cart = (Cart) getItem(position);

        viewHolder.tvTensp.setText(cart.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.tvGiasp.setText(decimalFormat.format(cart.getGiasp()));
        Picasso.with(context).load(cart.getHinhsp())
                .placeholder(R.drawable.ic_not_available)
                .error(R.drawable.ic_error)
                .into(viewHolder.imgSp);

        viewHolder.etSoluongsp.setText(cart.getSoluong() + "");

        return null;
    }
}
