package com.example.WebBanSach_Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebBanSach_Backend.Entity.NguoiDung;
import com.example.WebBanSach_Backend.Security.JwtResponse;
import com.example.WebBanSach_Backend.Security.LoginRequest;
import com.example.WebBanSach_Backend.Service.JwtService;
import com.example.WebBanSach_Backend.Service.TaiKhoanService;
import com.example.WebBanSach_Backend.Service.UserService;
import org.springframework.security.core.AuthenticationException;

@RestController
@RequestMapping("/tai-khoan")
public class TaiKhoanController {
    @Autowired
    TaiKhoanService taiKhoanService ;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService ;

    @Autowired
    private JwtService jwtService ;

    @PostMapping("/dang-ky")
    public ResponseEntity<?> dangKyNguoiDung(@Validated  @RequestBody NguoiDung nguoiDung)
    {
        return taiKhoanService.dangKyNguoiDung(nguoiDung);
    }

    @GetMapping("/kich-hoat")
    public ResponseEntity<?> kichHoatTaiKhoan(@RequestParam String email, @RequestParam String maKichHoat)
    {
        return taiKhoanService.kichHoatTaiKhoan(email, maKichHoat);
    }

    @PostMapping("/dang-nhap")
    public ResponseEntity<?> dangNhap(@Validated @RequestBody LoginRequest loginRequest)
    {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getTenDangNhap(), loginRequest.getMatKhau())
            );
            //Nếu xác thực thành công 
            if(authentication.isAuthenticated()){
                final String jwt = jwtService.generateToken(loginRequest.getTenDangNhap());
                return ResponseEntity.ok(new JwtResponse(jwt));
            }
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body("Tên đăng nhập hoặc mật khẩu không chính xác");
        }
        return ResponseEntity.badRequest().body("Xác thực không thành công");
    }
}
 