package com.example.validateexercise.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class CreateUserDTO implements Validator {
    @Min(value = 5 ,message = "Nhập ít nhất là 5 ký tự")
    @Max(45)
    @NotBlank(message = "Mời nhập tên ")
    private String firstName;

    @Min(5)
    @Max(45)
    @NotBlank(message = "Mời nhập tên " )
    private String lastName;

    @Pattern(regexp = "^(84|0[3|5|7|8|9])+([0-9]{8})$")
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date age;

   @NotBlank(message = "Nhập email")
    private String email;

    public CreateUserDTO() {
    }

    public CreateUserDTO(String firstName, String lastName, String phoneNumber, Date age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
