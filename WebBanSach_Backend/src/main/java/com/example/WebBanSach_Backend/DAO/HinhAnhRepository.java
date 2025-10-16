package com.example.WebBanSach_Backend.DAO;

import com.example.WebBanSach_Backend.Entity.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HinhAnhRepository extends JpaRepository<HinhAnh, Integer> {
}
