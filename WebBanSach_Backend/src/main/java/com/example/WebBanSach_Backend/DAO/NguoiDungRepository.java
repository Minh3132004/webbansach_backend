package com.example.WebBanSach_Backend.DAO;

import com.example.WebBanSach_Backend.Entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {
}
