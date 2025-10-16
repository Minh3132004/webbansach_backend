package com.example.WebBanSach_Backend.DAO;

import com.example.WebBanSach_Backend.Entity.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "hinh-anh")
public interface HinhAnhRepository extends JpaRepository<HinhAnh, Integer> {
}
