package com.example.WebBanSach_Backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.WebBanSach_Backend.DAO.NguoiDungRepository;
import com.example.WebBanSach_Backend.Entity.NguoiDung;

@Service
public class TaiKhoanService {
    
    @Autowired
    NguoiDungRepository nguoiDungRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<?> dangKyNguoiDung(NguoiDung nguoiDung)
    {
        if(nguoiDungRepository.existsByTenDangNhap(nguoiDung.getTenDangNhap()))
        {
            return ResponseEntity.badRequest().body("Ten dang nhap da ton tai");
        }
        if(nguoiDungRepository.existsByEmail(nguoiDung.getEmail()))
        {
            return ResponseEntity.badRequest().body("Email da ton tai");
        }

        //Mã hóa mật khẩu 
        String matKhauMaHoa = bCryptPasswordEncoder.encode(nguoiDung.getMatKhau());
        nguoiDung.setMatKhau(matKhauMaHoa);

        //Lưu người dùng vào database
        nguoiDungRepository.save(nguoiDung);
        return ResponseEntity.ok().body("Dang ky thanh cong");
    }
}