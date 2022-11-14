package com.example.qlvotcaulong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtNguoiDung,edtMatKhau;
    Button btnDangNhap,btnThoat;
    ArrayList<MatKhau> dsMatKhau=new ArrayList<>();
    SqliteHelper mysql=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNguoiDung=findViewById(R.id.editTextNguoiDung);
        edtMatKhau=findViewById(R.id.editTextMatKhau);
        btnDangNhap=findViewById(R.id.buttonDangNhap);
        btnThoat=findViewById(R.id.buttonThoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mysql = new SqliteHelper(MainActivity.this);

                dsMatKhau=mysql.DanhSachNguoiDung();
                String nd=edtNguoiDung.getText().toString();
                String mk=edtMatKhau.getText().toString();
                boolean tc=false;
                for(MatKhau m:dsMatKhau)
                {
                    if (m.getMatKhau().equals(mk)&&m.getNguoiDung().equals(nd))
                    {
                        Intent intent=new Intent(MainActivity.this,Qlvcl.class);
                        startActivity(intent);
                        tc=true;
                        break;
                    }
                    if(!tc)
                        Toast.makeText(MainActivity.this,"Đăng nhập lại",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}