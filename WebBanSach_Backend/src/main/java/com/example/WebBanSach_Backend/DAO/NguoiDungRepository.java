package com.example.WebBanSach_Backend.DAO;

import com.example.WebBanSach_Backend.Entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "nguoi-dung")
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {
    public boolean existsByTenDangNhap(String tenDangNhap);
    public boolean existsByEmail(String email);
    public NguoiDung findByTenDangNhap(String tenDangNhap);
    public NguoiDung findByEmail(String email);
}
    