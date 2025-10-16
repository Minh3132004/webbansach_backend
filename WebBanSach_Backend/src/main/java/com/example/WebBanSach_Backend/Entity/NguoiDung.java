package com.example.WebBanSach_Backend.Entity;

import lombok.Data;

import java.util.List;

@Data
public class NguoiDung {

    private int maNguoiDung;

    private String hoDem;

    private String ten;

    private String tenDangNhap;

    private String matKhau;

    private char gioiTinh;

    private String email;

    private String soDienThoai;

    private String diaChiMuaHang;

    private String diaChiGiaoHang;

    private List<DanhGia> danhSachDanhGia;

    private List<SachYeuThich> danhSachSachYeuThich;

    private List<Quyen> danhSachQuyen;

    private List<DonHang> danhSachDonhang;

}
