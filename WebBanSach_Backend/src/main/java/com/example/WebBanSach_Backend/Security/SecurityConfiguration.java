package com.example.WebBanSach_Backend.Security;

import com.example.WebBanSach_Backend.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider  authenticationProvider(UserService userService) {
        DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
        dap.setUserDetailsService(userService);
        dap.setPasswordEncoder(bCryptPasswordEncoder());
        return dap;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurer -> configurer
                        .requestMatchers(HttpMethod.GET, "/sach").permitAll()
                        .requestMatchers(HttpMethod.GET, "/sach/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/hinh-anh").permitAll()
                        .requestMatchers(HttpMethod.GET, "/hinh-anh/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/nguoi-dung").hasAuthority("Admin")
                        .requestMatchers(HttpMethod.GET, "/nguoi-dung/search/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/tai-khoan/dang-ky").permitAll()
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf-> csrf.disable());
        return http.build();
    }
}
