package com.example.WebBanSach_Backend.DAO;

import com.example.WebBanSach_Backend.Entity.ChiTietDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang , Long> {
}
