package com.example.WebBanSach_Backend.DAO;

import com.example.WebBanSach_Backend.Entity.DanhGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "danh-gia")
public interface DanhGiaRepository extends JpaRepository<DanhGia, Long> {
}
