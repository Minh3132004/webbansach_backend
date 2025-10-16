package com.example.WebBanSach_Backend.Entity;

import lombok.Data;

@Data
public class ChiTietDonHang {
    private long chiTietDonHang;

    private int soLuong;

    private double giaBan;

    private Sach sach;

    private DonHang donHang;
}
