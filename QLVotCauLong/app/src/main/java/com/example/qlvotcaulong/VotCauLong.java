package com.example.qlvotcaulong;

public class VotCauLong implements Comparable<VotCauLong>{
    String Hang;
    String TrongLuong;
    String Gia;
    String ChatLieu;
    String MauSac;
    private int Anh;
    public VotCauLong(String hang, String trongLuong, String gia, String chatLieu, String mauSac, int anh) {
        Hang = hang;
        TrongLuong = trongLuong;
        Gia = gia;
        ChatLieu = chatLieu;
        MauSac = mauSac;
        Anh = anh;
    }
    @Override
    public int compareTo(VotCauLong votCauLong) {
        return Hang.compareTo(votCauLong.Hang);
    }

    public VotCauLong() {
    }

    public int getAnh() {
        return Anh;
    }

    public void setAnh(int anh) {
        Anh = anh;
    }

    public String getHang() {
        return Hang;
    }

    public void setHang(String hang) {
        Hang = hang;
    }

    public String getTrongLuong() {
        return TrongLuong;
    }

    public void setTrongLuong(String trongLuong) {
        TrongLuong = trongLuong;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public String getChatLieu() {
        return ChatLieu;
    }

    public void setChatLieu(String chatLieu) {
        ChatLieu = chatLieu;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String mauSac) {
        MauSac = mauSac;
    }

    @Override
    public String toString() {
        return Hang + "-" + TrongLuong + "-"+ Gia + "-"+ ChatLieu + "-"+ MauSac;
    }

}
