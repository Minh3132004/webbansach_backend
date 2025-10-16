package com.example.WebBanSach_Backend.DAO;

import com.example.WebBanSach_Backend.Entity.DanhGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhGiaRepository extends JpaRepository<DanhGia, Long> {
}
