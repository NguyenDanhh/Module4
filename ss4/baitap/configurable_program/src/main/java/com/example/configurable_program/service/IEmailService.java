package com.example.configurable_program.service;

import com.example.configurable_program.model.Email;

import java.util.List;

public interface IEmailService {
    List<String> getLanguages();
    List<Integer> getPageSize();
    Email getEmail();
    void update(Email email);
}
