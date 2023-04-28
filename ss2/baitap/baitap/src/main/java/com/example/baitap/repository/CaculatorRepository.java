package com.example.baitap.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CaculatorRepository implements ICaculatorRepository {
    @Override
    public int result(String type, int number1, int number2) {
        switch (type) {
            case "Addition":
                return number1 + number2;
            case "Subtraction":
                return number1 - number2;
            case "Multiplication":
                return number1*number2;
            case "Division":
                return number1/number2;
        }
        return 0;
    }
}
