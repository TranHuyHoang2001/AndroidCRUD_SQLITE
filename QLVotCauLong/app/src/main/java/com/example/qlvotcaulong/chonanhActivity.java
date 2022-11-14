package com.example.qlvotcaulong;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class chonanhActivity extends AppCompatActivity {
    ArrayList<anh_class> dsAnh=new ArrayList<>();
    GridView gvHinhAnh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chonanh);
        gvHinhAnh=findViewById(R.id.gvHinhAnh);
        gvHinhAnh.setNumColumns(3);
        dsAnh.add(new anh_class(R.drawable.vcl1));
        dsAnh.add(new anh_class(R.drawable.vcl2));
        dsAnh.add(new anh_class(R.drawable.vcl3));
        dsAnh.add(new anh_class(R.drawable.vcl4));
        dsAnh.add(new anh_class(R.drawable.vcl5));
        dsAnh.add(new anh_class(R.drawable.vcl6));
        AnhAdapter anhAdapter=new AnhAdapter(chonanhActivity.this,R.layout.motanh,dsAnh);
        gvHinhAnh.setAdapter(anhAdapter);
        gvHinhAnh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Qlvcl.hinhanh=dsAnh.get(i).getAnh();
                Qlvcl.imgHinh.setImageResource(Qlvcl.hinhanh);
                finish();
            }
        });

    }
}