package com.example.WebBanSach_Backend.DAO;

import com.example.WebBanSach_Backend.Entity.Quyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "quyen")
public interface QuyenRepository extends JpaRepository<Quyen, Integer> {
}
