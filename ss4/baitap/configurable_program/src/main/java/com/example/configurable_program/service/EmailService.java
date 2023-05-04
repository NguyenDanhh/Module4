package com.example.configurable_program.service;

import com.example.configurable_program.model.Email;
import com.example.configurable_program.repository.EmailRepository;
import com.example.configurable_program.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmailService implements IEmailService{
    private IEmailRepository iEmailRepository = new EmailRepository();
    @Override
    public List<String> getLanguages() {
        return iEmailRepository.getLanguage();
    }

    @Override
    public List<Integer> getPageSize() {
        return iEmailRepository.getPageSize();
    }

    @Override
    public Email getEmail() {
        return iEmailRepository.getEmail();
    }

    @Override
    public void update(Email email) {
        iEmailRepository.update(email);
    }
}
