package com.example.WebBanSach_Backend.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtService  {
    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    //Tạo JWT dựa trên tên đăng nhập 
    public String generateToken(String tenDangNhap){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, tenDangNhap);
    }

    //Tạo JWT dựa trên tên đăng nhập và các claims
    private String createToken(Map<String, Object> claims, String tenDangNhap){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(tenDangNhap)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+30*60*1000))
                .signWith(SignatureAlgorithm.HS256, getSignKeỵ̣())
                .compact();
    }

    //Lấy secret key
    private Key getSignKeỵ̣(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //Trích xuất thông tin

    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(getSignKeỵ̣()).parseClaimsJws(token).getBody();
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
