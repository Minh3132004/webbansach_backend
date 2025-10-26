package com.example.WebBanSach_Backend.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.WebBanSach_Backend.Entity.NguoiDung;
import com.example.WebBanSach_Backend.Entity.Quyen;

@Component
public class JwtService  {
    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    @Autowired
    private UserService userService ; 

    //Tạo JWT dựa trên tên đăng nhập 
    public String generateToken(String tenDangNhap){
        Map<String, Object> claims = new HashMap<>();
        boolean isAdmin = false;
        boolean isStaff = false;
        boolean isUser = false;
        NguoiDung nguoiDung = userService.findByUsername(tenDangNhap);
        if(nguoiDung != null && nguoiDung.getDanhSachQuyen().size()>0){
            List<Quyen> listQuyen = nguoiDung.getDanhSachQuyen();
            for(Quyen quyen : listQuyen){
                if(quyen.getTenQuyen().equals("ADMIN")){
                    isAdmin = true;
                }
                if(quyen.getTenQuyen().equals("STAFF")){
                    isStaff = true;
                }
                if(quyen.getTenQuyen().equals("USER")){
                    isUser = true;
                }
            }
        }
        claims.put("isAdmin", isAdmin);
        claims.put("isStaff", isStaff);
        claims.put("isUser", isUser);
        return createToken(claims, tenDangNhap);
    }

    //Tạo JWT dựa trên tên đăng nhập và các claims
    private String createToken(Map<String, Object> claims, String tenDangNhap){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(tenDangNhap)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+30*60*1000))
                .signWith(SignatureAlgorithm.HS256, getSignKey())
                .compact();
    }

    //Lấy secret key
    private Key getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //Trích xuất thông tin

    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(getSignKey()).parseClaimsJws(token).getBody();
    }

    //Trích xuất thông tin cho 1 claim
    public <T> T extractClaim(String token, Function<Claims, T> claimsTFunction){
        final  Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    //Kiểm tra thời gian hết hạn từ JWT
    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    //Lấy ra tên đăng nhập
    public String extractUserName(String token){
        return extractClaim(token, Claims::getSubject);
    }

    //Kiểm tra JWT đã hết hạn hay chưa
    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    //Kiểm tra tính hợp lệ của JWT
    public boolean validDateToken(String token , UserDetails  userDetails){
        final String tenDangNhap = extractUserName(token);
        return (tenDangNhap.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
