package com._book_loan_app.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Log {

    @AfterThrowing(value = "execution(* com._book_loan_app.controller.BookController.oderBook())")
    public void checkErrors(){
        System.out.println("lỗi");
    }
    @AfterReturning(value = "execution(* com._book_loan_app.controller.BookController.oderBook())")
    public void logDone(){
        System.out.println("Mượn thành công");
    }
}
