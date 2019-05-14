package com.example.demo.service;

public interface LoginService {
    String sort(String token, String timestamp, String nonce);

    String shal(String sortStr);
}

