package com.example.WebBanSach_Backend.Entity;

import lombok.Data;

import java.util.List;

@Data
public class TheLoai {
    private int maTheLoai;

    private String tenTheLoai;

    private List<Sach> danhSachSach;
}
