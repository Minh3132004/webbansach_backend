package com.example.WebBanSach_Backend.DAO;

import com.example.WebBanSach_Backend.Entity.Quyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyenRepository extends JpaRepository<Quyen, Integer> {
}
