package com.example.WebBanSach_Backend.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.WebBanSach_Backend.DAO.NguoiDungRepository;
import com.example.WebBanSach_Backend.Entity.NguoiDung;

@Service
public class TaiKhoanService {
    
    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmailService emailService;

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

        //Gắn và gửi thông tin kích hoạt
        nguoiDung.setMaKichHoat(taoMaKichHoat());
        nguoiDung.setDaKichHoat(false);

        //Lưu người dùng vào database
        nguoiDungRepository.save(nguoiDung);

        //Gửi email cho người dùng để họ kích hoạt
        guiEmailKichHoat(nguoiDung.getEmail(), nguoiDung.getMaKichHoat());

        return ResponseEntity.ok().body("Dang ky thanh cong");

    }

    private String taoMaKichHoat(){
        return UUID.randomUUID().toString();
    }

    public void guiEmailKichHoat(String email, String maKichHoat){
        String subject = "Kich hoat tai khoan tại WEB BÁN SÁCH";
        String text = "Vui lòng sử dụng mã sau để kích hoạt tài khoản : " + email + "\n" + "Mã kích hoạt: " + maKichHoat;
        emailService.sendMessage("de180352vubinhminh@gmail.com", email, subject, text);
    }
}