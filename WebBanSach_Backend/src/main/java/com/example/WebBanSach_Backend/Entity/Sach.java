package com.example.WebBanSach_Backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "sach")
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_sach")
    private int maSach;

    @Column(name = "ten_sach", length = 256 ,  nullable = false)
    private String tenSach;

    @Column(name = "ten_tac_gia", length = 256 , nullable = false)
    private String tenTacGia;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "mo_ta", columnDefinition = "text" , nullable = false)
    private String moTa;

    @Column(name = "gia_niem_yet", nullable = false)
    private double giaNiemYet;

    @Column(name = "gia_ban", nullable = false)
    private double giaBan;

    @Column(name = "so_luong", nullable = false)
    private int soLuong;

    @Column(name = "trung_binh_xep_hang", nullable = false)
    private double trungBinhXepHang;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(
            name = "sach_theloai",
            joinColumns = @JoinColumn(name = "ma_sach"),
            inverseJoinColumns = @JoinColumn(name = "ma_the_loai")
    )
    private List<TheLoai> danhSachTheLoai;

    @OneToMany(mappedBy = "sach", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HinhAnh> danhSachHinhAnh;

    @OneToMany(mappedBy = "sach", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DanhGia> danhSachDanhGia;

    @OneToMany(mappedBy = "sach", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    private List<ChiTietDonHang> danhSachChiTietDonHang;

    @OneToMany(mappedBy = "sach", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SachYeuThich> danhSachSachYeuThich;
}
