package com.example.validateexercise.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.util.Date;

public class CreateUserDTO implements Validator {
    private int id ;
    @NotBlank(message = "Mời nhập tên ")
    @Size(message = "Lớn hơn 5 và bé hơn 45 ký tự")
    private String firstName;

    @NotBlank(message = "Mời nhập tên " )
    @Size(message = "Lớn hơn 5 và bé hơn 45 ký tự")
    private String lastName;

    @NotBlank
    @Size(min = 10, max = 11, message = "Nhập số điện thoại lớn hơn 10 và bé hơn 11 số")
    @Pattern(regexp = "^([0-9]{10})$")
    private String phoneNumber;

    @Min(value = 18, message = "Độ tuổi lớn hơn 18")
    private Date age;

   @NotBlank(message = "Nhập email")
   @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z]+", message = "Nhập đúng định dạng vd :abc@gmail.com")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
