package com.example.WebBanSach_Backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMessage(String from, String to, String subject, String text) {

        //MimeMailMessage  : có đính kèm file
        //SimpleMailMessage : nội dung thông thường 

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        //Thực hiện hành động gửi email 

        javaMailSender.send(message);
    }
}
