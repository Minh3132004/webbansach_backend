package com.example.WebBanSach_Backend.DAO;

import com.example.WebBanSach_Backend.Entity.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SachRepository extends JpaRepository<Sach, Integer> {
}
