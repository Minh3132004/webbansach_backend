package com.example.WebBanSach_Backend.DAO;

import com.example.WebBanSach_Backend.Entity.ChiTietDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "chi-tiet-don-hang")
public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang , Long> {
}
