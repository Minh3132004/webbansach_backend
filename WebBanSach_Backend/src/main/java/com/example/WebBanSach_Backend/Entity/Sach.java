package com.example.WebBanSach_Backend.Entity;

import lombok.Data;

import java.util.List;

@Data
public class Sach {
    private int maSach;

    private String tenSach;

    private String tenTacGia;

    private String ISBN;

    private String moTa;

    private double giaNiemYet;

    private double giaBan;

    private int soLuong;

    private double trungBinhXepHang;

    private List<TheLoai> danhSachTheLoai;

    private List<HinhAnh> danhSachHinhAnh;

    private List<DanhGia> danhSachDanhGia;

    private List<ChiTietDonHang> danhSachChiTietDonHang;

    private List<SachYeuThich> danhSachSachYeuThich;
}
