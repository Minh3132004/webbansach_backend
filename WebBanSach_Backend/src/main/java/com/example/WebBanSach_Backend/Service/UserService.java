package com.example.WebBanSach_Backend.Service;


import com.example.WebBanSach_Backend.Entity.NguoiDung;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public NguoiDung findByUsername(String username);
}
