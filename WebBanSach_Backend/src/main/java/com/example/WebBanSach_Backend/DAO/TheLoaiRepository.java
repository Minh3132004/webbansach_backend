package com.example.WebBanSach_Backend.DAO;

import com.example.WebBanSach_Backend.Entity.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "the-loai")
public interface TheLoaiRepository extends JpaRepository<TheLoai, Integer> {
}
