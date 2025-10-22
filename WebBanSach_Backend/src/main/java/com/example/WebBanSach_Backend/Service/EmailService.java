package com.example.WebBanSach_Backend.Service;

public interface EmailService {

    public void sendMessage(String from , String to , String subject , String text);
}