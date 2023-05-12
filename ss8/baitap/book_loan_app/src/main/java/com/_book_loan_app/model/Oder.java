package com._book_loan_app.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Oder {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id ;

    @Column(name = "code_oder")
    private int code;

    @Column(name = "date_order_book")
    private Date date;

    public Oder() {
    }

    public Oder(int id, int code, Date date) {
        this.id = id;
        this.code = code;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
