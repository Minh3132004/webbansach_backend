package com.example.WebBanSach_Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebBanSach_Backend.Entity.NguoiDung;
import com.example.WebBanSach_Backend.Service.TaiKhoanService;

@RestController
@RequestMapping("/tai-khoan")
public class TaiKhoanController {
    @Autowired
    TaiKhoanService taiKhoanService ;

    @CrossOrigin(origins = "http://localhost:3000")  
    @PostMapping("/dang-ky")
    public ResponseEntity<?> dangKyNguoiDung(@Validated  @RequestBody NguoiDung nguoiDung)
    {
        return taiKhoanService.dangKyNguoiDung(nguoiDung);
    }
}
