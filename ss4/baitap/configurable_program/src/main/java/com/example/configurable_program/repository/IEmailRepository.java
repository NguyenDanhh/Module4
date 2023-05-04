package com.example.configurable_program.repository;

import com.example.configurable_program.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<String> getLanguage();
    List<Integer> getPageSize();
    Email getEmail();
    void update(Email email);
}
