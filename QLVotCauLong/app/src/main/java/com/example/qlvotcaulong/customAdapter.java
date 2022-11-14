package com.example.qlvotcaulong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class customAdapter extends ArrayAdapter<VotCauLong> {
    private Context context;
    private int resource;
    private List<VotCauLong> objects;

    public customAdapter(@NonNull Context context, int resource, @NonNull List<VotCauLong> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView Hang,TrongLuong,Gia,ChatLieu,MauSac;
        ImageView hinh;
        convertView= LayoutInflater.from(context).inflate(R.layout.votcaulong,parent,false);
        Hang=convertView.findViewById(R.id.txtHang);
        TrongLuong=convertView.findViewById(R.id.txtTrongLuong);
        Gia=convertView.findViewById(R.id.txtGia);
        ChatLieu=convertView.findViewById(R.id.txtChatLieu);
        MauSac=convertView.findViewById(R.id.txtMauSac);
        hinh=convertView.findViewById(R.id.imgHinh);

        VotCauLong votCauLong=objects.get(position);
        Hang.setText(votCauLong.getHang());
        TrongLuong.setText(votCauLong.getTrongLuong());
        Gia.setText(votCauLong.getGia());
        ChatLieu.setText(votCauLong.getChatLieu());
        MauSac.setText(votCauLong.getMauSac());
        hinh.setImageResource(votCauLong.getAnh());
        return convertView;
    }
}
