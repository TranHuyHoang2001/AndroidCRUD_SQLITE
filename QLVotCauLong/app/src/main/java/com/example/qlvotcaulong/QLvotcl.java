package com.example.qlvotcaulong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class QLvotcl extends AppCompatActivity {
    public static ArrayList<VotCauLong> dsVotCauLong = new ArrayList<>();
    public static ArrayList<VotCauLong> dsTimKiem = new ArrayList<>();
    public static customAdapter adapter, adapterTK;
    public static int vitri = -1;
    ListView listViewVotCauLong;
    public static SqliteHelper mysqlite;
    Intent intent;
    ArrayList<Integer> dsAnh = new ArrayList<>();
    Spinner spAnh;
    public static int hinhanh;
    EditText edtHang, edtTrongLuong, edtGia, edtChatLieu, edtMauSac;
    Button btnThem, btnXoa, btnTimKiem, btnThoat, btnSapXep;
    public static ImageView imgHinh;
    SqliteHelper mysql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlvotcl);

        edtHang = findViewById(R.id.edtHang);
        edtTrongLuong = findViewById(R.id.edtTrongLuong);
        edtGia = findViewById(R.id.edtGia);
        edtChatLieu = findViewById(R.id.edtChatLieu);
        edtMauSac = findViewById(R.id.edtMauSac);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnTimKiem = findViewById(R.id.btnTimKiem);
        btnThoat = findViewById(R.id.btnThoat);
        btnSapXep = findViewById(R.id.btnSapXep);
        imgHinh = findViewById(R.id.imgHinh);
        listViewVotCauLong = findViewById(R.id.lvVotCauLong);
        spAnh = findViewById(R.id.spAnh);

        adapter = new customAdapter(QLvotcl.this, R.layout.votcaulong, dsVotCauLong);
        adapterTK = new customAdapter(QLvotcl.this, R.layout.votcaulong, dsTimKiem);
        listViewVotCauLong.setAdapter(adapter);
        mysql = new SqliteHelper(this);

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnTimKiem.getText().equals("Tìmkiếm")) {
                    btnTimKiem.setText("DừngTK");
                    dsTimKiem.clear();
                    for (VotCauLong vcl : dsVotCauLong)
                        if (vcl.getHang().contains(edtHang.getText().toString()) &&
                                vcl.getTrongLuong().contains(edtTrongLuong.getText().toString()) &&
                                vcl.getGia().contains(edtGia.getText().toString()) &&
                                vcl.getChatLieu().contains(edtChatLieu.getText().toString()) &&
                                vcl.getMauSac().contains(edtMauSac.getText().toString()))
                            dsTimKiem.add(vcl);
                    adapterTK.notifyDataSetChanged();
                    listViewVotCauLong.setAdapter(adapterTK);
                } else {
                    btnTimKiem.setText("Tìmkiếm");
                    adapter.notifyDataSetChanged();
                    listViewVotCauLong.setAdapter(adapter);
                }
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnThem.getText().equals("Thêm")) {
                    VotCauLong vcl = new VotCauLong();
                    vcl.setHang(edtHang.getText().toString());
                    vcl.setTrongLuong(edtTrongLuong.getText().toString());
                    vcl.setGia(edtGia.getText().toString());
                    vcl.setChatLieu(edtChatLieu.getText().toString());
                    vcl.setMauSac(edtMauSac.getText().toString());
                    vcl.setAnh(hinhanh);
                    dsVotCauLong.add(vcl);
                    adapter.notifyDataSetChanged();
                    listViewVotCauLong.setAdapter(adapter);
                    mysql.ThemVotCauLong(vcl);
                    Xoathongtin();
                } else {
                    if (vitri == -1)
                        Toast.makeText(QLvotcl.this, "Chưa chọn vợt cầu lông cần sửa", Toast.LENGTH_SHORT).show();
                    else {
                        btnThem.setText("Thêm");
                        VotCauLong vcl = new VotCauLong();
                        vcl.setHang(edtHang.getText().toString());
                        vcl.setTrongLuong(edtTrongLuong.getText().toString());
                        vcl.setGia(edtGia.getText().toString());
                        vcl.setChatLieu(edtChatLieu.getText().toString());
                        vcl.setMauSac(edtMauSac.getText().toString());
                        vcl.setAnh(hinhanh);
                        dsVotCauLong.set(vitri, vcl);
                        adapter.notifyDataSetChanged();
                        vitri = -1;
                        mysql.Delete();
                        for (VotCauLong v : dsVotCauLong)
                            mysql.ThemVotCauLong(v);
                        Xoathongtin();
                    }
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vitri==-1)
                    Toast.makeText(QLvotcl.this,"Chưa chọn vợt cầu lông cần xóa",Toast.LENGTH_SHORT).show();
                else
                {
                    btnThem.setText("Thêm");
                    dsVotCauLong.remove(vitri);
                    adapter.notifyDataSetChanged();
                    mysql.Delete();
                    for(VotCauLong vcl:dsVotCauLong)
                        mysql.ThemVotCauLong(vcl);
                    vitri=-1;
                    Xoathongtin();
                }
            }
        });
        listViewVotCauLong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                VotCauLong vcl=dsVotCauLong.get(i);
                edtHang.setText(vcl.getHang());
                edtTrongLuong.setText(vcl.getTrongLuong());
                edtGia.setText(vcl.getGia());
                edtChatLieu.setText(vcl.getChatLieu());
                edtMauSac.setText(vcl.getMauSac());
                imgHinh.setImageResource(vcl.getAnh());
                btnThem.setText("Sửa");
                vitri=i;
            }
        });
        imgHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QLvotcl.this,chonanhActivity.class);
                startActivity(intent);
            }
        });
        mysqlite=new SqliteHelper(QLvotcl.this);
        dsVotCauLong =mysqlite.DanhSachVotCauLong();
        adapter=new customAdapter(QLvotcl.this,R.layout.votcaulong, dsVotCauLong);
        listViewVotCauLong.setAdapter(adapter);
        dsAnh.add(R.drawable.vcl1);
        dsAnh.add(R.drawable.vcl2);
        dsAnh.add(R.drawable.vcl3);
        dsAnh.add(R.drawable.vcl4);
        dsAnh.add(R.drawable.vcl5);
        dsAnh.add(R.drawable.vcl6);


        ArrayAdapter<Integer> adapterHinhAnh=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,dsAnh);
        spAnh.setAdapter(adapterHinhAnh);
        spAnh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                imgHinh.setImageResource(dsAnh.get(i));
                hinhanh=dsAnh.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    private void Xoathongtin() {
        edtHang.setText("");
        edtTrongLuong.setText("");
        edtGia.setText("");
        edtChatLieu.setText("");
        edtMauSac.setText("");
        edtHang.requestFocus();
        imgHinh.setImageResource(0);

    }
}