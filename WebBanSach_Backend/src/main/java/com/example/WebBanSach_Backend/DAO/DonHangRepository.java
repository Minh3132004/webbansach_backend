package com.example.WebBanSach_Backend.DAO;

import com.example.WebBanSach_Backend.Entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
}
