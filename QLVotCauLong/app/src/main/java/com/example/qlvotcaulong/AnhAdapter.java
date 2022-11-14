package com.example.qlvotcaulong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AnhAdapter extends ArrayAdapter<anh_class> {
    private Context context;
    private int resource;
    private ArrayList<anh_class> objects;
    public AnhAdapter(@NonNull Context context, int resource, @NonNull ArrayList<anh_class> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.motanh,parent,false);
        ImageView img=convertView.findViewById(R.id.imgMotAnh);
        img.setImageResource(objects.get(position).getAnh());
        return convertView;
    }
}
