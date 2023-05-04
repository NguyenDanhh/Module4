package com.example.configurable_program.repository;

import com.example.configurable_program.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository{
    private Email email = new Email("English" , 5 , "","Thor");
    private static List<String> listLanguages = new ArrayList<>();
    static {
        listLanguages.add("English");
        listLanguages.add("Vietnamese");
        listLanguages.add("Japanese");
        listLanguages.add("Chinese");
    }
    private static List<Integer> listPageSize = new ArrayList<>();
    static {
        listPageSize.add(5);
        listPageSize.add(10);
        listPageSize.add(15);
        listPageSize.add(25);
        listPageSize.add(50);
        listPageSize.add(100);
    }

    @Override
    public List<String> getLanguage() {
        return listLanguages;
    }

    @Override
    public List<Integer> getPageSize() {
        return listPageSize;
    }

    @Override
    public Email getEmail() {
        return email;
    }

    @Override
    public void update(Email email) {
        this.email = email;
    }
}
