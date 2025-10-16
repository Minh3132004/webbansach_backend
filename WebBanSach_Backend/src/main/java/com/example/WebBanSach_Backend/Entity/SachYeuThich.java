package com.example.WebBanSach_Backend.Entity;

import lombok.Data;

@Data
public class SachYeuThich {
    private int maSachYeuThich;

    private NguoiDung nguoiDung;

    private Sach sach;
}
