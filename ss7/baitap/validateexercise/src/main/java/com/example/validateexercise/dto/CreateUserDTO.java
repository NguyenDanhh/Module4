package com.example.validateexercise.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;

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
    @NotNull
    @NotBlank
    @Min(value = 18, message = "Độ tuổi lớn hơn 18")
    private String age;

   @NotBlank(message = "Nhập email")
   @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z]+", message = "Nhập đúng định dạng vd :abc@gmail.com")
    private String email;

    public CreateUserDTO() {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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
        CreateUserDTO userDTO = (CreateUserDTO) target;

        LocalDate dayOfBirth=LocalDate.parse(userDTO.getAge());
        LocalDate now=LocalDate.now();
        int age= Period.between(now,dayOfBirth).getYears();
        if (age < 18) {
            errors.rejectValue("age", "age", "tuoi khong duoc nho hon 18");
        }
    }

}
