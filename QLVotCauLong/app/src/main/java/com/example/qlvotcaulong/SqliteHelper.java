package com.example.qlvotcaulong;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SqliteHelper extends SQLiteOpenHelper
{
    private static final int version=1;
    private static final String Database_name="QLVCL1.db";
    private static final String Table_VCL="votcaulong";
    private static final String Table_MK="DangNhap";
    private static final String col_user="user";
    private static final String col_pass="pass";
    private static final String col_Hang="Hang";
    private static final String col_TrongLuong="TrongLuong";
    private static final String col_Gia="Gia";
    private static final String col_ChatLieu="ChatLieu";
    private static final String col_MauSac="MauSac";
    private static final String col_anh="Anh";


    public SqliteHelper(@Nullable Context context) {
        super(context, Database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<MatKhau> DanhSachNguoiDung() {
        ArrayList<MatKhau> danhsachMatKhau=new ArrayList<>();
        String sqlcm="select * from "+Table_MK;
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery(sqlcm,null);
        if(cursor.moveToFirst())
        {
            do{
                MatKhau matKhau=new MatKhau();
                matKhau.setNguoiDung(cursor.getString(0));
                matKhau.setMatKhau(cursor.getString(1));
                danhsachMatKhau.add(matKhau);
            } while (cursor.moveToNext());
        }
        return danhsachMatKhau;
    }

    public ArrayList<VotCauLong> DanhSachVotCauLong() {
        ArrayList<VotCauLong> danhsachVotCauLong=new ArrayList<>();
        String sqlcm="select * from "+Table_VCL;
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery(sqlcm,null);
        if(cursor.moveToFirst())
            do{
                VotCauLong vcl=new VotCauLong();
                vcl.setHang(cursor.getString(0));
                vcl.setTrongLuong(cursor.getString(1));
                vcl.setGia(cursor.getString(2));
                vcl.setChatLieu(cursor.getString(3));
                vcl.setMauSac(cursor.getString(4));
                vcl.setAnh(cursor.getInt(5));

                danhsachVotCauLong.add(vcl);
            }  while (cursor.moveToNext());
        return danhsachVotCauLong;
    }

    public void Delete()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Delete from " + Table_VCL);
    }

    public void ThemVotCauLong(VotCauLong vcl)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_Hang, vcl.getHang());
        contentValues.put(col_TrongLuong, vcl.getTrongLuong());
        contentValues.put(col_Gia, vcl.getGia());
        contentValues.put(col_ChatLieu, vcl.getChatLieu());
        contentValues.put(col_MauSac, vcl.getMauSac());
        contentValues.put(col_anh, vcl.getAnh());

        db.insert(Table_VCL, "", contentValues);
    }
    public void XoaVotCauLong(String Hang)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("Delete from " + Table_VCL+" where Hang="+Hang);
        //return database.delete(Table_SV,col_ma+"=?",new String[]{String.valueOf(ID)});
    }
}
